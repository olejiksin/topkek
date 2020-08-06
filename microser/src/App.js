import {Component} from 'react';
import React from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";

var stompConnection;
var stompClient;


class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            messages: [],
            currentMes: '',
            room: ''
        }
    }

    componentDidMount() {
        let usver = this.props.match.params.user;
        let room = this.props.match.params.room;
        this.setState({user: usver,room:room});
        stompConnection = new SockJS('http://localhost:8080/api/2/stomp/chat');
        stompClient = Stomp.over(stompConnection);
        stompClient.connect({}, (frame) => {
            stompClient.subscribe('/topic/public', (message) => {
                let k = JSON.parse(message.body);
                if (k[1] !== undefined) {
                    this.setState({messages: k});
                }
            });
            let data = {
                from: usver,
                text: "new user",
                room: room,
                type: "JOIN"
            };
            stompClient.send('/app/' + usver + "/" + room + ".addUser", {}, JSON.stringify(data));
        });
		
    }


    sendMes = (user, text, room) => {
        console.log(user);
        let mes = {
            from: user,
            text: text
        };
        let data = {
            from: user,
            text: text,
            room: room,
            type: "CHAT"
        };
        let arr = this.state.messages;
        let d = arr.push(mes);
        console.log(arr);
        this.setState({messages: arr});
        stompClient.send('/app/' + this.state.user + "/" + this.state.room + '.sendMessage', {}, JSON.stringify(data));
    };


    render() {
        const {messages} = this.state;
        const {user} = this.state;
        console.log(this.state.room);
        if ({messages}) {
            const mess = messages.map((message, index) =>
                <div key={index}>
                    <ul>
                        <br/>
                        <li>{message.from} : {message.text}</li>
                    </ul>
                </div>
            );
            return (<div>
                <h1>Chat</h1>
                <h3>Hello, {user} </h3>
                <br/>
                <textarea name={"message"} id={"mes"}
                          onChange={(event) => this.setState({currentMes: event.target.value})}/>
                <br/>
                <button onClick={() => this.sendMes(this.state.user, this.state.currentMes, this.state.room)}> Send
                </button>
                <h2>Messages:</h2>
                <div>{mess}</div>
            </div>);
        }
    }
}

export default Chat;