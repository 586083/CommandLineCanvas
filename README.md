** Usage Information **

** Revision history **

 S.No  | Description  | Date  | Author  
 --  | --  | --  | --  
 1  | Initial Draft |  26-Jun-2021 |  Aravinthraj C


# Canvas

** This application create an canvas and help to execute below command ** 


C w h  Should create a new canvas of width w and height h.

L x1 y1 x2 y2 Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.

R x1 y1 x2 y2 Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.

B x y c Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.

Q Should quit the program.


## How to run the application

Step 1: Change to project director
** cd /Users/aravinthrajchakkaravarthy/eclipse-workspace/canvas **

Step 2: Clean , install the dependency and package the application
**mvn clean install package**

Step 3: Go to target folder which has jar file
**cd target**

Step 4: Execute jar via java command
**java -cp canvas-0.0.1-SNAPSHOT.jar app.CommandLineCanvas**

### Extensible Design

In Future any need command need to be added then create an command implementation class and add to CmdFactory.java