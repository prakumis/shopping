#!/bin/bash

set -x
# Usually User need to change the following POM location only
ETME_MAIN_POM_LOCATION="D:\EriTech\WS\WS_MyApp_New\shopping"
PROJECT_VERSION="0.0.1-SNAPSHOT"

# Usually User don't need to change the following
ETME_WAR_LOCATION="$ETME_MAIN_POM_LOCATION/etme-gateway-web/target"
WAR_FILE_NAME="etme-web-${PROJECT_VERSION}.war"
STATIC_CODE_GIT_LOC="$ETME_MAIN_POM_LOCATION/etme-gui-projects/"
ETME_CONFIG_PATH="${ETME_MAIN_POM_LOCATION}/etme-gateway-web/src/main/resources"

JBOSS_HOME_LOC="D:/EriTech/AppServers/etme_jboss-as-7.1.1.Final_nilabja"
JBOSS_DEPLOYEMENT_PATH="$JBOSS_HOME_LOC/standalone/deployments"
TEMP_FILE_TO_DELETE_LOCATION="$JBOSS_HOME_LOC/standalone/tmp/vfs"
RUN_JBOSS_SCRIPT_LOCATION="$JBOSS_HOME_LOC/bin"
JBOSS_ETME_CONFIG_PATH="$JBOSS_HOME_LOC/standalone/configuration/etme_config"

APACHE_HOME_LOC="C:/Apache24/htdocs"
DATE_FORMAT='%Y%m%d-%H%M'
CURRENT_DATE="$(date +$DATE_FORMAT)"
echo $CURRENT_DATE

deployStatic() {

	echo "Moving latest files from etme_integrate to ${APACHE_HOME_LOC}"
	cd $APACHE_HOME_LOC
	cd ../
	echo "Taking backup of exiting $APACHE_HOME_LOC into ${APACHE_HOME_LOC}_${CURRENT_DATE}"
	mkdir ${APACHE_HOME_LOC}_${CURRENT_DATE}
	mv -f ${APACHE_HOME_LOC}/* ${APACHE_HOME_LOC}_${CURRENT_DATE}
	echo "Copying static code from GIT [$STATIC_CODE_GIT_LOC] to ${APACHE_HOME_LOC}/"
	cp -r ${STATIC_CODE_GIT_LOC}/* ${APACHE_HOME_LOC}/
	echo "Static GUI contents moved to ${APACHE_HOME_LOC}"
}

mavenBuild() {

	cd $ETME_MAIN_POM_LOCATION
	echo "Running mvn clean install"
	mvn clean install
	echo "mvn clean install completed"
}

deployWar() {

	#echo "Copying config files from $ETME_CONFIG_PATH to $JBOSS_ETME_CONFIG_PATH"
	#cd $ETME_CONFIG_PATH
	#cp -f action-businesssvc-mapping.xml $JBOSS_ETME_CONFIG_PATH/
	#cp -f common-user-function.properties $JBOSS_ETME_CONFIG_PATH/

	echo "Copying war file to jboss"
	cd $ETME_WAR_LOCATION
	cp $WAR_FILE_NAME $JBOSS_DEPLOYEMENT_PATH
	cd $TEMP_FILE_TO_DELETE_LOCATION
	echo "Deleting old tmp files from "$TEMP_FILE_TO_DELETE_LOCATION
	echo "First time this deletion may take time ........Please wait"
	rm -fr *
	echo "WAR file deployed to jboss"
}

startJBoss() {

	echo "Starting jboss"
	cd $RUN_JBOSS_SCRIPT_LOCATION
	./standalone.sh -b 0.0.0.0 -bmanagement=0.0.0.0
	echo "Started jboss"
}

startApache() {

	echo "Re-Starting Apache"
	cd $APACHE_HOME_LOC
	cd ../bin
	httpd.exe -k restart
	echo "Apache restarted"
}

# start calling your functions
#deployStatic;
mavenBuild;
deployWar;
startJBoss;
