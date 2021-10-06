VGSC Costa tool
Application to manage vehicles and services.

Solution have two parts:

- Backend
Java application to fetch list of vehicles and services from a Mockoon api, store them in a database and make them available via graphql

- Frontend
React application which will fetch services and vehicles and present them .

How to test BE part:

Prerequisites
- Run mvn clean install on root folder in application

Steps
1) Start "Simple vehicle Api" on Mockoon api tool in port 1337
2) Run SpringBoot application CostaToolApplication.java
3) Go to http://localhost:8080/playground to show graphql visual tool
4) Queries which are implemented:
    - To get all vehicles * query{getVehicles{id,name}} 
    - To get vehicle by id * query{
        getVehicleById(id:VEHICLE_ID){id,name}
      }
    - Add vehicle * {
      addVehicle(id: "1234", name: "car2"){id name}
      }
    - To listen to add events * subscription {vehicleCreation{id name}}

How to test FE part:

- Prerequisites
  Npm and node installed locally
  
  1) Go to folder /costa-tool/costa-tool-core/src/main/frontend/costa-client-2
  2) Run npm i
  3) Run npm start to open application on webbrowser
  4) Go to menu button "OPEN MENU" and switch between pages.
  5) Not much to see there :) but still using material lib for menu,table and container components
 
  TODO
  
  - Implement mutations on BE 
  - Test missing FE and BE. Had no time for it
  - Implement Apollo on FE to request graphql form BE
  - Refactor FE Functional? . Not so nice to look at now.
  - etc,etc