FROM java:openjdk-8-jdk-alpine

# add directly the jar
ADD build/libs/client-server.jar client-server.jar


# to create a modification date
RUN sh -c 'touch client-server.jar'

CMD ["java", "-jar", "client-server.jar"]

EXPOSE 8080