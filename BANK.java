import java.util.Scanner;
import java.util.ArrayList;

public class BANK{

    ArrayList<customer> a=new ArrayList<customer>();//to keep track of customer details
}
 abstract class set_details{
    abstract void viewmybalance();
    abstract void enter_yourAccountnumber();
    abstract void enter_yourAccountpassword();
}
class customer extends set_details//class to set details
{

    Scanner in=new Scanner(System.in);
    int acc_no,password;
    double balance=0;
    String phone,ifsc;

    void viewmybalance()
    {
        System.out.println("your balance is"+balance+"");
    }
    void enter_yourAccountnumber()
    {
        System.out.println("enter your account number to set");
        acc_no=in.nextInt();

    }
    void enter_yourAccountpassword()
    {
        System.out.println("enter your password to set");
        password=in.nextInt();
    }
    void enter_yourAccountbalance()
    {
        System.out.println("enter your account balance to set");
        balance=in.nextDouble();


    }
    void enter_yourphonenumber(){
        System.out.println("enter your phone number");
        phone=in.next();
    }
void enter_yourifsccode()
{
    System.out.println("enter ifsc code");
    ifsc=in.next();
}

}
