# ENDPOINTS v2:

## Employee Controller

### GET http://localhost:8081/v2/employees   - get all Employees

### GET http://localhost:8081/v2/employees/{id}   - get Employee by ID

### POST http://localhost:8081/v2/employees       - save new Employee

`{
"firstName": "{firstName}",
"lastName": "{lastName}",
"dateOfBirth": "{dateOfBirth}",
"phone": "{phone}",
"job": "{job}"
}`

### PUT http://localhost:8081/v2/employees/{id}    - update Employee by ID

`{
"firstName": "{firstName}",
"lastName": "{lastName}",
"dateOfBirth": "{dateOfBirth}",
"phone": "{phone}",
"job": "{job}"
}`

### DELETE http://localhost:8081/v2/employees/{id} - delete Employee by ID

***

## SalaryInfo Controller - Зарплаты, которые уже выплачены

### GET http://localhost:8081/v2/salaries    - get all salaries

### GET http://localhost:8081/v2/salaries/{employee_id}  - get salaries by Employee ID

### POST http://localhost:8081/v2/salaries/{id}?salary={amount} - save salary by Employee ID

***

## SalaryManager Controller - Показывает всех рабочих и их зарплаты. Также, можно устанавливать следущую ЗП.

### GET http://localhost:8081/v2/salary-manager  - get all records

### GET http://localhost:8081/v2/salary-manager/{employee_id} - get record by Employee ID

### GET http://localhost:8081/v2/salary-manager/status?status={status} - get records by status

### POST http://localhost:8081/v2/salary-manager/{id}?scheduleSalary={amount} - schedule salary by Employee ID

### POST http://localhost:8081/v2/salary-manager/status/{id}?status={status} - set status for Employee ID

***

# Triggers

### POST http://localhost:8081/v2/triggers/trigger-salary-scheduler - applies scheduled salary for status APPROVED

### POST http://localhost:8081/v2/triggers/trigger-salary-pay - Выплачивает все зарплаты (по полю - currentSalary)

***

1. Создаете Employee
2. Назначаете зарплату при помощи salary manager
3. Делаете Approve/Reject
4. Запускаете Salary scheduler
5. Запускаете Salary pay scheduler