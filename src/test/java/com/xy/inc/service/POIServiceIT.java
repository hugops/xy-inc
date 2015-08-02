package com.xy.inc.service;

import com.xy.inc.config.ApplicationContextTest;
import com.xy.inc.model.POI;
import com.xy.inc.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Hugo
 */
@ContextConfiguration(classes = {ApplicationContextTest.class})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class POIServiceIT {

    @Autowired
    private POIService instance;

    POI poi;

    @Before
    public void setUp() throws ServiceException {
        
        for(POI p : instance.findAll()){
            instance.remove(p.getId());
        }
        
        poi = new POI();
        poi.setNome("Lanchonete");
        poi.setCoordenadaX(27);
        poi.setCoordenadaY(12);
        poi = instance.save(poi);
        
        poi = new POI();
        poi.setNome("Posto");
        poi.setCoordenadaX(31);
        poi.setCoordenadaY(18);
        poi = instance.save(poi);
        
        poi = new POI();
        poi.setNome("Joalheria");
        poi.setCoordenadaX(15);
        poi.setCoordenadaY(12);
        poi = instance.save(poi);
        
        poi = new POI();
        poi.setNome("Floricultura");
        poi.setCoordenadaX(19);
        poi.setCoordenadaY(21);
        poi = instance.save(poi);
        
        poi = new POI();
        poi.setNome("Pub");
        poi.setCoordenadaX(12);
        poi.setCoordenadaY(8);
        poi = instance.save(poi);
        
        poi = new POI();
        poi.setNome("Supermercado");
        poi.setCoordenadaX(23);
        poi.setCoordenadaY(6);
        poi = instance.save(poi);
        
        poi = new POI();
        poi.setNome("Churrascaria");
        poi.setCoordenadaX(28);
        poi.setCoordenadaY(2);
        poi = instance.save(poi);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class POIService.
     */
    @Test
    public void testSave() throws ServiceException {
        System.out.println("save");
        poi = instance.save(poi);
        assertEquals(poi, instance.findById(poi.getId()));
    }

    /**
     * Test of findById method, of class POIService.
     */
    @Test
    public void testFindById() throws ServiceException {
        System.out.println("findById");
        POI result = instance.findById(poi.getId());
        assertEquals(poi, result);
    }

    /**
     * Test of findAll method, of class POIService.
     */
    @Test
    public void testFindAll() throws ServiceException {
        System.out.println("findAll");
        List<POI> result = instance.findAll();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of remove method, of class POIService.
     */
    @Test
    public void testRemove() throws ServiceException {
        System.out.println("remove");
        instance.remove(poi.getId());
        POI poiDeleted = instance.findById(poi.getId());
        assertNull(poiDeleted);
    }
    
    /**
     * Test of buscarPOISProximos method, of class POIServiceImpl.
     */
    @Test
    public void testBuscarPOISProximos() throws ServiceException {
        System.out.println("buscarPOISProximos");
        Integer coordenadaX = 20;
        Integer coordenadaY = 10;
        Integer distMax = 10;
        List<POI> result = instance.buscarPOISProximos(coordenadaX, coordenadaY, distMax);
        
          List<String> poiNamesList = new ArrayList<>();
          
        for(POI s : result){
            System.out.println(s.getNome());
            poiNamesList.add(s.getNome());
        }
            assertArrayEquals(poiNamesList.toArray(),new String[]{"Lanchonete","Joalheria","Pub","Supermercado"});
    }

}
