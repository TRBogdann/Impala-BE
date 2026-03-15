FROM eclipse-temurin:21-jdk

WORKDIR /var/www/app

COPY build.gradle ./
COPY settings.gradle ./
COPY gradle gradle
COPY gradlew ./

RUN ./gradlew dependencies --no-daemon

EXPOSE 9000

CMD ["./gradlew", "bootRun", "--no-daemon", "-Dorg.gradle.jvmargs=-Dspring.devtools.restart.enabled=true"]