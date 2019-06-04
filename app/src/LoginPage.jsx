import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Redirect } from 'react-router-dom'

class LoginPage extends React.Component {
  state = {
    redirect: false,
  }

  constructor(props) {
    super(props);
    // This binding is necessary to make `this` work in the callback
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    // prevents to page from reloading
    e.preventDefault();
    const form = e.target;

    // form values are access via controlId
    const username = form.elements.inputUsername.value;
    const password = form.elements.inputPassword.value;

    // TODO: call some function here to login 
    console.log(username, password);

    this.setState({redirect: true});
  }

  render() {
    if (this.state.redirect) {
      return (
        <Redirect to='/browseEvents' />
      )
    } else {
      return (<Form onSubmit={this.handleSubmit}>
        <Form.Group controlId="inputUsername">
          <Form.Label>Username</Form.Label>
          <Form.Control ref="username" type="text" placeholder="Enter Username" />
          <Form.Text className="text-muted">
            We'll never share your username with anyone else.
          </Form.Text>
        </Form.Group>

        <Form.Group controlId="inputPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control ref="password" type="password" placeholder="Password" />
        </Form.Group>
        <Form.Group controlId="formBasicChecbox">
          <Form.Check type="checkbox" label="Check me out" />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
      );
    }
  };
};

export default LoginPage;
