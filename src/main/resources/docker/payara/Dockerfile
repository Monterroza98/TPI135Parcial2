FROM payara/micro:5-SNAPSHOT
ADD postgresql-42.2.2.jar $PAYARA_PATH/
ADD asadmin.txt $PAYARA_PATH/
ADD MantenimientoWebData-1.0-SNAPSHOT.war  $PAYARA_PATH/
ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--addJars", "postgresql-42.2.2.jar", "--postbootcommandfile", "asadmin.txt", "--deploy","MantenimientoWebData-1.0-SNAPSHOT.war"]

#MantenimientoWebData-1.0-SNAPSHOT.war