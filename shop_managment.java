package prashant.com;

import java.util.Scanner;

public class shop_managment {
    public static void main(String[] args) {

      /*  char user_1 = profile_selection();*/
        admin();
    }

    static char profile_selection() {
        System.out.println("select your profile");
        System.out.println("1 :- login as admin , 2:-  for user ");
        Scanner input = new Scanner(System.in);
        char For_login = input.next().trim().charAt(0);



        return For_login;


    }

    static void admin()
    {
        int user_need = 0;
        int user_need_1 = 0;
        String Iteam_name="";
        String Iteam_name_2="";
        int weight_2 = 0;
        int weight  = 0;
        /*creating Database and add the stock */
        System.out.println("1:- ADD STOCK ");
        System.out.println("2:- CHECK STOCK  ");
        Scanner input = new Scanner(System.in);
        int stock = input.nextInt();
        if (stock==1) {


            /* we have to  use array from there ,  I use basic of java for all this, but now I use array for taking stock information
             * I am  also planning to connect it with sql (for Database , and use Ms-excel to add stock
             * I design the place where coustmer can give order
             *   take two item to check at this time */
            System.out.println("entre the name of item ");
            Iteam_name = input.nextLine();
            System.out.println("entre the weight of ," + Iteam_name);
             weight = input.nextInt();
            System.out.println("entre the name of item ");
             Iteam_name_2 = input.nextLine();
            System.out.println("entre the weight of ," + Iteam_name_2);
             weight_2 = input.nextInt();
        }

        if (stock == 2) {
            int item_left=weight-user_need;
                System.out.println("THE  rest stock left in warehouse is ,"+ Iteam_name +":- "+item_left);
                System.out.println("THE  rest stock left in warehouse is ,"+ Iteam_name_2 +":- "+(weight_2 - user_need_1));

            }
        if(stock == 3){
               System.out.println("Coustmer portale is opeing ");
               /* I have to call the user portale here */

           }
    }
        static void user_portale ( String item_name , String item_name_2 , int weight , int weight_2, int user_need_portol_1, int user_need_portol_2)
        {

            System.out.println("HELLO COUSTMER slect what you want ");
            System.out.println("1:- "+item_name);
            System.out.println("2:- "+item_name_2);
            Scanner input = new Scanner(System.in);
            int user_select = input.nextInt();
            if (user_select == 1){
                System.out.println("entre the quantity you want:- "+item_name);
                 user_need_portol_1 = input.nextInt();
            }
            else if (user_select == 2) {
                System.out.println("entre the quantity you want:- "+item_name);
                 user_need_portol_2 = input.nextInt();



            }



        }

    }
