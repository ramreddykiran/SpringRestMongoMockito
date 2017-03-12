This is a web application developed by 
Java,Spring with REST and Spring data for Mongo DB
Used Lombok API, apache commons builder
Added PowerMock for Unit tests
Used Gradle to build the application  


-- to start application using Tomcat server, we need to point the WAR extracted folder.
-- Tried to run directly (right click on the app, run as tomcat server.
   It ran successfully but application is not accessed)
-- Open servers view -> double click on tomcat server icon ->
 select modules tab (besides Overview tab) ->click on Add external web module
-- path: /<app name to access (it can be any name)>
   Document Base: point to application war file which is present in build -> libs folder
	eg:  Document Base:  D:\lunaworkspace\PowerMockitoExample\build\libs\PowerMockitoExample
		 Path : /powermockgradle
-- start server in Run or debug mode 
access app using REST Urls


 PowerMock for Unit tests
 Added for controller class for controller methods. also wrote for APIs using 
 MockMvc approach for both GET (request param and path variable) and POST methods


Actions: 
Add spring integration test for one of the flows
Configure Angular JS 1.+ and build  some pages