import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter, Route, Switch } from 'react-router-dom';



import Login from './components/login';
import reducers from './reducers';
import Home from './components/common/home';
import { OVERVIEW_URL,TREND_URL,DETAILS_URL} from './components/common/constant'


const createStoreWithMiddleware = applyMiddleware()(createStore);



  ReactDOM.render(
    <Provider store={createStoreWithMiddleware(reducers)}>
      <BrowserRouter>
        <div>
          <Switch>
            <Route path="/login" component={Login} /> 
            <Route path={`/${OVERVIEW_URL}`} component={Home} />
            <Route path={`/${TREND_URL}`} component={Home} />
            <Route path={`/${DETAILS_URL}`} component={Home} />
            <Route path="/" component={Home} />
          </Switch>
        </div>
      </BrowserRouter>
    </Provider>
    , document.querySelector('.app'));
