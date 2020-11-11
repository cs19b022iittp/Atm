# Atm
code on atm

first i have tried the code for just one person after that i finally made code for n number of users

IN mycode there willbe  four modules

1.ATM class which having methods to check passwords,account numbers and methods for having cash withdrawals,deposits, taking input for customer to store details

2.BANK class inthis i instantiated array list for customers to track their details
  in this module abstract class named set_info having abstract methods like setting details of account number and password and setting account balance


Again class customer inherits set_info and methods are declared and another method view mybalance to check balance


3.SOLUTION class having main method to run the code 


4. Database class which having methods like connecting to data base and adding users and updating bank balance,passwords

in this it will take inputs of how many customer details they want to store
it will take all details of n number of customers

it willadd details to database
and extract details of previous customer from data base to array list



-> now it will ask the user two options 
1. directs to entering into main menu for transactions 
2. directs to switch off the atm for security gaurd

for first option it ask the user to enter the account number and then checks it is there in arraylist after that checks the password
AFTER this it gives options for transactions and exit option to enter to main menu

**** for second option it asks a password if it matches then code will stops running

you can add  any number of customers
my database name is Atmdatabase
table name is customer data
i have used db browser for sqlite
****************
conditions to run the code:

for inputting details you have to enter only five digit account number password for setting details  and account balance its size should be lessthan 13 digits

And while checking details even you enter number other than 5 digit it will not accept and again asks for 5 digit number therefore for setting details you have to enter 5 digit numbers


conditon to exit code:
while for switching off atm it asks security pin to end the code 

the security pin is 84653
if we enter this it will end the code  till then untill we stops the code it runs

i have included  two common consrtraints like change password method,storing details ionto database...
