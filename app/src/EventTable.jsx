import React from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

class EventTable extends React.Component {

    getRows = (dataSource) => {
        let rows = [];
        dataSource.forEach(event => {
            rows.push(<tr>
                <td>{event.name}</td>
                <td>{event.createdBy}</td>
                <td>{event.sport}</td>
                <td>{event.locationName}</td>
                <td>{new Date(event.dateAndTime).toUTCString()}</td>
                <td>{event.noOfTeams}</td>
                <td>{event.isTournament ? "Tournament" : "For Fun"}</td>
                {/* TODO hookup button to a redirect */}
                <td><Button type="button" className="twoButtons">View</Button></td>
            </tr>)
        });

        return (
            rows
        );
    };

    render() {
        return (
            <div>
                <Table bordered hover responsive>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Created By</th>
                            <th>Sport</th>
                            <th>Location</th>
                            <th>Date and Time</th>
                            <th>Number of teams</th>
                            <th>Tournament/For Fun</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.getRows(this.props.events)}
                    </tbody>
                </Table>
            </div>);
    };
}

export default EventTable;