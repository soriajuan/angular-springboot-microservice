FROM alpine:3.15.0

# install java 17
RUN apk add openjdk17-jdk

# add artifacts to image
ADD artifacts/*.jar /app/

# run application
CMD java -jar /app/*.jar
