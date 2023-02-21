import lk.ijse.hibernet.entity.Customer;
import lk.ijse.hibernet.util.FactoryConfiguratoin;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Demo {
    public static void main(String[] args) {
        Customer ob1 = new Customer();
        ob1.setName("Avidu");
        ob1.setAge(18);
        Customer ob2 = new Customer();
        ob2.setName("Sachin");
        ob2.setAge(20);

        Session session = FactoryConfiguratoin.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Integer id = (Integer) session.save(ob1);
            //session.save returns a serializable and it is cast to integer
            // Then Id is returned
            session.save(ob2);
            System.out.println(ob1);
            System.out.println("id " + id);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
        Customer c = session.get(Customer.class, 1);
        c.setName("New Name");
        Transaction transaction2 = session.beginTransaction();
        try{
            Integer id = (Integer) session.save(ob1);
            //session.save returns a serializable and it is cast to integer
            // Then Id is returned
            session.update(c);
            transaction2.commit();
        }catch (Exception e){
            transaction2.rollback();
        }
        System.out.println("-----------Updated-------------");
        System.out.println(c);
    }
}
