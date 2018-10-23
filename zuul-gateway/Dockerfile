FROM maven:3.5.4-jdk-8

ENV APP_DIR=/usr/src/app

RUN mkdir -p $APP_DIR
WORKDIR $APP_DIR

ADD pom.xml pom.xml
RUN mvn dependency:go-offline -B

ADD ./src $APP_DIR/src
RUN mvn package

EXPOSE 8080
CMD java -jar target/zuulGateway.jar
