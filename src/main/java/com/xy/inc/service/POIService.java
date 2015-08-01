/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xy.inc.service;

import com.xy.inc.model.POI;
import com.xy.inc.service.exception.ServiceException;
import java.util.List;

/**
 *
 * @author Hugo
 */
public interface POIService {

    POI save(POI poi) throws ServiceException;

    POI findById(Long id) throws ServiceException;

    List<POI> findAll() throws ServiceException;

    void remove(Long id) throws ServiceException;

    public List<POI> buscarPOISProximos(Integer coordenadaX, Integer coordenadaY, Integer distMax) throws ServiceException;

}
