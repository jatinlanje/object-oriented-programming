## Problem Statement: Bank Management System

The system should allow managing customer accounts, performing transactions, and maintaining the bank's records.

---

Implement the following functionalities:

### Account Creation:
-The system should allow creating new customer accounts with the following details: bank, ifsc, customer name, account number, initial deposit amount.
-Each account should have a unique account number.
-Automatically generate the IFSC code based on the bank name.
-The initial deposit amount should be greater than or equal to a specified minimum balance.

### Account Validation: 
-Add validation mechanisms to ensure that the account number, customer name, and other user inputs meet certain criteria (e.g., format, length, uniqueness).

### User Roles and Permissions: 
-Implement a role-based access control system with different user roles (e.g., administrator, cashier) and associated permissions to restrict access to specific functionalities.

### Account Management:
-The system should provide functionalities to deposit and withdraw money from customer accounts.
-Implement appropriate validations to ensure that withdrawal doesn't exceed the available balance.
-Provide functionalities to display customer account information, including customer name, account number, account balance, bank and ifsc.

### Transaction History:
-The system should maintain a transaction history for each account, including details like transaction type (deposit/withdrawal), date, and amount.

### Account Sorting: 
-Implement sorting to sort accounts based on account balance. 

### Error Handling and Exception Handling: 
-Implement proper error handling and exception handling to catch and handle errors or exceptional situations gracefully, providing meaningful error messages to users.
