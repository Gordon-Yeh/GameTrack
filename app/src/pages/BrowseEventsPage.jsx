import React from 'react';

import Jumbotron from 'react-bootstrap/Jumbotron'
import InputGroup from 'react-bootstrap/InputGroup'
import Button from 'react-bootstrap/Button'
import Col from 'react-bootstrap/Col'
import Form from 'react-bootstrap/Form'
import EventTable from './EventTable'
import { getLocationsFromServer } from '../api/location';
import { getSports } from '../api/sports';
import { getAllEvents, getFilteredEvents } from '../api/event';
import { Redirect } from 'react-router';

import './BrowseEventsPage.css'

class BrowseEventsPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            validated: false, locations: [], sports: [], events: [], redirectToEvent: false, redirectEvent: null, filters: {
                created_by: React.createRef(),
                event_name: React.createRef(),
                sport: React.createRef(),
                location_name: React.createRef(),
                no_of_teams: React.createRef(),
                is_a_tournament: React.createRef(),
                start_day: React.createRef(),
                start_month: React.createRef(),
                start_year: React.createRef()
            }
        };
        this.handleSearch = this.handleSearch.bind(this);
        getLocationsFromServer().then(locs => this.setState({ locations: locs }));
        getSports().then(sports => this.setState({ sports: sports }));
        getAllEvents().then(e => this.setState({ events: e }));
    }

    getLocationsOptions = () => {
        let options = [<option value=''>Select Location</option>];
        this.state.locations.forEach(l => options.push(
            <option value={l.name}>{l.name}</option>
        ));
        return options;
    }

    getSportsOptions = () => {
        let options = [<option value=''>Select Sport</option>];
        this.state.sports.forEach(s => options.push(
            <option value={s.name}>{s.name}</option>
        ));
        return options;
    }

    handleSearch() {
        let actualFilter = this.transformFilter(this.state.filters);
        getFilteredEvents(actualFilter).then(e => this.setState({ events: e }));

    }

    transformFilter(stateFilter) {
        let actualFilter = {};
        actualFilter.created_by = this.getRefVal(this.state.filters.created_by);
        actualFilter.event_name = this.getRefVal(this.state.filters.event_name);
        actualFilter.sport = this.getRefVal(this.state.filters.sport);
        actualFilter.location_name = this.getRefVal(this.state.filters.location_name);
        actualFilter.no_of_teams = this.getRefVal(this.state.filters.no_of_teams);
        actualFilter.is_a_tournament = this.getRefVal(this.state.filters.is_a_tournament);
        actualFilter.start_day = this.getRefVal(this.state.filters.start_day);
        actualFilter.start_month = this.getRefVal(this.state.filters.start_month);
        actualFilter.start_year = this.getRefVal(this.state.filters.start_year);
        return actualFilter;
    }

    getRefVal(ref) {
        return ref.current.value;
    }

    handleView = (event) => {
        this.setState({ redirectToEvent: true, redirectEvent: event });
    }


    getDateSelector = () => {
        return (
            <Form.Row>
                <Form.Group as={Col} md="4" controlId="v1">
                    <Form.Label>Day</Form.Label>
                    <InputGroup>
                        <Form.Control ref={this.state.filters.start_day} as="select">
                            <option value=''>-</option>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='7'>7</option>
                            <option value='8'>8</option>
                            <option value='9'>9</option>
                            <option value='10'>10</option>
                            <option value='11'>11</option>
                            <option value='12'>12</option>
                            <option value='13'>13</option>
                            <option value='14'>14</option>
                            <option value='15'>15</option>
                            <option value='16'>16</option>
                            <option value='17'>17</option>
                            <option value='18'>18</option>
                            <option value='19'>19</option>
                            <option value='20'>20</option>
                            <option value='21'>21</option>
                            <option value='22'>22</option>
                            <option value='23'>23</option>
                            <option value='24'>24</option>
                            <option value='25'>25</option>
                            <option value='26'>26</option>
                            <option value='27'>27</option>
                            <option value='28'>28</option>
                            <option value='29'>29</option>
                            <option value='30'>30</option>
                            <option value='31'>31</option>
                        </Form.Control>
                    </InputGroup>
                </Form.Group>
                <Form.Group as={Col} md="4">
                    <Form.Label>Month</Form.Label>
                    <InputGroup>
                        <Form.Control ref={this.state.filters.start_month} as="select">
                            <option value=''>-</option>
                            <option value='1'>January</option>
                            <option value='2'>February</option>
                            <option value='3'>March</option>
                            <option value='4'>April</option>
                            <option value='5'>May</option>
                            <option value='6'>June</option>
                            <option value='7'>July</option>
                            <option value='8'>August</option>
                            <option value='9'>September</option>
                            <option value='10'>October</option>
                            <option value='11'>November</option>
                            <option value='12'>December</option>
                        </Form.Control>
                    </InputGroup>
                </Form.Group>
                <Form.Group as={Col} md="4">
                    <Form.Label>Year</Form.Label>
                    <InputGroup>
                        <Form.Control
                            type="text"
                            placeholder="Year"
                            ref={this.state.filters.start_year}
                        />
                        <InputGroup.Append>
                            <Button as="input" type="reset" value="X" disabled />
                        </InputGroup.Append>
                    </InputGroup>
                </Form.Group>
            </Form.Row>
        );
    }

    renderSearchBar = () => {
        const { validated } = this.state;
        return (
            <Jumbotron>
                <h3>Filter Events By:</h3>
                <Form
                    noValidate
                    validated={validated}
                    onSubmit={e => this.handleSearch(e)}
                >
                    <Form.Row>
                        <Form.Group as={Col} md="4" controlId="v2">
                            <Form.Label>Event Name</Form.Label>
                            <InputGroup>
                                <Form.Control
                                    type="text"
                                    placeholder="Event Name"
                                    ref={this.state.filters.event_name}
                                />
                                <InputGroup.Append>
                                    <Button as="input" type="reset" value="X" disabled />
                                </InputGroup.Append>
                            </InputGroup>
                        </Form.Group>
                        <Form.Group as={Col} event md="4" controlId="validationCustomUsername">
                            <Form.Label>Creator</Form.Label>
                            <InputGroup>
                                <Form.Control
                                    type="text"
                                    placeholder="Username"
                                    aria-describedby="inputGroupPrepend"
                                    ref={this.state.filters.created_by}
                                />
                                <InputGroup.Append>
                                    <Button as="input" type="reset" value="X" disabled />
                                </InputGroup.Append>
                            </InputGroup>
                        </Form.Group>
                        <Form.Group as={Col} controlId="exampleForm.ControlSelect1">
                            <Form.Label>Sport</Form.Label>
                            <Form.Control as="select" ref={this.state.filters.sport}>
                                {this.getSportsOptions()}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                        <Form.Group as={Col} event md="4" controlId="v3">
                            <Form.Label>Location</Form.Label>
                            {/* { todo make it a dropdown to select from locations we have} */}
                            <Form.Control as="select" ref={this.state.filters.location_name}>
                                {this.getLocationsOptions()}
                            </Form.Control>
                        </Form.Group>
                        <Form.Group as={Col} event md="4" controlId="validationCustomUsername">
                            <Form.Label>Number of teams</Form.Label>
                            <InputGroup>
                                <Form.Control
                                    type="text"
                                    placeholder="No. of teams"
                                    aria-describedby="inputGroupPrepend"
                                    ref={this.state.filters.no_of_teams}
                                />
                                <InputGroup.Append>
                                    <Button as="input" type="reset" value="X" disabled />
                                </InputGroup.Append>
                            </InputGroup>
                        </Form.Group>
                        <Form.Group as={Col} event md="3" controlId="v5">
                            <Form.Label>Tournament/For Fun</Form.Label>
                            <Form.Control as="select" ref={this.state.filters.is_a_tournament}>
                                <option value=''>-</option>
                                <option value='1'>Tournament</option>
                                <option value='0'>For Fun</option>
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    {this.getDateSelector()}
                    <Button className="twoButtons" onClick={this.handleSearch}>Search</Button>
                    <Button type="reset" className="twoButtons">Clear Filters</Button>
                </Form>
            </Jumbotron>);

    }
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
                        <h1>Browse Events!</h1>
                        <p>
                            Browse and search for events by creator username, sport, location, date, and whether or not it is a tournament or a for fun event.
                        </p>
                    </Jumbotron>
                    {this.renderSearchBar()}
                    <EventTable events={this.state.events} viewClickHandler={this.handleView} />
                </div>);
        }

    };
}

export default BrowseEventsPage;