import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.Throwable;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
            EntityManager entitymanager = emfactory.createEntityManager( );
            entitymanager.getTransaction( ).begin( );

            User user = new User();

            user.setUsername(username);
            user.setPassword(password);

            entitymanager.persist(user);
            entitymanager.getTransaction().commit();

            entitymanager.close( );
            emfactory.close( );

            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            request.getRequestDispatcher("user.html").include(request, response);

            out.close();
        
        }

        catch(javax.persistence.RollbackException e) {
        String cause = e.getCause().toString();
        boolean errorCode = cause.contains("Error Code: 1062");
        if (errorCode){
            out.print("This username already in use");
            request.getRequestDispatcher("register.html").include(request, response);
        }
        out.close();
                
        }

        catch(Exception se) {
            out.println("registered");
            out.println(se.getMessage());
            se.printStackTrace();
            out.close();
        }

        

	
    }
}
