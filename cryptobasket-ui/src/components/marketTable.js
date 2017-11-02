import React, { Component } from "react";
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { fetchTickers } from '../actions';

class MarketTable extends Component {

    componentDidMount() {
        console.log("componentMount!")
        this.props.fetchTickers();
    }


    renderTickers() {
        if (Object.keys(this.props.tickers).length===0 ) {
            console.log('loading')
            console.log(this.props.tickers);
            return;
        }


        return _.map(this.props.tickers, ticker => {
            return (
                <tr key={ticker.rank}>
                    <td>{ticker.rank}</td>
                    <td>{ticker.nameId}</td>
                    <td>{ticker.marketCapUSD}</td>
                    <td>{ticker.priceUSD}</td>
                    <td>{ticker.percentChange24h}</td>
                    <td>Graph</td>
                    <td>Edit Removie</td>
                </tr>
            )
        })
    }


    render() {
        return (
            <div className="card mb-3" style={{ backgroundColor: "#ADD8E6" }} >
                <div className="card-header">
                    <i className="fa fa-table"></i>
                    Portfolio :
                </div>
                <div className="card-body">
                    <div className="table-responsive">
                        <table className="table table-bordered" width="100%" id="dataTable" cellSpacing="0">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Market Cap</th>
                                    <th>Price</th>
                                    <th>%Change(24h)</th>
                                    <th>Price Graph(7d)</th>
                                    <th>Operation</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderTickers()}               
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="card-footer small text-muted">
                    Updated yesterday at 11:59 PM
          </div>
            </div>)
    };
}


function mapDispatchToProps(dispatch) {
    return bindActionCreators({ fetchTickers }, dispatch);
}

function mapStateToProprs(state) {
    return { tickers: state.tickers };
}

export default connect(mapStateToProprs, mapDispatchToProps)(MarketTable);