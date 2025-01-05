# Coin Calculator (backend)

This project is the backend part for [CoinCalculator(frontend)](https://github.com/HIT-cenhaoyang/2025_CenHaoyang_frontend).

## Request Example
Please use POST Method to `http://<Your IP address>/coins/calculate`
```
{
    "targetAmount": 138.25,
    "coinDenominations": [0.05,2,10,50,100,1000]
}
```
## Response Example
```
[
    0.05,
    0.05,
    0.05,
    0.05,
    0.05,
    2,
    2,
    2,
    2,
    10,
    10,
    10,
    100
]
```

## Getting started

1. Clone the repository

   ```
   git clone https://github.com/HIT-cenhaoyang/2025_CenHaoyang_frontend
   ```
2. Build the project
   `mvn clean package`
3. Run the project
   ### Option 1
   You can run the project directly through
   ```
   java -jar target/Coins.jar server
   ```
   ### Option 2
   Or use Docker to build and run
   ```
   docker build -t coins-calculator .
   docker run -p 8080:8080 coins-calculator
   ```
   ### Option 3
   Also can use Docker-Compose to start frontend and backend at the same time
   
   Refer to [CoinCalculator(frontend)](https://github.com/HIT-cenhaoyang/2025_CenHaoyang_frontend).
