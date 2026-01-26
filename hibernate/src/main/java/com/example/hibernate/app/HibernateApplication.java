package com.example.hibernate.app;

import com.example.hibernate.entity.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApplication {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Pelicula p = new Pelicula();
            p.setTitulo("Origen");
            p.setGenero("Ciencia Ficcion");
            p.setEstreno(2010);

            session.persist(p);

            tx.commit();
            System.out.println("Guardado correcto: " + p.toString());
            
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
