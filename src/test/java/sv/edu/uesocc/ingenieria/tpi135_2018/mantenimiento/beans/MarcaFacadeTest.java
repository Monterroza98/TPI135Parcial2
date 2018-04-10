/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
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
    
}
