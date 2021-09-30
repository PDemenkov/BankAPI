post json 
User
```
{
  "name" : "Name",
  "surname" : "Surname",
  "accounts" : [{
    "accountNumber" : "42355523",
    "balance" : 999999,
    "cards" : [{
      "cardNumber" : "1432 2311 4221 7667",
      "expDate" : "10/2021",
      "cvv" : "122"
    },
      {
        "cardNumber": "5522 4211 4122 5111",
        "expDate": "04/2025",
        "cvv": "244"
      }
    ]}
  ]}
  ```
  
  post Card
  ```
  {
"cardNumber" : "3333 4444 4444 3333",
      "expDate" : "10/2022",
      "cvv" : "555"
}
```

post CounterParty
```
{
  "name" : "CounterP2",
  "accounts" : [{
    "accountNumber" : "42355523",
    "balance" : 444444,
    "cards" : [{
      "cardNumber" : "1432 2311 4221 7667",
      "expDate" : "10/2021",
      "cvv" : "444"
    }
    ]}
  ]}
  ```
  
 post transfer
  ```
  {
"counterPartyId" : "2",
"amount" : 10000
}
```
  
  
