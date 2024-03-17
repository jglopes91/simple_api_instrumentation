FROM openjdk:22-ea-21-jdk-slim-bullseye

WORKDIR /app

RUN apt-get update && apt-get install -y curl \
    && curl -fsSL -o /app/opentelemetry-javaagent.jar https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.2.0/opentelemetry-javaagent.jar \
    && apt-get remove -y curl \
    && apt-get autoremove -y \
    && rm -rf /var/lib/apt/lists/*

COPY ./target/api-0.0.1-SNAPSHOT.jar /app

EXPOSE 4500

CMD ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-Dotel.resource.attributes=service.name=simpleapi", "-Dotel.exporter.otlp.endpoint=http://otel-collector:4318", "-Dspring.profiles.active=docker" ,"-jar", "api-0.0.1-SNAPSHOT.jar"]