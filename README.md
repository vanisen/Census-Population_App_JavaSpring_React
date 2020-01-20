# Census Population App

This application uploads the census data and provides query on it.<br/>
It appllication is based on CQRS design patter with shared database. It has different handlers for POST and GET services.

## Pre-Requisite softwares:

1. Java 8
2. Maven 3+
3. MySQL
4. npm

## Tech Stacks used:

1. Java 8
2. Maven 3+
3. MySQL
4. Spring Boot
5. Spring Data
6. Spring Exception Handling
7. React

## Steps to run the application - backend:

1. Start MySQL
2. create census schema in MySQL
3. change directory to census application in terminal
4. update the line 16 of resources/application.properties with a temprary working folder to store the uploaded file
5. build census - mvn clean install
6. Execue in terminal - java -jar target/demographics-1.0-SNAPSHOT.jar

## Steps to run the application - frontend:

Navigate to census/census-client folder

# `npm install`

Installs the node dependencies for the project.<br/>
It will download the required third party dependencies and install them.

## `npm run start`

Runs the app in the development mode.<br />
The page will reload if you make edits.<br />
You will also see any lint errors in the console.

## `npm run test`

Launches the test runner in the interactive watch mode.<br />

## `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

## Notes
The Census Client has a basic UI for visualizing limited data.<br/>
It can be improved further by including pagination, lazy loading etc.<br/>

## Additional Information : Below are sample URLs for each functionality in the app

1. Import Data 2010 Census Populations by Zip Codefrom CSV into Database for use by API.
	METHOD: POST
	URL: http://localhost:8080/census/upload
	SAMPLE PAYLOAD: https://data.lacity.org/api/views/nxs9-385f/rows.csv?accessType=DOWNLOAD
	FILE UPLOAD NAME: file
2. Return all zipcodes which have a total population within range provided by the client.
    METHOD: GET
	URL: http://localhost:8080/census/pupulation/range?start=1&end=10
3. Return all zipcodes which have a median age within a range provided by the client.
    METHOD: GET
	URL: http://localhost:8080/pupulation//medianage?start=10&end=19.3
4. Return top X number of most populated zipcodes.
    METHOD: GET
	URL: http://localhost:8080/pupulation/polulated?top=90
2. Return all zipcodes with more females than males ordered by the difference descending.
    METHOD: GET
	URL: http://localhost:8080/pupulation/genderdiff


