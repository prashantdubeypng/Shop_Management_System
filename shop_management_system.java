package prashant.com;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class shop_management_system {
    Scanner input = new Scanner(System.in);
int  profit = 0;
    float paid = 0;
    int profite = 0 ;
    ArrayList<Integer> stock_quantity = new ArrayList<>();
    ArrayList<Float>COST_PRICE = new ArrayList<>();
    ArrayList<String>stock_name = new ArrayList<>();
    ArrayList<Float>stock_price = new ArrayList<>();
    ArrayList<String>customer_choice = new ArrayList<>();
    ArrayList<Float>customer_weight = new ArrayList<>();
    ArrayList<Float>customer_paid = new ArrayList<>();
    ArrayList<Float>total_paid = new ArrayList<>();
    ArrayList<String>name_sale = new ArrayList<>();
    ArrayList<Float>weight_sale = new ArrayList<>();
    ArrayList<Float>paid_sale = new ArrayList<>();
    public void profile()
    {
        System.out.println("Select your profile  :-");
        System.out.println("1:- for admin ");
        System.out.println("2:- for customer");
        int login = input.nextInt();
        if (login == 1){
            admin();
        }
        if (login == 2){
               customer();
        }
    }
    public void admin(){
        System.out.println("1:- add stock ");
        System.out.println("2:- stock check ");
        System.out.println("3:- check Today  sale ");
        int stock_check = input.nextInt();
       if (stock_check == 1 || stock_check == 2 || stock_check == 3) {
           switch (stock_check) {
               case 1:// In this I have used concept of arraylist (because we don't know the number of stock have to add
                   while (true){
                       System.out.println("to exit it please write exit ");
                       System.out.println("entre the name of the material to add :-");
                       String name = input.next();
                       if (name.equalsIgnoreCase("exit")){
                           break;
                       }
                       System.out.println("entre the quantity of material :-");
                       int quantity = input.nextInt();
                       System.out.println("entre the price of material per kg :-");
                       float price = input.nextFloat();
                       System.out.println("entre the cost price of material :- ");
                       float COST= input.nextFloat();
                       stock_name.add(name);
                       stock_quantity.add(quantity);
                       stock_price.add(price);
                       COST_PRICE.add(COST);
                   }
                   profile();
                   break;
               case 2:
                   for (int i = 0 ; i < stock_name.size() ; i++){
                       System.out.println(stock_name.get(i)+":-"+stock_quantity.get(i));
                   }
                   profile();
                   break;
               case 3:
                   System.out.println("                                 TODAY SALE                                    ");
                   TOTAL_SALE();// today sale after customer
                   calculateProfit();// total profit of day
                   admin();
           }
       }
       else{
           System.out.println("INVALID INPUT RE-START THE PROCESS ");
           System.out.println("start the process from beginning");
           profile();
       }
    }
    public void customer(){
        //stock visual to customer
        System.out.println("if you want to add anything in your cart entre 1 else any number ");
        for(int i = 0 ; i <stock_name.size() ; i++ ){
            System.out.println(stock_name.get(i)+":-"+stock_price.get(i));
            System.out.println("DO YOU WANT"+stock_name.get(i));
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("entre the quantity you want (in kg):-");
                float weight = input.nextFloat();
                customer_weight.add(weight);
                customer_choice.add(stock_name.get(i));
                customer_paid.add(stock_price.get(i)*customer_weight.get(i));
            }
        }
        System.out.println("*******************THE END *******************************************");
        System.out.println("your bill is getting ready ");
        System.out.println("LOADING..................................................................................");
        utility_bill();
        System.out.println("THANK YOU FOR YOU VISIT ");
        profile();
    }
    public void utility_bill() {
        System.out.println("entre your name :-");
        String name = input.next();
        System.out.println("entre your mobile number :-");
        long mobile_number = input.nextLong();
        int length = String.valueOf(mobile_number).length();
        if (length != 10) {
            System.out.println("your phone number is invalid in ");
            utility_bill();
        }
        System.out.println("                                  ENGINEERING GENERAL  STORE                          ");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(name+ "                                             " + formattedDateTime);
        System.out.println(mobile_number);
        for (int i = 0 ; i< customer_weight.size(); i++){
            System.out.println(customer_choice.get(i)+"  "+customer_weight.get(i)+"  "+customer_paid.get(i));
            paid = paid+customer_paid.get(i);
        }
        for (int i = 0 ; i < customer_weight.size();i++ ){
            name_sale.add(customer_choice.get(i));
            weight_sale.add(customer_weight.get(i));
            paid_sale.add(customer_paid.get(i));
        }
        customer_choice.clear();
        customer_weight.clear();
        customer_paid.clear();
        total_paid.add(paid);
        for (int i = 0 ; i <total_paid.size();i++) {
            System.out.println("TOTAL AMOUNT TO PAY :-" + total_paid.get(i));
        }
        total_paid.clear();
        System.out.println("Thanks to come in your favourite store ");
        stock_manage();
        stock_check();
    }
    public void TOTAL_SALE(){
        System.out.println("TOTAL SALE ");
        for (int i = 0 ; i <name_sale.size();i++ ){
            System.out.println(name_sale.get(i)+":-"+weight_sale.get(i)+":-"+paid_sale.get(i));
            profite += paid_sale.get(i);
        }
        System.out.println("Total sale :-"+profite);
    }
    public void stock_manage() {// stock get decrease with customer's shopping
        for (int i = 0; i < stock_name.size(); i++) {
            if (customer_choice.contains(stock_name.get(i))) {
                int index = customer_choice.indexOf(stock_name.get(i));
                stock_quantity.set(i, stock_quantity.get(i) - customer_weight.get(index).intValue());
            }
        }
    }
    public void calculateProfit() {
        float total_cost = 0;
        for (int i = 0; i < name_sale.size(); i++) {
            int index = stock_name.indexOf(name_sale.get(i));
            total_cost += COST_PRICE.get(index) * weight_sale.get(i);
        }
        float total_paid = (float) paid_sale.stream().mapToDouble(Float::doubleValue).sum();
        profit = (int) (total_paid - total_cost);
        System.out.println("Profit made today: " + profit);
    }
    public void stock_check(){// check if the stock is less than a thresold value and give notification to admin;
        for (int i = 0; i < stock_quantity.size(); i++) {
            if (stock_quantity.get(i)<5){
                System.out.println("stock is getting less, please fill the stock");
            }
        }
    }
    public static void main(String[] args) {
        shop_management_system system = new shop_management_system();
        system.profile();
    }
}
