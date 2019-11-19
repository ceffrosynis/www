import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Validate {
    public static boolean checkUser(String username, String password) 
    {
        boolean st =false;
        try {

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );

            EntityManager entitymanager = emfactory.createEntityManager( );
            entitymanager.getTransaction( ).begin( );
            User user = entitymanager.find( User.class, username );

            if (user == null) {
                System.out.println("Invalid username");
                return false;
            }
            else {
                System.out.println("Username = " + user.getUsername( ));
                System.out.println("Password = " + user.getPassword( ));
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return true;                 
    }   
}

