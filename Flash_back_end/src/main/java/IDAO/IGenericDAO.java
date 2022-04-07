package IDAO;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO <T extends Serializable> {

    public void saveOrUpdate(T entity);

    public void update(T entity);

    public void delete(T entity);

    public T findById(int id);

}
