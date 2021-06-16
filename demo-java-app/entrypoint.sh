#!/bin/bash

set -o pipefail
set -o errexit

ulimit -c unlimited

exec java -javaagent:./jmx_prometheus_javaagent-0.15.0.jar=9404:config.yaml -jar java-web-app-1.0.0.jar

