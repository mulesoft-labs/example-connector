Example Connector - DSQL
=========================
 
This Anypoint Studio Connector is a simple example intended to help users understand DSQL configuration concepts. It is written to acompany the following documentation page: http://www.mulesoft.org/documentation/display/current/Implementing+DataSense+Query+Language+Support
 
This Connector in particular shows how to translate DSQL into a service's native query language.
 
The service's native query language follows the structure below:
 
```
S [selectedFieldName, ]
F [Type]
W ( [ fieldName OPERATION value, & ] )
 
```
 
 
The service that the connector connects to is a library web service, it contains two elements:
*books
*authors
 
The book element contains the following fields:
*title
*synopsis
*author
 
The author element contains the following fields:
*firstName
*lastName
 
 
For information on how this connector is built and how to build your own, refer the following documentation page: http://www.mulesoft.org/documentation/display/current/DevKit+Metadata+Implementation