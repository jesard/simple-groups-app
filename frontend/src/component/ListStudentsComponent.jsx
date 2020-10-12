import React, { Component } from 'react';
import GroupsDataService from '../service/GroupsDataService';
import { Link } from 'react-router-dom';
import styles from "../styles";

class ListStudentsComponent extends Component {
	constructor(props) {
        super(props)
        this.state = {}
        this.deleteStudent = this.deleteStudent.bind(this);
       
    
    }

    deleteStudent(id, event) {
    	event.preventDefault();
    	GroupsDataService.deleteStudent(this.props.id, id)
    	.then(response => this.props.refreshGroup())
    	.catch(error => alert(error));
    	
    }


    render() {

    	const students = this.props.students;

	    return (
	        <div>
	            <table className="table" style={styles.Table}>
	                    <thead>
	                        <tr>
	                            <th style={styles.Th}>Дата принятия</th>
	                            <th style={styles.ThCenter}>ФИО студента</th>
	                            <th style={styles.Th}>Действия</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        {
	                            students.map(
	                                student =>
	                                    <tr key={student.id}>
	                                        <td style={styles.Td}>{student.date}</td>
	                                        <td style={styles.TdCenter}>{student.name}</td>
	                                        <td style={styles.Td}><Link to='' onClick={(e) => this.deleteStudent(student.id, e)}>Delete</Link></td>
	                                    </tr>
	                            )
	                        }
	                    </tbody>
	            </table>
	        </div>
	    )
	}
}

export default ListStudentsComponent