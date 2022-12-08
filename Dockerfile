FROM maven:3-openjdk-17 as build
COPY  /src /app
WORKDIR /app

# If you want to skip the test in creating image use line below and comment "RUN mvn clean package"
RUN mvn clean package -Dmaven.test.skip=true

# If you want to run the test in creating image use line below and comment "RUN mvn clean package -Dmaven.test.skip=true"
#RUN mvn clean package

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build ./app/target /app
ENTRYPOINT ["java","-jar" , "merchant.jar"]
