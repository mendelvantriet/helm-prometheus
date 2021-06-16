FROM openjdk:8-jdk

ENV WORKDIR=/opt

COPY jmx_prometheus_javaagent-0.15.0.jar $WORKDIR/
COPY config.yaml $WORKDIR/
COPY target/java-web-app-1.0.0.jar $WORKDIR/
COPY entrypoint.sh $WORKDIR/

WORKDIR $WORKDIR

RUN chmod +x entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

