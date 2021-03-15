import './css/main.scss';
import {Loader} from "./Loader";
import React from "react";
import {List} from "./List";
import axios from 'axios';


const {useReducer, useEffect} = React;


function reducer(state, action) {
    switch (action.type) {
        case 'page': {
            return {...state, page: action.payload}
        }
        case 'loaded': {
            return {...state, isLoading: action.payload}
        }
        case 'data': {
            return {...state, loadedData: action.payload}
        }
    }
}

export const Main = () => {

    const initState = {
        page: 1,
        isLoading: true,
        loadedData: []
    };
    const [state, dispatch] = useReducer(reducer, initState);

    const changePage = (element) => {
        document.getElementById("" + state.page).classList.remove('selected');
        dispatch({type: 'page', payload: +element.id});
        document.getElementById(element.id).classList.add('selected');
    };

    useEffect(() => {
        document.getElementById('1').classList.add('selected');
        axios.get(`https://watchlater.cloud.technokratos.com/get/array`)
            .then((r) => {
                dispatch({type: 'data', payload: r.data});
                dispatch({type: 'loaded', payload: false});
            })
            .catch((e) => {
                console.log(e);
                alert('Error')
            });

    }, []);

    const closeAuthWarn = (e) => {
        document.getElementById('auth').style.display = 'none';
    };

    let prev = -1;
    let cur=-1;

    const closeModal = () => {
        cur=-1;
        let k = document.getElementsByClassName('submenu-modal')[0].children[0].children;
        for (let i = 0; i < 3; i++) {
            if (k[i].classList.value === 'li-selected') {
                prev = i;
            }
        }
        document.getElementById('modal').style.display = 'none';
        document.getElementById('mask').style.display = 'none';
    };

    let clicked = false;
    const showHideSubmenu = (e) => {
        let k = document.getElementsByClassName('submenu-modal')[0].children[0].children;
        for (let i = 0; i < 3; i++) {
            if (k[i].classList.value === 'li-selected') {
                cur=i;
            }
        }
        if (prev !== -1 && prev!==cur) {
            k[prev].classList.value = 'li';
        }

        console.log('pr'+prev);
        if (e.target.id === 'p-sub') {
            if (e.type !== 'mouseleave') {
                if (e.target !== null) {
                    setTimeout(() => {
                        e.target.parentNode.children[1].style.display = 'block';
                        clicked = true;
                    }, 70);
                }
            }
        }
        if (e.target.children.length === 2) {
            if (e.type !== 'mouseleave') {
                if (e.target !== null) {
                    setTimeout(() => {
                        e.target.children[1].style.display = 'block';
                        clicked = true;
                    }, 70);
                }
            } else {
                e.target.children[1].style.display = 'none';
                clicked = false;
            }
        } else if (e.target.children.length === 3) {
            clicked = false;
            e.target.parentElement.style.display = 'none';
        }
    };

    return (
        <div className="app">
            <div id="mask"/>
            <div id="modal">
                <h1 id="sub-fullname">Ivanov Ivan</h1>
                <span id="modal-closer" onClick={(e) => {
                    closeModal()
                }}/>
                <div className="modal-flex">
                    <div className="modal-flex-class" id="modal-flex-fname"></div>
                    <div className="modal-flex-class" id="modal-flex-name"></div>
                    <div className="modal-flex-class" id="modal-flex-mname" style={{'margin-right': '90px'}}></div>
                    <div className="modal-flex-class" id="modal-flex-sub" onClick={(e) => {
                        showHideSubmenu(e)
                    }} onMouseLeave={(e) => {
                        showHideSubmenu(e)
                    }}>
                        <p id="p-sub"/>
                        <div className="submenu submenu-modal">
                            <ul className="ul-modal">
                                <li className="li">Приостановлена</li>
                                <li className="li">Подписка активна</li>
                                <li className="li">Заблокирован</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <button className="modal-btn">Сохранить</button>
            </div>
            <div className="authorization" id="auth"><p
                className="authorization-p" onClick={(e) => closeAuthWarn(e)}>Authorization required <span
                className="auth-warn"/></p></div>
            <div className="header">
                <a href="#" className="header-link" style={{'margin-left': '40px'}} id="1"
                   onClick={(e) => changePage(e.target)}>Все</a>
                <a href="#" className="header-link" id="2" onClick={(e) => changePage(e.target)}>Заблокированные</a>
                <a href="#" className="header-link" id="3" onClick={(e) => changePage(e.target)}>Активные</a>
            </div>
            {state.page === 1 && state.isLoading !== true ? <List list={state.loadedData}/> : <Loader/>}
        </div>
    );
};

