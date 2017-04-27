#!/bin/bash
# no recomiendo usar el GIT con el openshift
# ocupa mucho espacion dentro del GEAR
cd lavadero3
# git config --global user.name "Roger Armoa"
# git config --global user.email googolplex@lcompras.biz
git commit -am "variables de ambiente server.xml context.xml web.xml catalina.properties"
git push
