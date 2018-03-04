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
 * @authorName	Kole-Ibrahim AbdulQudus
 * @authorMail	femi.highsky@yahoo.com
 * @authorWebsite http://www.kolequotes.com/profile
 */
public class LoginServlet extends HttpServlet {

  private String name, email, username, password, id = "";

  Connection con;
  PreparedStatement prep;
  final String url = "jdbc:mysql://localhost:3306/aptech?zeroDateTimeBehavior=convertToNull";

  //Connection Method
  //supply your phpMyAdmin or MySQL database username and password is you have the option set in your phpMyAdmin/MySQL
  //if not just change babafemi10665798 to an empty string, but leave root as is, it's a default in phpMyAdmin
  protected void connect() {
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, "root", "babafemi10665798");
	 } catch (ClassNotFoundException | SQLException ex) {
		System.out.println(ex.getMessage());
	 }
  }

  //Checks to see if the user exists in the database with the supplied login parameters and returns a bool value
  protected boolean userIsValidForLogin(String username, String password) {
	 connect();
	 boolean flag = false;
	 try {
		String sql = "select * from users where username = ? and password = ?";
		prep = con.prepareStatement(sql);
		prep.setString(1, username);
		prep.setString(2, password);
		ResultSet resultSet = prep.executeQuery();
		while (resultSet.next()) {
		  flag = username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"));
		  this.name = resultSet.getString("name");
		  this.username = resultSet.getString("username");
		  this.password = resultSet.getString("password");
		  this.id = resultSet.getString("id");
		  break;
		}
	 } catch (SQLException ex) {
		System.out.println(ex.getMessage());
		flag = false;
	 }
	 return flag;
  }

  //creates a new user with supplied parameters
  protected boolean addNewUser(String name, String username, String email, String password) {
	 connect();
	 boolean flag = false;
	 try {
		String sql = "insert into users (name, username, email, password) values (?, ?, ?, ?)";
		prep = con.prepareStatement(sql);
		prep.setString(1, name);
		prep.setString(2, username);
		prep.setString(3, email);
		prep.setString(4, password);
		int check = prep.executeUpdate();
		flag = check > 0 || check == 1;
	 } catch (SQLException ex) {
		System.out.println(ex.getMessage());
		flag = false;
	 }
	 return flag;
  }

  //checks if the user exists in the database, based on the two most unique kind of data
  protected boolean userExists(String username, String email) {
	 connect();
	 boolean flag = false;
	 try {
		String sql = "select * from users where username = ? or email = ?";
		prep = con.prepareStatement(sql);
		prep.setString(1, username);
		prep.setString(2, password);
		ResultSet resultSet = prep.executeQuery();
		while (resultSet.next()) {
		  flag = username.equals(resultSet.getString("username")) && email.equals(resultSet.getString("email"));
		  break;
		}
	 } catch (SQLException ex) {
		System.out.println(ex.getMessage());
	 }
	 return flag;
  }

  //checks if the varibles required to perform authentication processes are empty
  //this is called before the addNewUser() method
  protected boolean checkVariables() {
	 //this is line is in test mode, pls ignore
//	 boolean flag = this.name.isEmpty() && this.username.isEmpty() && this.email.isEmpty() && this.password.isEmpty();
	 boolean flag = "".equals(this.name) && "".equals(this.username) && "".equals(this.email) && "".equals(this.password);
	 return flag;
  }

  //access to the servlet, just like a main method, but for java web apps
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 try (PrintWriter out = response.getWriter()) {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("login")) {
		  this.username = request.getParameter("username");
		  this.password = request.getParameter("password");
		  if (userIsValidForLogin(this.username, this.password)) {
			 HttpSession httpSession = request.getSession();
			 httpSession.setAttribute("id", this.id);
			 httpSession.setAttribute("name", this.name);
			 httpSession.setAttribute("username", this.username);
			 out.println("<script>alert('Login Successful.')</script>");
		  } else {
			 out.println("<script>alert('Username / Password Incorrect!')</script>");
		  }
		} else if (action.equalsIgnoreCase("register")) {
		  this.name = request.getParameter("name");
		  this.email = request.getParameter("email");
		  this.username = request.getParameter("username");
		  this.password = request.getParameter("password");
		  if (!checkVariables()) {
			 if (!userExists(this.username, this.email)) {
				if (addNewUser(this.name, this.username, this.email, this.password)) {
				  out.println("Signup was successful!");
				} else {
				  out.println("Signup failed...");
				}
			 } else {
				out.println("Username Or Email is already taken!");
			 }
		  } else {
			 out.println("All fields are required!");
		  }
		}
	 }
  }

  //the following are default methods created by netbeans, please do not touch if you're not sure of what you're getting into
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
