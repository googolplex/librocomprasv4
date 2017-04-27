#!/bin/bash
cp -r /home/xoldfusion/Downloads/openxava-5.6/workspace/librocomprasv3  librocompras
cp /home/xoldfusion/Downloads/openxava-5.6/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cd librocompras
git add -A
git commit -a -m "dia tres - campos calculados"
git push -u origin master
