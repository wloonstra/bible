mvn clean package
$CATALINA_HOME/bin/shutdown.sh
rm $CATALINA_HOME/webapps/bible.war
rm -rf $CATALINA_HOME/webapps/bible
cp target/*.war $CATALINA_HOME/webapps/bible.war
$CATALINA_HOME/bin/startup.sh 
