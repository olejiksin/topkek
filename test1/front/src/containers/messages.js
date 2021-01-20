import {Component} from "react";
import React from "react";

export default class Messages extends Component {

    click = () => {
      this.props.sendMessages("sdfsdfs");
    };

    render() {
        const mes = this.props.mes.map((message, index) =>
            <div key={index}>
                <ul>
                    <br/>
                    <li>{message.user}:{message.message}</li>
                </ul>
            </div>);

        return (
            <div>
                {mes}
            </div>
        )
    }
}