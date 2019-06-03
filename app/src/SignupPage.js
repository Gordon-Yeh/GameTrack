import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

function handleSubmit(e) {
  // prevents to page from reloading
  e.preventDefault();
  const form = e.target;
  
  // form values are access via controlId
  const username = form.elements.inputUsername.value;
  const password = form.elements.inputPassword.value;

  // TODO: call some function here to login 
  console.log(username, password);
}

function SignupPage(props) {
  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group controlId="inputFullName">
        <Form.Label>Full Name</Form.Label>
        <Form.Control type="text" placeholder="Enter your full name" />
      </Form.Group>

      <Form.Group controlId="inputAge">
        <Form.Label>Age</Form.Label>
        <Form.Control type="number" placeholder="Enter your age" />
      </Form.Group>

      <Form.Group controlId="inputSex">
        <Form.Label>Age</Form.Label>
        <Form.Control type="number" placeholder="Enter your age" />
      </Form.Group>

      <Form.Group controlId="inputUsername">
        <Form.Label>Username</Form.Label>
        <Form.Control type="text" placeholder="Enter Username" />
        <Form.Text className="text-muted">
        We'll never share your username with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group controlId="inputPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" />
      </Form.Group>

      <Form.Group controlId="formBasicChecbox">
        <Form.Check type="checkbox" label="Check me out" />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  )
}

export default SignupPage;
