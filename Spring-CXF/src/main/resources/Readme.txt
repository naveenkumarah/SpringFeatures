Different ways of Building Web service Clients
	WSDL2Java generated Client
	JAX-WS Proxy
	JAX-WS Dispatch APIs
	Simple Frontend Client Proxy
	Dynamic Client

Reference:http://cxf.apache.org/docs/how-do-i-develop-a-client.html

wsdl2java -p com.sample.ws.service -d out http://localhost:8080/SpringMVC-1.0/services/StudentService?wsdl

Key Generation
--------------
http://cxf.apache.org/docs/ws-security.html
	
Steps:
	1.	Creating private key with given alias and password like "myAlias"/"myAliasPassword" in keystore (protected by password for
		security reasons)
		keytool -genkey -alias myAlias -keypass myAliasPassword -keystore  privatestore.jks -storepass keyStorePassword -dname "cn=myAlias" -keyalg RSA

	  eg:-keytool -genkey -alias myAlias -keypass naveen -keystore  privatestore.jks -storepass naveen -dname "cn=myAlias" -keyalg RSA
	2.   Self-sign our certificate
		keytool -selfcert -alias myAlias -keystore privatestore.jks -storepass keyStorePassword -keypass myAliasPassword
		
		eg:- keytool -selfcert -alias myAlias -keystore privatestore.jks -storepass naveen -keypass naveen
	3.  Export the public key from our private keystore to file named key.rsa
		keytool -export -alias myAlias -file key.rsa -keystore privatestore.jks -storepass keyStorePassword
		
		eg:-keytool -export -alias myAlias -file key.rsa -keystore privatestore.jks -storepass naveen
	4. Import the public key to new keystore:
		keytool -import -alias myAlias  -file key.rsa -keystore publicstore.jks -storepass keyStorePassword
		
		eg:-keytool -import -alias myAlias  -file key.rsa -keystore publicstore.jks -storepass naveen
	

SOAP Security
	1.Username Token Profile 1.1
		https://www.oasis-open.org/committees/download.php/16782/wss-v1.1-spec-os-UsernameTokenProfile.pdf
	2.X.509 Token Profile 1.1
		https://www.oasis-open.org/committees/download.php/16785/wss-v1.1-spec-os-x509TokenProfile.pdf
	3.SAML Token profile 1.1
	4.Kerberos Token Profile 1.1