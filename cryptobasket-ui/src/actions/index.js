import axios from 'axios';

export const FETCH_TICKERS='fetch_tickers';
export const LOGIN='login';
export const REGISTER='register';

const APPSERVER_URL='http://localhost:8080';

const TICKER_URL='/ticker';

const LOGIN_URL='/user/login';

const REGISTER_URL='/user/register';

export function fetchTickers(){
    const request = axios.get(`${APPSERVER_URL}${TICKER_URL}`);
    return {
        type: FETCH_TICKERS,
        payload: request
    }
}

export function login(jsonRequest){
    const request = axios.post(`${APPSERVER_URL}${LOGIN_URL}`,jsonRequest)
    return {
        type: LOGIN,
        payload: request
    }
}


export function register(jsonRequest){
    const request = axios.get(`${APPSERVER_URL}${REGISTER_URL}`,jsonRequest);
    return {
        type: REGISTER,
        payload: request
    }
}
