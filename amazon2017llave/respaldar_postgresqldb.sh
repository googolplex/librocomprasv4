#!/bin/bash
#!/bin/bash
# debes ejecutarlo desde el usuario postgresql
cd respaldosdb
pg_dump manzanas > manzanas_respaldo_20170210a.dump
