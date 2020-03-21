#!/bin/bash

CMD="java $JAVA_START_PARAMS -jar /data/app.jar /data/conf/application-production.properties"

echo "ENVIRONMENT VARIABLES"
echo " JAR_FILE: app.jar"
echo " ENV_FILE: application-production.properties"
echo " JAVA_START_PARAMS: $JAVA_START_PARAMS"
echo ""
echo "Start Java with command: $CMD"
echo ""

exec $CMD "$@"
