/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.List;

/**
 *
 * @author joker
 */
public interface AbstractFacadeInterface<T> {
    
    public boolean create(T t);

    public T crear(T t);

    public boolean edit(T t);

    public T editar(T t);

    public boolean remove(T t);
    
    public T remover(T t);
    
    public T find(Object id);
    
//    public T findByName(Object name);
    
    public List<T> findAll();
    
    public List<T> findRange(int first, int pagesize);
    
    int count();
    
 
}
