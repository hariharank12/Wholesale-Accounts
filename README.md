# Wholesale-Accounts
This is a backend REST API project developed using Spring Boot to display accounts and transactions of a given user.

## Design Conventions
* Uses Java8 and SpringBoot 2 for REST implementation.
* Uses InMemory H2db and schema are placed in resources folder. 
* Choice of build tool is Maven because of first class IDE support.
* Application has a context path Wholesale and runs on port 8080. 
* Application supports querying small chunks of data through pagination, having default values.
* A Domain Driven design with multilayered architecture.
* Uses Junit and Mockito for testing. 
* Application is containerized, can be run using docker.
* Uses spotify docker plugin to build docker image as part of maven life cycle.

## Build and Run
* mvn clean install && mvn spring-boot:run or java -jar target/WholesaleAccounts.jar or mvn exec:java -Dexec.mainClass="org.anz.wholesale.WholesaleAccountsApplication"
* docker run -p 8080:8080 hariharank12/wholesale-accounts:1.0-SNAPSHOT

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

