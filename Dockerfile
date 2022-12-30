FROM eclipse-temurin:17-jre-alpine
RUN mkdir /app

WORKDIR /app

ADD narocila-api-*.jar /app

EXPOSE 8080

CMD java -jar narocila-api-*.jar
