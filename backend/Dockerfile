# STAGE 1
FROM gradle as build

RUN mkdir -p /app/src

COPY ./src /app/src
COPY ./build.gradle.kts /app
COPY ./settings.gradle /app
COPY ./gradle.properties /app
COPY ./gradlew /app
COPY ./gradle /app/gradle
WORKDIR /app
RUN ./gradlew --scan :shadowJar


# STAGE 2
FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /app

COPY --from=build /app/build/libs/app-1.0-SNAPSHOT-all.jar /app.jar
CMD ["java", "-jar", "/app.jar"]