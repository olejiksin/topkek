import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";

class Log extends Component {
    constructor(props) {
        super(props);
        this.state = {
            room: '',
            usver: ''
        }
    };

    sub=()=>{
        let data={
            room:this.state.room,
            user:this.state.user
        };
       /* fetch(`/login`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        });*/
    };

    render() {
        return (
            <div>
                <label>Ur name</label>
                <br/>
                <input type={"text"} id={"name"} onChange={(event) => this.setState({user: event.target.value})}/>
                <br/>
                <label>INPUT ROOM NUMBER</label>
                <br/>
                <input type={"text"} id={"room"} onChange={(event) => this.setState({room: event.target.value})}/>
                <br/>
                <Link onClick={()=>this.sub()} to={'/chat/'+this.state.user+'/'+this.state.room}> Bxod</Link>
            </div>
        )
    };
}
export default Log;