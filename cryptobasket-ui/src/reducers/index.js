import { combineReducers } from 'redux';
import MarketReducer from './marketReducer';

const rootReducer = combineReducers({
  tickers:MarketReducer
});

export default rootReducer;
