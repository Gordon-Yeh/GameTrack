import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import BrowseEventsPage from './pages/BrowseEventsPage';
import MyEventsPage from './pages/MyEventsPage';
import LeaderboardsPage from './pages/LeaderbooardsPage';
import MessagesPage from "./pages/MessagesPage";
import EventSettingsPage from './pages/EventSettingsPage';
import InvitesPage from "./pages/InvitesPage"
import EventPage from "./pages/EventPage"
import DraftMessagePage from "./pages/DraftMessagePage";
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'

function AppRouter() {
  return (
    <Router>
      <Navbar bg="light" expand="lg" style={{ marginBottom: '50pt' }}>
        <Navbar.Brand href="#home">GameTracker</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/login/">Login</Nav.Link>
            <Nav.Link href="/signup/">Sign Up</Nav.Link>
            <Nav.Link href="/browseEvents/">Browse Events</Nav.Link>
            <Nav.Link href="/myEvents/">My Events</Nav.Link>
            <Nav.Link href="/leaderboards/">Leaderboards</Nav.Link>
            <Nav.Link href="/event/create">Create Event</Nav.Link>
            <Nav.Link href="/invites/">Invites</Nav.Link>
            <Nav.Link href="/Messages/">Messages</Nav.Link>
            <Nav.Link href="/draftmessage/">Send Message</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>

      <Route path="/" exact component={LoginPage} />
      <Route path="/login/" component={LoginPage} />
      <Route path="/signup/" component={SignupPage} />
      <Route path="/browseEvents" component={BrowseEventsPage} />
      <Route path="/myEvents" component={MyEventsPage} />
      <Route path="/leaderboards" component={LeaderboardsPage} />
      <Route path="/Messages/" component={MessagesPage} />
      <Route path="/draftmessage/" component={DraftMessagePage} />
      <Route path="/invites/" component={InvitesPage} />
      <Route path="/event/" exact component={EventPage} />
      <Route path="/event/create" component={EventSettingsPage} />
      {/* reference: https://tylermcginnis.com/react-router-pass-props-to-components/ */}
      <Route path="/event/edit" render={(props) => <EventSettingsPage {...props} isEditing/>} />
    </Router>
  );
}

export default AppRouter;