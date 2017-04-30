#!/bin/bash
sudo docker run --name pgadmin4feliz \
           -p 5050:5050 \
           -d fenglc/pgadmin4
