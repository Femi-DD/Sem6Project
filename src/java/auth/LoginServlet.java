package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kole-Ibrahim AbdulQudus Babafemi
 */
public class LoginServlet extends HttpServlet {

    private String username, password = "";

    Connection con;
    PreparedStatement prep;
    final String url = "jdbc:mysql://localhost:3306/aptech?zeroDateTimeBehavior=convertToNull";

    protected void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "babafemi10665798");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected boolean userIsValid(String username, String password) {
        boolean flag = false;
        connect();
        try {
            String sql = "select * from users where name = ? and password = ?";
            prep = con.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, password);
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                flag = username.equals(resultSet.getString("name")) && password.equals(resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            flag = false;
        }
        return flag;
    }

    protected boolean addNewUser(String name, String email, String password) {
        connect();
        boolean flag = false;
        try {
            String sql = "insert into users (name, email, password) values (?, ?, ?)";
            con.prepareStatement(sql);
            prep.setString(1, name);
            prep.setString(2, email);
            prep.setString(3, password);
            int check = prep.executeUpdate();
            flag = check > 0 || check == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            this.username = request.getParameter("username");
            this.password = request.getParameter("password");
            if (userIsValid(this.username, this.password)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("username", this.username);
                out.println("<script>alert('Login Successful.')</script>");
            } else {
                out.println("<script>alert('Username / Password Incorrect!')</script>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
