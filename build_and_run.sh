#!/bin/sh
cd api/
mvn clean package
podman build -t simpleapi .
cd ../service
mvn clean package
podman build -t simpleservice .
cd ..
podman-compose -f docker-compose.yml up -d
