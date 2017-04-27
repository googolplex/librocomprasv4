#!/bin/bash
sudo locale-gen "en_US.UTF-8"
sudo dpkg-reconfigure locales
export LC_ALL="en_US.UTF-8"
