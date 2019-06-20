import React from 'react';

import Jumbotron from 'react-bootstrap/Jumbotron'
import EventTable from './EventTable'
import {getUserEvents, getEventsUserJoined} from '../api/event'
import { Redirect } from 'react-router-dom'
import {getSessionFromCookie} from '../session'

class MyEventsPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {eventsCreated: [], eventsJoined: [], redirectToEvent: false, redirectEvent: null};
        let currentUser  = getSessionFromCookie();
        if(currentUser) {
            getUserEvents(currentUser.user_id).then(e => this.setState({eventsCreated: e}));
            getEventsUserJoined(currentUser.user_id).then(e => this.setState({eventsJoined: e}));
        }
    }

    handleView = (event) => {
        this.setState({ redirectToEvent: true, redirectEvent: event });
    }

    render() {
        if(this.state.redirectToEvent) {
            return (
                <Redirect to={{
                    pathname: '/Event',
                    state: { event: this.state.redirectEvent }
                }}
                />
            );
        } else {
            return(
                <div className="main-content">
                    <Jumbotron>
                        <h1>My Events!</h1>
                        <p>
                            Browse through all of the events you created and participated in.
                        </p>
                    </Jumbotron>
                    <h2>Events You Created:</h2>
                    <EventTable events={this.state.eventsCreated} viewClickHandler={this.handleView}/>
                    <h2>Events You Joined:</h2>
                    <EventTable events={this.state.eventsJoined} viewClickHandler={this.handleView}/>
                </div>
            )
        }
    }
}

export default MyEventsPage;