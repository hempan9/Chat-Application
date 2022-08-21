
FROM maven:3.8.2-jdk-11
#ADD chat-client/target/chat-client-1.0.0.jar .
ADD chat-server/target/chat-server-1.0.0.jar .
ADD build.sh .
RUN which java
WORKDIR .

CMD ["bash", "build.sh"]
