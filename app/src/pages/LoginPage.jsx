import React from 'react';
import { Redirect } from "react-router-dom";
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import { login } from '../api/account';

const errorMessages = {
  'DOES_NOT_EXIST': 'Wrong combination of username and password'
};

class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      validated: false,
      error: null,
      loggedIn: false
    };
    // This binding is necessary to make `this` work in the callback
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    const form = e.target;

    // prevents to page from reloading
    e.preventDefault();
    e.stopPropagation();

    if (form.checkValidity() === false) {
      this.setState({ validated: true });
      return;
    }

    // form values are access via controlId
    const username = form.elements.inputUsername.value;
    const password = form.elements.inputPassword.value;

    login(username, password)
      .then(() => {
        this.setState({ loggedIn: true });
      })
      .catch((err) => {
        this.setState({ error: err });
      })
  }

  render() {
    const {validated, error, loggedIn} = this.state;

    if (loggedIn === true) return <Redirect to="/browseEvents" />;

    return (
      <div
        style={{
          height: '100%',
          marginTop: '30vh'
        }}
      >
        <Container>
          <Row className="justify-content-center">
            <Col xs={10} s={10} md={7} lg={5}
              style={{
                padding: '30px 20px 30px 20px',
                backgroundColor: '#efefef',
                borderRadius: '.25rem'
              }}
            >
              <h1>Login</h1>
              {error && (
                <Alert variant="danger">
                  {Object.keys(errorMessages).indexOf(error) > -1 ? errorMessages[error] : error}
                </Alert>
              )}
              <Form 
                noValidate
                validated={validated}
                onSubmit={this.handleSubmit}
              >
                <Form.Group controlId="inputUsername">
                  <Form.Label>Username</Form.Label>
                  <Form.Control ref="username" type="text" placeholder="Enter Username" required/>
                  <Form.Control.Feedback type="invalid">
                    Please enter your username
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group controlId="inputPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control ref="password" type="password" placeholder="Password" required/>
                  <Form.Control.Feedback type="invalid">
                    Please enter your password
                  </Form.Control.Feedback>
                </Form.Group>
                <Button variant="primary" type="submit">
                  Submit
                </Button>
              </Form>
            </Col>
          </Row>
        </Container>
      </div>
    );
  };
};

export default LoginPage;
