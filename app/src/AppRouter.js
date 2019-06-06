import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import BrowseEventsPage from './BrowseEventsPage';
import MyEventsPage from './MyEventsPage'
import LeaderboardsPage from './LeaderbooardsPage'

// function Index() {
//   return <h2>Home</h2>;
// }

function About() {
  return <h2>About</h2>;
}

function Users() {
  return <h2>Users</h2>;
}

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
              <Link to="/about/">About</Link>
            </li>
            <li>
              <Link to="/users/">Users</Link>
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
          </ul>
        </nav>

        <Route path="/" exact component={SignupPage} />
        <Route path="/about/" component={About} />
        <Route path="/users/" component={Users} />
        <Route path="/login/" component={LoginPage} />
        <Route path="/signup/" component={SignupPage} />
        <Route path="/browseEvents" component={BrowseEventsPage} />
        <Route path="/myEvents" component={MyEventsPage} />
        <Route path="/leaderboards" component={LeaderboardsPage} />
      </div>
    </Router>
  );
}

export default AppRouter;