
# Celebrity  
Repository to resolve the "Find the celebrity problem"  
  
### Steps to compile the project  
This is a Maven project that builds a SpringBoot application that uses a MySQL database, to compile the project, edit the `application.properties` file, to set the correct database connection details, after execute `mvn clean install`.

If everything works, you shoul see a file in the project's target folder, called `Celebrity-0.0.1-SNAPSHOT.jar`

### Steps to execute the project  

After the compilation stuff, you should execute the application executing:
`java -jar target/Celebrity-0.0.1-SNAPSHOT.jar <groupId>`

The `groupId` parameter, specifies the group's id where the application will try to find the celebrity.

When the application starts by the first time, it will try to create the database structure using `liquibase`.

#### Example
`java -jar target/Celebrity-0.0.1-SNAPSHOT.jar 1`

The result should be something like: 
```
Starting to find the celebrity for the 1 group, using the brute force algorithm
The celebrity in the group 1 is Christian
Finishing to find the celebrity for the 1 group, using the brute force algorithm
Starting to find the celebrity for the 1 group, using the stack algorithm
The celebrity in the group 1 is Christian
Finishing to find the celebrity for the 1 group, using the stack algorithm
```