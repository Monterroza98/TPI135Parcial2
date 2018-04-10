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
import org.mockito.internal.util.reflection.Whitebox;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Marca;

/**
 *
 * @author joker
 */
public class MarcaFacadeTest {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    
    public MarcaFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("mantPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class MarcaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        Marca marca1= new Marca();
        marca1.setIdMarca(5);
        marca1.setNombre("Asus");
        marca1.setActivo(true);
        
        Marca marca2= new Marca();
        marca2.setIdMarca(6);
        marca2.setNombre("Acer");
        marca2.setActivo(true);
        
        Marca marca3= new Marca();
        marca3.setIdMarca(7);
        marca3.setNombre("HewletPackard");
        marca3.setActivo(false);
        
        MarcaFacade mf= new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);
        
        mf.getEntityManager().getTransaction().begin();
        
        boolean test1 = mf.create(null);
        boolean test2 = mf.create(marca1);
        boolean test3 = mf.create(marca2);
        
        mf.getEntityManager().getTransaction().commit();
        assertFalse(test1);
        assertTrue(test2);
        assertTrue(test3);
        assertEquals(2, mf.findAll().size());

    }

    /**
     * Test of remover method, of class MarcaFacade.
     */
    @Test
    public void testRemover() throws Exception {
        Marca marca1= new Marca();
        marca1.setIdMarca(7);
        marca1.setNombre("nombre nuevo");
        marca1.setDescripcion("nuevo");
        marca1.setActivo(true);
        
        MarcaFacade mf= new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);
        mf.getEntityManager().getTransaction().begin();
        Marca t = mf.remover(marca1);
        mf.getEntityManager().getTransaction().commit();
        
        assertEquals(marca1, t);

    }

    /**
     * Test of crear method, of class MarcaFacade.
     */
    @Test
    public void testCrear() throws Exception {
        Marca marca1= new Marca();
        marca1.setIdMarca(7);
        marca1.setNombre("nombre nuevo");
        marca1.setDescripcion("nuevo");
        marca1.setActivo(true);
        
        MarcaFacade mf= new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);
        mf.getEntityManager().getTransaction().begin();
        Marca t = mf.crear(marca1);
        mf.getEntityManager().getTransaction().commit();
        
        assertEquals(marca1, t);

    }

    /**
     * Test of edit method, of class MarcaFacade.
     */
    @Test
    public void testEdit() throws Exception {
        Marca m1 = new Marca();
        m1.setIdMarca(1);
        m1.setNombre("pajarito");
        m1.setActivo(true);

        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);
        
        mf.getEntityManager().getTransaction().begin();
        
        boolean test1 = mf.edit(m1);
        
        mf.getEntityManager().getTransaction().commit();
        
        assertTrue(test1);

    }

    /**
     * Test of editar method, of class MarcaFacade.
     */
    @Test
    public void testEditar() throws Exception {
        Marca marca1= new Marca();
        marca1.setIdMarca(7);
        marca1.setNombre("nombre nuevo");
        marca1.setDescripcion("nuevo editado");
        marca1.setActivo(true);
        
        MarcaFacade mf= new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);
        mf.getEntityManager().getTransaction().begin();
        Marca t = mf.editar(marca1);
        mf.getEntityManager().getTransaction().commit();
        assertEquals(marca1, t);
        assertEquals(2, mf.findAll().size());

    }

    /**
     * Test of remove method, of class MarcaFacade.
     */
    @Test
    public void testRemove() throws Exception {
        Marca m1 = new Marca();
        m1.setIdMarca(1);
        m1.setNombre("pajarito");
        m1.setActivo(true);

        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);

        mf.getEntityManager().getTransaction().begin();
        boolean test1 = mf.remove(m1);
        boolean test2 = mf.remove(null);

        List<Marca> findAll = mf.findAll();

        mf.getEntityManager().getTransaction().commit();

        assertTrue(test1);
        assertFalse(test2);
        assertEquals(1, findAll.size());

    }

    /**
     * Test of find method, of class MarcaFacade.
     */
    @Test
    public void testFind() throws Exception {
        Marca m1 = new Marca();
        m1.setIdMarca(1);
        m1.setNombre("pajarito");
        m1.setActivo(true);
        
        MarcaFacade mf = new MarcaFacade();
        Whitebox.setInternalState(mf, "em", em);

        mf.getEntityManager().getTransaction().begin();
        
        List<Marca> find = (List<Marca>) mf.find(m1.getIdMarca());

        mf.getEntityManager().getTransaction().commit();

    }

    /**
     * Test of findAll method, of class MarcaFacade.
     */
    @Test
    public void testFindAll() throws Exception {

    }

    /**
     * Test of findRange method, of class MarcaFacade.
     */
    @Test
    public void testFindRange() throws Exception {

    }

    /**
     * Test of count method, of class MarcaFacade.
     */
    @Test
    public void testCount() throws Exception {

    }

    /**
     * Test of findByNombreLike method, of class MarcaFacade.
     */
    @Test
    public void testFindByNombreLike() throws Exception {

    }
    
}
