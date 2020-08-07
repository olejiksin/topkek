import {Component} from 'react';
import React from "react";

var websocket;

class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            messages: [],
            currentMes: '',
            token: ''
        }
    }

    componentDidMount() {
            websocket = new WebSocket('ws://localhost:8080/chat');
            console.log(websocket);
            websocket.onerror = function error() {
                alert("ALARM")
            };
            websocket.onopen=function () {
                alert("noice");
            };
        fetch(`/room`)
            .then(response => {
                return response.json();
            })
            .then(data => {
                console.log(data);
                this.setState({
                    messages: data.listOfMess
                });
            })
            .catch(error => {
                alert("Error: " + error)
            })
    }


    sendMes = (user, text, token) => {
        let mes = {
            user: user,
            message: text
        };
        let data = {
            from: user,
            text: text,
            token: token
        };
        console.log(user + "  " + text + "   " + token);
        if (text !== "Hello!") {
            let arr = this.state.messages;
            let d = arr.push(mes);
            this.setState({messages: arr});
        }
        websocket.send(JSON.stringify(data));
    };

    render() {
        const {messages} = this.state;
        console.log(messages);
        if ({messages}) {
            const mes = messages.map((message, index) =>
                <div key={index}>
                    <ul>
                        <br/>
                        <li>{message.usver}:{message.message}</li>
                    </ul>
                </div>
            );
            return (<div>
                <h1>Chat</h1>
                <label>Ur name</label>
                <br/>
                <input type={"text"} id={"name"} onChange={(event) => this.setState({user: event.target.value})}/>
                <button onClick={() => this.sendMes(this.state.user, "Hello!", null)}> Bxod</button>
                <br/>
                <input name={"message"} id={"mes"}
                       onChange={(event) => this.setState({currentMes: event.target.value})}/>
                <button onClick={() => this.sendMes(this.state.user, this.state.currentMes, this.state.token)}> Send
                </button>
                <h2>Messages:</h2>
                <div>{mes}</div>
            </div>);
        }
    }


}

export default Chat;