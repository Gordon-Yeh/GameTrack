import React from 'react';

import Jumbotron from 'react-bootstrap/Jumbotron'
import Table from 'react-bootstrap/Table';
import Form from 'react-bootstrap/Form'
import Col from 'react-bootstrap/Col'
import InputGroup from 'react-bootstrap/InputGroup'
import Button from 'react-bootstrap/Button'
import sampleLocationRankings from '../test-data/topLocations.json'
import sampleUserRankings from '../test-data/userRankings.json'
import { getSports } from '../api/sports';
import { getUsersInAllEvents } from '../api/event'
import { getSessionFromCookie } from '../session'

class LeaderboardsPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = { sports: [], currentUserId: getSessionFromCookie().user_id, usersInAllEvents: [] };
        getSports().then(sports => this.setState({ sports: sports }));
        getUsersInAllEvents().then(u => this.setState({ usersInAllEvents: u }));
    }


    renderLocationsTable = (locations) => {

        return (
            <Table bordered hover responsive>
                <thead>
                    <tr>
                        <th>Rank</th>
                        <th>Location Name</th>
                        <th>Address</th>
                        <th># of Events</th>
                    </tr>
                </thead>
                <tbody>
                    {this.getLocationsRows(locations)}
                </tbody>
            </Table>
        );

    }

    getLocationsRows = (locations) => {
        let rows = [];
        locations.forEach(loc => {
            rows.push(<tr>
                <td>{loc.rank}</td>
                <td>{loc.name}</td>
                <td>{loc.address + ' ' + loc.postalCode}</td>
                <td>{loc.noOfEvents}</td>
            </tr>);
        });
        return rows;
    }

    renderLeaderboardTable = (users) => {
        return (
            <Table bordered hover responsive>
                <thead>
                    <tr>
                        <th>Rank</th>
                        <th>Username</th>
                        <th>Name</th>
                        <th># of Events</th>
                    </tr>
                </thead>
                <tbody>
                    {this.getUserRows(users)}
                </tbody>
            </Table>
        );
    }

    getUserRows = (users) => {
        let rows = [];
        users.forEach(user => {
            rows.push(<tr>
                <td>{user.rank}</td>
                <td>{user.username}</td>
                <td>{user.fullName}</td>
                <td>{user.noOfEvents}</td>
            </tr>);
        });
        return rows;
    }

    getSportsOptions = () => {
        let options = [<option value=''>Select Sport</option>];
        this.state.sports.forEach(s => options.push(
            <option value={s.name}>{s.name}</option>
        ));
        return options;
    }

    getAllEventsUserTable = (users) => {
        let rows = [];
        if (users) {
            users.forEach(user => rows.push(
                <tr>
                    <td>{user.username}</td>
                    <td>{user.full_name}</td>
                    <td>{user.city}</td>
                    <td>{user.province}</td>
                    <td>{user.age}</td>
                    <td>{user.sex === 'M' ? "Male" : "Female"}</td>
                </tr>
            ))
        }

        return (
            <Table bordered hover responsive>
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Full Name</th>
                        <th>City</th>
                        <th>Province</th>
                        <th>Age</th>
                        <th>Gender</th>
                    </tr>
                </thead>
                <tbody>
                    {rows}
                </tbody>
            </Table>
        )
    }

    // TODO finalize Search Button Handlers
    render() {
        return (
            <div className="main-content">
                <Jumbotron>
                    <h1>Top Locations and Leaderboards </h1>
                    <p>
                        Find the most active locations and see who the top users are.
                    </p>
                </Jumbotron>
                <h2>Top Locations</h2>
                <div>
                    <Form.Row>
                        <Form.Group as={Col} md="3">
                            <Form.Label>Sport</Form.Label>
                            <InputGroup>
                                <Form.Control as="select">
                                    {this.getSportsOptions()}
                                </Form.Control>
                            </InputGroup>
                        </Form.Group>
                        <Form.Group as={Col} md="3">
                            <Form.Label>Time Period</Form.Label>
                            <InputGroup>
                                <Form.Control as="select">
                                    <option value=''>All Time</option>
                                    <option value='week'>Past Week</option>
                                    <option value='month'>Past Month</option>
                                    <option value='year'>Year</option>
                                </Form.Control>
                                <Button as="input" type="reset" value="Search" style={{ marginLeft: '10pt' }} />
                            </InputGroup>
                        </Form.Group>
                    </Form.Row>
                    {this.renderLocationsTable(sampleLocationRankings.locations)}
                    <h2>Leaderboards</h2>
                    <Form.Row>
                        <Form.Group as={Col} md="4">
                            <Form.Label>Sport</Form.Label>
                            <InputGroup>
                                <Form.Control as="select">
                                    {this.getSportsOptions()}
                                </Form.Control>
                                <Button as="input" type="reset" value="Search" style={{ marginLeft: '10pt' }} />
                            </InputGroup>
                        </Form.Group>
                    </Form.Row>
                </div>
                {this.renderLeaderboardTable(sampleUserRankings.users)}
                <h2>Users Who Participated in All Events:</h2>
                {this.getAllEventsUserTable(this.state.usersInAllEvents)}
            </div>
        )
    }
}

export default LeaderboardsPage;