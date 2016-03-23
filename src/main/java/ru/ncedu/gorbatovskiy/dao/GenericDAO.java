package ru.ncedu.gorbatovskiy.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;

import org.hibernate.*;
import org.hibernate.criterion.*;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public abstract class GenericDAO<T, PK extends Serializable> {
    private SessionFactory sessionFactory;
    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public T read(PK id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }

    public void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public Long getCount() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return (Long) session.createCriteria(type).setProjection(Projections.rowCount()).uniqueResult();
    }

    public List<T> findByNamedQuery(String namedQuery) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return (List<T>) session.getNamedQuery(namedQuery).list();
    }

    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.createCriteria(type).list();
    }

    public void closeSession() {
        if (sessionFactory != null) {
            Session session = sessionFactory.getCurrentSession();
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
