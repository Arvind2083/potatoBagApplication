/**
 * 
 */
package com.potatoBag.service;

import java.util.List;

import com.potatoBag.domain.Bag;

/**
 * @author Arvind
 *
 */
public interface PotatoBagService {
	
	/**
	 * This method will return the bagList count based the
	 * variable count.
	 * 
	 * @param count
	 * @return
	 */
	public List<Bag> getBagList(int count);
	
	/**
	 * This method will add a new Bag in bagDetails List.
	 * 
	 * @param bag
	 * @return
	 */
	public String addBag(Bag bag);
}
