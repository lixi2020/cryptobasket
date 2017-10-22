import React, { Component } from "react";
import Nav from './nav';
import Footer from './footer';
import Logout from './logout';
import PortfolioDonut from '../portfolioDonut';
import PortfolioLine from '../portfolioLine';
import PortfolioTable from '../portfolioTable';
import MarketTable from '../marketTable';
import { OVERVIEW_URL,TREND_URL,DETAILS_URL,MARKET_URL} from './constant'

export default class Home extends Component {
  constructor(props) {
    super(props);
    var path = this.props.location.pathname.split('/')[1];
    if(path==null||path==''){
      path=OVERVIEW_URL;
    }
    this.state = {
      path:path
    }
 }
  returnURL() {
    if(this.state.path==OVERVIEW_URL){
      return  <PortfolioDonut />
    }else if(this.state.path==TREND_URL){
      return  <PortfolioLine />
    }else if(this.state.path==DETAILS_URL){
      return  <PortfolioTable />
    }else if(this.state.path==MARKET_URL){
      return  <MarketTable />
    }
  }

  render() {
    return (<div>
      <Nav path={this.state.path} />
      <div className="content-wrapper" style={{ backgroundColor: "#ADD8E6" }}>
        <div className="container-fluid">
          {/* <ol className="breadcrumb">
            <li className="breadcrumb-item active">
              Latest News: <a href="#">Bitcoin surged to 9000 usd!!!!!</a>
            </li>
          </ol> */}
          {this.returnURL()}
        </div>
      </div>
      <Footer />
      <Logout />
    </div>)
  };
}
