FROM maven:3.6.1-jdk-8-alpine
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean 