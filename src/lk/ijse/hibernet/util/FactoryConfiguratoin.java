package lk.ijse.hibernet.util;

import lk.ijse.hibernet.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguratoin {
    public static FactoryConfiguratoin factoryConfiguratoin;
    private final SessionFactory sessionFactory;

    private FactoryConfiguratoin() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguratoin getInstance() {
        return factoryConfiguratoin == null ?
                factoryConfiguratoin = new FactoryConfiguratoin() : factoryConfiguratoin;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
