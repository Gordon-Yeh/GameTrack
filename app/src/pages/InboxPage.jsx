import React from 'react';
import { Redirect } from "react-router-dom";
import { Jumbotron, Button, Alert, Table } from 'react-bootstrap';
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
      replying: false,
      replyReceiver: null,
      replyTitle: null
    };

    this.handleReply = this.handleReply.bind(this);
  }

  handleReply(message) {
    this.setState({
      replying: true,
      replyReceiver: message.senderUsername,
      replyTitle: `Re: ${message.title}`
    });
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
    const { replying, replyReceiver, replyTitle } = this.state;

    if (replying) {
      return (
        <Redirect to={{
          pathname: '/draftmessage',
          state: { receiver: replyReceiver, title: replyTitle }
        }}/>);
    }

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
              <th></th>
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
                <td>
                  <Button 
                    variant="secondary"
                    onClick={() => this.handleReply(m)}
                  >
                    Reply
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    );
  };
};

export default InboxPage;
