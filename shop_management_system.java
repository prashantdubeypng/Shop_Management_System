


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class shop_management_system {
    Scanner input = new Scanner(System.in);
    String item_name_1 = "";/* To get the stock */
    int TOTAL_PAID;

    String item_name_2 = "";// To get the stock information
    int item_weight_1 ;//weight of stock item
    int Item_weight_2;//weight of second stock item
    /* customer buy variable*/
    int customer_weight_1;// quantity how much customer need
    int Customer_weight_2;//quantity how much customer need
    int customer_choice_1; //
    int customer_choice_2;
    int customer_paid_1 ;
    int customer_paid_2 ;
    /* stock_check_variable*/
    int stock_weight_1 ;////TO get information about stock left
    int stock_weight_2; //= (Item_weight_2 - Customer_weight_2);//TO get information about stock left
    int price_1;
    int price_2;

    
    public void profile()
    {
        System.out.println("Select your profile  :-");
        System.out.println("1:- for admin ");
        System.out.println("2:- for customer");
        int login = input.nextInt();
        if (login == 1){
            admin();

        }
        if (login == 2);{
               customer();
        }
    }
    public void admin(){
        String password = "";
        System.out.println("1:- add stock ");
        System.out.println("2:- stock check ");
        System.out.println("3:- check Today  sale ");
        int stock_check = input.nextInt();
       if (stock_check == 1 || stock_check == 2 || stock_check == 3) {
           switch (stock_check) {
               case 1:
                   System.out.println("NAME :-  ");
                   item_name_1 = input.next();
                   System.out.println("quantity(kg) :-  ");
                   item_weight_1 = input.nextInt();
                   System.out.println("price:-  ");
                   price_1 = input.nextInt();
                   System.out.println("NAME :- ");
                   item_name_2 = input.next();
                   System.out.println("quantity(kg) :-  ");
                   Item_weight_2 = input.nextInt();
                   System.out.println("price:-  ");
                   price_2 = input.nextInt();
                   System.out.println("stock is updated, if you want to check the stock entre PASSWORD otherwise just entre 'x'");
                   password = input.next();
                   break;
               case 2:
                   System.out.println("**************************STOCK DETAILS ********************************");
                   System.out.println(item_name_1 + ":-" + item_weight_1);
                   System.out.println(item_name_2 + ":-" + Item_weight_2);
                   break;
               case 3:
                   System.out.println("                                 TODAY SALE                                    ");
                   System.out.println("UNDER DEVELOPMENT 404...........................................................");// today sale after customer
                   admin();
           }
       }
       else{
           System.out.println("INVALID INPUT RE-START THE PROCESS ");
           System.out.println("start the process from beginning");
           profile();
       }
       if (password.equals("PASSWORD") || password.equals("Password") || password.equals("pASSWORD")  || password.equals("password") ){
           System.out.println("**************************STOCK DETAILS ********************************");
           System.out.println(item_name_1 + ":-" + item_weight_1);
           System.out.println(item_name_2 + ":-" + Item_weight_2);
           profile();
       } else if (password.equals("X")|| password.equals("x")) {
           profile();
       }

    }
    public void customer(){
        System.out.println("IF YOU WANT TO ADD ANYTHING IN YOU CART ENTRE 1 ELSE ENTRE 0 ");
        System.out.println("1>"+item_name_1+":-"+price_1+"per kg");
        System.out.println("DID  YOU WANT"+item_name_1+":-");
        customer_choice_1 = input.nextInt();
        if (customer_choice_1 == 1){
            System.out.println("How much you want :- ");
            int sample_check_1 = input.nextInt();
            System.out.println("SELECT IN WHICH QUANTITY YOU WANT THE PRODUCT");
            System.out.println("1:-kg");
            System.out.println("2:-gram");
            int weight = input.nextInt();
            if (weight == 1){

                customer_weight_1 = sample_check_1;
               customer_paid_1 = price_1*customer_weight_1;

            } else if (weight == 2) {
                customer_weight_1 = sample_check_1/1000;//converting gram into kg for all correct value
                customer_paid_1 = price_1*customer_weight_1;
            }
            else {
                System.out.println("INVALID INPUT");
                customer();
            }

        }
        System.out.println("2>"+item_name_2+":-"+price_2+"per kg");
        System.out.println("DID  YOU WANT"+item_name_2+":-");
        customer_choice_2 = input.nextInt();
        if (customer_choice_2 == 1){
            System.out.println("How much you want :- ");
            int sample_check_2 = input.nextInt();
            System.out.println("SELECT IN WHICH QUANTITY YOU WANT THE PRODUCT");
            System.out.println("1:-kg");
            System.out.println("2:-gram");
            int weight_1 = input.nextInt();
            if (weight_1 == 1){
                Customer_weight_2 = sample_check_2;
                customer_paid_2 = price_2*Customer_weight_2;

            } else if (weight_1 == 2) {
                Customer_weight_2 = sample_check_2 /1000;//converting gram into kg for all correct value
                customer_paid_2 = price_2*Customer_weight_2;
            }
            else {
                System.out.println("***********************INVALID INPUT*******************************");
                customer();
            }

        }
        System.out.println("*******************THE END *******************************************");
        System.out.println("your bill is getting ready ");
        System.out.println("LOADING..................................................................................");
        utility_bills();
        System.out.println("THANK YOU FOR YOU VISIT ");
        profile();

    }
    public void utility_bills() {
        System.out.println("ENTRE YOUR NAME :- ");
        String name = input.next();
        System.out.println("ENTRE YOUR PHONE NUMBER :-");
        long phone_no = input.nextLong();
        int length = String.valueOf(phone_no).length();
        if (length != 10) {
            System.out.println("your phone number is invalid input ");
            utility_bills();
        }
        System.out.println("*********YOUR UTILITY BILL IS READY NOW************************** ");
        input.nextLine();
        System.out.println("                                  ENGINEERING GENERAL  STORE                          ");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(name+ "                                             " + formattedDateTime);
        System.out.println(phone_no);
        System.out.println("ITEM                  QTY                          PRICE ");
        System.out.println(item_name_1+"          "+customer_weight_1+"        "+customer_paid_1);
        System.out.println(item_name_2+"          "+Customer_weight_2+"        "+customer_paid_2);
        TOTAL_PAID = customer_paid_1+customer_paid_2;

        System.out.println("Total paid able Amount :-- "+TOTAL_PAID);
        System.out.println("GIVE THIS BILL TO WORKER AND COLLECT ALL YOUR STUFF FROM COUNTER NO 1");
        System.out.println("THANK YOU COME AGAIN ");



    }
    public static void main(String[] args) {
        shop_management_system system = new shop_management_system();
        system.profile();
    }
}





