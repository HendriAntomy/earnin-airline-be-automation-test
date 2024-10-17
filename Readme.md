# Prerequisites
- Java JDK 11
- Docker Installed

# How to run

## Running the BE services
- Make exec_sql.sh executable `chmod +x ./.docker/db/exec_sql.sh`
- Run with docker-compose `docker-compose up -d`
- Make sure both postgres, wiremock and be services running by using `docker container ls -a`
- Open the Swagger UI http://localhost:8000/docs#/

## Executing the Test
- Open with your favorite IDE (e.g. Intellij IDEA or VSCode)
- You can run the test by using command :`./gradlew clean test`
- Report can be seen on folder `build/reports/tests/test/index.html`