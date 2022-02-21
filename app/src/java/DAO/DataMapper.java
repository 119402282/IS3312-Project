package DAO;

import Data.DataBase;
import static Data.DataBase.getInstance;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

public abstract class DataMapper<ObjType, IdType> {
    
    Connection conn = DataBase.getConnection();

    public abstract ObjType load(ObjType id);
    public abstract ObjType loadById(IdType id);
    
    //The following is just a filter function
    public abstract ArrayList<ObjType> findAllWhere(String condition);
    public abstract ArrayList<ObjType> loadAll();
    protected abstract ArrayList<ObjType> queryMultiple(String qry);
    protected abstract ObjType querySingle(String qry);
    
    //The following mutate the sql file and the arraylist of all saved
    //They call loadAll at their end for the return
    
    public abstract ArrayList<ObjType> create(ObjType item);
    public abstract ArrayList<ObjType> createById(ObjType item, IdType id);
    public abstract ArrayList<ObjType> updateById(ObjType item, IdType id);
    public abstract ArrayList<ObjType> update(ObjType item);
    public abstract ArrayList<ObjType> deleteById(IdType id);
    public abstract ArrayList<ObjType> delete(ObjType id);
}
