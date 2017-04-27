#!/bin/bash
ipsec pki --self --ca --lifetime 3650 \
--in server-root-key.pem \
--type rsa --dn "C=US, O=Contabilidad VPN Server, CN=Contabilidad VPN Server Root CA" \
--outform pem > contabilidad-root-ca.pem
