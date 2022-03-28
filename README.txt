Game of Life - Brian Heaphy for Ohme

The GameOfLifeController is used to progress the universe evolution through HTTP requests and returns a HTML string.

Step 1:
Run the Spring Boot application, which will default to http://localhost:8080

This can be done through an IDE or by using the gameoflife-0.0.1-SNAPSHOT.jar in the target folder (Using the below cmd).

To create the jar run: mvn clean package
This will put the .jar in the target folder.

java -jar gameoflife-0.0.1-SNAPSHOT.jar

Step 2:
In your browser, navigate to http://localhost:8080/state

This will display the start state for a universe with the 'Glider' pattern in place.

Step 3:
In your browser, navigate to http://localhost:8080/tick

Each time you refresh the page you will be able to see the progression of the universe as the cells die/live.

Finally:
If you want to reset the universe, navigate to http://localhost:8080/reset


