package com.company;

import java.util.ArrayList;

public interface DataMapper {

    public abstract Object load(int id);
    public abstract ArrayList<Object> loadAll(String query);
    public abstract Object find(String query);
    public abstract ArrayList<Object> findAll(String query);
    public abstract ArrayList<Object> update(String query);
    public abstract ArrayList<Object> save(int id);
    public abstract ArrayList<Object> delete(int id);


}
