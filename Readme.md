# Prerequisites
- Java JDK 11
- Docker Installed

# How to run

## Running the BE services
- Run with docker-compose `docker-compose up -d`
- Make sure both postgres, wiremock and be services running by using `docker container ls -a`
- Open the Swagger UI http://localhost:8000/docs#/

## Executing the Test
- Open with your favorite IDE (e.g. Intellij IDEA or VSCode)
- You can run the test by using command :`./gradlew clean test`
- Report can be seen on folder `build/reports/tests/test/index.html`

TODO : 
1. Add Logging
2. Add Synchronous data storage
3. Find out how to run with specific tags
4. Try use test suite?
5. Run with different environment

Pipeline :
1. Create another repo for the BE code implementation
2. Try to find how to add schema
3. Try to create a pipeline to trigger build pipeline for publishing docker, then run the automation test from different repo
4. 