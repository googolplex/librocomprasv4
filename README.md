sistema para registrar compras y ventas personales y elaborar 
el libro de compras y ventas, que es necesario para la
presentacion del IVA en la SET
hecho el 01/2017

1. si se puede usar el OJDBC7 y el JDK8 con eclipse neon y openxava 5.6
2. Dar permiso al JAVA8 en el java.policy con la linea

permission javax.management.MBeanTrustPermission "register";
esto evita el warning de la tarea ant para actualizar esquemas

Este sistema esta escrito en OPENXAVA 5.6 con eclipse neon
y el JDK8 

Para que funcione en la intranet de casa debes cambiar el JUNIT2 por el JUNIT
dentro del persistence del openxava. De otro modo no se conecta, data timeout.
Simplemente intercambiar los nombres.

la carpeta openshiftfeliz contiene lo necesario para conectarse
al postgres del openshift 

20170131a. JDBC4 con POSTGRESQL
----------------------

para que te funcione esa tecnologia debes comentar
<!-- <property name="hibernate.connection.driver_class" value="org.postgresql.Driver"/> -->
en el archivo persistence.xml
y poner el JAR de postgres dentro del WEB-INF/lib del proyecto postgresql-9.4.1212.jre7
no sirve si pones el JAR dentro del tomcat lib
ni tampoco en el classpath del eclipse neon

el server.xml queda con el driverClassName="org.postgresql.Driver"  sin cambios


conexion lenta al postgres 

http://stackoverflow.com/questions/29670916/hibernate-with-jpa-connection-time-very-slow

para evitar el error de file IO user preferences
crear una carpeta el /usr/share/tomcat/.openxava

https://sourceforge.net/p/openxava/discussion/437013/thread/d2401ff3/

error: Impossible to translate id 
poner https://sourceforge.net/p/qamanager/discussion/780347/thread/6430ce41/
i18nWarnings=false


#agregado para que no explote el librocompras informe 2017.02
CATALINA_OPTS="-Djava.awt.headless=true"

vamos por el tema fonts

2017.4.17a. El tema VPN lo agrego con la receta que encontre en digital ocean strongswan

2017.5.27a. Le agrego el Modulo de inversiones , cambio de la version 3 a la version4
