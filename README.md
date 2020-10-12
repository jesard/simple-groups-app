# Simple Groups App

The app is just a simple university group management utility. 
Features: 
* List university groups
* Group creation
* Edit group members:
  * List group members
  * Add
  * Delete


# Run the Appication


## Data base
The app has MySQL backend. 
* To initialize base for the app one should run `sql/groups.sql` script aginst own MySQL server.
* The app uses MySQL credentials and JDBC connection string from `src/main/resources/mysql.jdbc.properties`. Modify for your MySQL connection.


## Build java backend

Run `mvn install`.


## Run java backend

Run `java -jar simple-groups-app-1.0-SNAPSHOT.jar` from `target/` folder


## Build React.js frontend
For front-end web-UI I used React-Application.
`npm install` in `frontend/` folder.


## Run Web-UI
Run `npm start` in `frontend/` folder.


The app consists of two pages. First is for list of university groups [http://localhost:3000/groups](http://localhost:3000/groups). Another is for Group member studends list, one per group e.g. [http://localhost:3000/groups/1](http://localhost:3000/groups/1) the group is determined by ID (1 in the example).

