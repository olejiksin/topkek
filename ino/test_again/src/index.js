import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import App from './App';
import {BrowserRouter as Router, Switch,Route} from "react-router-dom";

const Appp=()=>(
    <Switch>
      <Route path={'/mimi'} component={App}/>
    </Switch>
)

ReactDOM.render(
    <Router>
      <Appp/>
    </Router>,
  document.getElementById('root')
);

