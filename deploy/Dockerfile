FROM adoptopenjdk/openjdk15
VOLUME /tmp
COPY build/libs/unieat-pigeon-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Duser.timezone='Asia/Seoul'", "-Xmx2048m", "-jar","/app.jar"]
