package com.sda;

import org.hibernate.Session;

public class DAO {
    public <T> void newObject(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(object);
        session.flush();
        session.close();
    }

    public <T> T findById(Long id, Class<T> typeClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T findingObject = (T) session.find(typeClass, id);
        session.close();
        return findingObject;
    }

    public <T> T update(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        object = (T) session.merge(object);
        session.flush();
        session.close();
        return object;
    }

    public <T> void delete(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.flush();
        session.close();
    }
}
