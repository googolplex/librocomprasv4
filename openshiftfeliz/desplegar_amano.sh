#!/bin/bash
# para openshift GEAR
# recuerde poner unpackwars=true en el server.xml del openshift
# tocar el path del catalina.properties para que lea el driver de postgres
# poner en el server.xml los JNDI al postgres

cp /home/xoldfusion/Descargas/openxava-5.6/workspace.dist/lavadero2.dist/lavadero2.war /home/xoldfusion/Descargas/openshiftfeliz/amano/lavadero2.war
rhc stop-app jbossews
scp lavadero2.war 58121a587628e1d0d10001f7@jbossews-melones.rhcloud.com:app-root/dependencies/jbossews/webapps/
# rhc start-app jbossews

# unzip -o lavadero2.war -d lavadero2
# scp -r lavadero2 58121a587628e1d0d10001f7@jbossews-melones.rhcloud.com:jbossews/work/Catalina/localhost/
rhc start-app jbossews
