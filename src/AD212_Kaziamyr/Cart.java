package AD212_Kaziamyr;

import java.util.Scanner;
/*
 * @author Bohdan Kaziamyr
 * @version 9 Oct 2022
 */
public class Cart {
    Scanner sc = new Scanner(System.in);
    public Product[] stack;
    private int topIndex, l = 0, userInt;
    double cost, cartPrice= 0;

    //constructor which allows to create a cart with certain capacity
    public Cart(int capacity){
        stack = new Product[capacity];
    }

    //the method delete one product from the cart
    public void deleteProduct(){
        productList();
        System.out.print("Select the number of the product to delete\nEnter the number: ");
        userInt = sc.nextInt();
        userInt -= 1;
        l--;
        stack[userInt] = null;
        int last2 = 0;
        for (int i=userInt; i< stack.length-1;i++) {
            stack[userInt] = stack[userInt+1];
            last2 = userInt+1;
        }
        stack[last2] = null;
    }

    //add one product with name and price
    public void addProduct(){
        if (l < stack.length){
            System.out.printf("\n\nPlease, enter the name of the product: ");
            String name = sc.next();
            do {
                System.out.printf("Please, enter the cost of the product: ");
                cost = sc.nextFloat();
                if (cost <= 0) System.out.printf("The price can't be <= 0! \nTry again\n");
            }while(cost <= 0);
            stack[l] = new Product(name, (float) cost);
            l++;
        }
        else System.out.print("Your cart is full! Delete some products to add another one.");
    }

    //shows the list of the products
    public void productList(){
        System.out.print("\n---THE LIST---\n");
        for(int i=0;i< stack.length; i++){
            if (stack[i] != null){
                System.out.printf("%d. Name = %s \tprice = %.2f\n", i+1, stack[i].name, stack[i].cost);
            }
        }
        if (l>1) {
            cartSum();
            System.out.printf("TOTAL:\t%.2f",cartPrice);
        }
        int last = stack.length-l;
        if (last != 0) System.out.printf("\nYou can take "+ last + " more\n");
        else System.out.print("\nThe cart is full\n");

    }

    //counts the total cost of all products in the cart
    public void cartSum(){
        cartPrice = 0;
        for (int i = 0; i<l; i++){
            cartPrice += stack[i].cost;
        }
    }

    //increases products prices as a percentage
    public void pricesUp(double percent){
        for (int i = 0; i<l; i++){
            stack[i].cost *= (percent/100)+1;
        }
    }

    //reduces products prices as a percentage
    public void pricesDown(double percent){
        for (int i = 0; i<l; i++){
            stack[i].cost -= stack[i].cost * (percent/100);
        }
    }
}
