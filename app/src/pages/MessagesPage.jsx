import React from 'react';
import { Redirect } from "react-router-dom";
import { Jumbotron, Button, Alert, Table } from 'react-bootstrap';
import { getMessages, getMessagesSent } from '../api/account';
import { getSessionFromCookie } from '../session'
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';

const errorMessages = {
  'DOES_NOT_EXIST': 'Wrong combination of username and password'
};

class MessagesPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      messages: [],
      sentMessages: [],
      replying: false,
      replyReceiver: null,
      currentUserId: getSessionFromCookie().user_id,
      currentUsername: getSessionFromCookie().username
    };
    console.log(getSessionFromCookie());
    this.handleReply = this.handleReply.bind(this);
  }

  handleReply(receiverId) {
    this.setState({
      replying: true,
      replyReceiver: receiverId
    });
  }

  componentDidMount() {
    getMessages(this.state.currentUserId)
      .then((messages) => {
        this.setState({ messages });
      })
      .catch((err) => {
        this.setState({ error: err });
      });

    getMessagesSent(this.state.currentUserId)
      .then((sentMessages) => {
        this.setState({ sentMessages });
      })
      .catch((err) => {
        this.setState({ error: err });
      });
  }

  getTabs = () => {
    return (
      <Tabs defaultActiveKey="inbox" id="uncontrolled-tab-example">
        <Tab eventKey="inbox" title="Inbox">
          {this.getTable(true, this.state.messages)}
        </Tab>
        <Tab eventKey="sent" title="Sent">
          {this.getTable(false, this.state.sentMessages)}
        </Tab>
      </Tabs>
    )
  }

  getTable = (isInbox, messages) => {
    return (
      <Table responsive hover>
        <thead>
          <tr>
            <th></th>
            <th>{isInbox ? "Sender" : "Sent To"}</th>
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
              <td>{isInbox ? m.sender_username : m.receiver_username}</td>
              <td>{m.content}</td>
              <td>{new Date(Number(m.message_timestamp)).toUTCString()}</td>
              <td>
                <Button
                  variant="primary"
                  onClick={() => this.handleReply(isInbox ? m.sender_user_id : m.receiver_user_id)}
                >
                  {isInbox ? "Reply" : "New Message"}
              </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    );
  }

  render() {
    const { error } = this.state;
    const { replying, replyReceiver } = this.state;

    if (replying) {
      return (
        <Redirect to={{
          pathname: '/draftmessage',
          state: { receiver: replyReceiver }
        }} />);
    }

    return (
      <div className="main-content">
        {error && (
          <Alert variant="danger">
            {Object.keys(errorMessages).indexOf(error) > 0 ? errorMessages[error] : error}
          </Alert>
        )}

        <Jumbotron>
          <h1>Messages</h1>
          <p>
            Find all messages you sent and received.
          </p>
        </Jumbotron>
        {this.getTabs()}
      </div>
    );
  };
};

export default MessagesPage;
