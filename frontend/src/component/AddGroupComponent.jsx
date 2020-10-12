import React, { Component } from 'react';
import GroupsDataService from '../service/GroupsDataService';
import { Redirect } from 'react-router-dom';
import styles from "../styles"

class AddGroupComponent extends Component {
	
	constructor(props) {
    super(props);
    this.state = {
    				value: '',
    				redirect: false,
    				id: 0
				};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();
    if (this.state.value.length > 50) {
      alert( 'Слишком длинный номер [>50 символов]' );
      return; 
    }
    GroupsDataService.insertGroup(this.state.value)
    	.then(response => this.setState({ 
    					value: '',
    					redirect: true,
    					id: response.data.id}))
      .catch(error => {
        if (error.response) {
          alert(error.response.data);
        } else {
          alert(error);
        }
      })
  }

  render() {

  	const { redirect } = this.state;

    if (redirect) {
    	return <Redirect to={'/groups/' + this.state.id}/>;
    }

    return (
	    <form 
      onSubmit={this.handleSubmit}
      style={{}}>
	       	<input 
          placeholder="Номер группы"
          type="text"
          value={this.state.value}
          onChange={this.handleChange}
          required 
          style={styles.Input}/>
	        <p><input 
          type="submit" 
          value="Добавить новую группу"
          style={styles.Button} /></p>
	    </form>
    );
  }



}

export default AddGroupComponent
