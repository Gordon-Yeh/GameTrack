import React from 'react';
import Jumbotron from 'react-bootstrap/Jumbotron';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import sampleInvites from '../test-data/invites.json'

class InvitesPage extends React.Component {

    getRows = (invites) => {
        let rows = [];
        invites.forEach(invite => {
            rows.push(<tr>
                <td>{invite.senderUsername}</td>
                <td>{invite.eventName}</td>
                <td>{invite.sport}</td>
                <td>{invite.eventLocationName}</td>
                <td>{new Date(Number(invite.eventDateAndTime)).toUTCString()}</td>
                <td>{invite.eventIsTournament ? "Tournament" : "For Fun"}</td>
                {/* TODO hookup button to a redirect */}
                <td><Button type="button" className="twoButtons">View</Button></td>
            </tr>)
        });

        return (
            rows
        );
    };

    render() {
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
                            <th>Sport</th>
                            <th>Location</th>
                            <th>Date and Time</th>
                            <th>Tournament/For Fun</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.getRows(sampleInvites.invites)}
                    </tbody>
                </Table>
            </div>
        );
    }
}
export default InvitesPage;