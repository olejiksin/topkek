import React from "react";
import './css/loader.scss';

export const List = (props) => {

    const {list} = props;


    const parDate = (date) => {
        let dat = new Date();
        let result;
        if (dat.getFullYear() + '' === date.split('-')[0]) {
            if (dat.getMonth() + 1 === parseInt(date.split('-')[1])) {
                if (dat.getDate() + '' === date.split('-')[2].split('T')[0]) {
                    if (dat.getHours() === parseInt(date.split('-')[2].split('T')[1].split(':')[0])) {
                    } else {
                        result = `${dat.getHours() - parseInt(date.split('-')[2].split('T')[1].split(':')[0])} час назад`;
                    }
                } else {
                    result = `${dat.getDate() - date.split('-')[2].split('T')[0]} дня назад`;
                }
            } else {
                result = `${date.split('-')[2].split('T')[0]}-${parseInt(date.split('-')[1])}-${date.split('-')[0]}`;
            }
        } else {
            result = `${date.split('-')[2].split('T')[0]}-${parseInt(date.split('-')[1])}-${date.split('-')[0]}`;
        }
        return result;
    };

    const subb = (status) => {
        let result;
        if (status === 0) {
            {
                result = 'Приостановлена';
            }
        } else if (status === 1) {
            {
                result = 'Подписка активна';
            }
        } else if (status === 2) {
            {
                result = 'Заблокирован';
            }
        }
        return result;
    };

    const showHideSubmenu = (e) => {
        console.log(e.type);
        if (e.target.children.length === 1) {
            if (e.type !== 'mouseleave') {
                if (e.target !== null) {
                    setTimeout(() => {
                        e.target.children[0].style.display = 'block';
                    }, 70);
                }
            } else {
                e.target.children[0].style.display = 'none';
            }
        } else if (e.target.children.length === 3) {
            e.target.parentElement.style.display = 'none';
        }
    };

    const openModal = (e, elem) => {
        let k = document.getElementById("modal");
        document.getElementById('sub-fullname').innerText=`${elem.fname} ${elem.name}`;
        document.getElementById('modal-flex-name').innerText=`${elem.name}`;
        document.getElementById('modal-flex-fname').innerText=`${elem.fname}`;
        document.getElementById('modal-flex-mname').innerText=`${elem.mname}`;
        document.getElementById('p-sub').innerText=`${subb(elem.status)}`;
        document.getElementsByClassName('submenu-modal')[0].children[0].children[elem.status].classList.value='li-selected';
        k.style.display = 'block';
        document.getElementById('mask').style.display = 'block';
    };


    const table = list.map((elem, key) => {
        return (
            <div className="list-elem" key={key}>
                <div className="left-flex">
                    <div style={{'display': 'flex'}} className="for-modal" onClick={(e) => openModal(e, elem)}>
                        <div className="avatar"><img id="avatar"
                            // src={elem.avatar}
                                                     src={'https://avatars.mds.yandex.net/get-zen_doc/1592246/pub_5e3c84113a37040237bf3a29_5e3c8f373ca31f61b1afe494/scale_1200'}
                                                     alt="avatar"/>
                        </div>
                        <div style={{
                            'min-width': '140px'
                        }} className="list-div-elem">{elem.fname} {elem.name[0]}. {elem.mname[0]}.
                        </div>
                    </div>
                    <div className="list-div-elem"
                         style={{
                             'min-width': '150px'
                         }}>Баланс: {elem.balance.toFixed(2)}</div>
                </div>
                <div className="right-flex" style={{'margin-right':'25px'}}>
                    <div className="list-div-elem" style={{'opacity': '0.4'}}>Последние
                        изменение: {parDate(elem.lastUpdatedAt)}</div>
                    <div className="list-div-elem sub" onMouseLeave={(e) => {
                        showHideSubmenu(e)
                    }} onClick={(e) => {
                        showHideSubmenu(e)
                    }}>{subb(elem.status)}
                        <div className="submenu">
                            <ul id={'ul' + key}>
                                <li className={elem.status === 0 ? 'li-selected' : 'li'}>Приостановлена</li>
                                <li className={elem.status === 1 ? 'li-selected' : 'li'}>Подписка активна</li>
                                <li className={elem.status === 2 ? 'li-selected' : 'li'}>Заблокирован</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        )
    });

    return (
        <div className="list-div">
            <div>{table}</div>
        </div>
    );
};
