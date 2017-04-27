#!/bin/bash
ipsec pki --pub --in vpn-server-key.pem \
--type rsa | ipsec pki --issue --lifetime 1825 \
--cacert contabilidad-root-ca.pem \
--cakey server-root-key.pem \
--dn "C=US, O=Contabilidad VPN Server, CN=contabilidad.lcompras.biz" \
--san contabilidad.lcompras.biz \
--flag serverAuth --flag ikeIntermediate \
--outform pem > vpn-server-cert.pem
