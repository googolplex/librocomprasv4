#!/bin/bash
# scp -i "librocomprasv3.pem"  ubuntu@ec2-54-161-126-158.compute-1.amazonaws.com:/home/ubuntu/*.sh .
scp -i "librocomprasv3.pem"  ubuntu@ec2-52-207-31-88.compute-1.amazonaws.com:/home/ubuntu/respaldosdb/*.dump respaldosdb
