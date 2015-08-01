package com.xy.inc.web.controller;

import com.xy.inc.model.POI;
import com.xy.inc.service.POIService;
import com.xy.inc.service.exception.ServiceException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hugo
 */
@Controller
@RequestMapping("/poi")
public class POIController {

    @Autowired
    private POIService poiService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void save(@RequestBody POI poi) throws ServiceException {
        poiService.save(poi);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<POI> findAllPOI() throws ServiceException {
        return poiService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public POI findPOIById(@PathVariable Long id) throws ServiceException {
        return poiService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePOI(@PathVariable Long id) throws ServiceException {
        poiService.remove(id);
    }

    @RequestMapping(value = "/proximidade", method = RequestMethod.GET)
    @ResponseBody
    public List<POI> buscarPOISProximos(@RequestParam Integer coordenadaX, @RequestParam Integer coordenadaY, @RequestParam Integer distMax) throws ServiceException {
        return poiService.buscarPOISProximos(coordenadaX, coordenadaY, distMax);
    }
    
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(ServiceException ex) {
        return ex.getMessage();
    }
}
