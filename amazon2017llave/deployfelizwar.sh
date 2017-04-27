#!/bin/bash
sudo /etc/init.d/tomcat7 stop
rm -R /var/lib/tomcat7/webapps/librocomprasv3
cp *.war  /var/lib/tomcat7/webapps
cp *.jar  /usr/share/tomcat7/lib
sudo /etc/init.d/tomcat7 restart
