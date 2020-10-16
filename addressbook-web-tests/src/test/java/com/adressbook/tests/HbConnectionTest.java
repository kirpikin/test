package com.adressbook.tests;

import com.adressbook.model.GroupData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.type.DateType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class HbConnectionTest {
    private SessionFactory sessionFactory;

    @BeforeTest
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

//INSERT INTO `group_list`(`deprecated`, `group_name`, `group_header`, `group_footer`) VALUES ("")
    @Test
    public void connTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        GroupData newGr = new GroupData().withName("nhnew23").withFooter("footer22").withHeader("header22").withDeprecated(Timestamp.valueOf("1983-07-12 21:30:55.888"));
        session.saveOrUpdate(newGr);
        //session.getTransaction().commit();


        List<GroupData> result = session.createQuery( "from GroupData" ).list();
        for ( GroupData group : result ) {
            System.out.println(group);
        }
        session.getTransaction().commit();
        session.close();
    }
}
