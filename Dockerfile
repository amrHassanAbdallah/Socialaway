FROM openjdk:8-jre-alpine

# Copy war file
COPY build/Socialaway-0.0.1-SNAPSHOT.jar /socialaway.war

# run the app
CMD ["/usr/bin/java", "-jar", "/socialaway.war"]