import React, { Component } from 'react';
import GroupsDataService from '../service/GroupsDataService';
import AddGroupComponent from './AddGroupComponent';
import styles from "../styles"


class ListGroupsComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            groups: [],
            message: null
        }
        this.refreshGroups = this.refreshGroups.bind(this)
    }

    componentDidMount() {
        this.refreshGroups();
    }

    refreshGroups() {
        GroupsDataService.retrieveAllGroups()
            .then(response => {
                    this.setState({ groups: response.data })})
            .catch(error => alert(error))                
    }

    render() {

        return (
            <div className="container">
                <h3 style={styles.Header}>Группы университета ScaleApps</h3>
                    <table className="table" style={styles.Table}>
                        <thead>
                            <tr>
                                <th style={styles.Th}>Номер</th>
                                <th style={styles.ThCenter}>Количество студентов</th>
                                <th style={styles.Th}>Действия</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.groups.map(
                                    group =>
                                        <tr key={group.id}>
                                            <td style={styles.Td}
                                                >{group.number}</td>
                                            <td style={styles.TdCenter}>{group.studentCount}</td>
                                            <td style={styles.Td}><a href={'/groups/' + group.id}>Edit</a></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <AddGroupComponent/>
            </div>
        )
    }
}

export default ListGroupsComponent