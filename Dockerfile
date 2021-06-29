FROM openjdk:11

RUN mkdir -p /usr/share/gradle /usr/share/gradle/ref
RUN curl -fsSL -o /tmp/gradle.zip https://services.gradle.org/distributions/gradle-7.1-bin.zip
RUN unzip -d /usr/share/gradle /tmp/gradle.zip
RUN rm -f /tmp/gradle.zip
RUN ln -s /usr/share/gradle/gradle-7.1 /usr/bin/gradle

ENV GRADLE_VERSION 7.1
ENV GRADLE_HOME /usr/bin/gradle
ENV GRADLE_USER_HOME /cache
ENV PATH $PATH:$GRADLE_HOME/bin

EXPOSE 8080