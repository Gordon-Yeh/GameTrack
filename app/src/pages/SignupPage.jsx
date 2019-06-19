import React from 'react';
import { Redirect } from "react-router-dom";
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import { signup } from '../api/account';

const genders = {
  M: 'Male',
  F: 'Female',
  O: 'Other',
  N: 'Rather not say'
};

const provinces = {
  NL: 'Newfoundland and Labrador',
  PE: 'Prince Edward Island',
  NS: 'Nova Scotia',
  NB: 'New Brunswick',
  QC: 'Quebec',
  ON: 'Ontario',
  MB: 'Manitoba',
  SK: 'Saskatchewan',
  AB: 'Alberta',
  BC: 'British Columbia',
  YT: 'Yukon',
  NT: 'Northwest Territories',
  NU: 'Nunavut'
};

const errorMessages = {
  'USERNAME_ALREADY_EXIST': 'Wrong combination of username and password'
};

class SignupPage extends React.Component {
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
    // TODO: figure out a cleaner way to get form values
    let userInfo = {};
    userInfo.full_name = form.elements.fullName.value;
    userInfo.age = form.elements.age.value;
    userInfo.sex = form.elements.sex.value;
    userInfo.city = form.elements.city.value;
    userInfo.province = form.elements.province.value;
    userInfo.username = form.elements.username.value;
    userInfo.password = form.elements.password.value;
    console.log(userInfo);

    signup(userInfo)
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
              <h1>Signup</h1>
              {error && (
                <Alert variant="danger">
                  {errorMessages[error]}
                </Alert>
              )}
              <Form 
                noValidate
                validated={validated}
                onSubmit={this.handleSubmit}
              >
                <Form.Group controlId="fullName">
                  <Form.Label>Full Name</Form.Label>
                  <Form.Control type="text" placeholder="Enter your full name" required/>
                  <Form.Control.Feedback type="invalid">
                    Please enter your name
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group controlId="age">
                  <Form.Label>Age</Form.Label>
                  <Form.Control type="number" required/>
                  <Form.Control.Feedback type="invalid">
                    Please enter your age
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group controlId="sex">
                  <Form.Label>Gender</Form.Label>
                  <Form.Control as="select" required>
                    {Object.keys(genders).map((abbrev) => (
                      <option key={abbrev} value={abbrev}>
                        {genders[abbrev]}
                      </option>
                    ))}
                  </Form.Control>
                  <Form.Control.Feedback type="invalid">
                    Please choose your gender
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Row>
                  <Form.Group as={Col} controlId="city">
                    <Form.Label>City</Form.Label>
                    <Form.Control type="text" required/>
                  </Form.Group>

                  <Form.Group as={Col} controlId="province">
                    <Form.Label>Province</Form.Label>
                    <Form.Control as="select" required>
                      <option>Choose...</option>
                      {Object.keys(provinces).map((abbrev) => (
                        <option key={abbrev} value={abbrev}>
                          {provinces[abbrev]}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>
                </Form.Row>

                <Form.Group controlId="username">
                  <Form.Label>Username</Form.Label>
                  <Form.Control type="text" placeholder="Enter A Username" required/>
                  <Form.Control.Feedback type="invalid">
                    Please enter a username
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group controlId="password">
                  <Form.Label>Password</Form.Label>
                  <Form.Control type="password" placeholder="Password" required/>
                  <Form.Control.Feedback type="invalid">
                    Please enter a password
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

export default SignupPage;
