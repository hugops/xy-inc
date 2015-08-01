/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xy.inc.service.impl;

import com.xy.inc.model.POI;
import com.xy.inc.repository.POIRepository;
import com.xy.inc.service.POIService;
import com.xy.inc.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugo
 */
@Service
public class POIServiceImpl implements POIService {

    @Autowired
    private POIRepository poiRepository;

    @Override
    public POI save(POI poi) throws ServiceException {
        try {
            return poiRepository.save(poi);
        } catch (Exception e) {
            throw new ServiceException("Não foi possivel persistir o POI");
        }
    }

    @Override
    public POI findById(Long id) throws ServiceException {
        try {
            return poiRepository.findOne(id);
        } catch (Exception e) {
            throw new ServiceException("Não foi possivel buscar o POI com o id=" + id);
        }
    }

    @Override
    public List<POI> findAll() throws ServiceException {
        try {
            List<POI> poiList = new ArrayList<>();
            for (POI poi : poiRepository.findAll()) {
                poiList.add(poi);
            }
            return poiList;
        } catch (Exception e) {
            throw new ServiceException("Não foi possivel buscar todos os POIs");
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            poiRepository.delete(id);
        } catch (Exception e) {
            throw new ServiceException("Não foi possivel remover o POI com o id=" + id);
        }
    }

    @Override
    public List<POI> buscarPOISProximos(Integer coordenadaX, Integer coordenadaY, Integer distMax) throws ServiceException {
        try {
            List<POI> poiList = new ArrayList<>();
            for (POI poi : poiRepository.findAll()) {
                if (Math.sqrt(Math.pow(coordenadaX - poi.getCoordenadaX(), 2) + Math.pow(coordenadaY - poi.getCoordenadaY(), 2)) <= 10) {
                    poiList.add(poi);
                }
            }
            return poiList;
        } catch (Exception e) {
            throw new ServiceException("Não foi possivel buscar os POIs proximos");
        }
    }

}
