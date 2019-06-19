
import React from 'react';
import EventTable from './EventTable';
import Jumbotron from 'react-bootstrap/Jumbotron'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import { getProjectedEvents } from '../api/event';

class EventPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            events: [],
            name: true,
            host_username: true,
            sport: true,
            locationName: true,
            startDate: true,
            number_of_teams: true,
            is_a_tournament: true
        };
        this.refreshTable(this.getFilter());
    }

    handleView = () => {
        alert("Does nothing on this view!");
    }

    getCheckBox = (label, field) => {
        return (
            <Form.Check type="checkbox" label={label} checked={field} handleCheckboxChange={() => field = !field} />
        );
    }

    refreshTable = (filters) => {
        getProjectedEvents(filters).then(e => this.setState({ events: e }));
    }

    getFilter = () => {
        let filter = {};
        filter.name = this.state.name;
        filter.host_username = this.state.host_username;
        filter.sport = this.state.sport;
        filter.locationName = this.state.locationName;
        filter.startDate = this.state.startDate;
        filter.number_of_teams = this.state.number_of_teams;
        filter.is_a_tournament = this.state.is_a_tournament;
        return filter;
    }

    onProjectClicked = () => {
        let filters = this.getFilter();
        this.refreshTable(filters);
    }

    render() {
        return (
            <div className="main-content">
                <Jumbotron>
                    <h1>Project Events Attributes!</h1>
                    <p>
                        Project all you want! Select which attributes you want to see.
                        </p>
                    <Form>
                        <Form.Group controlId="formBasicChecbox">
                            <Form.Check type="checkbox" label="Name" checked={this.state.name} onChange={() => this.setState({ name: !this.state.name })} disabled={true} />
                            <Form.Check type="checkbox" label="Created By" checked={this.state.host_username} onChange={() => this.setState({ host_username: !this.state.host_username })} />
                            <Form.Check type="checkbox" label="Sport" checked={this.state.sport} onChange={() => this.setState({ sport: !this.state.sport })} />
                            <Form.Check type="checkbox" label="Location" checked={this.state.locationName} onChange={() => this.setState({ locationName: !this.state.locationName })} />
                            <Form.Check type="checkbox" label="Date and Time" checked={this.state.startDate} onChange={() => this.setState({ startDate: !this.state.startDate })} />
                            <Form.Check type="checkbox" label="Number of Teams" checked={this.state.number_of_teams} onChange={() => this.setState({ number_of_teams: !this.state.number_of_teams })} />
                            <Form.Check type="checkbox" label="Tournament/For Fun" checked={this.state.is_a_tournament} onChange={() => this.setState({ is_a_tournament: !this.state.is_a_tournament })} disabled={true} />
                        </Form.Group>
                        <Button variant="primary" onClick={() => this.onProjectClicked()}>
                            Project!
                            </Button>
                    </Form>
                </Jumbotron>
                <EventTable events={this.state.events} viewClickHandler={this.handleView} />
            </div>);
    };
}

export default EventPage