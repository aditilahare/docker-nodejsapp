FROM openjdk:8 AS BUILD_IMAGE

WORKDIR /todoApp

COPY build.gradle gradlew /todoApp/

COPY gradle /todoApp/gradle

COPY . .

RUN ./gradlew build

FROM openjdk:8-jre

WORKDIR /todoApp/

COPY --from=BUILD_IMAGE /todoApp/build/libs/todoApp.jar .

COPY --from=BUILD_IMAGE /todoApp/src/main/resources/static/todo.json .

CMD ["java","-jar","todoApp.jar"]
