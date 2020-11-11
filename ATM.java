import java.util.*;
public class ATM {
    int acc,pass,cwd,d,count,t,count1;
    int k=0;
    int currentpass=0;
    private int security_pin=84653;//turning off the atm
    int getSecurity_pin=this.security_pin;
    Scanner in=new Scanner(System.in);
    void back()
    {
        int out=in.nextInt();
    }
    void changepassword()
    {
        System.out.println("enter current password");
        currentpass=in.nextInt();
    }
    void display()// welcome statement
    {
        System.out.println("WELCOME");
    }
    void number()// taking  input forn number of customers details to store
    {
        System.out.println("enter number of customers you want to store");
        t=in.nextInt();
    }

    void account()//method for taking account number
    {
        System.out.println("enter your account no");
        acc=in.nextInt();
    }
    void checkPass()//method for taking password
    {
        System.out.println("enter your password");
        pass=in.nextInt();
    }
    void cashwithdraw()//method for taking cash
    {
        System.out.println("enter how much money you want");
        cwd=in.nextInt();
    }
    void deposits()//method to deposit cash
    {
        System.out.println("enter the amount to deposit in your account");
        d=in.nextInt();
    }

}