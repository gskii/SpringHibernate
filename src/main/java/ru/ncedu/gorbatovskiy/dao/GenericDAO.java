package ru.ncedu.gorbatovskiy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

    public void create(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public T read(PK id) {
        T resultEntity = null;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        resultEntity = (T) sessionFactory.getCurrentSession().get(type, id);
        session.getTransaction().commit();
        return resultEntity;
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

    protected Integer getCount(String tableName) {
        String sqlStatement = "SELECT COUNT(*) FROM " + tableName + ";";
        List resultSetList = null;
        Integer countValue = null;
        resultSetList = executeQuery(sqlStatement);
        if (resultSetList != null && !resultSetList.isEmpty()) {
            Object resultObject = resultSetList.get(0);

            // Результаты целочисленных запросов Hibernate приводит к BigInteger

            if (resultObject instanceof BigInteger) {
                countValue = ((BigInteger) resultObject).intValue();
            }
        }
        return countValue;
    }

    public List<T> findByQuery(String query) {
        List<T> resultList = null;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        resultList = (List<T>) session.createSQLQuery(query)
                .addEntity(type)
                .list();
        session.getTransaction().commit();
        return resultList;
    }

    public List executeQuery(String query) {
        List resultList = null;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        resultList = session.createSQLQuery(query).list();
        session.getTransaction().commit();
        return resultList;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
