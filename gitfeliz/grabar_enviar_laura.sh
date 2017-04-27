#!/bin/bash
cp -r /home/laurasalinas/Downloads/openxava-5.6/workspace/librocomprasv3  librocompras
# cp /home/laurasalinas/Downloads/openxava-5.6/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cd librocompras
git add -A
git commit -a -m "dia tres - laura commit"
git push -u origin master
