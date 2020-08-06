import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        }
    }


    handleSubmit = (email, password) => {
        var data = {
            email: email,
            password: password
        };
        console.log(data);
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
                    <input type={"text"} name={"email"} id={"email"}
                           onChange={(event) => this.setState({email: event.target.value})}/>
                    <br/>
                    <label>Parol</label>
                    <input type={"password"} name={"password"} id={"password"} onChange={(event) => this.setState({password: event.target.value})}/>
                    <Link onClick={() => this.handleSubmit(this.state.email, this.state.password)} to={'/chat/' + this.state.email}> Next</Link>
            </div>);
    }
}

export default Login;

