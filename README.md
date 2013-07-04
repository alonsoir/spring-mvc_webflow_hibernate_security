spring-mvc_webflow_hibernate_security
=====================================

a sample of latest version of web flow,hibernate, spring mvc and spring security 

tomcat-servlet-api.version : 7.0.30
spring.version : 3.2.2.RELEASE
springwebflow.version : 2.3.2.RELEASE
spring-security.version : 3.1.3.RELEASE
jetty-maven-plugin.version : 8.1.4.v20120524
ognl.version : 3.0
jstl.version : 1.2
hibernate-annotations.version : 3.5.6-Final
hibernate-core.version : 4.2.0.Final
ehcache.version : 1.6.0
postgresql.version : 9.1-901-1.jdbc4
persistence-api.version : 1.0
commons-dbcp.version : 1.3
slf4j-simple.version : 1.6.1
slf4j-log4j12.version : 1.6.4
jasperreports-maven-plugin.version : 1.0-beta-2
jasperreports.version : 5.0.1
groovy.version : 1.8.6
junit.version : 4.8.2
slf4jVersion : 1.7.5

create database with proper name, update hibernate.properties with user, pass and url, then launch mvn clean install tomcat7:run
you should see login form in http://localhost:8080/SpringMVC/login.

Next is to update user and roles on database, so you may modify security.sql for your convenience and launch the sentence
using something like pgAdmin or phpmyadmin. Next you can login on system. You can save data, iterate over the flow, 
generate a document using a jaspersoft tecnologies, then you can see the flow and see in a cool table a resume of 
generated data, included a link in order to see generated document.
thats all for now, enjoy and have fun!

If you need some help, keep me in touch

