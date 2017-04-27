#!/bin/bash
# hecho para mi pc de escritorio
# el 2017/01
cp /home/xoldfusion/Descargas/openxava-5.6_librocompras/workspace.dist/librocomprasv3.dist/*.war  /home/xoldfusion/Descargas/librocompras2017/amazon2017llave/
cp -r /home/xoldfusion/Descargas/openxava-5.6_librocompras/workspace/librocomprasv3  librocompras
cp /home/xoldfusion/Descargas/openxava-5.6_librocompras/tomcat/conf/*.xml librocompras/tomcatfeliz
cp *.sh librocompras/gitfeliz
cp -r openshiftfeliz librocompras/
cp -r jasperfeliz librocompras/
cp  amazon2017llave/*.sh librocompras/amazon2017llave
cp  amazon2017llave/vpn_feliz/*.sh librocompras/amazon2017llave/vpn_feliz
cp  amazon2017llave/vpn_feliz/*.conf librocompras/amazon2017llave/vpn_feliz
# cp  amazon2017llave/*.war librocompras/amazon2017llave ### no llevo el war porque no es necesario
rm *.*~
cd librocompras
git add -A
git commit -a -m "agrego la VPN feliz - me faltan las rutas"
git push -u origin master
