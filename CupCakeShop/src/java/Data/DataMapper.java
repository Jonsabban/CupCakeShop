package Data;

import classes.CakeBottom;
import classes.CakeTopping;
import classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataMapper {

    // must be put into Facade
    private Connection con;

    public DataMapper() {
        con = new DB().getConnection();
    }

    public User getUser(String username, String password) {

        User user = null;
        PreparedStatement getUser = null;
        ResultSet rs = null;
        String SQLString = "select * from user where username = ? and Password = ?";

        try {
            con.setAutoCommit(false);
            getUser = con.prepareStatement(SQLString);

            //Setting the "?" to the given String
            getUser.setString(1, username);
            getUser.setString(2, password);
            rs = getUser.executeQuery();
            con.commit();
            //Getting the results from the statement
            if (rs.next()) {
                user = new User(rs.getInt("User_ID"), rs.getString("Username"), rs.getString("Password"), rs.getInt("Balance"));
            }
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - getUser");
            System.out.println(e.getMessage());
        }
        return user;

    }

    public void registerUser(String username, String password) {
        PreparedStatement newUser = null;
        String SQLString = "insert into User (Username, Password) values (?,?)";
        try {

            con.setAutoCommit(false);
            newUser = con.prepareStatement(SQLString);
            newUser.setString(1, username);
            newUser.setString(2, password);
            newUser.executeUpdate();

            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - registerUser");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<CakeBottom> listAllBottoms() {

        CakeBottom bottom = null;
        ArrayList<CakeBottom> bottomList = new ArrayList();

        String SQLString = "SELECT * FROM cupcake_bottom";
        PreparedStatement listBottom = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con.setAutoCommit(false);
            listBottom = con.prepareStatement(SQLString);
            con.commit();
            rs = listBottom.executeQuery();
            while (rs.next()) {
                bottom = new CakeBottom(rs.getInt("b_ID"), rs.getString("bottom"), rs.getInt("price"));
                bottomList.add(bottom);
            }
            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - listAllBottoms");
            System.out.println(e.getMessage());
        }
        return bottomList;
    }

    public ArrayList<CakeTopping> listAllToppings() {

        CakeTopping topping = null;
        ArrayList<CakeTopping> toppingList = new ArrayList();

        String SQLString = "SELECT * FROM cupcake_topping";
        PreparedStatement listTopping = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con.setAutoCommit(false);
            listTopping = con.prepareStatement(SQLString);
            con.commit();
            rs = listTopping.executeQuery();
            while (rs.next()) {
                topping = new CakeTopping(rs.getInt("t_ID"), rs.getString("topping"), rs.getInt("price"));
                toppingList.add(topping);
            }
            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - listAllToppings");
            System.out.println(e.getMessage());
        }
        return toppingList;
    }

    public CakeBottom selectBottom(String bottom) {

        CakeBottom cakeBottom = null;
        PreparedStatement getBottom = null;
        ResultSet rs = null;
        String SQLString = "select * from cupcake_bottom where bottom = ?";

        try {
            con.setAutoCommit(false);
            getBottom = con.prepareStatement(SQLString);

            getBottom.setString(1, bottom);
            rs = getBottom.executeQuery();
            con.commit();

            if (rs.next()) {
                cakeBottom = new CakeBottom(rs.getInt("b_ID"), rs.getString("bottom"), rs.getInt("price"));
            }
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - getBottom");
            System.out.println(e.getMessage());
        }
        return cakeBottom;

    }

    public CakeTopping selectTopping(String topping) {

        CakeTopping cakeTopping = null;
        PreparedStatement getTopping = null;
        ResultSet rs = null;
        String SQLString = "select * from cupcake_topping where topping = ?";

        try {
            con.setAutoCommit(false);
            getTopping = con.prepareStatement(SQLString);

            getTopping.setString(1, topping);
            rs = getTopping.executeQuery();
            con.commit();

            if (rs.next()) {
                cakeTopping = new CakeTopping(rs.getInt("t_ID"), rs.getString("topping"), rs.getInt("price"));
            }
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - getTopping");
            System.out.println(e.getMessage());
        }
        return cakeTopping;

    }
}
