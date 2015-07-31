package com.xy.inc.web.controller;

import com.xy.inc.model.POI;
import com.xy.inc.service.POIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hugo
 */
@Controller
@RequestMapping("/agreement")
public class POIController {
	
	private POIService poiService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void save(POI poi){
		poiService.save(poi);
	}
}
