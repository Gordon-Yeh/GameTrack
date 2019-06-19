import React from 'react';
import { Redirect } from "react-router-dom";
import { Jumbotron, Alert, Form, Button } from 'react-bootstrap';
import { sendMessage, getAllUsers } from '../api/account';
import { getSessionFromCookie } from '../session'

const errorMessages = {
  'DOES_NOT_EXIST': 'Wrong combination of username and password'
};

class DraftMessage extends React.Component {
  constructor(props) {
    super(props);

    const presetState = props.location.state;

    this.state = {
      error: null,
      success: false,
      // check for data that is passed with <Redirect to={{ state: {...} }}>
      receiver: presetState && presetState.receiver ? presetState.receiver : null,
      content: null,
      users: [],
      currentUserId: getSessionFromCookie().user_id
    };

    this.handleReceiverChange = this.handleReceiverChange.bind(this);
    this.handleContentChange = this.handleContentChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    getAllUsers().then(u => this.setState({ users: u }));
  }

  handleSubmit(e) {
    // prevents to page from reloading
    e.preventDefault();
    e.stopPropagation();
    if (this.state.content && this.state.receiver) {
      const message = {
        sender_user_id: this.state.currentUserId,
        receiver_user_id: this.state.receiver,
        content: this.state.content,
        message_timestamp: new Date().getTime()
      };

      sendMessage(message)
        .then(() => {
          this.setState({ success: true });
        })
        .catch((error) => {
          this.setState({ error });
        });
    }
  }

  handleReceiverChange(e) {
    this.setState({ receiver: e.target.value });
  }

  handleContentChange(e) {
    this.setState({ content: e.target.value });
  }

  getAllUsersAsOptions = () => {
    let options = [<option value=''>Select User</option>];
    this.state.users.filter(u => u.user_id !== this.state.currentUserId).forEach(u => options.push(
      <option value={u.user_id}>{u.username}</option>
    ));
    return options;
  }

  render() {
    const { error, success, receiver, content } = this.state;

    if (success) return <Redirect to="/Messages" />

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
              as="select"
              value={receiver}
              onChange={this.handleReceiverChange}
            >
              {this.getAllUsersAsOptions()}
            </Form.Control>
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

export default DraftMessage;
