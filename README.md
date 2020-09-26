# Client-Server

This is a simple client server interacting system to confirm if the user is a bot or a human.
This project is developed using angular for client and spring boot for server.
Test cases are written for integration and controller layer.
As I am using a mac for development I cannot create a windows batch file.
I have created a docker image for easy use.
Follow instruction below to run it.

The project has been uploaded to docker hub and can be downloaded using below command. The below command also brings up the server.
<b>docker run --rm -d --name cp -p 8080:8080/tcp client-server:latest</b>
Open browser and visit url <b>http://localhost:8080</b>
After testing the app stop docker container using the below command.
<b>docker stop cp</b>

Note: I couldnt complete the project as soon as it was mailed because I was busy in travel and could start working on it the following day.
