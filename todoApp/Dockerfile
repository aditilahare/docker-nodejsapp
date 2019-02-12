FROM openjdk:8 AS BUILD_IMAGE

ENV APP_HOME=/todoApp/

# RUN mkdir -p $APP_HOME/src/main/java

WORKDIR $APP_HOME

COPY build.gradle gradlew $APP_HOME/

COPY gradle $APP_HOME/gradle

# RUN ./gradle build

COPY . .

RUN ./gradlew build

FROM openjdk:8-jre

WORKDIR /src/todoApp/

COPY --from=BUILD_IMAGE /todoApp/build/libs/todoApp.jar .

COPY --from=BUILD_IMAGE /todoApp/src/main/resources/static/todo.json .

CMD ["java","-jar","todoApp.jar"]
