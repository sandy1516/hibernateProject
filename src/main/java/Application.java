import model.Address;
import model.Contact;
import model.Employee;
import org.hibernate.Session;
import persistence.HibernateUtil;

/**
 * Created by sandeep_k on 28-06-2017.
 */
public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Address address = new Address();
        address.setStreet("Velachery");
        address.setCity("Chennai");
        address.setState("Tamil Nadu");
        address.setZipcode("600100");
//        session.save(address);

        Contact contact = new Contact();
        contact.setContactType("Office");
        contact.setMobileNumber("9876543210");
        contact.setLandLine("205502");
        contact.setEmailId("muthukumar@mail.com");
        contact.setAddress(address);
//        session.save(contact);

        Employee emp = new Employee();
        emp.setFirstName("Muthukumar");
        emp.setLastName("M");
        emp.setContact(contact);
        session.save(emp);

        session.getTransaction().commit();
    }
}
