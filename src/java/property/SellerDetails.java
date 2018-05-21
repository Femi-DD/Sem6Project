/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TheoTino
 */
public class SellerDetails extends HttpServlet {

  private String title, description, type, interior, facility, region, state, payment, id = "";
  private String price, bedroom, bathroom;
  private String firstname, lastname, email, telephone, address, postcode, seller_region, seller_city;

  //private String; 
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

  // Checks if the variable is empty
  protected boolean checkVariables() {
    //this is line is in test mode, pls ignore
//	 boolean flag = this.name.isEmpty() && this.username.isEmpty() && this.email.isEmpty() && this.password.isEmpty();
    boolean flag = "".equals(this.title) && "".equals(this.description) && "".equals(this.price)
            && "".equals(this.type) && "".equals(this.bedroom) && "".equals(this.bathroom) && "".equals(this.interior)
            && "".equals(this.facility) && "".equals(this.region) && "".equals(this.state) && "".equals(this.payment);
    return flag;
  }

  // This list all the details about the property too be uploaded
  protected boolean addSellerDetails(String title, String description, String price, String type,
          String bedroom, String bathroom, String interior, String facility, String region,
          String state, String payment) {
    connect();
    boolean flag, salute = false;
    //boolean salute = false;
    try {
      String sql = "INSERT INTO property(title, price, type, payment, region, state) VALUES(?, ?, ?, ?, ?, ?)";
      prep = con.prepareStatement(sql);
      prep.setString(1, title);
      prep.setString(2, price);
      prep.setString(3, type);
      prep.setString(4, payment);
      prep.setString(5, region);
      prep.setString(6, state);
      int check = prep.executeUpdate();
      salute = check > 0 || check == 1;
    } catch (Exception ep) {
      System.out.println(ep.getMessage());
      salute = false;
    }

    try {
      String query = "INSERT INTO property_details(title, description, bedroom, bathroom, interior, facility)"
              + "VALUES(?, ?, ?, ?, ?, ?)";
      prep = con.prepareStatement(query);
      prep.setString(1, title);
      prep.setString(2, description);
      prep.setString(3, bedroom);
      prep.setString(4, bathroom);
      prep.setString(5, interior);
      prep.setString(6, facility);
      int checking = prep.executeUpdate();
      flag = checking > 0 || checking == 1;
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      flag = false;
    }
    return flag;
  }

  // This is too Add the Seller Contact Information 
  protected boolean contactSellerDetails(String firstname, String lastname, String email, String telephone,
          String address, String postcode, String seller_region, String seller_city) {
    connect();
    boolean parade = false;
    try {
      String sql = "INSERT INTO contact_details(firstname, lastname, email, telephone, address, postcode, region, city)"
              + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
      prep = con.prepareStatement(sql);
      prep.setString(1, firstname);
      prep.setString(2, lastname);
      prep.setString(3, email);
      prep.setString(4, telephone);
      prep.setString(5, address);
      prep.setString(6, postcode);
      prep.setString(7, seller_region);
      prep.setString(8, seller_city);
      int checked = prep.executeUpdate();
      parade = checked > 0 || checked == 1;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      parade = false;
    }
    return parade;
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      String action = request.getParameter("action");
      if (action.equalsIgnoreCase("submit")) {
        this.title = request.getParameter("title");
        this.description = request.getParameter("description");
        this.type = request.getParameter("type");
        this.interior = request.getParameter("interior");
        this.facility = request.getParameter("facility[]");
        this.region = request.getParameter("region");
        this.state = request.getParameter("state");
        this.payment = request.getParameter("payment");
        this.price = request.getParameter("price");
        this.bedroom = request.getParameter("bedroom");
        this.bathroom = request.getParameter("bathroom");

        this.firstname = request.getParameter("firstname");
        this.lastname = request.getParameter("lastname");
        this.email = request.getParameter("email");
        this.telephone = request.getParameter("telephone");
        this.address = request.getParameter("address");
        this.postcode = request.getParameter("postcode");
        this.seller_region = request.getParameter("seller_region");
        this.seller_city = request.getParameter("seller_city");

        if (!checkVariables()) {
          if (addSellerDetails(this.title, this.description, this.price, this.type, this.bedroom,
                  this.bathroom, this.interior, this.facility, this.region, this.state, this.payment)
                  && contactSellerDetails(this.firstname, this.lastname, this.email, this.telephone,
                          this.address, this.postcode, this.seller_region, this.seller_city)) {
            System.out.println("Uploaded successfully!");
          } else {
            System.out.println("Upload failed...");
          }
        }
      } else {
        System.out.println("All fields are required!");
      }
    }
  }
}
