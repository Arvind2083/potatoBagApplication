/**
 * 
 */
package com.potatoBag.domain;

import javax.validation.constraints.Size;

import com.potatoBag.util.Supplier;
import com.potatoBag.util.validator.RangValidator;
import com.potatoBag.util.validator.EnumSupplier;

/**
 * This is the domain class for potatoBag.
 * 
 * @author Arvind
 *
 */
public class Bag {
	
	private String bagId;
	
    @RangValidator(min=1,max=100, message="The count of Potatos in a bag must be between {min} and {max}")
	private int potatoCount;
    
	@EnumSupplier(enumClass=Supplier.class, ignoreCase=true)
	private String supplier;
	
	private long creationdate;
	
	@RangValidator(min=1,max=50, message="The Price of Potato Bag must be between {min} and {max}")
	private double price;
	
	/**
	 * Default Construction
	 */
	public Bag() {
	}
	/**
	 * Constructor for creating new bags.
	 */
	public Bag(String bagId,int potatoCount, String supplier, long creationdate, double price) {
		this.bagId = bagId;
		this.potatoCount = potatoCount;
		this.supplier = supplier;
		this.creationdate = creationdate;
		this.price = price;
	}
	
	/**
	 * @return the bagId
	 */
	public String getBagId() {
		return bagId;
	}
	/**
	 * @param bagId the bagId to set
	 */
	public void setBagId(String bagId) {
		this.bagId = bagId;
	}
	/**
	 * @return the potatoCount
	 */
	public int getPotatoCount() {
		return potatoCount;
	}
	/**
	 * @param potatoCount the potatoCount to set
	 */
	public void setPotatoCount(int potatoCount) {
		this.potatoCount = potatoCount;
	}
	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		 this.supplier = 	supplier;
	}
	/**
	 * @return the creationdate
	 */
	public long getCreationdate() {
		return creationdate;
	}
	/**
	 * @param creationdate the creationdate to set
	 */
	public void setCreationdate(long creationdate) {
		this.creationdate = creationdate;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Bag Id: '" + this.bagId + "', Potato Count: '" + this.potatoCount + "', Supplier Name: '" + this.supplier + "Creation Date:" +
			 + this.creationdate + "', Price: '" + this.price + "'";
	}

}
