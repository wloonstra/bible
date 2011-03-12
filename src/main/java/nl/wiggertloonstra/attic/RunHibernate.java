package nl.wiggertloonstra.attic;
 
import org.hibernate.Session;
 
public class RunHibernate {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        Person person = new Person();
        person.setName("Wiggert");
 
        session.merge(person);
        session.getTransaction().commit();
    }
}