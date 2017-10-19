import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';

export default class Login extends Component {

    render() {
        return (
            <div className="container">
                <div className="card card-login mx-auto mt-5">
                    <div className="card-header">
                        <h4 className="text-center">Decision Engine Migrator</h4>
                    </div>
                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
                            </div>
                            <div className="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" className="form-control" id="exampleInputPassword1" placeholder="Password" />
                            </div>
                            <div className="form-group">
                                <div className="form-check">
                                    <label className="form-check-label">
                                        <input type="checkbox" className="form-check-input" />
                                        Remember Password
                                    </label>
                                </div>
                            </div>

                            <a className="btn btn-primary btn-block" href="overview">Login</a>
                        </form>
                        <div className="text-center">
                            <a className="d-block small mt-3" href="register">Register an Account</a>
                            {/* <a className="d-block small" href="forgot-password.html">Forgot Password?</a> */}
                        </div>
                    </div>
                </div>
            </div>
           
        );
    }
}
