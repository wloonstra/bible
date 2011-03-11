mvn clean package
cp target/*.war $CATALINA_HOME/webapps/bible.war
$CATALINA_HOME/bin/shutdown.sh
$CATALINA_HOME/bin/startup.sh 
