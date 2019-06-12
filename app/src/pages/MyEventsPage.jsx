import React from 'react';

import Jumbotron from 'react-bootstrap/Jumbotron'
import EventTable from './EventTable'
import eventSample from '../test-data/events.json'

class MyEventsPage extends React.Component {

    render() {
        return(
            <div className="main-content">
                <Jumbotron>
                    <h1>My Events!</h1>
                    <p>
                        Browse through all of the events you created and participated in.
                    </p>
                </Jumbotron>
                <h2>Events You Created:</h2>
                <EventTable events={[eventSample.events[0]]}/>
                <h2>Events You Joined:</h2>
                <EventTable events={[eventSample.events[1]]}/>
            </div>
        )
    }
}

export default MyEventsPage;