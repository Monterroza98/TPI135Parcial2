/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.EntityManagerProvider;
import static sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.EntityManagerProvider.persistenceUnit;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.MarcaFacade;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Marca;

/**
 *
 * @author joker
 */
public class MarcaTest {
  @Rule
    public EntityManagerProvider em = persistenceUnit("mantenimientoTestPU"); 
  
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
