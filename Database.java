import java.sql.*;
public class Database {

    Statement stmt=null;
    Connection con=null;

    public   Connection conn(){

        try {
            Class.forName("org.sqlite.JDBC");
         con= DriverManager.getConnection("jdbc:sqlite:Atmdatabase.db");
            System.out.println("connected to data base");
        }
        catch(Exception e)
        {
            System.out.println("error"+e.getMessage()+"");
        }
        return con;
    }
    public void list_users(){

          conn();
        try{
            this.stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("select *from customerdata");
            while(res.next())
            {
                long ac=res.getLong("account");
                long pas=res.getLong("password");
                double bal=res.getDouble("balance");
                long ph=res.getLong("phone");
                String ifsc=res.getString("ifsc");
                System.out.println(ac+" "+pas+" "+bal+" "+ph);
            }
        }
        catch(Exception e){
            System.out.println("error"+e.getMessage()+"");
        }

    }
  private  void add_user(int account,int passw,double bal,String phn ,String ifsc )
  {

        conn();

        try {
            String sql = "INSERT INTO customerdata(account,password,balance,phone,ifsc) VALUES(?,?,?,?,?)";
           PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1,account);
            ps.setLong(2,passw);
            ps.setDouble(3,bal);
            ps.setString(4,phn);
            ps.setString(5,ifsc);
            ps.execute();
            System.out.println("added customer");

        }
        catch (Exception e) {
            System.out.println("error" + e.getMessage() + "");
        }
  }

         private void delete_user(int account)
         {

             conn();
             try{

                 String sql="DELETE FROM customerdata WHERE account= ? ";
                 PreparedStatement ps= con.prepareStatement(sql);
                 ps.setLong(1,account);
                 ps.execute();
                 System.out.println("deleted customer");

             }
             catch(Exception e)
             {
                 System.out.println("error"+e.toString());
             }
         }
         public void update_user_password(int ac,int pas)
         {

            ResultSet res=null;
             conn();
            try{
                String sql="update customerdata  set password = ? where account= ?";
                PreparedStatement  ps=con.prepareStatement(sql);
                ps.setInt(1,pas);
                ps.setInt(2,ac);
                ps.execute();
                System.out.println("password updated");
            }
            catch(Exception e)
            {
                System.out.println("error" + e.getMessage() + "");

            }

         }
         public void update_user_balance(int ac,double bal)
         {
             ResultSet res=null;
             conn();
             try{
                 String sql="update customerdata  set balance = ? where account= ?";
                 PreparedStatement  ps=con.prepareStatement(sql);
                 ps.setDouble(1,bal);
                 ps.setInt(2,ac);
                 ps.execute();
                 System.out.println("balance updated");
             }
             catch(Exception e)
             {
                 System.out.println("error" + e.getMessage() + "");

             }
         }

    public void closeconnection() {

        try {
            con.close();
        }
        catch(Exception e){
            System.out.println("error" + e.getMessage() + "");
        }
    }
    void getadd_user(int account,int passw,double bal,String phn ,String ifsc )
    {
        add_user(account,passw,bal,phn,ifsc );
    }
    void getdelete_user(int account)
     {
        delete_user(account);
      }
    int getcount()
    {

        int ct=0;
        conn();
        try {
            this.stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select *from customerdata");
            while(res.next())
            {
                ct=ct+1;
            }
        }
        catch(Exception e)
        {
            System.out.println("error" + e.getMessage() + "");
        }
        return ct;
    }

}
