/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service.dao;

import java.util.List;

/**
 *
 * @author OUMAIMA
 */
public interface dao<T>  {
     Boolean creat (T o);
    Boolean delete ( T o);
    Boolean update ( T o );
    T findById( int o);
    List<T> getAll();
    
}
