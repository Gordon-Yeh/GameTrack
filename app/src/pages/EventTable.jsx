import React from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

class EventTable extends React.Component {

    getRows = (dataSource) => {
        let rows = [];
        if (dataSource && dataSource.length > 0)
            dataSource.forEach(event => {
                rows.push(<tr>
                    <td>{event.name}</td>
                    <td>{event.creator_username}</td>
                    <td>{event.sport}</td>
                    <td>{event.location_name}</td>
                    <td>{new Date(event.start_date).toUTCString()}</td>
                    <td>{event.number_of_teams}</td>
                    <td>{event.is_a_tournament ? "Tournament" : "For Fun"}</td>
                    <td><Button type="button" className="twoButtons" onClick={() => this.props.viewClickHandler(event)}>View</Button></td>
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