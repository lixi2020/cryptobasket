import React, { Component } from "react";

export default class PortfolioTable extends Component {
    render() {
        return (
            <div className="card mb-3" style={{ backgroundColor: "#ADD8E6" }} >
                <div className="card-header">
                    <i className="fa fa-table"></i>
                     Portfolio :
                </div>
                <div className="card-body">
                    <div className="table-responsive">
                        <table className="table table-bordered" width="100%" id="dataTable" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Market Cap</th>
                                    <th>Price</th>
                                    <th>%Change(24h)</th>
                                    <th>Price Graph(7d)</th>
                                    <th>Operation</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>BitCoin</td>
                                    <td>$63,442,925,523</td>
                                    <td>$3860</td>
                                    <td>30%</td>
                                    <td>Graph</td>
                                    <td>Edit Removie</td>
                                </tr>
                                <tr>
                                    <td>BitCoin</td>
                                    <td>$63,442,925,523</td>
                                    <td>$3000</td>
                                    <td>-10%</td>
                                    <td>Graph</td>
                                    <td>Edit Removie</td>
                                </tr>
                                <tr>
                                    <td>BitCoin</td>
                                    <td>$63,442,925,523</td>
                                    <td>$3860</td>
                                    <td>66%</td>
                                    <td>Graph</td>
                                    <td>Edit Removie</td>
                                </tr>
                                <tr>
                                    <td>ETH</td>
                                    <td>$3,442,925,523</td>
                                    <td>$3860</td>
                                    <td>-10%</td>
                                    <td>Graph</td>
                                    <td>Edit Removie</td>
                                </tr>
                                <tr>
                                    <td>BitCoin</td>
                                    <td>$63,442,925,523</td>
                                    <td>$3860</td>
                                    <td>-10%</td>
                                    <td>Graph</td>
                                    <td>Edit Removie</td>
                                </tr>
                                <tr>
                                    <td>BitCoin</td>
                                    <td>$63,442,925,523</td>
                                    <td>$3860</td>
                                    <td>-10%</td>
                                    <td>Graph</td>
                                    <td>Edit Removie</td>
                                </tr>
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
