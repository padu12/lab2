package AD212_Kaziamyr;

import java.util.Scanner;
/*
 * @author Bohdan Kaziamyr
 * @version 9 Oct 2022
 */
public class Product {
    static Scanner sc = new Scanner(System.in);
    String name, userName;
    float cost, percent, userF;
    int user;
    static int itemId;

    //create product with certain name and cost
    Product(String userName, float userCost) {
        if (userCost < 0) userCost = 0;
        name = userName;
        cost = userCost;
    }

    //displays the name and the price of the Product
    public void text() {
        System.out.printf("Name = %s \tcost = %.2f\n", name, cost);
    }

    //the method increasing the price of the Product as a percentage
    public void priceUp(float percent) {
        cost += cost * percent / 100;
        text();
    }
    //the method decreasing the price of the Product as a percentage
    public void priceDown(float percent) {
        if (percent > 100) cost = 0;
        cost -= cost * percent / 100;
        text();
    }
/*

    //tests some features
    public void testing() {
        while(true){
            int user = sc.nextInt();
            switch(user){
                case 1:
                    userF = sc.nextFloat();
                    priceUp(userF);
                    break;
                case 2:
                    userF = sc.nextFloat();
                    priceDown(userF);
                    break;
                case 3:
                    text();
                    break;
            }
            if (user != 1 && user!=2 && user!=3) break;
        }
    }

*/

}
