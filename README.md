# Wholesale-Accounts
This is a backend REST API project developed using Spring Boot to display accounts and transactions of a given user.

## Design Conventions
* Uses Java8 and SpringBoot 2 for REST implementation.
* Uses InMemory H2db and schema are placed in resources folder. 
* Choice of build tool is Maven because of first class IDE support.
* Application has a context path Wholesale and runs on port 8080.
* Application supports nesting of spring profiles: 
    application.properties -> default -> profile mentioned in default property file(local), can be overriden by VM argument.
* Application supports querying small chunks of data through pagination, having default values.
* A Domain Driven design with multilayered architecture.
* Uses Junit and Mockito for testing. 
* Application is containerized, can be run using docker.
* Uses spotify docker plugin to build docker image as part of maven life cycle.

## Build and Run
* mvn clean install && mvn spring-boot:run or java -jar target/WholesaleAccounts.jar or mvn exec:java -Dexec.mainClass="org.anz.wholesale.WholesaleAccountsApplication"
* mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=dev
* mvn clean package -DskipTests && java -Dspring.profiles.active=dev -jar target/WholesaleAccounts.jar
* java -jar target/WholesaleAccounts.jar --spring.config.location="file:///tmp/Wholesale-Accounts/config/application-staging-tmp.properties"
* java -jar -Dspring.config.location=file:///tmp/Wholesale-Accounts/config/application-staging-tmp.properties target/WholesaleAccounts.jar
* mvn spring-boot:run -Dspring.config.location="file:///tmp/Wholesale-Accounts/config/application-staging-tmp.properties" #notWorking
* java -Dspring.config.location=classpath:/application-staging-tmp.properties -cp app:app/lib/*:/tmp/Wholesale-Accounts/config/* org.anz.wholesale.WholesaleAccountsApplication
* docker pull hariharank12/wholesale-accounts:1.0-SNAPSHOT
* docker build -t hariharank12/wholesale-accounts:1.0-SNAPSHOT .
* docker run -p 8080:8080 hariharank12/wholesale-accounts:1.0-SNAPSHOT
* docker run -e JAVA_OPTS="-Dspring.profiles.active=dev" -p 8080:8080 hariharank12/wholesale-accounts:1.0-SNAPSHOT
* docker run -e JAVA_OPTS="-Dspring.config.location=classpath:application-staging-tmp.properties" -p 8080:8080 -v /tmp/Wholesale-Accounts/config:/conf hariharank12/wholesale-accounts:1.0-SNAPSHOT
* docker run -e JAVA_OPTS="-Dspring.config.location=file:///tmp/Wholesale-Accounts/config/application-staging-tmp.properties" -p 8080:8080 hariharank12/wholesale-accounts:1.0-SNAPSHOT #notworking #noNeed



## To run the non jar version similar to dockerfile entrypoint
192-168-1-178:jar_extract hariharank12$ pwd
/Users/hariharank12/programs/springboot/anz_assessment/Wholesale-Accounts/jar_extract
192-168-1-178:jar_extract hariharank12$ ls
app	org
192-168-1-178:jar_extract hariharank12$ ls app/
META-INF			application-dev.properties	application-prod.properties	data.sql			org
application-default.properties	application-local.properties	application.properties		lib				schema.sql
192-168-1-178:WholesaleAccounts hariharank12$ java -Dspring.profiles.active=dev -cp app:app/lib/* org.anz.wholesale.WholesaleAccountsApplication
2021-01-17 10:51:48.330  INFO 5605 --- [           main] o.a.w.WholesaleAccountsApplication       : Starting WholesaleAccountsApplication on 192-168-1-178.tpgi.com.au with PID 5605 (/Users/hariharank12/programs/springboot/anz_assessment/Wholesale-Accounts/target/jar_extract/WholesaleAccounts/app started by hariharank12 in /Users/hariharank12/programs/springboot/anz_assessment/Wholesale-Accounts/target/jar_extract/WholesaleAccounts)
2021-01-17 10:51:48.335 DEBUG 5605 --- [           main] o.a.w.WholesaleAccountsApplication       : Running with Spring Boot v2.1.0.RELEASE, Spring v5.1.2.RELEASE
2021-01-17 10:51:48.336  INFO 5605 --- [           main] o.a.w.WholesaleAccountsApplication       : The following profiles are active: dev

192-168-1-178:jar_extract hariharank12$ pwd
/Users/hariharank12/programs/springboot/anz_assessment/Wholesale-Accounts/jar_extract
192-168-1-178:jar_extract hariharank12$ java -Dspring.config.location=file:///tmp/Wholesale-Accounts/config/application-staging-tmp.properties -cp app:app/lib/* org.anz.wholesale.WholesaleAccountsApplication

## Endpoints and sample responses
* AccountsEndpoint - http://localhost:8080/Wholesale/accounts/user1?page=0&size=10
```
[
{
id: 1,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.377+0000",
currency: "IND",
openingAvailableBalance: 10
},
{
id: 2,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.452+0000",
currency: "IND",
openingAvailableBalance: 20
},
{
id: 3,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.454+0000",
currency: "IND",
openingAvailableBalance: 30
},
{
id: 4,
userId: "user1",
accountNumber: "100006",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.455+0000",
currency: "IND",
openingAvailableBalance: 40
},
{
id: 5,
userId: "user1",
accountNumber: "100006",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.457+0000",
currency: "IND",
openingAvailableBalance: 50
}
]

```

* TransactionEndpoint - http://localhost:8080/Wholesale/accounts/100001/transactions?page=0&size=10
```
[
[
{},
{
id: 1,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.377+0000",
currency: "IND",
openingAvailableBalance: 10
}
],
[
{
id: 7,
account: {
id: 1,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.377+0000",
currency: "IND",
openingAvailableBalance: 10
},
currency: "AUD",
valueDate: "2019-08-21T22:11:25.470+0000",
debitAmount: 200,
creditAmount: null,
debitCredit: "Debit",
transactionNumber: "801100001",
transactionNarrative: "TXN 801100001"
},
{
id: 1,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.377+0000",
currency: "IND",
openingAvailableBalance: 10
}
],
[
{
id: 6,
account: {
id: 1,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.377+0000",
currency: "IND",
openingAvailableBalance: 10
},
currency: "AUD",
valueDate: "2019-08-21T22:11:25.458+0000",
debitAmount: 100,
creditAmount: null,
debitCredit: "Debit",
transactionNumber: "801100001",
transactionNarrative: "TXN 801100001"
},
{
id: 1,
userId: "user1",
accountNumber: "100001",
accountName: "Account IN",
accountType: "Saving",
balanceDate: "2019-08-21T22:11:25.377+0000",
currency: "IND",
openingAvailableBalance: 10
}
]
]
```

