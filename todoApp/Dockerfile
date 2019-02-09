FROM gradle:jre-alpine

WORKDIR /src/app

COPY /build/libs/todoApp-0.0.1-SNAPSHOT.jar HelloWorld.jar

CMD ["java", "-jar", "HelloWorld.jar"]