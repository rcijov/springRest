# springRest
How to install using docker:

1) Database <br />
    docker pull postgres <br />
    docker run --rm -p:5432:5432 -d postgres <br />
    <br />
2) Backend <br />
    cd backend/ <br />
    docker build --no-cache --build-arg JAR_FILE=target/app-0.1.0.jar -t spring . <br />
    docker run -d -p 8080:8080 -ti spring <br />
    <br />
3) Frontend <br />
    cd frontend/ <br />
    docker build -t angular . <br />
    docker run -p 80:80 -d angular <br />
    <br />
As a result you have all the components run on the above ports: <br />
    5432 - Postgresql<br />
    8080 - Sprint Boot<br />
    80 - Angular<br />
    <br />
    <br />
* Modify the database postgres ip/port - credentials <br />
backend/src/main/resources/application.properties<br />
* Modify the frontend ip for the backend <br />
frontend/app/controllers.js<br />
