# GameOfThree
Game of Three Project

Game of Three
Algorithm:
1. Create a 'GameOfThree' Restfull Webservice API.
2. Create a 'PlayerService' GET call inside the API and write divisible by 3 logic and send the response back.
3. Host the API in Tomcat server and validate the logic.
	URL:- http://localhost:8080/GameOfThree/rest/PlayerService/numbers/Player1/10
	Player1 : The name of the player who is the current player.
	10 : Random number / Number sent by current player.
4. Create a simple JAVA project (client) who is going to consume the REST API.
5. Create 2 players inside the project who is going to play the game.
6. Create a random number. Assign the random number to Player1 who is starting the game.
7.  Call REST API  - 'PlayerService' GET call and collect the divided by 3 number and assign it to the other player.
8. Check if the other player is ready, if not, then the current player keeps on playing.
9. Do STEP 7 & 8, till response = 1. 
10. Once response is 1, the current player wins the GAME!

Content:
1. GameOfThree RESTFULL WebService API
2. PlayerProject JAVA Project.

Steps to install and run the application:
1. Download both the applications from GIT - https://github.com/aychakraborty/GameOfThree.
2. Install Tomcat Server in Eclipse. Run the GameOfThree WAR is Tomcat Server.
3. Run RestClient.java from PlayerProject as 'Run As Java Application'.
