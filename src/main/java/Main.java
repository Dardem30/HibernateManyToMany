import by.model.Role;
import by.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by УВД on 20.06.2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            session.beginTransaction();
           User user=new User();
           user.setUsername("Alexandr1");
           user.setPassword("765");
            User user2=new User();
            user2.setUsername("Ivanov1");
            user2.setPassword("878");
            User user3=new User();
            user3.setUsername("Kiselov1");
            user3.setPassword("787");
            Role role=new Role();
            role.setName("USER");
            role.setId(4);
            Set<Role> roles=new HashSet<Role>();
            roles.add(role);
            user.setRoles(roles);
            user2.setRoles(roles);
            user3.setRoles(roles);
//            session.update(role);
            session.update(user);
            session.update(user2);
            session.update(user3);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}