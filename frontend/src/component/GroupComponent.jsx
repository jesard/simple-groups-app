import React, { Component } from 'react';
import GroupsDataService from '../service/GroupsDataService';
import AddStudentComponent from './AddStudentComponent';
import ListStudentsComponent from './ListStudentsComponent';
import { Redirect } from 'react-router-dom';
import styles from "../styles";

class GroupComponent extends Component {

	constructor(props) {
        super(props)
        this.state = {
        	id: this.props.match.params.id,
        	group: null,
        	students: [],
        	redirect: false
        }
        this.backToGroups = this.backToGroups.bind(this);
        this.refreshGroup = this.refreshGroup.bind(this);
    
    }

    componentDidMount() {
    	this.refreshGroup();
    }

    refreshGroup() {
    	GroupsDataService.retrieveGroup(this.state.id)
            .then(response => this.setState({
                group: response.data.number,
                students: response.data.students}))
            .catch(error => alert(error))
    }


    backToGroups() {
    	this.setState({ redirect: true });
    }

    render() {

    	const { redirect, group } = this.state;

    	if (redirect) {
    		return <Redirect to='/groups' />
    	}

	    return (
	    	<div>
	    	<h3 style={styles.Header}>Группа № {group}</h3>
	        	<ListStudentsComponent refreshGroup={this.refreshGroup} students={this.state.students} id={this.state.id} />
	            <AddStudentComponent refreshGroup={this.refreshGroup} id={this.state.id} />
	            <button 
                onClick={this.backToGroups} 
                type="button"
                style={styles.Button}>Вернуться к списку групп</button>
	        </div>
	    )
	}

}

export default GroupComponent