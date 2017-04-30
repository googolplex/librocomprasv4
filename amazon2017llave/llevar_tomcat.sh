#!/bin/bash
scp -i "librocomprasv3.pem"  ../tomcatListo/*.zip ubuntu@ec2-52-207-31-88.compute-1.amazonaws.com:/home/ubuntu/
