package DBdao;
import java.io.Serializable;

import org.hibernate.Session;
import IDAO.IGenericDAO;

public abstract class GenericDAO<T extends Serializable> implements IGenericDAO<T> {

    private Class<T> persistentClass;
    private Session session;

    public GenericDAO(Class<T> entityClass) {
        this.persistentClass = entityClass;
    }

    public Session getSession() {
        session = HibernateUtils.getSessionFactory().openSession();
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public void saveOrUpdate(T entity) {
        Session sessionOne = getSession();
        sessionOne.beginTransaction();
        sessionOne.saveOrUpdate(entity);
        sessionOne.getTransaction().commit();
        sessionOne.close();
    }

    @Override
    public void update(T entity){
        Session sessionOne = getSession();
        sessionOne.beginTransaction();
        sessionOne.update(entity);
        sessionOne.getTransaction().commit();
        sessionOne.close();
    }

    @Override
    public void delete(T entity) {
        Session sessionOne = getSession();
        sessionOne.beginTransaction();
        sessionOne.delete(entity);
        sessionOne.getTransaction().commit();
        sessionOne.close();
    }

    @Override
    public T findById(int id) {
        Session sessionOne = getSession();
        sessionOne.beginTransaction();
        T entity = (T) session.get(persistentClass, id);
        sessionOne.getTransaction().commit();
        sessionOne.close();
        return entity;
    }


    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }
}
