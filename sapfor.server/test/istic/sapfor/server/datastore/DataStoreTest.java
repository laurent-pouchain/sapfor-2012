/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package istic.sapfor.server.datastore;

import istic.sapfor.api.dto.*;
import java.util.Collection;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author duke
 */
public class DataStoreTest {
    
    public DataStoreTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class DataStore.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String user = "";
        String password = "";
        DataStore instance = new DataStoreImpl();
        SessionDTO expResult = null;
        SessionDTO result = instance.login(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgent method, of class DataStore.
     */
    @Test
    public void testGetAgent() {
        System.out.println("getAgent");
        Long id = null;
        DataStore instance = new DataStoreImpl();
        AgentDTO expResult = null;
        AgentDTO result = instance.getAgent(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUv method, of class DataStore.
     */
    @Test
    public void testGetUv() {
        System.out.println("getUv");
        Long id = null;
        DataStore instance = new DataStoreImpl();
        UvDTO expResult = null;
        UvDTO result = instance.getUv(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStage method, of class DataStore.
     */
    @Test
    public void testGetStage() {
        System.out.println("getStage");
        Long id = null;
        DataStore instance = new DataStoreImpl();
        StageDTO expResult = null;
        StageDTO result = instance.getStage(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeUv method, of class DataStore.
     */
    @Test
    public void testGetTypeUv() {
        System.out.println("getTypeUv");
        Long id = null;
        DataStore instance = new DataStoreImpl();
        TypeUvDTO expResult = null;
        TypeUvDTO result = instance.getTypeUv(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCandidat method, of class DataStore.
     */
    @Test
    public void testGetIdCandidat() {
        System.out.println("getIdCandidat");
        Long idUv = null;
        EtatCandidatureDTO etat = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdCandidat(idUv, etat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbUvs method, of class DataStore.
     */
    @Test
    public void testNbUvs() {
        System.out.println("nbUvs");
        DataStore instance = new DataStoreImpl();
        int expResult = 0;
        int result = instance.nbUvs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbAgents method, of class DataStore.
     */
    @Test
    public void testNbAgents() {
        System.out.println("nbAgents");
        DataStore instance = new DataStoreImpl();
        int expResult = 0;
        int result = instance.nbAgents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbTypeUvs method, of class DataStore.
     */
    @Test
    public void testNbTypeUvs() {
        System.out.println("nbTypeUvs");
        DataStore instance = new DataStoreImpl();
        int expResult = 0;
        int result = instance.nbTypeUvs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbStages method, of class DataStore.
     */
    @Test
    public void testNbStages() {
        System.out.println("nbStages");
        DataStore instance = new DataStoreImpl();
        int expResult = 0;
        int result = instance.nbStages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUv method, of class DataStore.
     */
    @Test
    public void testAddUv() {
        System.out.println("addUv");
        UvDTO uv = null;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.addUv(uv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAgent method, of class DataStore.
     */
    @Test
    public void testAddAgent() {
        System.out.println("addAgent");
        AgentDTO agent = null;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.addAgent(agent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTypeUv method, of class DataStore.
     */
    @Test
    public void testAddTypeUv() {
        System.out.println("addTypeUv");
        TypeUvDTO typeUv = null;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.addTypeUv(typeUv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStage method, of class DataStore.
     */
    @Test
    public void testAddStage() {
        System.out.println("addStage");
        StageDTO stage = null;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.addStage(stage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delUv method, of class DataStore.
     */
    @Test
    public void testDelUv() {
        System.out.println("delUv");
        long id = 0L;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.delUv(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delAgent method, of class DataStore.
     */
    @Test
    public void testDelAgent() {
        System.out.println("delAgent");
        long id = 0L;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.delAgent(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delTypeUv method, of class DataStore.
     */
    @Test
    public void testDelTypeUv() {
        System.out.println("delTypeUv");
        long id = 0L;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.delTypeUv(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delStage method, of class DataStore.
     */
    @Test
    public void testDelStage() {
        System.out.println("delStage");
        long id = 0L;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.delStage(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdStageDir method, of class DataStore.
     */
    @Test
    public void testGetIdStageDir() {
        System.out.println("getIdStageDir");
        Long idAgent = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdStageDir(idAgent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUvStageDir method, of class DataStore.
     */
    @Test
    public void testGetIdUvStageDir() {
        System.out.println("getIdUvStageDir");
        Long idStage = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdUvStageDir(idStage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUvStageDispo method, of class DataStore.
     */
    @Test
    public void testGetIdUvStageDispo() {
        System.out.println("getIdUvStageDispo");
        Long idAgent = null;
        Long idStage = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdUvStageDispo(idAgent, idStage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdStageInscrit method, of class DataStore.
     */
    @Test
    public void testGetIdStageInscrit() {
        System.out.println("getIdStageInscrit");
        Long idAgent = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdStageInscrit(idAgent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUvStageInscrit method, of class DataStore.
     */
    @Test
    public void testGetIdUvStageInscrit() {
        System.out.println("getIdUvStageInscrit");
        Long idAgent = null;
        Long idStage = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdUvStageInscrit(idAgent, idStage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInscrip method, of class DataStore.
     */
    @Test
    public void testAddInscrip() {
        System.out.println("addInscrip");
        Long idAgent = null;
        Collection<Long> idsUv = null;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.addInscrip(idAgent, idsUv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatut method, of class DataStore.
     */
    @Test
    public void testSetStatut() {
        System.out.println("setStatut");
        Long idUv = null;
        Long idCandidat = null;
        EtatCandidatureDTO nouvelEtat = null;
        EtatCandidatureDTO ancienEtat = null;
        DataStore instance = new DataStoreImpl();
        boolean expResult = false;
        boolean result = instance.setStatut(idUv, idCandidat, nouvelEtat, ancienEtat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdStageDispo method, of class DataStore.
     */
    @Test
    public void testGetIdStageDispo() {
        System.out.println("getIdStageDispo");
        Long idAgent = null;
        DataStore instance = new DataStoreImpl();
        Collection expResult = null;
        Collection result = instance.getIdStageDispo(idAgent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DataStoreImpl implements DataStore {

        public SessionDTO login(String user, String password) {
            return null;
        }

        public AgentDTO getAgent(Long id) {
            return null;
        }

        public UvDTO getUv(Long id) {
            return null;
        }

        public StageDTO getStage(Long id) {
            return null;
        }

        public TypeUvDTO getTypeUv(Long id) {
            return null;
        }

        public Collection<Long> getIdCandidat(Long idUv, EtatCandidatureDTO etat) {
            return null;
        }

        public int nbUvs() {
            return 0;
        }

        public int nbAgents() {
            return 0;
        }

        public int nbTypeUvs() {
            return 0;
        }

        public int nbStages() {
            return 0;
        }

        public boolean addUv(UvDTO uv) {
            return false;
        }

        public boolean addAgent(AgentDTO agent) {
            return false;
        }

        public boolean addTypeUv(TypeUvDTO typeUv) {
            return false;
        }

        public boolean addStage(StageDTO stage) {
            return false;
        }

        public boolean delUv(long id) {
            return false;
        }

        public boolean delAgent(long id) {
            return false;
        }

        public boolean delTypeUv(long id) {
            return false;
        }

        public boolean delStage(long id) {
            return false;
        }

        public Collection<Long> getIdStageDir(Long idAgent) {
            return null;
        }

        public Collection<Long> getIdUvStageDir(Long idStage) {
            return null;
        }

        public Collection<Long> getIdUvStageDispo(Long idAgent, Long idStage) {
            return null;
        }

        public Collection<Long> getIdStageInscrit(Long idAgent) {
            return null;
        }

        public Collection<Long> getIdUvStageInscrit(Long idAgent, Long idStage) {
            return null;
        }

        public boolean addInscrip(Long idAgent, Collection<Long> idsUv) {
            return false;
        }

        public boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat) {
            return false;
        }

        public Collection<Long> getIdStageDispo(Long idAgent) {
            return null;
        }
    }
}
