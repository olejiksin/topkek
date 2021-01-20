import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";
import axios from 'axios';


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            pass: " "
        }
    }


    handleSubmit = (name) => {
        var data = {
            name: name,
            password: this.state.pass
        };
        axios.post('/login', data).catch((error) => {
            alert("ОШИБКА"  +  error);
        });
        fetch(`/login`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        });
    };


    render() {
        return (
            <div>
                <h1>Login</h1>
                <label>Name</label>
                <input type={"text"} name={"name"} id={"name"}
                       onChange={(event) => this.setState({name: event.target.value})}/>
                <br/>
                <input type={"password"} onChange={(event) => this.setState({pass: event.target.value})}
                       name={'password'}/>
                <Link onClick={() => this.handleSubmit(this.state.name)} to={'/chat/' + this.state.name}> Next</Link>
            </div>);
    }
}

export default Login;

