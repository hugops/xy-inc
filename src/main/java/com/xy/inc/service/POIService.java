/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xy.inc.service;

import com.xy.inc.model.POI;
import com.xy.inc.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugo
 */
@Service
public class POIService {
	
	@Autowired
	private POIRepository poiRepository;
	
	public void save(POI poi){
		poiRepository.save(poi);
	}
	
}
