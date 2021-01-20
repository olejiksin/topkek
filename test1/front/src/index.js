import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './index.css';
import Login from './Login';
import Chat from './Chat';
import * as serviceWorker from './serviceWorker';
import {storeGlob} from './storeConf';
import {Provider} from 'react-redux';

const Test = () => (
        <Switch>
            <Route exact path='/login' component={Login}/>
            <Route path='/chat/:user' component={Chat}/>
        </Switch>
);

ReactDOM.render(
    <Provider store={storeGlob}>
    <Router>
    <Test/>
    </Router>
    </Provider>
    ,document.getElementById('root'));

serviceWorker.unregister();
