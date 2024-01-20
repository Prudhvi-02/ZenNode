import java.util.Scanner;
public class Discount {
    public static void main(String[] args) {
        int noOfUnitsPerPackage = 10;
        int shippingFeePerPackage = 5;
        int discount = 0;
        int flat10Discount = 200;
        int bulk5Discount = 10;
        int bulk10Discount = 20;
        int tiered50Discount = 30;
        int tiered50Quantity = 15;
        int priceOfA = 20;
        int priceOfB = 40;
        int priceOfC = 50;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Quantity of Product A: ");
        int quantityOfA = userInput.nextInt();
        System.out.println("Gift wrapping for productA?: ");
        boolean giftWrapOfA = userInput.nextBoolean();

        System.out.println("Quantity of Product B: ");
        int quantityOfB = userInput.nextInt();
        System.out.println("Gift wrapping for productB?: ");
        boolean giftWrapOfB = userInput.nextBoolean();

        System.out.println("Quantity of Product C: ");
        int quantityOfC = userInput.nextInt();
        System.out.println("Gift wrapping for productC?: ");
        boolean giftWrapOfC = userInput.nextBoolean();

        int totalPriceOfA = costOfEachProduct(priceOfA, quantityOfA);
        int totalPriceOfB = costOfEachProduct(priceOfB, quantityOfB);
        int totalPriceOfC = costOfEachProduct(priceOfC, quantityOfC);
        int subTotal = totalPriceOfA + totalPriceOfB + totalPriceOfC;

        String[] discount_names={"flat_10_Discount","bulk_5_Discount","bulk_10_Discount","tiered_50_Discount"};
        int[] discountDetails = DiscountObtained(subTotal, quantityOfA, quantityOfB, quantityOfC, flat10Discount, bulk5Discount, bulk10Discount, tiered50Discount, tiered50Quantity, discount,totalPriceOfA,totalPriceOfB, totalPriceOfC);
        int discountAmount=discountDetails[0];
        String discountName=discount_names[discountDetails[1]];
        int giftWrapTotalFee = TotalGiftWrapFee(quantityOfA, giftWrapOfA) + TotalGiftWrapFee(quantityOfB, giftWrapOfB) + TotalGiftWrapFee(quantityOfC, giftWrapOfC);
        int shippingFee = TotalShippingFee(quantityOfA, quantityOfB, quantityOfC, noOfUnitsPerPackage, shippingFeePerPackage);
        int total = subTotal - discountAmount + shippingFee + giftWrapTotalFee;

        System.out.println("\nProduct Details:");
        PrintingProductDetails("Product A", quantityOfA, totalPriceOfA);
        PrintingProductDetails("Product B", quantityOfB, totalPriceOfB);
        PrintingProductDetails("Product C", quantityOfC, totalPriceOfC);

        System.out.println("\nSubtotal: $" + subTotal);
        System.out.println("Discount Amount Applied: $" + discountAmount);
        System.out.println("Discount Name Applied: " + discountName);
        System.out.println("Shipping Fee: $" + shippingFee);
        System.out.println("Gift Wrap Fee: $" + giftWrapTotalFee);
        System.out.println("Total: $" + total);
    }

    public static int[] DiscountObtained(int subTotal, int quantityOfA, int quantityOfB, int quantityOfC, int flat10Discount, int bulk5Discount, int bulk10Discount, int tiered50Discount, int tiered50Quantity, int discount, int totalPriceOfA, int totalPriceOfB, int totalPriceOfC) {
        int[] discounts_array=new int[4];
        discounts_array[0] = flat10_Discount(subTotal,flat10Discount,discount);
        discounts_array[1] = bulk5_Discount(discount,quantityOfA,quantityOfB,quantityOfC,bulk5Discount, totalPriceOfA, totalPriceOfB, totalPriceOfC);
        discounts_array[2] = bulk10_Discount(subTotal, discount, quantityOfA, quantityOfB, quantityOfC, bulk10Discount);
        discounts_array[3]= tier50_Discount(discount, quantityOfA, quantityOfB, quantityOfC, tiered50Discount, tiered50Quantity, totalPriceOfA, totalPriceOfB, totalPriceOfC );
        int[] discount_details=new int[2];
        int max_discount=discounts_array[0],ind=0;
        for (int i=1;i<4;i++){
            if(discounts_array[i]>max_discount){
                max_discount=discounts_array[i];
                ind=i;
            }
        }
        discount_details[0]=max_discount;
        discount_details[1]=ind;
        return discount_details;

    }

    public static int TotalGiftWrapFee(int quantity, boolean giftWrap) {
        if(giftWrap)
            return quantity;
        return 0;
    }

    public static int TotalShippingFee(int quantityA, int quantityB, int quantityC, int noOfUnitsPerPackage, int shippingFeePerPackage) {
        int totalNoOfItems = quantityA + quantityB + quantityC;
        int totalNoOfPackages = (int) Math.ceil((double) totalNoOfItems / noOfUnitsPerPackage);
        return totalNoOfPackages * shippingFeePerPackage;
    }

    public static int costOfEachProduct(int priceOfProduct, int quantityOfProduct) {
        return priceOfProduct * quantityOfProduct;
    }

    public static int flat10_Discount(int subtotal, int flat10Discount, int discount){
        if (subtotal > flat10Discount)
            discount=10;
        return discount;
    }

    public static int bulk5_Discount(int discount,int quantityOfA, int quantityOfB, int quantityOfC, int bulk5Discount,int totalA,int totalB,int totalC){
        if(quantityOfA > bulk5Discount){
            discount+= (int) (totalA * 0.05);
        }
        if(quantityOfB > bulk5Discount){
            discount+= (int) (totalB * 0.05);
        }
        if(quantityOfC > bulk5Discount){
            discount+= (int) (totalC * 0.05);
        }
        return discount;
    }
    public static int bulk10_Discount(int subTotal, int discount, int quantityA, int quantityB, int quantityC, int bulk10Discount){
        if (quantityA + quantityB + quantityC > bulk10Discount)
            discount = 10;
        return (subTotal * discount) / 100;
    }
    public static int tier50_Discount( int discount, int quantityA, int quantityB, int quantityC, int tiered50Discount, int tiered50Quantity, int totalA, int totalB, int totalC ){
        if (quantityA + quantityB + quantityC > tiered50Discount && quantityA > tiered50Quantity) {
            discount+=totalA/2;
        }
        if (quantityA + quantityB + quantityC > tiered50Discount && quantityB > tiered50Quantity) {
            discount+=totalB/2;
        }
        if (quantityA + quantityB + quantityC > tiered50Discount && quantityC > tiered50Quantity) {
            discount+=totalC/2;
        }
        return discount;
    }

    public static void PrintingProductDetails(String productName, int quantity, int total) {
        System.out.println(productName + " - Quantity: " + quantity + ", Total: $" + total);
    }
}
