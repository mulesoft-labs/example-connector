Example Connector - Dynamic Metadata
=========================

This Anypoint Studio Connector is a simple example intended to help users understand DataSense configuration concepts. It is written to acompany the following documentation page: http://www.mulesoft.org/documentation/display/current/DevKit+Metadata+Implementation

This Connector in particular shows how to obtain meta data from a service with a dynamic (weakly typed) data model. The meta data is obtained directly from the service itself.

The service that the connector connects to is a book database, it contains two elements: 
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
