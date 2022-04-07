package models;

import Factories.DAOfactory;

import java.io.Serializable;

public abstract class TableModel <T> implements Serializable {

    private Class<T> persistentClass;
    public TableModel(Class<T> entityClass) {
        this.persistentClass = entityClass;
    }

    public void save(){
        DAOfactory.getAccountDAO().saveOrUpdate(this);
    }




}
