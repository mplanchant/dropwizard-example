# dropwizardExample

How to start the dropwizardExample application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-example-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Swagger Codegen
---

`java -jar swagger-codegen-cli-2.2.1.jar config-help -l jaxrs-spec`

	sortParamsByRequiredFlag
	    Sort method arguments to place required parameters before optional parameters. (Default: true)

	ensureUniqueParams
	    Whether to ensure parameter names are unique in an operation (rename parameters that are not). (Default: true)

	modelPackage
	    package for generated models

	apiPackage
	    package for generated api classes

	invokerPackage
	    root package for generated code

	groupId
	    groupId in generated pom.xml

	artifactId
	    artifactId in generated pom.xml

	artifactVersion
	    artifact version in generated pom.xml

	sourceFolder
	    source folder for generated code

	localVariablePrefix
	    prefix for generated code members and local variables

	serializableModel
	    boolean - toggle "implements Serializable" for generated models (Default: false)

	bigDecimalAsString
	    Treat BigDecimal values as Strings to avoid precision loss. (Default: false)

	fullJavaUtil
	    whether to use fully qualified name for classes under java.util. This option only works for Java API client (Default: false)

	hideGenerationTimestamp
	    hides the timestamp when files were generated

	dateLibrary
	    Option. Date library to use
	        joda - Joda
	        legacy - Legacy java.util.Date
	        java8-localdatetime - Java 8 using LocalDateTime (for legacy app only)
	        java8 - Java 8 native

	implFolder
	    folder for generated implementation code

	title
	    a title describing the application

	library
	    library template (sub-template) to use (Default: <default>)
	        <default> - JAXRS

	implFolder
	    folder for generated implementation code

	title
	    a title describing the application