import { LOGIN } from '../actions';
import _ from 'lodash';

const initialState={
    isSubmit:false,
    isLoginSucceed:false,
    error:null
}

export default function (state = initialState, action) {
    switch (action.type) {
        case LOGIN:
            console.log('Login Start...');
            return state;
        case `${LOGIN}_PENDING`:
            console.log('Login Pending...');
            var newState=Object.assign({},initialState,{isSubmit:true});
            return newState;
        case `${LOGIN}_FULFILLED`:
            console.log('Login FULFILLED...');
            //todo add error and map login result
            var newState=Object.assign({},initialState,{isLoginSucceed:action.payload.data.succeed,
                error:action.payload.data.errors});
            return newState;
        default:
            //console.log(action)
            return state;
    }
}