import {Component} from 'react';
import React from "react";

class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            usver: '',
            messages: [],
            currentMes: ''
        }
    }
    login=(usver)=>{
        var body = {
            usver: usver,
            text: 'H3LL0, MEGA' + usver
        };
        fetch(`/mes`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(body)
        });
        this.receiveMessage();
    };
    componentDidMount() {
        console.log(this.props.match.params.usver);
        fetch(`/chat/${this.props.match.params.usver}`)
            .then(response => {
                return response.json();
            })
            .then(data => {
                if (data.messages !== null) {
                    this.setState({usver: this.props.match.params.usver, messages: data});
                } else alert("Ошибка в чем-то, перелогиньтесь.");
            })
            .catch(error => {
                console.log(error);
            });
        this.login(this.props.match.params.usver);
    };

    send = (usver, text) => {
        let data = {
            usver: usver,
            text: text
        };
        let arr = this.state.messages;
        let d = arr.push(data);
        console.log(arr);
        this.setState({messages: arr});
        fetch(`/mes`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        });
    };


    receiveMessage = () => {
        console.log(this.state.usver+"fetch");
        fetch(`/mes?usver=${this.props.match.params.usver}`)
            .then(response => {
                return response.json();
            })
            .then(data => {
                console.log(data + " data");
            })
            .catch(error => {
                console.log(error);
            }).finally(()=>{this.receiveMessage();})
    };



    render() {
        const {usver} = this.state;
        let {messages} = this.state;
        console.log(usver);
        if ({messages}) {
            const messag = messages.map((message, index) =>
                <div key={index}>
                    <ul>
                        <br/>
                        <li>{message.usver}:{message.text}</li>
                    </ul>
                </div>);
            return (<div>
                <div>Hello, {usver}</div>
                <div>
                    <input name={"message"} id={"mes"}
                           onChange={(event) => this.setState({currentMes: event.target.value})}/>
                    <button onClick={() => this.send(this.state.usver, this.state.currentMes)}> Send</button>
                </div>
                <div>{messag}</div>
            </div>);
        }
    }

}

export default Chat;