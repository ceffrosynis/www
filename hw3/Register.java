import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/users","root","xristos");

            PreparedStatement ps = con.prepareStatement
                        ("insert into users values(?,?,?)");

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("You are sucessfully registered");
            }
        
        }
        catch(SQLException se) {

            if(se.getErrorCode() == 1062){
                 out.println("This username already exists");
            }

        }
        catch(Exception se) {
            out.println("registered");
            out.println(se.getMessage());
            se.printStackTrace();
        }

	
    }
}
