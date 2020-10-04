FROM openjdk:14-alpine
COPY build/libs/core-*-all.jar core.jar
EXPOSE 8081
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "core.jar"]