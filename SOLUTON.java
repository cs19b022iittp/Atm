import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class SOLUTON {

    public static void main(String[] args) {
        int tout=0;
        Scanner in=new Scanner(System.in);
        Database db=new Database();
        BANK obj1 = new BANK();//instantiating bank class
        ATM obj = new ATM();//instantiating atm class
        obj.number();

        int  b=db.getcount();//for counting how many users are there
            db.conn();

            //adding details from database to array list
            try{
                db.stmt=db.con.createStatement();
                ResultSet res=db.stmt.executeQuery("select *from customerdata");
                while(res.next())
                {
                    customer details=new customer();
                    ArrayList<customer> a=new ArrayList<customer>();
                    obj1.a.add(details);//adding details to customers
                    details.acc_no=res.getInt("account");
                    details.password=res.getInt("password");
                    details.balance=res.getDouble("balance");
                    details.phone=res.getString("phone");
                    details.ifsc=res.getString("ifsc");

                }
            }
            catch(Exception e){
                System.out.println("error"+e.getMessage()+"");
            }

     int v=b+obj.t;
     //int c=db.getcount();

        for (int i = b; i <v; i++)//loop for inputting details
        {
            int q=i+1;
            customer details=new customer();
            ArrayList<customer> a=new ArrayList<customer>();
            obj1.a.add(details);//adding details to customers
            System.out.println("enter details for person"+q+"");
            details.enter_yourAccountnumber();
            details.enter_yourAccountpassword();
            details.enter_yourAccountbalance();
            details.enter_yourphonenumber();
            details.enter_yourifsccode();
            db.getadd_user(details.acc_no,details.password,details.balance,details.phone,details.ifsc);

            db.closeconnection();

        }

        while(obj.k!=5) //loop for switching off the atm
        {

            int m;
            System.out.println(" welcome to atm");
            System.out.println("");
            System.out.println("enter number 1 to go main menu for cash withdrawals and deposits ");
            System.out.println("enter number 2 if you are security gaurd to turn off atm");
            m = in.nextInt();
            if (m == 1)//condition for entering into main menu
            {
                int l = -1;
                obj.display();//welcome statement
                while (l != 0)//we have to give choice
                {
                    System.out.println("");
                    obj.account();
                    while (obj.acc < 10000 || obj.acc >= 100000)//condition for taking 5 digit input
                    {
                        System.out.println("please enter five digit");
                        obj.account();

                    }
                    for (int i = 0; i <v; i++) // indentifying the  specific customer
                    {
                        if (obj1.a.get(i).acc_no == obj.acc)
                        {
                            obj.count = i;
                            l = 0;
                            break;
                        }

                    }
                    if (l == -1)
                        System.out.println("please enter correct account number");
                }

                obj.checkPass();//taking input for password
                while (obj.pass < 10000 || obj.pass >= 100000)//condition for taking 5 digit input
                {
                    System.out.println("please enter five digit");
                    obj.checkPass();//taking input for password

                }
                while (obj1.a.get(obj.count).password != obj.pass) {
                    System.out.println("your  password may be incorrect");

                    obj.checkPass();
                }

                System.out.println("enter the number 1 for cashwithdrawals");
                System.out.println("enter the number  2 for deposits");
                System.out.println("enter the number 3 for viewing your current balance");
                System.out.println("enter the number 4 for changing password");
                System.out.println("enter the number 5 for exit");
                int n;
                n = in.nextInt();

                while (n != 5) {
                    switch (n) {
                        case 1:
                            obj.cashwithdraw();
                            if (obj.cwd <=obj1.a.get(obj.count).balance)
                            {
                                obj1.a.get(obj.count).balance =obj1.a.get(obj.count).balance - obj.cwd;
                                System.out.println("TAKE YOUR  "+obj.cwd+" RUPEES");
                            } else
                            {
                                System.out.println("you account does not have enough balance");
                            }

                            break;
                        case 2:
                            obj.deposits();
                            obj1.a.get(obj.count).balance =obj1. a.get(obj.count).balance + obj.d;
                            System.out.println(+obj.d+"  RUPEES sucessfully transferred to your account");
                            break;
                        case 3:
                            obj1.a.get(obj.count).viewmybalance();//to display the balance
                            break;

                        case 4:
                            while(obj1.a.get(obj.count).password!=obj.currentpass)
                            {
                                obj.changepassword();
                            }
                            System.out.println("enter new password");
                            int cp1=in.nextInt();
                            while (cp1 < 10000 || cp1 >= 100000)//condition for taking 5 digit input
                            {
                                System.out.println("please enter five digit");
                                 cp1=in.nextInt();
                            }
                            System.out.println("confirm and enter new password");
                            int cp2=in.nextInt();
                            while (cp2< 10000 || cp2 >= 100000)//condition for taking 5 digit input
                            {
                                System.out.println("please enter five digit");
                                cp2=in.nextInt();
                            }
                            while(cp1!=cp2)
                            {
                                System.out.println("enter confirm password correctly");
                                cp2=in.nextInt();
                            }
                            obj1.a.get(obj.count).password=cp1;
                            db.update_user_password(obj1.a.get(obj.count).acc_no,cp1);
                            System.out.println("your new password is"+obj1.a.get(obj.count).password);
                            break;
                        default:
                            System.out.println("please enter valid input");
                            break;

                    }
                    System.out.println("enter the number 1 for cashwithdrawals");
                    System.out.println("enter the number  2 for deposits");
                    System.out.println("enter the number 3 for viewing your current balance");
                    System.out.println("enter the number 4 for changing password");
                    System.out.println("enter the number 5 for exit");
                    n = in.nextInt();
                }

            }//m=1

            else if (m == 2)// condition for turning off atm

            {
                int y;
                System.out.println("enter the security pin to turn off atm");
                y = in.nextInt();
                if (y == obj.getSecurity_pin) {

                    obj.k = 5;
                    System.out.println("ATM is turning off .......");

                } else
                    System.out.println("wrong security pin");
            }
            for(int u=0;u<v;u++)
            {
                int facc=obj1.a.get(u).acc_no;
                int finalpassword=obj1.a.get(u).password;
                double finalbalance=obj1.a.get(u).balance;
                db.update_user_password(facc,finalpassword);
                db.update_user_balance(facc,finalbalance);
            }




        }


    }

}
