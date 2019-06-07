import React from 'react';
import { Redirect } from "react-router-dom";
import { Jumbotron, Alert, Form, Button } from 'react-bootstrap';
import { sendMessage } from '../api/account';

const errorMessages = {
  'DOES_NOT_EXIST': 'Wrong combination of username and password'
};

class InboxPage extends React.Component {
  constructor(props) {
    super(props);

    const presetState = props.location.state;

    this.state = {
      error: null,
      success: false,
      // check for data that is passed with <Redirect to={{ state: {...} }}>
      receiver: presetState && presetState.receiver ? presetState.receiver : null,
      title: presetState && presetState.receiver ? presetState.title : null,
      content: null,
    };

    this.handleReceiverChange = this.handleReceiverChange.bind(this);
    this.handleTitleChange = this.handleTitleChange.bind(this);
    this.handleContentChange = this.handleContentChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    // prevents to page from reloading
    e.preventDefault();
    e.stopPropagation();

    const message = {
      receiver: this.state.receiver,
      title: this.state.title,
      content: this.state.content
    };

    sendMessage(message)
      .then(() => {
        this.setState({ success: true });
      })
      .catch((error) => {
        this.setState({ error });
      })
  }

  handleReceiverChange(e) {
    this.setState({ receiver: e.target.value });
  }

  handleTitleChange(e) {
    this.setState({ title: e.target.value });
  }

  handleContentChange(e) {
    this.setState({ content: e.target.value });
  }

  render() {
    const { error, success, receiver, title, content } = this.state;

    if (success) return <Redirect to="/inbox"/>

    return (
      <div className="main-content">
        {error && (
          <Alert variant="danger">
            {Object.keys(errorMessages).indexOf(error) > 0 ? errorMessages[error] : error}
          </Alert>
        )}

        <Jumbotron>
          <h2>Draft A New Message</h2>
        </Jumbotron>

        <Form onSubmit={this.handleSubmit}>
          <Form.Group controlId="receiver">
            <Form.Label>Receiver</Form.Label>
            <Form.Control 
              type="text" 
              value={receiver}
              onChange={this.handleReceiverChange}
            />
          </Form.Group>

          <Form.Group controlId="title">
            <Form.Label>Title</Form.Label>
            <Form.Control 
              type="text" 
              value={title}
              onChange={this.handleTitleChange}
            />
          </Form.Group>

          <Form.Group controlId="content">
            <Form.Label>Content</Form.Label>
            <Form.Control
              as="textarea"
              rows="8"
              type="text" 
              value={content}
              onChange={this.handleContentChange}
            />
          </Form.Group>
          
          <Button variant="primary" type="submit">
            Send
          </Button>
        </Form>
      </div>
    );
  };
};

export default InboxPage;
