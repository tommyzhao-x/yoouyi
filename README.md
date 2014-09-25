bilvyou
=======
this is a maven web product
we use spring mvc and angularjs build this product

web server use Tomcat7, you need add a tomcat manager user and modify the pox.xml tomcat plugin config.

BUILD COMMAND:
    mvn clean package tomcat7:deploy -Dmaven.test.skip=true
