FROM adoptopenjdk/openjdk12-openj9:jre-12.0.2_10_openj9-0.15.1-alpine
RUN mkdir /opt/app
COPY target/*-SNAPSHOT.jar /opt/app/app.jar
EXPOSE 8081
ENV TZ=Asia/Jakarta
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD ["java", "-jar", "/opt/app/app.jar","-Xmx256M","-Xms128M","-XX:+UseG1GC","-XX:MaxGCPauseMillis=20","-XX:InitiatingHeapOccupancyPercent=35","-XX:+ExplicitGCInvokesConcurrent","-Djava.awt.headless=true"]
