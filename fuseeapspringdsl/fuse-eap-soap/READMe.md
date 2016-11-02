SoapJaxB Dependencies are not included completely with EAP
the module "javax.jws.api" needs to be included in the dependencies

Edit the file 

$JBOSS_HOME/modules/system/layers/fuse/org/apache/camel/component/soap/main/module.xml

Add the below line to the dependencies of the org.apache.camel.component.soap module

When done the module.xml should look like below

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.1" name="org.apache.camel.component.soap">
  <resources>
    <resource-root path="camel-soap-2.17.0.redhat-630187.jar" />
  </resources>
  <dependencies>
    <module name="javax.api" />
    <module name="javax.xml.ws.api" />
   <module name="javax.jws.api"/>
    <module name="org.slf4j" />
    <module name="javax.xml.bind.api" />
    <module name="org.apache.camel.component.jaxb" />
    <module name="org.apache.camel.core" />
  </dependencies>
  <exports>
    <exclude path="org/w3**" />
  </exports>
</module>


2. Copy the files under data directory to any other directory within the system and 
change the fileDirectory value to filepath.