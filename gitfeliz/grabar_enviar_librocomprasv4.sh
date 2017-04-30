#!/bin/bash
# hecho para el librocomprasv4 - portatil moneyless
cp -r /home/xoldfusion/Downloads/openxava-5.6.1_librocomprasv4/workspace/librocomprasv4  librocomprasv4
cp /home/xoldfusion/Downloads/openxava-5.6.1_librocomprasv4/tomcat/conf/*.xml librocomprasv4/tomcatfeliz
cp *.sh librocomprasv4/gitfeliz
cp -r openshiftfeliz librocomprasv4/
cp -r pentaho_transformacion librocomprasv4/
# ya no lo hago mas porque esta separado por versiones
# rm -R librocomprasv4/jasperfeliz/*

# sigo limpiando los archivos de trabajo nada mas
rm -R jarperfeliz/*.*~
rm -R librocomprasv4/jasperfeliz/*.*~
cp -r jasperfeliz librocomprasv4/
cp -r tomcatfeliz librocomprasv4/
cp  amazon2017llave/*.sh librocomprasv4/amazon2017llave
rm *.*~
cd librocomprasv4
git add -A
git commit -a -m "agrego el mapa de transferencia pentaho"
git push -u origin master
