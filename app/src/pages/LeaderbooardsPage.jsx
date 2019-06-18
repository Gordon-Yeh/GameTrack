import React from 'react';

import Jumbotron from 'react-bootstrap/Jumbotron'
import Table from 'react-bootstrap/Table';
import Form from 'react-bootstrap/Form'
import Col from 'react-bootstrap/Col'
import InputGroup from 'react-bootstrap/InputGroup'
import Button from 'react-bootstrap/Button'
import { getSports } from '../api/sports';
import {
    getUsersInAllEvents,
    getUsersLeaderboards,
    getTopLocations,
    getEventsCount,
    getUsersCount
} from '../api/leaderboards'
import { getSessionFromCookie } from '../session'

class LeaderboardsPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            sports: [],
            currentUserId: getSessionFromCookie().user_id,
            usersInAllEvents: [], topLocations: [],
            userLeaderboards: [],
            userLeaderboardSport: React.createRef(),
            topLocationsSport: React.createRef(),
            userCount: null,
            eventCount: null
        };
        getSports().then(sports => this.setState({ sports: sports }));
        getUsersInAllEvents().then(u => this.setState({ usersInAllEvents: u }));
        getUsersCount().then(c => this.setState({userCount: c.count}));
        getEventsCount().then(c => this.setState({eventCount: c.count}));
    }

    onUserLeaderboardsSearch = () => {
        let sport = this.state.userLeaderboardSport.current.value;
        if (sport) {
            getUsersLeaderboards(sport).then(users => this.setState({ userLeaderboards: users }));
        }
    }

    onTopLocationsSearch = () => {
        let sport = this.state.topLocationsSport.current.value;
        if (sport) {
            getTopLocations(sport).then(locs => this.setState({ topLocations: locs }));
        }
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
        locations.forEach((loc, i) => {
            rows.push(<tr>
                <td>{i + 1}</td>
                <td>{loc.name}</td>
                <td>{loc.street_address + ' ' + loc.postal_code}</td>
                <td>{loc.no_of_events}</td>
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
        users.forEach((user, i) => {
            rows.push(<tr>
                <td>{i + 1}</td>
                <td>{user.username}</td>
                <td>{user.full_name}</td>
                <td>{user.no_of_events}</td>
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

    render() {
        return (
            <div className="main-content">
                <Jumbotron>
                    <h1>Top Locations and Leaderboards </h1>
                    <p>
                        Find the most active locations and see who the top users are.
                    </p>
                </Jumbotron>
                <h2>Statistics:</h2>
                <h4>Total number of users: {this.state.userCount}</h4>
                <h4>Total number of events: {this.state.eventCount}</h4>
                <h2 style={{ marginTop: '20pt'}}>Top Locations</h2>
                <div>
                    <Form.Row>
                        <Form.Group as={Col} md="3">
                            <Form.Label>Sport</Form.Label>
                            <InputGroup>
                                <Form.Control as="select" ref={this.state.topLocationsSport}>
                                    {this.getSportsOptions()}
                                </Form.Control>
                                <Button as="input" type="submit" value="Search" style={{ marginLeft: '10pt' }} onClick={() => this.onTopLocationsSearch()} />
                            </InputGroup>
                        </Form.Group>
                    </Form.Row>
                    {this.renderLocationsTable(this.state.topLocations)}
                    <h2>Leaderboards (Most Active)</h2>
                    <Form.Row>
                        <Form.Group as={Col} md="4">
                            <Form.Label>Sport</Form.Label>
                            <InputGroup>
                                <Form.Control as="select" ref={this.state.userLeaderboardSport}>
                                    {this.getSportsOptions()}
                                </Form.Control>
                                <Button as="input" type="submit" value="Search" style={{ marginLeft: '10pt' }} onClick={() => this.onUserLeaderboardsSearch()} />
                            </InputGroup>
                        </Form.Group>
                    </Form.Row>
                </div>
                {this.renderLeaderboardTable(this.state.userLeaderboards)}
                <h2>Users Who Participated in All Events:</h2>
                {this.getAllEventsUserTable(this.state.usersInAllEvents)}
            </div>
        )
    }
}

export default LeaderboardsPage;