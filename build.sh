#!/bin/bash
mvn clean install eclipse:eclipse: assembly:single && chmod +x target/*.jar
