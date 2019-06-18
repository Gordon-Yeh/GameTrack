import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import BrowseEventsPage from './pages/BrowseEventsPage';
import MyEventsPage from './pages/MyEventsPage';
import LeaderboardsPage from './pages/LeaderbooardsPage';
import CreateEventPage from './pages/CreateEventPage';
import MessagesPage from "./pages/MessagesPage";
import InvitesPage from "./pages/InvitesPage"
import EventPage from "./pages/EventPage"
import DraftMessagePage from "./pages/DraftMessagePage";

function AppRouter() {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/login/">Login</Link>
            </li>
            <li>
              <Link to="/signup/">signup</Link>
            </li> 
            <li>
              <Link to="/browseEvents/">Browse Events</Link>
            </li>
            <li>
              <Link to="/myEvents/">My Events</Link>
            </li>
            <li>
              <Link to="/leaderboards/">Leaderboards</Link>
            </li>
            <li>
              <Link to="/createEvent/">Create Events</Link>
            </li>
            <li>
              <Link to="/Messages/">Messages</Link>
            </li>
            <li>
              <Link to="/invites/">Invites</Link>
            </li>
            <li>
              <Link to="/Event/">Event</Link>
            </li>
            <li>
              <Link to="/draftmessage/">draftmessage</Link>
            </li>
          </ul>
        </nav>

        <Route path="/" exact component={LoginPage} />
        <Route path="/login/" component={LoginPage} />
        <Route path="/signup/" component={SignupPage} />
        <Route path="/browseEvents" component={BrowseEventsPage} />
        <Route path="/myEvents" component={MyEventsPage} />
        <Route path="/leaderboards" component={LeaderboardsPage} />
        <Route path="/createEvent/" component={CreateEventPage} />
        <Route path="/Messages/" component={MessagesPage} />
        <Route path="/invites/" component={InvitesPage} />
        <Route path="/Event/" component={EventPage} />
        <Route path="/draftmessage/" component={DraftMessagePage} />
      </div>
    </Router>
  );
}

export default AppRouter;