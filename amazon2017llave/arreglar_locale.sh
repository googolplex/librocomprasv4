#!/bin/bash
locale-gen en_US.UTF-8
dpkg-reconfigure locale
dpkg-reconfigure keyboard-configuration
localedef -i en_US -c -f UTF-8 en_US.UTF-8
reboot
locale
