import React, { Component } from "react";
import NetworthChart from './networthChart';
import PortfolioTable from './portfolioTable';
import DynamicDoughnut from './dynamicDoughnut';

export default class Content extends Component {
  render() {
    return (
      <div className="content-wrapper" style={{ backgroundColor: "#ADD8E6" }}>
        <div className="container-fluid">
          <ol className="breadcrumb">
            <li className="breadcrumb-item active">
              Latest News: <a href="#">Bitcoin surged to 9000 usd!!!!!</a>
            </li>
          </ol>

          <DynamicDoughnut />
          <NetworthChart />
          <PortfolioTable/>
        </div>
      </div>
    );
  };
}

