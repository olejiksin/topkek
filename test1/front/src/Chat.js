import {Component} from 'react';
import {Link} from "react-router-dom";
import React from "react";
import {connect} from "react-redux";
import {sendMessages, getMess, logout} from "./actions/chatAction";
import OnlineUsers from "./containers/onlineUsers"
import Messages from "./containers/messages";

class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            messages: [],
            onlineUsers: [],
            currentMes: ''
        }
    }

    componentDidMount() {
        const {getMess} = this.props;
        getMess();
    }

    render() {
        const {messages, activeUsers, logout, sendMessages} = this.props;
        const currentUser = this.props.match.params.user;
        const {currentMes} = this.state;
        return (
            <div>
                <h1><Link onClick={logout(currentUser)} to={"/login"}>Quit</Link></h1>
                <h1>Chat</h1>
                <h2>U a: {currentUser}</h2>
                <h2>Online users :</h2>
                <OnlineUsers users={activeUsers}/>
                <br/>
                <input name={"message"} id={"mes"}
                       onChange={(event) => this.setState({currentMes: event.target.value})}/>
                <button onClick={() => sendMessages(currentUser, currentMes)}> Send</button>
                <h2>Messages:</h2>
                <Messages mes={messages} updateMessages={sendMessages}/>
            </div>);
    }


}

const mapDispatchToProps = dispatch => ({
    sendMessages: (user, mes) => dispatch(sendMessages(user, mes)),
    getMess: () => dispatch(getMess()),
    logout: user => dispatch(logout(user))
});

const mapStateToProps = store => {
    console.log(store);
    return {
        messages: store.messages,
        activeUsers: store.activeUsers
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Chat);

