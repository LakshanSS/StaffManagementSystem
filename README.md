# StaffManagementSystem
Drivers and Assistants Management System using MongoDB and SpringBoot

### About the requirement
An organization has a requirement to create a microservice to serve all the drivers and assistants as roles.
Roles should be saved in a MongoDB collection called 'role'.

There are 2 types of roles: Driver and Assistant

A given role has the following attributes
- Organization
- Firstname
- Lastname
- NIC No
- RoleType

The following REST APIs should be exposed
- Basic CRUD operations on a given role
- Retrieve a role from the NIC No
- A list of roles should br retrived from organization and role type (this should expose only list of firstname, lastname and NIC No of a role) 

### Extra requirements
- Swagger documentation of the APIs have to be exposed
- Need to add current date and last updated date of a given document


## MongoDB Configuration
MongoDB configurations can be added in https://github.com/LakshanSS/StaffManagementSystem/blob/master/src/main/resources/application.properties
