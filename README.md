## Problem: SALES TAXES
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items
I receive a receipt which lists the name of all the items and their price (including tax),
finishing with the total cost of the items,
and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax
rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of
sales tax.
Write an application that prints out the receipt details for these shopping baskets...


======================= SOLUTION ===================

To solve the project three classes are written Store Class and ShoppingCart class. Store class contains all the necessary 
methods such as add items in store, verify user inputs, check items' availibity, do actual shopping etc. ShoppingCart class
contains necessary methods to calculate the price with tax, and to generate receipt, whereas Item class defines an item. Main class Create a store and shopping cart for a customer in that particular store.
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
9. .files and bin folder kept in git if necessay.

