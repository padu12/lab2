package AD212_Kaziamyr;

import java.util.Scanner;
/*
* @author Bohdan Kaziamyr
* @version 9 Oct 2022
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userCartLength, userInt;
        System.out.printf("Please, enter the length of the cart: ");
        userCartLength = sc.nextInt();
        Cart myCart = new Cart (userCartLength);

        //the main cycle where everything happens
        while(true){
            System.out.printf("\n\n---SELECT AN OPTION---\n1 - Add a product\n2 - Show list of products\n3 - Delete a product\n4 - Rise up all prices\n5 - Rise down all prices\n6 - Exit\n\nEnter the number: ");//displays all features
            userInt = sc.nextInt();
            if (userInt == 6) break;
            switch(userInt){
                case 1: //the first case allows you to add some products
                    while (true) {
                        System.out.printf("\n---SELECT AN OPTION---\n1 - Add a product\n2 - Return\n\nEnter the number: ");
                        userInt = sc.nextInt();
                        if (userInt == 1) myCart.addProduct();
                        else if (userInt == 2) break;
                        else System.out.printf("Please, enter the correct number (1 or 2)\n");
                    }
                    break;
                case 2://the case allows you to display the list of all products
                    myCart.productList();
                    System.out.printf("\nEnter sth: ");
                    userInt = sc.nextInt();
                    break;
                case 3://the case allows you to delete products
                    myCart.deleteProduct();
                    break;
                case 4://the case allows you to increase all prices of products as a percentage
                    System.out.printf("Enter the percent: ");
                    userInt = sc.nextInt();
                    myCart.pricesUp(userInt);
                    myCart.productList();
                    System.out.printf("\nEnter sth: ");
                    userInt = sc.nextInt();
                    break;
                case 5:// the case allows you to reduce all prices of products as a percentage
                    System.out.printf("Enter the percent: ");
                    userInt = sc.nextInt();
                    myCart.pricesDown(userInt);
                    myCart.productList();
                    System.out.printf("\nEnter sth: ");
                    userInt = sc.nextInt();
                    break;
            }
        }
    }
}