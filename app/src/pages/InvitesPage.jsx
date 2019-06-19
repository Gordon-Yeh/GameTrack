import React from 'react';
import Jumbotron from 'react-bootstrap/Jumbotron';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { getUsersInvites } from "../api/event";
import { Redirect } from 'react-router';
import { getSessionFromCookie } from '../session';

class InvitesPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = { invites: [], redirectToEvent: false, redirectEvent: null };
        let currentUser = getSessionFromCookie();
        if(currentUser) {
            getUsersInvites(currentUser.user_id).then(i => this.setState({ invites: i }));
        }
    }

    onViewClicked = (invite) => {
        this.setState({ redirectToEvent: true, redirectEvent: invite.event });
    }

    getRows = (invites) => {
        console.log(invites);
        let rows = [];
        if (invites && invites.length > 0) {
            invites.forEach(invite => {
                rows.push(<tr>
                    <td>{invite.host.username}</td>
                    <td>{invite.event.name}</td>
                    <td>{invite.event.creator_username}</td>
                    <td>{invite.event.sport}</td>
                    <td>{invite.event.location_name}</td>
                    <td>{new Date(invite.event.start_date).toUTCString()}</td>
                    <td>{invite.event.is_a_tournament ? "Tournament" : "For Fun"}</td>
                    <td><Button type="button" className="twoButtons" onClick={() => this.onViewClicked(invite)}>View</Button></td>
                </tr>)
            });
        }

        return (
            rows
        );
    };

    render() {
        if (this.state.redirectToEvent) {
            return (
                <Redirect to={{
                    pathname: '/Event',
                    state: { event: this.state.redirectEvent }
                }}
                />
            );
        } else {
            return (
                <div className="main-content">
                    <Jumbotron>
                        <h1>Invites!</h1>
                        <p>
                            Browse through all invites you have received from other users.
                    </p>
                    </Jumbotron>
                    <h2>Invites You Received:</h2>
                    <Table bordered hover responsive>
                        <thead>
                            <tr>
                                <th>Invited By</th>
                                <th>Event Name</th>
                                <th>Created By</th>
                                <th>Sport</th>
                                <th>Location</th>
                                <th>Date and Time</th>
                                <th>Tournament/For Fun</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.getRows(this.state.invites)}
                        </tbody>
                    </Table>
                </div>
            );
        }
    }
}
export default InvitesPage;