## Problem 1: SALES TAXES
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items
I receive a receipt which lists the name of all the items and their price (including tax),
finishing with the total cost of the items,
and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax
rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of
sales tax.
Write an application that prints out the receipt details for these shopping baskets...

### INPUT ###
Input 1: 
> 1 book at 12.49
> 1 music CD at 14.99
> 1 chocolate bar at 0.85

Input 2:
> 1 imported box of chocolates at 10.00
> 1 imported bottle of perfume at 47.50

Input 3:
> 1 imported bottle of perfume at 27.99
> 1 bottle of perfume at 18.99
> 1 packet of headache pills at 9.75
> 1 box of imported chocolates at 11.25

### OUTPUT ###
Output 1:
> 1 book: 12.49
> 1 music CD: 16.49
> 1 chocolate bar: 0.85
> Sales Taxes: 1.50
> Total: 29.83
Output 2:
> 1 imported box of chocolates: 10.50
> 1 imported bottle of perfume: 54.65
> Sales Taxes: 7.65
> Total: 65.15
Output 3:
> 1 imported bottle of perfume: 32.19
> 1 bottle of perfume: 20.89
> 1 packet of headache pills: 9.75
> 1 imported box of chocolates: 11.85
> Sales Taxes: 6.70
> Total: 74.68

======================================================================= SOLUTION =======================================================================

To solve the project two class are written Store Class and ShoppingCart class. Store class contains all the necessary 
methods such as add items in store, verify user inputs, check items' availibity, do actual shopping etc. ShoppingCart class
contains necessary methods to calculate the price with tax, and to generate receipt. Main class Create a store and shopping cart for a customer in that particular store.
Methods are quite individulal and simple, one can easily integrate more functionalities hence everyone is invited to pull.

	
ENVIRONMENT
Code has been developed and tested in jdk11 environment
junit5 classes called to implement a unit test.

USAGE
In Main Class:
For time being store personnel should add items in store with specification (name,price,isIported,isExepted,quantity)
One should create a store object with store name // firstStore
And, one shopping cart for a user/customer should be created for that store // firstCustomer
Call shoppong method for this customer on that store // firstStore.shopping(firstCustomer)
      > user need to give input
Calculate bill and get receipt // firstCustomer.calculateAndPayBillWithTax();

** Demo items are already added in the main class. Once can manipulate those.

ASSUMPTIONS
1. Console base solution is ok, as no specific type is mentioned in the challenge
2. A store is needed to shop, and a shopping cart to put the item in.
3. There are no database/file sources for a store, hence manual input.
      It is assumed and also pragmatic that a store has a finite number of products, each item has also a stock.
      User/store manager can add/update the list of products usually in the database. However in this project user can add a product
      from the main class, which can be replaced later with populating a store from a database.

4. One items can not be infinitely available, hence need to specify the quantity while adding in store
5. Quantity reduced if once bought some.
6. customer must pay once added in the basket, as no reduction from the basket functionality added
7. No exit, without leaving through cash counter, put a name when asking for product name, put quantity 0, and type "n" to leave.
8. jdk11 environment is possible, test classes utilized junit 5.

