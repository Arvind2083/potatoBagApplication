
package com.potatoBag.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.potatoBag.domain.Bag;
import com.potatoBag.service.PotatoBagService;

/**
 * This is the controller class for the Potatobag Application.
 * 
 * @author Arvind
 * 
 */
@RestController
public class PotatoBagController {
	
	private final static Logger LOGGER = Logger.getLogger(PotatoBagController.class);
	/**
	 * This is DI injection for the service layer.
	 */
	@Autowired
	private PotatoBagService potatoBagService;
	
	/**
	 * This method will return list of Potato bags.
	 * By default this method will return only 3 bag details.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getBags")
	public @ResponseBody List<Bag> getBagList(@RequestParam(value = "count",  required = false) String count) {
		
		/**Default count is 3 */
		int cnt = 3;
		if(null!= count && !count.equalsIgnoreCase("")){
			cnt = Integer.valueOf(count);
		}
		/**Call to service layer to return the potato Bags*/
		return potatoBagService.getBagList(cnt);
	}
	
	/**
	 * This method will persist a new bag.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addBag")
	public ResponseEntity<String> addBag(@Valid Bag bag,BindingResult bindingResult){
		
		 List<String> errorMessages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
        	
        	bindingResult.getAllErrors().forEach(error-> {
        		errorMessages.add("\n"+error.getDefaultMessage());
        	});
        	
        	LOGGER.error("Error "+ errorMessages);
        	return new ResponseEntity<String>("Errors "+ errorMessages.toString(),HttpStatus.NOT_ACCEPTABLE);
        }
		/**Generate the unique bag id*/
		bag.setBagId(UUID.randomUUID().toString()); 
		bag.setCreationdate(System.currentTimeMillis());
		
		/**Call to service layer to persist a new potatoBag*/
		String retParam = potatoBagService.addBag(bag);
		if(retParam.equalsIgnoreCase("success")){
			return new ResponseEntity<String>("New Popato bag with BagId "+bag.getBagId()+" is added",HttpStatus.CREATED);			
		}else{
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);	
		}
	}
}
