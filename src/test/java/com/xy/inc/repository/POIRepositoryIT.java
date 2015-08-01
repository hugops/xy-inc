/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xy.inc.repository;

import com.xy.inc.config.ApplicationContextTest;
import com.xy.inc.model.POI;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
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
public class POIRepositoryIT {

    @Autowired
    private POIRepository instance;

    POI poi;

    @Before
    public void setUp() {
        poi = new POI();
        poi.setNome("Lanchonete");
        poi.setCoordenadaX(27);
        poi.setCoordenadaY(12);
        poi = instance.save(poi);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class POIService.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        poi = instance.save(poi);
        assertEquals(poi, instance.findOne(poi.getId()));
    }

    /**
     * Test of findById method, of class POIService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        POI result = instance.findOne(poi.getId());
        assertEquals(poi, result);
    }

    /**
     * Test of findAll method, of class POIService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Iterable result = instance.findAll();
        assertTrue(result.iterator().hasNext());
    }

    /**
     * Test of remove method, of class POIService.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        instance.delete(poi.getId());
        POI poiDeleted = instance.findOne(poi.getId());
        assertNull(poiDeleted);
    }
}
