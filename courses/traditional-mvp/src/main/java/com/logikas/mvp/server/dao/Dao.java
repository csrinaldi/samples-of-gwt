/**
 * 
 */
package com.logikas.mvp.server.dao;

import java.util.List;

/**
 * Package: com.logikas.erp.server.dao.imp File: Dao.java Date: 27/09/2011
 * 
 * @autor cristian - Logikas Conectando Ideas
 */
public interface Dao<E, T> {

  void persist(E entity);
  
  void remove(E entity);

  E findById(T id);

  List<E> findAll();

}