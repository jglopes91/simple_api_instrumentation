FROM openjdk:22-ea-21-jdk-slim-bullseye

WORKDIR /app

RUN apt-get update && apt-get install -y curl \
    && OTEL_LATEST_VERSION=`curl -s https://api.github.com/repos/open-telemetry/opentelemetry-java-instrumentation/releases/latest | grep "browser_download_url" | cut -d '"' -f 4` \   
    && curl -fsSL -o /app/opentelemetry-javaagent.jar $OTEL_LATEST_VERSION \
    && apt-get remove -y curl \
    && apt-get autoremove -y \
    && rm -rf /var/lib/apt/lists/*

COPY ./target/api-0.0.1-SNAPSHOT.jar /app

EXPOSE 4500

CMD ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-Dotel.resource.attributes=service.name=simpleapi", "-Dotel.exporter.otlp.endpoint=http://otel-collector:4318", "-Dspring.profiles.active=docker" ,"-jar", "api-0.0.1-SNAPSHOT.jar"]