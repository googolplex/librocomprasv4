#!/bin/bash
ipsec pki --gen --type rsa --size 4096 --outform pem > vpn-server-key.pem
