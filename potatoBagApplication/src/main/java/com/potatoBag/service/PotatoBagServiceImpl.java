/**
 * 
 */
package com.potatoBag.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.potatoBag.domain.Bag;
import com.potatoBag.util.Utililty;

/**
 * This is service class for the potatoBag application.
 * Apart from providing the service methods to controller
 * this class will also persist all the newly added potato Bag
 * for the session.
 * 
 * @author Arvind
 *
 */
@Service
public class PotatoBagServiceImpl implements PotatoBagService{
	private final static Logger LOGGER = Logger.getLogger(PotatoBagServiceImpl.class);
	/**
	 * This method will return the bagList count based the
	 * variable count.
	 * 
	 * @param count
	 * @return
	 */
	@Override
	public List<Bag> getBagList(int count) {
		
		/**Check the count of Bags*/
		if(Utililty.bagDetails.size() > count){
			
			return Utililty.bagDetails.subList(0, count);	
		}else{
			/**If count is greater then available count of bags, then return only available counts*/
			LOGGER.info("The number of bag requested are greater than what exist in the System");
			return Utililty.bagDetails.subList(0, Utililty.bagDetails.size());	
		}
	}

	/**
	 * This method will add a new Bag in bagDetails List.
	 * 
	 * @param bag
	 */
	@Override
	public String addBag(Bag bag) {

		Utililty.bagDetails.add(bag);
		return "success";
		
	}
}