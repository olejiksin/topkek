import './css/login.scss';
import React from "react";
import axios from 'axios';
import './css/loader.scss';
import {Loader} from "./Loader";

export const Login = () => {

    const showOrHidePass = (element) => {
        console.log(element);
        let pasInput = document.getElementById("password-input");
        if (pasInput !== null && element !== undefined) {
            if (pasInput.getAttribute('type') === 'password') {
                element.classList.add('view');
                pasInput.setAttribute('type', 'text');
            } else {
                element.classList.remove('view');
                pasInput.setAttribute('type', 'password');
            }
        }
    };

    const login = () => {
        // axios.post('/login',data)
        //     .then((r)=>{})
        //     .catch((error)=>alert('Error'));
    };

    return (
        <div className="loginDiv">
            <input name="login" type="text" className="login-input" placeholder="Login"/>
            <br/>
            <input className="login-input" name="pas" type="password" id="password-input" placeholder="******"/>
            <a className="password-control" onClick={(e) => showOrHidePass(e.target)}/>
            <br/>
            <button className="login-button" onClick={(e) => login()}>ВОЙТИ</button>
        </div>

    );
};
