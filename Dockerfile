FROM maven:3.6.3-jdk-11
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY src /app/src
RUN mvn package
CMD ["mvn", "test"]
