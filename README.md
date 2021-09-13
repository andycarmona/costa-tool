VGSC Costa tool
Application to manage vehicles and services.

It is defined in two parts:
- Backend
Java application to fetch list of vehicles and services from a Mockoon api, store them in a database and make them available via graphql

- Frontend
React application which will fetch services and vehicles and present them .

How to test:

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
