import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

  public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      response.setContentType("text/html");  
      PrintWriter out=response.getWriter();
              
      String username=request.getParameter("username");
      String password=request.getParameter("password");
              
      if(Validate.checkUser(username, password)) {
        request.getRequestDispatcher("user.html").include(request, response);
        HttpSession session=request.getSession();
        session.setAttribute("username",username);
      }  
      else {
        out.print("Sorry, username or password error!");
        request.getRequestDispatcher("login.html").include(request, response);
      }
      out.close();
    }
  }
