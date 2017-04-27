#!/bin/bash
# ejemplo para restaurar postgresl 9.5
# recuerde crear la base minuevabase
cd respaldosdb
psql minuevabase < manzanas_respaldo_20170210a.dump
