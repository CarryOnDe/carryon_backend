FROM openjdk:11-jdk

# Lcoale values
ENV LANG="de_DE.UTF-8"
ENV LC_COLLATE="de_DE.UTF-8"
ENV LC_CTYPE="de_DE.UTF-8"
ENV LC_MESSAGES="de_DE.UTF-8"
ENV LC_MONETARY="de_DE.UTF-8"
ENV LC_NUMERIC="de_DE.UTF-8"
ENV LC_TIME="de_DE.UTF-8"


COPY target/backend.jar /data/app.jar
COPY conf /data/conf

ADD /entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 8080
