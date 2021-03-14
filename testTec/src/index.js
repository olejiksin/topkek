import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './index.css';
import {Main} from './Main';
import {Login} from './Login';

const App = () => (
    <Switch>
        <Route component={Login} path={'/login'}/>
        <Route component={Main} path={'/main'}/>
    </Switch>
);

ReactDOM.render(
    <Router>
        <App/>
    </Router>
    , document.getElementById('root')
);

