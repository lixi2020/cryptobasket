import { combineReducers } from 'redux';
import { reducer as formReducer } from 'redux-form';
import marketReducer from './marketReducer';
import loginReducer from './loginReducer';


const rootReducer = combineReducers({
  tickers: marketReducer,
  loginState: loginReducer,
  form: formReducer
});

export default rootReducer;
