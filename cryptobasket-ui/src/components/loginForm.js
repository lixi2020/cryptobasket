import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { Link } from 'react-router-dom';

class LoginForm extends Component {

    renderFieldEmail(field) {
        const classNameForInput = `form-group ${field.meta.touched && field.meta.error ? 'has-danger' : ''}`;
        return (
            <div className={classNameForInput}>
                <label htmlFor="exampleInputEmail1">Email address</label>
                <input
                    type="email"
                    className="form-control"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    placeholder="Enter email"
                    {...field.input}
                />
                <div className="text-help">
                    {field.meta.touched ? field.meta.error : ''}
                </div>

            </div>
        );
    }

    renderFieldPassword(field) {
        const classNameForInput = `form-group ${field.meta.touched && field.meta.error ? 'has-danger' : ''}`;
        return (
            <div className={classNameForInput}>
                <label htmlFor="exampleInputPassword1">Password</label>
                <input
                    type="password"
                    className="form-control" id="exampleInputPassword1" placeholder="Password"
                    {...field.input}
                />
                <div className="text-help">
                    {field.meta.touched ? field.meta.error : ''}
                </div>
            </div>
        );
    }

    // onSubmit(values) {
    //     debugger;
    //     login(values);
    // }


    render() {
        const { handleSubmit } = this.props;
        return (
            <form onSubmit={handleSubmit(this.props.onSubmit.bind(this))}>
                <Field
                    label="Email"
                    name="email"
                    component={this.renderFieldEmail}
                />
                <Field
                    label="Password"
                    name="password"
                    component={this.renderFieldPassword}
                />
                <div className="form-group">
                    <div className="form-check">
                        <label className="form-check-label">
                            <input type="checkbox" className="form-check-input" />
                            Remember Password
                                    </label>
                    </div>
                </div>
                <button type='submit' className="btn btn-primary btn-block">Login</button>
            </form>
        );
    }
}

function validate(values) {
    //console.log(values)->{title:'asdfsda',categories:'sadsada',content:'sdsadsa'}
    //console.log(values);
    const errors = {};

    //validate each input from 'values'
    if (!values.email) {
        errors.email = "Email can not be empty!";
    }


    //if errors is empty, the form is fine to submit
    if (!values.password) {
        errors.password = "Password can not be empty!";
    }

    //if errors has any* properties, redux form assume is invalid
    return errors;
}


export default reduxForm({
    validate: validate,
    form: 'LoginForm'
})(LoginForm);



