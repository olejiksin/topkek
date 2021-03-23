import './css/App.css';
import React from "react";
import axios from 'axios';
import {Cats} from './Cats';


const {useReducer, useEffect} = React;

function reducer(state, action) {
    switch (action.type) {
        case 'username': {
            return {...state, username: action.payload};
        }
        case 'access': {
            return {...state, access: action.payload}
        }
        case 'data': {
            return {...state, data: action.payload};
        }
        default: {
            return
        }
    }
}

const App = () => {

    const initialState = {
        username: '',
        access: false,
        data: []
    }

    const [state, dispatch] = useReducer(reducer, initialState);

    useEffect(() => {
        if (state.data.length === 0) {
            axios.get('/data')
                .then(res => {
                    changer('data', res.data)
                })
                .catch(err => {
                    alert('Some error')
                })
        }
    }, [state.access, state.data]);

    console.log(state.data);

    const changer = (type, value) => {
        dispatch({type: type, payload: value});
    }

    const checkName = () => {
        let data = {email: state.username};
        axios.post('/check', data)
            .then((r) => {
                if (r.data === true) {
                    changer('access', true);
                } else {
                    alert('Change ur name, pls')
                }
            })
            .catch((e) => alert("Some error"))
    }


    return (
        <div>
            {state.access === false ?
                <div>
                    <label>Your email, pls</label>
                    <br/>
                    <input type="text" onChange={(e) => changer('username', e.target.value)}/>
                    <br/>
                    <button onChange={() => checkName()}>Log in</button>
                </div>
                :
            <Cats cats={state.data}/>
            }
        </div>
    );
}

export default App;
