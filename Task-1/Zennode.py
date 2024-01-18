noOfUnitsPerPackage = 10
shippingFeePerPackage = 5
discount = 0
flat10Discount = 200
bulk5Discount = 10
bulk10Discount = 20
tiered50Discount = 30
tiered50Quantity = 15
priceOfA = 20
priceOfB = 40
priceOfC = 50

def DiscountObtained(subTotal, quantityOfA, quantityOfB, quantityOfC, flat10Discount, bulk5Discount, bulk10Discount, tiered50Discount, tiered50Quantity, discount, totalPriceOfA, totalPriceOfB, totalPriceOfC):
    discounts_array = [flat10_Discount(subTotal, flat10Discount, discount),
                       bulk5_Discount(discount, quantityOfA, quantityOfB, quantityOfC, bulk5Discount, totalPriceOfA, totalPriceOfB, totalPriceOfC),
                       bulk10_Discount(subTotal, discount, quantityOfA, quantityOfB, quantityOfC, bulk10Discount),
                       tier50_Discount(discount, quantityOfA, quantityOfB, quantityOfC, tiered50Discount, tiered50Quantity, totalPriceOfA, totalPriceOfB, totalPriceOfC)]
    discount_details = [0, 0]
    max_discount = discounts_array[0]
    ind = 0
    for i in range(1, 4):
        if discounts_array[i] > max_discount:
            max_discount = discounts_array[i]
            ind = i
    discount_details[0] = max_discount
    discount_details[1] = ind
    return discount_details

def TotalGiftWrapFee(quantity, giftWrap):
    if giftWrap=="True":
        return quantity
    return 0

def TotalShippingFee(quantityA, quantityB, quantityC, noOfUnitsPerPackage, shippingFeePerPackage):
    totalNoOfItems = quantityA + quantityB + quantityC
    totalNoOfPackages = (totalNoOfItems + noOfUnitsPerPackage - 1) // noOfUnitsPerPackage
    return totalNoOfPackages * shippingFeePerPackage

def costOfEachProduct(priceOfProduct, quantityOfProduct):
    return priceOfProduct * quantityOfProduct

def flat10_Discount(subtotal, flat10Discount, discount):
    if subtotal > flat10Discount:
        discount = 10
    return discount

def bulk5_Discount(discount, quantityOfA, quantityOfB, quantityOfC, bulk5Discount, totalA, totalB, totalC):
    if quantityOfA > bulk5Discount:
        discount += int(totalA * 0.05)
    if quantityOfB > bulk5Discount:
        discount += int(totalB * 0.05)
    if quantityOfC > bulk5Discount:
        discount += int(totalC * 0.05)
    return discount

def bulk10_Discount(subTotal, discount, quantityA, quantityB, quantityC, bulk10Discount):
    if quantityA + quantityB + quantityC > bulk10Discount:
        discount = 10
    return (subTotal * discount) // 100

def tier50_Discount(discount, quantityA, quantityB, quantityC, tiered50Discount, tiered50Quantity, totalA, totalB, totalC):
    if quantityA + quantityB + quantityC > tiered50Discount and quantityA > tiered50Quantity:
        discount += totalA // 2
    if quantityA + quantityB + quantityC > tiered50Discount and quantityB > tiered50Quantity:
        discount += totalB // 2
    if quantityA + quantityB + quantityC > tiered50Discount and quantityC > tiered50Quantity:
        discount += totalC // 2
    return discount

def PrintingProductDetails(productName, quantity, total):
    print(productName + " - Quantity: " + str(quantity) + ", Total: $" + str(total))

quantityOfA = int(input("Quantity of Product A: "))
giftWrapOfA = str(input(("Gift wrapping for productA? (True/False): ")))

quantityOfB = int(input("Quantity of Product B: "))
giftWrapOfB = str(input(("Gift wrapping for productB? (True/False): ")))

quantityOfC = int(input("Quantity of Product C: "))
giftWrapOfC = str(input(("Gift wrapping for productC? (True/False): ")))

totalPriceOfA = costOfEachProduct(priceOfA, quantityOfA)
totalPriceOfB = costOfEachProduct(priceOfB, quantityOfB)
totalPriceOfC = costOfEachProduct(priceOfC, quantityOfC)
subTotal = totalPriceOfA + totalPriceOfB + totalPriceOfC

discount_names = ["flat_10_Discount","bulk_5_Discount","bulk_10_Discount","tiered_50_Discount"]
discountDetails = DiscountObtained(subTotal, quantityOfA, quantityOfB, quantityOfC, flat10Discount, bulk5Discount, bulk10Discount, tiered50Discount, tiered50Quantity, discount, totalPriceOfA, totalPriceOfB, totalPriceOfC)
discountAmount = discountDetails[0]
discountName = discount_names[discountDetails[1]]
giftWrapTotalFee = TotalGiftWrapFee(quantityOfA, giftWrapOfA) + TotalGiftWrapFee(quantityOfB, giftWrapOfB) + TotalGiftWrapFee(quantityOfC, giftWrapOfC)
shippingFee = TotalShippingFee(quantityOfA, quantityOfB, quantityOfC, noOfUnitsPerPackage, shippingFeePerPackage)
total = subTotal - discountAmount + shippingFee + giftWrapTotalFee

print("\nProduct Details:")
PrintingProductDetails("Product A", quantityOfA, totalPriceOfA)
PrintingProductDetails("Product B", quantityOfB, totalPriceOfB)
PrintingProductDetails("Product C", quantityOfC, totalPriceOfC)

print("\nSubtotal: $" + str(subTotal))
print("Discount Amount Applied: $" + str(discountAmount))
print("Discount Name Applied: " + str(discountName))
print("Shipping Fee: $" + str(shippingFee))
print("Gift Wrap Fee: $" + str(giftWrapTotalFee))
print("Total: $" + str(total))

