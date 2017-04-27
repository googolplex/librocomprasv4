#!/bin/bash
ipsec pki --gen --type rsa --size 4096 --outform pem > server-root-key.pem
chmod 600 server-root-key.pem
