#!/bin/bash
# hecho para mi pc de escritorio
# el 2017/01
rm *.*~
cp /home/xoldfusion/Descargas/openxava-5.6.1_librocomprasv4/workspace.dist/librocomprasv4.dist/*.war  /home/xoldfusion/Descargas/librocompras2017/amazon2017llave/

rm -R  /home/xoldfusion/Descargas/librocompras2017/librocomprasv4/librocomprasv4/*
cp -r /home/xoldfusion/Descargas/openxava-5.6.1_librocomprasv4/workspace/librocomprasv4  librocomprasv4
cp /home/xoldfusion/Descargas/openxava-5.6.1_librocomprasv4/tomcat/conf/*.xml librocomprasv4/tomcatfeliz
cp *.sh librocomprasv4/gitfeliz
cp -r openshiftfeliz librocomprasv4/
# ya no hace mas porque se separo por version
# cp -r jasperfeliz librocomprasv4/
cp  amazon2017llave/*.sh librocomprasv4/amazon2017llave
cp  amazon2017llave/vpn_feliz/*.sh librocomprasv4/amazon2017llave/vpn_feliz
cp  amazon2017llave/vpn_feliz/*.conf librocomprasv4/amazon2017llave/vpn_feliz
# cp  amazon2017llave/*.war librocompras/amazon2017llave ### no llevo el war porque no es necesario
rm *.*~
cd librocomprasv4
git add -A
git commit -a -m "agrego el modulo de inversiones"
git push -u origin master
