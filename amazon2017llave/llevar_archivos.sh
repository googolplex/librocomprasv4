#!/bin/bash
# scp -i "librocomprasv3.pem"  *.jar ubuntu@ec2-54-161-126-158.compute-1.amazonaws.com:/home/ubuntu/
scp -i "librocomprasv3.pem"  *.war ubuntu@ec2-52-207-31-88.compute-1.amazonaws.com:/home/ubuntu/
# ya no es necesario, ya se como se estira del classpath
# scp -i "librocomprasv3.pem"  ../jasperfeliz/*.jrxml ubuntu@ec2-54-161-126-158.compute-1.amazonaws.com:/home/xoldfusion/Descargas/librocompras2017/jasperfeliz
# scp -i "librocomprasv3.pem"  letras*.zip ubuntu@ec2-54-161-126-158.compute-1.amazonaws.com:/home/ubuntu
