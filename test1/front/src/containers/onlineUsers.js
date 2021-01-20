import {Component} from "react";
import React from "react";

export default class OnlineUsers extends Component {

    render() {
        const onlineUsers = this.props.users.map((name, index) =>
            <div key={index}>
                <ul>
                    <li>{name}</li>
                    <br/>
                </ul>
            </div>);

        return (
            <div>
                {onlineUsers}
            </div>
        )
    }
}