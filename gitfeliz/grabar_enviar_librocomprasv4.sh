#!/bin/bash
# hecho para el librocomprasv4 - portatil moneyless
cp -r /home/xoldfusion/Downloads/openxava-5.6.1_librocomprasv4/workspace/librocomprasv4  librocomprasv4
cp /home/xoldfusion/Downloads/openxava-5.6.1_librocomprasv4/tomcat/conf/*.xml librocomprasv4/tomcatfeliz
cp *.sh librocomprasv4/gitfeliz
cp -r openshiftfeliz librocomprasv4/
cp -r jasperfeliz librocomprasv4/
cp -r tomcatfeliz librocomprasv4/
cp  amazon2017llave/*.sh librocomprasv4/amazon2017llave
rm *.*~
cd librocomprasv4
git add -A
git commit -a -m "corrijo el build.xml - nueva version postgres"
git push -u origin master
