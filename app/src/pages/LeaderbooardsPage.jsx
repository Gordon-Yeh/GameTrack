import React from 'react';

import Jumbotron from 'react-bootstrap/Jumbotron'
import Table from 'react-bootstrap/Table';
import Form from 'react-bootstrap/Form'
import Col from 'react-bootstrap/Col'
import InputGroup from 'react-bootstrap/InputGroup'
import Button from 'react-bootstrap/Button'
import sampleLocationRankings from '../test-data/topLocations.json'
import sampleUserRankings from '../test-data/userRankings.json'

import '../GlobalStyles.css'

class LeaderboardsPage extends React.Component {

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
        locations.forEach(loc=> {
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
                        <Form.Group as={Col} md="4">
                            <Form.Label>Sport</Form.Label>
                            <InputGroup>
                                <Form.Control as="select">
                                    {/* TODO finalize sports list */}
                                    <option value='Soccer'>Soccer</option>
                                    <option value='American Football'>American Football</option>
                                    <option value='Basketball'>Basketball</option>
                                    <option value='Tennis'>Tennis</option>
                                    <option value='Squash'>Squash</option>
                                </Form.Control>
                            </InputGroup>
                        </Form.Group>
                        <Form.Group as={Col} md="4">
                            <Form.Label>Time Period</Form.Label>
                            <InputGroup>
                                <Form.Control as="select">
                                    {/* TODO finalize sports list */}
                                    <option value=''>All Time</option>
                                    <option value='week'>Past Week</option>
                                    <option value='month'>Past Month</option>
                                    <option value='year'>Year</option>
                                </Form.Control>
                                <Button as="input" type="reset" value="Search" style={{marginLeft: '10pt'}} />
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
                                    {/* TODO finalize sports list */}
                                    <option value='Soccer'>Soccer</option>
                                    <option value='American Football'>American Football</option>
                                    <option value='Basketball'>Basketball</option>
                                    <option value='Tennis'>Tennis</option>
                                    <option value='Squash'>Squash</option>
                                </Form.Control>
                                <Button as="input" type="reset" value="Search" style={{marginLeft: '10pt'}} />
                            </InputGroup>
                        </Form.Group>
                    </Form.Row>
                </div>
                {this.renderLeaderboardTable(sampleUserRankings.users)}
            </div>
        )
    }
}

export default LeaderboardsPage;