# Instructor Feedback

### Project Problem Statement and Plan

Hi Ron, This sounds like a useful application and since you are both the customer and the developer, it should be easy to gather user requirements!

* Project object/problem statement looks good. Creative app title too!

* I like that you've utilized a real calendar to begin your planning.  
* To help with that process, make a list of all the tasks that will need to be completed and assign a time estimate to them. 
* Then, take those tasks and get them on the calendar. 
* Here's a start at a list to help you: design UI, design database, document application flow, create database tables, add data to tables, 
* write weekly blog/wiki/status report, design classes, research sending a message (email?) from the application, etc.

* What web service will you be using in your application?
	
	Got a full SpringMVC CRUD example working with Maven, I've altered the daos, feilds, made my own database with my own unique feilds which connects successfully, I've customized my own .jsps with bootstrap css to display feilds I've made.
	I will use the pom.xml file and maven for to find my .jars 11/07/2015 (way easier than pulling in jars on your own like a teasure hunt, but you still need to know what jars you need!), and aspects of it, pom.xml file etc..
	I used the example as a template and built off that, this structure helped me understand and guide me through what the annotations do, and how they work.
	In my presentation I will go over what Maven is https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html, and also what the Spring Annotations do.
	I will use SPRING 4 MVC, bootstrap for css, properties file for validation given from the http://www.javaworld.com/article/2077352/java-se/smartly-load-your-properties.html website you gave us way back to read up on. 
	I will also make use of Springorg.springframework.core.convert.converter.Converter interface, 
	this helps us with mapping Id’s of items to actual entities in sekhonmics database.
	In the MySql sekhonmics database there is a app_users table which will store the tenants: id, first name, last name, 
	sso id (which will link to the primary key Id to help map values in CRUD methods), email, phone, address, city, and property of interest. 
	
	Originally I was going to consume the webservice of the WI Court System who only give the API information at a large cost$$$$, I emailed them to see if I could get access as a student, however they have still not responded. 
	step 1: https://wcca.wicourts.gov/index.xsl
	step 2: "Data Extraction Option: WCCA data is available through a REST interface on a subscription basis. For subscription, contact, and technical information, please click here."
	step 3: After clicking the link in step 2 there are pdf pages of samples from the CCAP like this, but I was not able to access them without a key -->
				
				This is a sample request for a name search in test county 99 for last name Jones and first name James.
			hƩp://wccarest.wicourts.gov/api/v1/cases?lastName=jones&firstName=james&&&countyNo=99&&&&&&&
			Is a sample response for James Jones name search:
			[
			{
			meta:
			{
			href: "http://wccarest.wicourts.gov/api/v1/cases/99/1996TR999999",
			mediaType: "application/json"
			},
			county:
			{
			meta:
			{
			href: "http://wccarest.wicourts.gov/api/v1/counties/99",
			mediaType: "application/json"
			},
			countyNo: 99
			},
			caseNo: "1996TR9999999",
			filingDate: "1996-06-18",
			status:
			{
			meta:
			{
			href: "http://wccarest.wicourts.gov/api/v1/statusCodes/CL",
			mediaType: "application/json"
			},
			statusCode: "CL"
			},
			searchedForParty:
			{
			name:
			{
			first: "James",
			middle: "Test",
			last: "Jones"
			},
			dob: "1920-08"
			},
			lastModified: "2014-11-13T03:07:33.631Z"
			}
			
			
			So I've come to a conclusion that I will just output the weather perhaps for that day or something that would make sense with my app.
			
* What will your individual research topic/technique/technology be?  One option might be sending email from within the application.
- Maven 
- Spring MVC annotations 
