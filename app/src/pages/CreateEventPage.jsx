import React from 'react';
import { Redirect } from "react-router-dom";
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';
import { createEvent } from '../api/event';
import { getLocations } from '../api/location';

const MAX_ALLOWED_TEAM = 8;
const CURRENT_YEAR = new Date().getFullYear();
const CURRENT_MONTH = new Date().getMonth();
const CURRENT_DATE = new Date().getDate();

const getArrayWithRange = (a, b) => {
  let arr = [];
  for (let i = a; i <= b; i++) arr.push(i);
  return arr;
}

const eventTypes = {
  CASUAL: 'Casual',
  TOURNAMENT: 'Tournament'
};

const sportsList = {
  SOCCER: 'Soccer',
  BASKETBALL: 'Basketball',
  TENNIS: 'Tennis',
  FOOTBALL: 'Football'
};

const errorMessages = {
  'USERNAME_ALREADY_EXIST': 'Wrong combination of username and password'
};

class CreateEventPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      validated: false,
      error: null,
      success: false,

      eventType: null,
      startYear: CURRENT_YEAR,
      startMonth: CURRENT_MONTH,
      startDate: CURRENT_DATE,
      startTime: null,

      durationHour: 1,
        
      sport: null,
      locationId: null,
      teamSize: null,
      numberOfTeams: 2,

      availableLocations: null
    };
    // This binding is necessary to make `this` work in the callback
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleEventTypeChange = this.handleEventTypeChange.bind(this);
    this.handleSportChange = this.handleSportChange.bind(this);
    this.handleLocationIdChange = this.handleLocationIdChange.bind(this);
    this.handleNumberOfTeamsChange = this.handleNumberOfTeamsChange.bind(this);
    this.handleTeamSizeChange = this.handleTeamSizeChange.bind(this);
    this.handleStartYearChange = this.handleStartYearChange.bind(this);
    this.handleStartMonthChange = this.handleStartMonthChange.bind(this);
    this.handleStartDateChange = this.handleStartDateChange.bind(this);
    this.handleStartTimeChange = this.handleStartTimeChange.bind(this);
    this.handleDurationHourChange = this.handleDurationHourChange.bind(this);
  }

  handleSportChange(e) {
    const val = e.target.value;
    if (Object.keys(sportsList).indexOf(val) > -1) {
      getLocations(val)
        .then((locationList) => {
          this.setState({
            sport: val,
            locationId: null,
            availableLocations: locationList
          });      
        })
    }
  }

  handleEventTypeChange(e) {
    const val = e.target.value;
    if (val === 'TOURNAMENT') {
      this.setState({ eventType: val });
    } else {
      this.setState({
        numberOfTeams: 2, 
        eventType: val 
      });
    }
  }

  handleLocationIdChange(e) {
    const val = e.target.value;
    if (this.state.availableLocations.filter(loc => loc.locationId === val).length > 0) {
      this.setState({ locationId: val });
    }
  }

  handleNumberOfTeamsChange(e) {
    const val = e.target.value;
    if (val >= 2 && val <= MAX_ALLOWED_TEAM) {
      this.setState({ numberOfTeams: val });
    }
  }

  handleTeamSizeChange(e) {
    const val = e.target.value;
    if (Number(val) > 0) {
      this.setState({ teamSize: val });
    }
  }

  handleStartYearChange(e) {
    const val = e.target.value;
    this.setState({ startYear: val });
  }

  handleStartMonthChange(e) {
    const val = e.target.value;
    this.setState({ startMonth: val });
  }

  handleStartDateChange(e) {
    const val = e.target.value;
    this.setState({ startDate: val });
  }

  handleStartTimeChange(e) {
    const val = e.target.value;
    this.setState({ startTime: val });
  }

  handleDurationHourChange(e) {
    const val = e.target.value;
    this.setState({ durationHour: val });
  }

  handleSubmit(e) {
    // prevents to page from reloading
    const { eventType, sport, locationId, teamSize, numberOfTeams, startYear, startMonth, startDate, startTime, durationHour } = this.state;
    e.preventDefault();
    e.stopPropagation();

    const eventInfo = {};
    eventInfo.is_a_tournament = (eventType === 'TOURNAMENT');
    eventInfo.sport = sport;
    eventInfo.location_id = locationId;
    eventInfo.team_size = teamSize;
    eventInfo.number_of_teams = numberOfTeams;
    
    let st = new Date(startYear, startMonth, startDate);
    st.setHours(startTime);
    console.log(st.toISOString());
    eventInfo.start_time = st.valueOf();

    const hour_to_ms_mask = 3600000;
    eventInfo.end_time = eventInfo.start_time + (durationHour * hour_to_ms_mask);
    console.log(new Date(eventInfo.end_time).toISOString());
    console.log(eventInfo);
    
    createEvent(eventInfo)
      .then(() => {
        this.setState({ success: true });
      })
      .catch((err) => {
        this.setState({ error: err });
      });
  }

  render() {
    const { validated, error, success } = this.state;
    const { eventType, sport, locationId, teamSize, numberOfTeams } = this.state;
    const { startYear, startMonth, startDate, startTime, durationHour } = this.state;
    const { availableLocations } = this.state;

    // TODO: should redirect to event page once done
    if (success === true) return <Redirect to="/browseEvents" />;

    return (
      <div
        style={{
          height: '100%',
          marginTop: '30vh'
        }}
      >
        <Container>
          <Row className="justify-content-center">
            <Col xs={10} s={10} md={7} lg={5}
              style={{
                padding: '30px 20px 30px 20px',
                backgroundColor: '#efefef',
                borderRadius: '.25rem'
              }}
            >
              <h1>Create New Event</h1>
              {error && (
                <Alert variant="danger">
                  {Object.keys(errorMessages).indexOf(error) > 0 ? errorMessages[error] : error}
                </Alert>
              )}
              
              <Form 
                noValidate
                validated={validated}
                onSubmit={this.handleSubmit}
              >
                <Form.Group controlId="eventType">
                    <Form.Label>Event Type</Form.Label>
                    <Form.Control 
                      as="select"
                      onChange={this.handleEventTypeChange}
                      value={eventType ? eventType : ''}
                      required
                    >
                      <option value="">-</option>
                      {Object.keys(eventTypes).map((type) => (
                        <option key={type} value={type}>
                          {eventTypes[type]}
                        </option>
                      ))}
                    </Form.Control>
                </Form.Group>

                {eventType === 'TOURNAMENT' && (
                  <Form.Group controlId="numberOfTeams">
                    <Form.Label>Number Of Teams</Form.Label>
                    <Form.Control 
                      as="select"
                      onChange={this.handleNumberOfTeamsChange}
                      value={numberOfTeams}
                      required
                    >
                      {Array
                        .from(Array(MAX_ALLOWED_TEAM + 1).keys())
                        .filter(num => num >= 2)
                        .map(num => <option value={num}>{num}</option>)
                      }
                    </Form.Control>
                  </Form.Group>
                )}

                <Form.Group controlId="teamSize">
                    <Form.Label>Team Size</Form.Label>
                    <Form.Control 
                      as="select"
                      onChange={this.handleTeamSizeChange}
                      value={teamSize ? teamSize : ''}
                      required
                    >
                      <option value="">-</option>
                      {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((num) => (
                        <option key={num} value={num}>
                          {num}
                        </option>
                      ))}
                    </Form.Control>
                </Form.Group>

                <Form.Group controlId="sport">
                  <Form.Label>Sport</Form.Label>
                  <Form.Control 
                    as="select"
                    onChange={this.handleSportChange}
                    value={sport ? sport : ''}
                    required
                  >
                    <option value="">-</option>
                    {Object.keys(sportsList).map((sp) => (
                      <option key={sp} value={sp}>
                        {sportsList[sp]}
                      </option>
                    ))}
                  </Form.Control>
                </Form.Group>

                {availableLocations && (
                  <Form.Group controlId="location">
                    <Form.Label>Location</Form.Label>
                    <Form.Control 
                      as="select"
                      onChange={this.handleLocationIdChange}
                      value={locationId ? locationId : ''}
                      required
                    >
                      <option value="">-</option>
                      {availableLocations.map((loc) => (
                        <option key={loc.locationId} value={loc.locationId}>
                          {loc.name}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>
                )}

                <Form.Row>
                  <Form.Group as={Col} controlId="startYear">
                    <Form.Label>Year</Form.Label>
                    <Form.Control as="select" value={startYear} onChange={this.handleStartYearChange} required>
                      {getArrayWithRange(CURRENT_YEAR, CURRENT_YEAR+3).map((yr) => (
                        <option key={yr} value={yr}>
                          {yr}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>

                  <Form.Group as={Col} controlId="startMonth">
                    <Form.Label>Month</Form.Label>
                    <Form.Control as="select" value={startMonth} onChange={this.handleStartMonthChange} required>
                      {getArrayWithRange(1, 12).map((mon) => (
                        <option key={mon} value={mon-1 /* -1 because js Date's month is 0 based */}>
                          {mon}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>

                  <Form.Group as={Col} controlId="province">
                    <Form.Label>Date</Form.Label>
                    <Form.Control as="select" value={startDate} onChange={this.handleStartDateChange} required>
                      {getArrayWithRange(1, 31).map((date) => (
                        <option key={date} value={date}>
                          {date}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>
                </Form.Row>

                <Form.Row>
                  <Form.Group as={Col} controlId="startTime">
                    <Form.Label>Start Time</Form.Label>
                    <Form.Control as="select" value={startTime} onChange={this.handleStartTimeChange} required>
                      {getArrayWithRange(8, 20).map((hr) => (
                        <option key={hr} value={hr}>
                          {`${hr}:00`}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>

                  <Form.Group as={Col} controlId="startTime">
                    <Form.Label>Duration (Hours)</Form.Label>
                    <Form.Control as="select" value={durationHour} onChange={this.handleDurationHourChange} required>
                      {getArrayWithRange(1, 6).map((hr) => (
                        <option key={hr} value={hr}>
                          {hr}
                        </option>
                      ))}
                    </Form.Control>
                  </Form.Group>
                </Form.Row>

                <Button variant="primary" type="submit">
                  Submit
                </Button>
                </Form>
            </Col>
          </Row>
        </Container>
      </div>
    );
  };
};

export default CreateEventPage;
