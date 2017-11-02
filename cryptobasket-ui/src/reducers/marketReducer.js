import { FETCH_TICKERS } from '../actions';
import _ from 'lodash';


export default function (state = {}, action) {
    switch (action.type) {
        case FETCH_TICKERS:
            console.log('Fetch Ticker Start...');
            return state;
        case `${FETCH_TICKERS}_PENDING`:
            console.log('Fetch Ticker Pending...');
            return state;
        case `${FETCH_TICKERS}_FULFILLED`://append to old state
            console.log('Fetch Ticker Resilved...');
            console.log(action)
            console.log(action.payload);
            return _.mapKeys(action.payload.data, 'rank');;
        default:
            //console.log(action);
            return state;
    }
}