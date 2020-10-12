import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import ListGroupsComponent from './component/ListGroupsComponent';
import GroupComponent from './component/GroupComponent';


class App extends Component {
  render() {
    return (
      	<div className="container">
        	<Router>
                		<Switch>
                			<Route exact path="/"> <Redirect to="/groups" /> </Route>
		                    <Route path="/groups" exact component={ListGroupsComponent} />
		                    <Route path="/groups/:id" component={GroupComponent} />
                		</Switch>
        	</Router>
      	</div>
    );
  }
}

export default App;
