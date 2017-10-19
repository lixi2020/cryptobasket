import React, { Component } from "react";

export default class Template extends Component {
  render() {
    return   <div className="container">
    <div className="card card-register mx-auto mt-5">
      <div className="card-header">Register an Account</div>
      <div className="card-body">
        <form>
          <div className="form-group">
            <div className="form-row">
              <div className="col-md-6">
                <label for="exampleInputName">Username</label>
                <input className="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter username"/>
              </div>
            </div>
          </div>
          <div className="form-group">
          <div className="form-row">
              <div className="col-md-6">
            <label for="exampleInputEmail1">Email Address</label>
            <input className="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Enter email"/>
            </div>
            <div className="col-md-6">
            <label for="exampleInputEmail1">&nbsp;</label>
            <input className="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Confirm email"/>
            </div>
          </div>
          </div>
          <div className="form-group">
            <div className="form-row">
              <div className="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input className="form-control" id="exampleInputPassword1" type="password" placeholder="Enter password"/>
              </div>
              <div className="col-md-6">
                <label for="exampleConfirmPassword">&nbsp;</label>
                <input className="form-control" id="exampleConfirmPassword" type="password" placeholder="Confirm password"/>
              </div>
            </div>
          </div>
          <a className="btn btn-primary btn-block" href="login">Register</a>
        </form>
        <div className="text-center">
          <a className="d-block small mt-3" href="login">Login Page</a>
          {/* <a className="d-block small" href="forgot-password.html">Forgot Password?</a> */}
        </div>
      </div>
    </div>
  </div>
  };
}