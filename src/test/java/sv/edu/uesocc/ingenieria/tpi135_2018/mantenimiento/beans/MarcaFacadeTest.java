/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.mockito.internal.util.reflection.Whitebox;
import static sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.EntityManagerProvider.persistenceUnit;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Marca;

/**
 *
 * @author joker
 */
public class MarcaFacadeTest {
    @Rule
    public EntityManagerProvider em = persistenceUnit("mantenimientoTestPU");


    @Test
    public void when_creating_null_marca_expect_false() {
        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em.em());
        mf.getEntityManager().getTransaction().begin();

        boolean result = mf.create(null);

        assertEquals(0, mf.findAll().size());
        assertFalse(result);
    }

    @Test
    public void when_creating_new_marca_expect_true() {
        Marca nuevoMarca = new Marca();
        nuevoMarca.setNombre("Test Marca");
        nuevoMarca.setDescripcion("Algun detalle de prueba");
        nuevoMarca.setActivo(true);

        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em.em());

        mf.getEntityManager().getTransaction().begin();
       
        boolean result = mf.create(nuevoMarca);

        assertTrue(result);
        assertEquals(1, mf.findAll().size());
    }

    @Test
    public void when_modify_valid_marca_expect_true() {
        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em.em());
        mf.getEntityManager().getTransaction().begin();
        mf.getEntityManager().persist(new Marca(null, "test marca", true));

        Marca expected = new Marca(1, "changed Marca", false);
        Marca modified = new Marca(1, "changed Marca", false);

        Marca result = mf.editar(expected);

        assertNotNull(result.getIdMarca());
        assertEquals(result.getNombre(), expected.getNombre());
    }

    @Test
    public void when_delete_null_marca_expect_false() {
        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em.em());
        mf.getEntityManager().getTransaction().begin();
        boolean result = mf.remove(null);
        assertEquals(0, mf.findAll().size());
        assertFalse(result);
    }

    @Test
    public void when_delete_valid_marca_expect_true() {
        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em.em());
        mf.getEntityManager().getTransaction().begin();
        mf.getEntityManager().persist(new Marca(null, "test Marca", true));
        Marca entity = new Marca(1);
        boolean result = mf.remove(entity);
        assertTrue(result);
    }
    
    @Test
    public void findAll(){
        MarcaFacade mf = new MarcaFacade();
        
        Marca nuevoMarca = new Marca();
        nuevoMarca.setNombre("Test Marca");
        nuevoMarca.setDescripcion("Algun detalle de prueba");
        nuevoMarca.setActivo(true);
        
        Marca nuevoMarca2 = new Marca();
        nuevoMarca2.setNombre("Test Marca2");
        nuevoMarca2.setDescripcion("Algun detalle de prueba2");
        nuevoMarca2.setActivo(true);

        Whitebox.setInternalState(mf, "em", em.em());

        mf.getEntityManager().getTransaction().begin();
        
        boolean result1 = mf.create(nuevoMarca);
        boolean result2 = mf.create(nuevoMarca2);
        
        assertTrue(result1);
        assertEquals(2, mf.findAll().size());   
    }
    
    @Test
    public void findRange(){
        MarcaFacade mf = new MarcaFacade();
        
        Marca nuevoMarca = new Marca();
        nuevoMarca.setNombre("Test Marca");
        nuevoMarca.setDescripcion("Algun detalle de prueba");
        nuevoMarca.setActivo(true);
        
        Marca nuevoMarca2 = new Marca();
        nuevoMarca2.setNombre("Test Marca2");
        nuevoMarca2.setDescripcion("Algun detalle de prueba2");
        nuevoMarca2.setActivo(true);
        
        Marca nuevoMarca3 = new Marca();
        nuevoMarca.setNombre("Test Marca3");
        nuevoMarca.setDescripcion("Algun detalle de prueba3");
        nuevoMarca.setActivo(true);
        
        Marca nuevoMarca4 = new Marca();
        nuevoMarca2.setNombre("Test Marca4");
        nuevoMarca2.setDescripcion("Algun detalle de prueba4");
        nuevoMarca2.setActivo(true);
        
        Whitebox.setInternalState(mf, "em", em.em());

        mf.getEntityManager().getTransaction().begin();
        
        boolean result1 = mf.create(nuevoMarca);
        boolean result2 = mf.create(nuevoMarca2);
        boolean result3 = mf.create(nuevoMarca3);
        boolean result4 = mf.create(nuevoMarca4);
        
        assertEquals(2, mf.findRange(0, 2).size());
  
    }
    
    @Test
  public void findByNombreLike(){
      MarcaFacade mf= new MarcaFacade();
      Whitebox.setInternalState(mf, "em", em.em());
      mf.getEntityManager().getTransaction().begin();
      Marca m1 = new Marca(1, "chepito", true);
      Marca m2 = new Marca(2, "gochez", true);
      Marca m3 = new Marca(3, "monzo", true);
   
      mf.getEntityManager().persist(m1);
      mf.getEntityManager().persist(m2);
      mf.getEntityManager().persist(m3);
      
      Assert.assertEquals(3, mf.findAll().size());
      
      List<Marca> resultado = mf.findByNombreLike("mon");
      
      List<Marca> esperado= new ArrayList<>();
      esperado.add(m3);

      resultado.stream().forEach(t->{
          System.out.println(t.getNombre());
      });
      
      Assert.assertEquals(resultado.size(), esperado.size());
      
      
  }
}
