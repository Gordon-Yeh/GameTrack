import React from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import Jumbotron from 'react-bootstrap/Jumbotron';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import { getEventTeams, joinTeam, kickOutOfTeam, inviteUserToEvent } from '../api/event';
import { getSportInfo } from '../api/sports';
import { getAllUsers } from '../api/account'
import { Redirect } from 'react-router';


import eventSample from '../test-data/events.json'
import './EventPage.css'

class EventPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = { event: this.props.location.state.event, redirectToEdit: false, teams: [], sportInfo: null, users: [], recipient: React.createRef() };
        this.refreshState();
    }

    refreshState = () => {
        getEventTeams(this.state.event.event_id).then(t => this.setState({ teams: t }));
        getSportInfo(this.state.event.sport).then(sp => this.setState({ sportInfo: sp }));
        getAllUsers().then(u => this.setState({ users: u }));
    }

    onEditClicked = () => {
        this.setState({ redirectToEdit: true });
    }

    onInviteClicked = () => {
        if (this.state.recipient.current.value) {
            // TODO figure out how to get current user id
            inviteUserToEvent(this.state.event.event_id, "af93f012-8ef9-11e9-bc42-526af7764f64", this.state.recipient.current.value).then(r => alert("Invitation sent!"));
        } else {
            alert("Please select recipient Username");
        }
    }

    getSideBar = (event) => {
        return (
            <Card className="event-info">
                <ListGroup variant="flush">
                    <ListGroup.Item>
                        {/* TODO get current user_id */}
                        <h2>{event.name} <Button type="button" variant="info" style={{ marginLeft: '10pt' }} disabled={false} onClick={() => this.onEditClicked()}>Edit</Button></h2>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>Created by: </h3>{event.creator_username}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>Sport: </h3>{event.sport}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>{event.is_a_tournament ? "Tournament" : "For Fun"}</h3>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>Location: </h3>{event.location_name}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>Start Date: </h3>{new Date(event.start_date).toUTCString()}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>End Date: </h3>{new Date(event.end_date).toUTCString()}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3># of Teams: </h3>{event.number_of_teams}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <Jumbotron>
                            <h4> Sport Description: </h4>
                            <p>{this.state.sportInfo ? this.state.sportInfo.description : ""}</p>
                        </Jumbotron>
                    </ListGroup.Item>
                </ListGroup>
            </Card>
        )
    }

    getTeams = (teams) => {
        return (
            <div>
                <h3>Teams:</h3>
                {this.generateTeamTables(teams)}
            </div>
        );
    }

    onJoinClicked = (team) => {
        // TODO figure out a way to get current username
        joinTeam(this.state.event.event_id, "af93f012-8ef9-11e9-bc42-526af7764f64", team.team_number).then(r => this.refreshState());
    }

    onKickClicked = (team, user) => {
        kickOutOfTeam(this.state.event.event_id, user.user_id, team.team_number).then(r => this.refreshState());
    }

    generateTeamTables = (teams) => {
        if (teams) {
            let tables = [];
            teams.forEach(team => {
                tables.push(
                    <div>
                        <h4>{team.name}: {team.curr_size}/{team.max_size}<Button type="button" variant="success" style={{ marginLeft: '10pt' }} onClick={() => this.onJoinClicked(team)}>Join</Button></h4>
                        <Table striped bordered hover className="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Username</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.generateTeamMembersRows(team)}
                            </tbody>
                        </Table>
                    </div>
                )
            });
            return tables;
        }
        return null;
    }

    generateTeamMembersRows = (team) => {
        let rows = [];
        team.team_members.forEach((member, i) => {
            rows.push(<tr>
                <td>{i + 1}</td>
                <td>{member.username}</td>
                <td><Button type="button" variant="danger" onClick={() => this.onKickClicked(team, member)}>Kick Out!</Button></td>
            </tr>);
        });
        return rows;
    }

    getInviteBox = () => {
        return (
            <Card className="invite">
                <ListGroup variant="flush">
                    <ListGroup.Item>
                        <h2>Invite Users</h2>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <InputGroup>
                                <Form.Control
                                    as="select"
                                    ref={this.state.recipient}
                                >
                                    {this.getAllUsersAsOptions()}
                                </Form.Control>
                                <Button as="input" type="reset" value="Send" style={{ marginLeft: '5pt' }} onClick={() => this.onInviteClicked()} />
                            </InputGroup>
                        </Form.Group>
                    </ListGroup.Item>
                </ListGroup>
            </Card>
        )
    }

    getAllUsersAsOptions = () => {
        let options = [<option value=''>Select User</option>];
        // TODO figure out how to get current user id
        this.state.users.filter(u => u.user_id != "af93f012-8ef9-11e9-bc42-526af7764f64").forEach(u => options.push(
            <option value={u.user_id}>{u.username}</option>
        ));
        return options;
    }

    render() {
        if (this.state.redirectToEdit) {
            return (
                // TODO change to redirect to edit event
                <Redirect to={{
                    pathname: '/Event',
                    state: { event: this.state.event }
                }}
                />
            );
        } else {
            return (
                <div className="main-content d-flex">
                    {this.getSideBar(this.state.event)}
                    <div className="teams">
                        {this.getTeams(this.state.teams)}
                    </div>
                    {this.getInviteBox()}
                </div>
            );
        }
    }
}

export default EventPage;