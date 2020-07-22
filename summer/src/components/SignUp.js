import {Component} from 'react';
import {Link} from "react-router-dom";
import React from "react";
import axios from "axios";


export default class SignUp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        }
    }

    submit = () => {
        const {username, password} = this.state;
        let data = {
            login: username,
            password: password
        };
        axios.post(`/signUp/`, data)
            .then(() => {
            })
            .catch((err) => {
                console.log(err);
                alert("Alarm")
            });
    };

    render() {
        return (
            <div className={'login'}>
                <label className={'log-label'}>Username</label>
                <br/>
                <input className={'text-input'} type={'text'} name={"username"} id={"username"}
                       onChange={(event) => this.setState({username: event.target.value})}/>
                <label className={'log-label'}>Password</label>
                <br/>
                <input className={'text-input'} type={'password'} name={"password"} id={"password"}
                       onChange={(event) => this.setState({password: event.target.value})}/>
                <Link className={"log-reg-btn"} onClick={() => {
                    this.submit()
                }} to={"/login/"}>Next</Link>
            </div>);
    }
}
