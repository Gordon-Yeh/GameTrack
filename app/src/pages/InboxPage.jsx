import React from 'react';
import { Redirect } from "react-router-dom";
import { Jumbotron, Container, Row, Col, Alert, Table } from 'react-bootstrap';
import { getMessages } from '../api/account';

const errorMessages = {
  'DOES_NOT_EXIST': 'Wrong combination of username and password'
};

class InboxPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      messages: [],
    };
  }

  componentDidMount() {
    getMessages()
      .then((messages) => {
        this.setState({ messages });
      })
      .catch((err) => {
        this.setState({ error: err });
      });
  }

  render() {
    const { error, messages } = this.state;

    return (
      <div className="main-content">
        {error && (
          <Alert variant="danger">
            {Object.keys(errorMessages).indexOf(error) > 0 ? errorMessages[error] : error}
          </Alert>
        )}

        <Jumbotron>
          <h1>Inbox</h1>
          <p>
              here are all the messages other users have sent you
          </p>
        </Jumbotron>

        <Table responsive hover>
          <thead>
            <tr>
              <th></th>
              <th>Sender</th>
              <th>Title</th>
              <th>Content</th>
              <th>Date / Time</th>
            </tr>
          </thead>

          <tbody
            style={{
              cursor: 'pointer'
            }}
          >
            {messages.map(m => (
              <tr>
                <td></td>
                <td>{m.senderFullName}</td>
                <td>{m.title}</td>
                <td>{m.content}</td>
                <td>{new Date(Number(m.timestamp)).toISOString()}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    );
  };
};

export default InboxPage;
