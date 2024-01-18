Steps to Use the Zennode Program:

Initialization and Constants:
The program initializes constants such as the number of units per package, shipping fee per package, various discount rates, and prices of products.
User Input:

The user is prompted to enter the quantity of each product (A, B, C) and whether they want gift wrapping for each product.
The program uses a Scanner to collect user input.
Cost Calculation:

For each product (A, B, C), the program calculates the total cost using the costOfEachProduct method.
The subtotal is calculated as the sum of the total costs for all products.
Discount Calculation:

The DiscountObtained method determines the applicable discount based on various criteria:
Flat discount of 10% if the subtotal exceeds a specified amount.
Bulk discount of 5% for each product if the quantity exceeds a specified amount.
Bulk discount of 10% if the total quantity of all products exceeds a specified amount.
Tiered discount of 50% for each product if the total quantity of all products exceeds a specified amount and the quantity of each product exceeds a specified amount.
The program selects the discount with the highest value and applies it to the subtotal.
Additional Fees Calculation:

Gift wrap fees are calculated based on the user's choice for each product using the TotalGiftWrapFee method.
Shipping fees are calculated based on the total quantity of items using the TotalShippingFee method.
Result Printing:

The program prints a summary of the product details, including quantity and total cost for each product.
It displays the subtotal, discount amount, discount name, shipping fee, gift wrap fee, and the final total cost.
Detailed Explanation of Methods:
DiscountObtained Method:

Calculates discounts for flat, bulk, and tiered discounts.
Selects the discount with the highest value and returns an array containing the discount amount and the name of the applied discount.
TotalGiftWrapFee Method:

Calculates and returns the total gift wrap fee based on the quantity of items and the user's choice for gift wrapping.
TotalShippingFee Method:

Calculates and returns the total shipping fee based on the total quantity of items, the number of units per package, and the shipping fee per package.

costOfEachProduct Method:
Calculates and returns the total cost for a given product based on its price and quantity.
Discount Methods:

flat10_Discount: Checks if the subtotal exceeds a specified amount and applies a flat discount of 10%.
bulk5_Discount: Applies a 5% bulk discount for each product if the quantity exceeds a specified amount.
bulk10_Discount: Applies a 10% bulk discount if the total quantity of all products exceeds a specified amount.
tier50_Discount: Applies a 50% tiered discount for each product if the total quantity of all products exceeds a specified amount and the quantity of each product exceeds a specified amount.
PrintingProductDetails Method:

Prints the details of a product, including its name, quantity, and total cost.
How to Run the Program:
Compile the Program:

Open a terminal or command prompt.
Navigate to the directory containing the Java file (Zennode.java).
Compile the program using the command: javac Zennode.java
Run the Program:

After compiling successfully, run the program using the command: java Discount
Follow the prompts to input the quantity of each product and choose gift wrapping.
View Results:

The program will display a summary of the product details and the final cost, including discounts, shipping fees, and gift wrap fees.

Note: Ensure that Java is installed on your system to run the program. No additional dependencies are required.
