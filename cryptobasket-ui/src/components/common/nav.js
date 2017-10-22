import React, { Component } from "react";
import { OVERVIEW_URL,TREND_URL,DETAILS_URL,MARKET_URL} from './constant'
export default class Nav extends Component {
    constructor(props) {
        super(props);
        console.log(this.props.path);
    }


    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
                <a className="navbar-brand" href="#">Cryptobasket</a>
                <button className="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarResponsive">
                    <ul className="navbar-nav navbar-sidenav" id="exampleAccordion">
                        <li className={this.props.path==OVERVIEW_URL?"nav-item active":"nav-item"} data-toggle="tooltip" data-placement="right" title="Dashboard">
                            <a className="nav-link" href={OVERVIEW_URL}>
                                <i className="fa fa-fw fa-dashboard"></i>
                                <span className="nav-link-text">
                                    &nbsp;Overview</span>
                            </a>
                        </li>
                        <li className={this.props.path==TREND_URL?"nav-item active":"nav-item"} data-toggle="tooltip" data-placement="right" title="Charts">
                            <a className="nav-link" href={TREND_URL}>
                                <i className="fa fa-fw fa-area-chart"></i>
                                <span className="nav-link-text">
                                &nbsp;Trend</span>
                            </a>
                        </li>
                        <li className={this.props.path==DETAILS_URL?"nav-item active":"nav-item"} data-toggle="tooltip" data-placement="right" title="Tables">
                            <a className="nav-link" href={DETAILS_URL}>
                                <i className="fa fa-fw fa-table"></i>
                                <span className="nav-link-text">
                                &nbsp; Holding</span>
                            </a>
                        </li>

                        <li className={this.props.path==MARKET_URL?"nav-item active":"nav-item"} data-toggle="tooltip" data-placement="right" title="Tables">
                            <a className="nav-link" href={MARKET_URL}>
                                <i className="fa fa-fw fa-table"></i>
                                <span className="nav-link-text">
                                &nbsp; Market</span>
                            </a>
                        </li>
                    </ul>
                    {/* <ul className="navbar-nav sidenav-toggler">
                        <li className="nav-item">
                            <a className="nav-link text-center" id="sidenavToggler">
                                <i className="fa fa-fw fa-angle-left"></i>
                            </a>
                        </li>
                    </ul> */}
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle mr-lg-2" href="#" id="messagesDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i className="fa fa-fw fa-envelope"></i>
                                <span className="d-lg-none">Messages
                          <span className="badge badge-pill badge-primary">12 New</span>
                                </span>
                                <span className="new-indicator text-primary d-none d-lg-block">
                                    <i className="fa fa-fw fa-circle"></i>
                                    <span className="number">12</span>
                                </span>
                            </a>
                            <div className="dropdown-menu" aria-labelledby="messagesDropdown">
                                <h6 className="dropdown-header">New Messages:</h6>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">
                                    <strong>David Miller</strong>
                                    <span className="small float-right text-muted">11:21 AM</span>
                                    <div className="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                                </a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">
                                    <strong>Jane Smith</strong>
                                    <span className="small float-right text-muted">11:21 AM</span>
                                    <div className="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                                </a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">
                                    <strong>John Doe</strong>
                                    <span className="small float-right text-muted">11:21 AM</span>
                                    <div className="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                                </a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item small" href="#">
                                    View all messages
                        </a>
                            </div>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle mr-lg-2" href="#" id="alertsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i className="fa fa-fw fa-bell"></i>
                                <span className="d-lg-none">Alerts
                          <span className="badge badge-pill badge-warning">6 New</span>
                                </span>
                                <span className="new-indicator text-warning d-none d-lg-block">
                                    <i className="fa fa-fw fa-circle"></i>
                                    <span className="number">6</span>
                                </span>
                            </a>
                            <div className="dropdown-menu" aria-labelledby="alertsDropdown">
                                <h6 className="dropdown-header">New Alerts:</h6>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">
                                    <span className="text-success">
                                        <strong>
                                            <i className="fa fa-long-arrow-up"></i>
                                            Status Update</strong>
                                    </span>
                                    <span className="small float-right text-muted">11:21 AM</span>
                                    <div className="dropdown-message small">This is an automated server response message. All systems are online.</div>
                                </a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">
                                    <span className="text-danger">
                                        <strong>
                                            <i className="fa fa-long-arrow-down"></i>
                                            Status Update</strong>
                                    </span>
                                    <span className="small float-right text-muted">11:21 AM</span>
                                    <div className="dropdown-message small">This is an automated server response message. All systems are online.</div>
                                </a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">
                                    <span className="text-success">
                                        <strong>
                                            <i className="fa fa-long-arrow-up"></i>
                                            Status Update</strong>
                                    </span>
                                    <span className="small float-right text-muted">11:21 AM</span>
                                    <div className="dropdown-message small">This is an automated server response message. All systems are online.</div>
                                </a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item small" href="#">
                                    View all alerts
                        </a>
                            </div>
                        </li>
                        <li className="nav-item">
                            <form className="form-inline my-2 my-lg-0 mr-lg-2">
                                <div className="input-group">
                                    <input type="text" className="form-control" placeholder="Search for..." />
                                    <span className="input-group-btn">
                                        <button className="btn btn-primary" type="button">
                                            <i className="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            </form>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" data-toggle="modal" data-target="#exampleModal">
                                <i className="fa fa-fw fa-sign-out"></i>
                                Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>)
    };
}
