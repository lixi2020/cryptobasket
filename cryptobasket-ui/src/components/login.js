import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import LoginForm from './loginForm';
import { login } from '../actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Redirect } from 'react-router';
import { MARKET_URL } from './common/constant'

class Login extends Component {
    constructor(props) {
        super(props);
        this.onSubmit = this.onSubmit.bind(this);
    }

    componentDidMount() {
        console.log("componentMount!")
    }

    onSubmit(values) {
        this.props.login(values);
    }

    renderError() {
        if (this.props.loginState.error) {
            console.log('Error:', this.props.loginState.error);
        }
    }

    renderLoding() {
        if (this.props.loginState.isSubmit) {
            console.log('Loading');
        }
    }

    renderRedirect() {
        console.log('LoginSucceed:', this.props.loginState.isLoginSucceed);
        if (this.props.loginState.isLoginSucceed) {
            this.props.history.push(`/${MARKET_URL}`);
        }

    }

    render() {
        return (
            <div className="container">
                {
                    this.renderError()
                }
                {
                    this.renderLoding()
                }
                {
                    this.renderRedirect()
                }
                <div className="card card-login mx-auto mt-5">
                    <div className="card-header">
                        <h4 className="text-center">Crypto Basket</h4>
                    </div>
                    <div className="card-body">
                        <LoginForm onSubmit={this.onSubmit} />
                        <div className="text-center">
                            <a className="d-block small mt-3" href="register">Register an Account</a>
                            {/* <a className="d-block small" href="forgot-password.html">Forgot Password?</a> */}
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators({ login }, dispatch);
}

function mapStateToProprs(state) {
    return { loginState: state.loginState };
}

export default connect(mapStateToProprs, mapDispatchToProps)(Login);