import React from 'react'
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card'
import ListGroup from 'react-bootstrap/ListGroup'
import Jumbotron from 'react-bootstrap/Jumbotron'
import Col from 'react-bootstrap/Col'
import Form from 'react-bootstrap/Form'
import InputGroup from 'react-bootstrap/InputGroup'

import eventSample from '../test-data/events.json'
import './EventPage.css'

class EventPage extends React.Component {

    getSideBar = (event) => {
        return (
            <Card className="event-info">
                <ListGroup variant="flush">
                    <ListGroup.Item>
                        {/* TODO hookup button */}
                        <h2>{event.name} <Button type="button" variant="info" style={{ "margin-left": '10pt' }} disabled>Edit</Button></h2>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>Sport: {event.sport}</h3>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>{event.isTournament ? "Tournament" : "For Fun"}</h3>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <h3>Max # of Teams: {event.noOfTeams}</h3>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <Jumbotron>
                            <h4> Sport Description: </h4>
                            <p>{event.sportDescription}</p>
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

    generateTeamTables = (teams) => {
        let tables = [];
        teams.forEach(team => {
            tables.push(
                <div>
                    <h4>{team.name}: {team.currentSize}/{team.capacity}<Button type="button" variant="success" style={{ "margin-left": '10pt' }}>Join</Button></h4>
                    {/* TODO attach handlers to kick out */}

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

    generateTeamMembersRows = (team) => {
        let rows = [];
        team.members.forEach((member, i) => {
            console.log(`came here, ${i}` + member)
            rows.push(<tr>
                <td>{i + 1}</td>
                <td>{member}</td>
                {/* TODO attach handlers to kick out */}
                <td><Button type="button" variant="danger">Kick Out!</Button></td>
            </tr>);
        });
        return rows;
    }

    getInviteBox = (event) => {
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
                                    type="text"
                                    placeholder="@Username"
                                />
                                <InputGroup.Append>
                                    {/* TODO hookup button */}
                                    <Button as="input" type="reset" value="Send" />
                                </InputGroup.Append>
                            </InputGroup>
                        </Form.Group>
                    </ListGroup.Item>
                </ListGroup>
            </Card>
        )
    }

    render() {
        return (
            <div className="main-content">
                {this.getSideBar(eventSample.events[0])}
                <div className="teams">
                    {this.getTeams(eventSample.events[0].teams)}
                </div>
                {this.getInviteBox(eventSample.events[0])}
            </div>
        );
    }
}

export default EventPage;