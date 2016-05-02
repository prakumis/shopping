Technologies Used in this application:
------------------------------------------------------------------------------------------
1. JDK 1.8
2. Eclipse - Luna: Maven PlugIn
3. Maven 3.2.2
4. GIT as repository (moved eclipse code to git:: http://stackoverflow.com/questions/17552457/how-do-i-upload-eclipse-projects-to-github)
5. Spring: MVC + REST Service (Jackson Lib)
6. Spring Security [FormBasedLogin: a) hardCoded-UserPassword. b) enterprize ldap c) openLdap]
6. Spring Security [Authorization: role based access to services]
7. LDAP for storing credentials

Implementation Pending
---------------------------------------------------------------------------------------------------
8. MySQL / POSTGRES / Oracle databases
9. JPA / Hibernate as ORM (Do the POC for Both)
10.Caching
11.Payment Gatway implementation
12.UML Diagrams (class diagram + sequence diagram + others (see eniq adapter design doc))
13.Latest scheduler implementation
14.JUnit test cases
15.Java Mail (or any other mail api implementation)
16.PDF / Excel report generation
17.HTTPS support in Tomcat server
18.

============================================================================================================
======= Step to create dynamic web project using maven and convert it into eclipse  ========================
============================================================================================================
1. Create Maven Project Structure
1.1. create a maven pom-packaging project in eclipse
	a) Create New Maven Project > Skip Archetype Selection
	b) groupId: com.sadarbazaar; artifactId: shopping; packaging: pom
	c) Finish. Save.

1.2. create a maven module (jar/war) under above parent project
	a) open parent pom.xml
	b) overview tab; modules section; click "Create". Proceed to create jar/war module. Update package before "Finish".

2. check in the code into git repository
http://stackoverflow.com/questions/17552457/how-do-i-upload-eclipse-projects-to-github
3. Add the maven dependency whenever required
4. Error: if any compilation error: in eclipse:
http://stackoverflow.com/questions/18122336/cannot-change-version-of-project-facet-dynamic-web-module-to-3-0
5. Error: SLF4J Dependencies and LocationAwareLogger.log Method Not Found Exception
http://www.captaindebug.com/2012/01/slf4j-dependencies-and.html#.VSeqynX_SPQ

============================================================================================================

###################################################################################################
------------------ Spring Security Notes ----------------------------------------------------------
---------------------------------------------------------------------------------------------------
1. web.xml
2. 

Notes: ThreadLocal, Namespace of spring security, sprin-security-4, url level + service level security
		https://spring.io/blog/2010/03/06/behind-the-spring-security-namespace/ (lakshmi shared this link)

Good Read on expression in spring security (using hasRole())::
		http://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html

Method level security:  http://howtodoinjava.com/2014/02/15/xml-config-based-method-level-spring-security-using-protect-pointcut/
<global-method-security>
  <protect-pointcut expression="execution(* com.howtodoinjava.service.*Impl.add*(..))" access="ROLE_USER"/>
  <protect-pointcut expression="execution(* com.howtodoinjava.service.*Impl.delete*(..))" access="ROLE_ADMIN"/>
</global-method-security>
---------------------------------------------------------------------------------------------------


###################################################################################################
------------------ Open LDAP Notes ----------------------------------------------------------
---------------------------------------------------------------------------------------------------
URL: http://www.unixmen.com/openldap-installation-configuration-ubuntu-12-1013-0413-10-debian-67-2/
---------------------------------------------------------------------------------------------------



###################################################################################################
------------------ JSON data from REST controller to AngularJS Issue ----------------------------------------------------------
---------------------------------------------------------------------------------------------------
http://stackoverflow.com/questions/24994440/no-serializer-found-for-class-org-hibernate-proxy-pojo-javassist-javassist
---------------------------------------------------------------------------------------------------


###################################################################################################
------------------ CORS Issue ---------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
Error Message:: Cross-Origin Request Blocked: The Same Origin Policy disallows reading the remote resource at 
http://localhost:9080/springHibernateAngularWeb/json/update. This can be fixed by moving the resource to the same domain or enabling CORS.

Solution:: https://htet101.wordpress.com/2014/01/22/cors-with-angularjs-and-spring-rest/
---------------------------------------------------------------------------------------------------
Error 2: Above solution works well when there is no header in the Controller method annotation as in case of GET, DELETE.
		But when there is some header annotation added in controller method (@RequestMapping(value = "/update", method = RequestMethod.POST, headers = {"Content-Type=application/json"})), 
		above solution fails.
Solution:: http://stackoverflow.com/questions/8163703/cross-domain-ajax-doesnt-send-x-requested-with-header
		SimpleCORSFilter:: 		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		http://stackoverflow.com/questions/28855198/post-blocked-even-when-cors-is-enabled
-----------------------------------------------------------------------------------------------------------
		

