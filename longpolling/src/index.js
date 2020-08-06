import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './index.css';
import Login from './App';
import Chat from './Chat';
import * as serviceWorker from './serviceWorker';

const Greet = () => (
    <Switch>
        <Route exact path='/login' component={Login}/>
        <Route path='/chat/:usver' component={Chat}/>
    </Switch>
);

ReactDOM.render(<Router>
    {/*<Switch/>*/}
    <Greet/>
</Router>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
