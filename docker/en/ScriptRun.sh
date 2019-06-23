#!/bin/sh

./ScriptRunSpotlight.sh
#
export MAVEN_OPTS="-Xmx16G -Dlog4j.configuration=file:data/fox/log4j.properties"
#
echo "##############################################################################" 
echo "# Check $0.log file."
echo "##############################################################################" 
#
mvn exec:java  -Dexec.mainClass="org.aksw.fox.ui.FoxRESTful" 
