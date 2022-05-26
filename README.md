# ENDPOINTS v2:

## Employee Controller

### GET http://localhost:8080/v2/employees

### GET http://localhost:8080/v2/employees/{id}

### POST http://localhost:8080/v2/employees

`{
"firstName": "{firstName}",
"lastName": "{lastName}",
"dateOfBirth": "{dateOfBirth}",
"phone": "{phone}",
"job": "{job}"
}`

### PUT http://localhost:8080/v2/employees/{id}

`{
"firstName": "{firstName}",
"lastName": "{lastName}",
"dateOfBirth": "{dateOfBirth}",
"phone": "{phone}",
"job": "{job}"
}`

### DELETE http://localhost:8080/v2/employees/{id}

***

## SalaryInfo Controller

### GET http://localhost:8080/v2/salaries

### GET http://localhost:8080/v2/salaries/{employee_id}

### POST http://localhost:8080/v2/salaries/{id}?salary={amount}

***

## SalaryManager Controller

### GET http://localhost:8080/v2/salary-manager

### GET http://localhost:8080/v2/salary-manager/{employee_id}

### GET http://localhost:8080/v2/salary-manager/status?status={status}

### POST http://localhost:8080/v2/salary-manager/{id}?scheduleSalary={amount}

### POST http://localhost:8080/v2/salary-manager/status/{id}?status={status}

***

# Triggers

### POST http://localhost:8080/v2/triggers/trigger-salary-scheduler

### POST http://localhost:8080/v2/triggers/trigger-salary-pay