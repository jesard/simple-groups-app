import React, { Component } from 'react';
import GroupsDataService from '../service/GroupsDataService';
import styles from "../styles"

class AddStudentComponent extends Component {

	constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }


  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();
    if (this.state.value.length > 100) {
      alert( 'Слишком длинное имя [>100 символов]' );
      return; 
    }
    GroupsDataService.insertStudent(this.state.value, this.props.id)
    .then(response => {
      this.setState({value: ''});
      this.props.refreshGroup()})
    .catch(error => alert(error));
    
  }

  render() {
    return (
      <form 
      onSubmit={this.handleSubmit}
      style={{marginBottom: "2%"}}>
        	<input 
          placeholder="ФИО"
          type="text" 
          value={this.state.value} 
          onChange={this.handleChange} 
          required 
          style={styles.Input}/>
        	<p><input 
          type="submit" 
          value="Принять нового студента"
          style={styles.Button} /></p>
      </form>
    );
  }

}

export default AddStudentComponent