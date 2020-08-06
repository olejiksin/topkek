import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './index.css';
import Chat from './App';
import Log from './log'
import * as serviceWorker from './serviceWorker';


const Greet = () => (
    <Switch>
        <Route path='/chat/:user/:room' component={Chat}/>
        <Route path='/login' component={Log}/>
    </Switch>
);


ReactDOM.render(<Router>
    <Greet/>
</Router>, document.getElementById('root'));


serviceWorker.unregister();
