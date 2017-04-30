#!/bin/bash
cp -r /home/xoldfusion/Downloads/openxava-5.6/workspace/librocomprasv3  librocompras
cp /home/xoldfusion/Downloads/openxava-5.6/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cp -r openshiftfeliz librocompras/
cp -r jasperfeliz librocompras/
cp -r tomcatfeliz librocompras/
cp  amazon2017llave/*.sh librocompras/amazon2017llave
rm *.*~
cd librocompras
git add -A
git commit -a -m "dia seis - incluyo compras retrasadas"
git push -u origin master
