#!/bin/sh
cd api/
mvn clean package -DskipTests
podman build -t simpleapi .
cd ../service
mvn clean package -DskipTests
podman build -t simpleservice .
cd ..
podman-compose -f docker-compose.yml up -d
