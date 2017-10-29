import axios from 'axios';

export const FETCH_TICKERS='fetch_tickers';

const APPSERVER_URL='http://localhost:8080/ticker';

export function fetchTickers(){
    const request = axios.get(APPSERVER_URL);
    console.log(request);
    return {
        type: FETCH_TICKERS,
        payload: request
    }
}
