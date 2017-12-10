/**
 * 
 */
package com.potatoBag.util;

/**
 * @author Arvind
 *
 */
public enum Supplier {
	DECOSTER("de coster"),
	OWEL("Owel"),
	PatatasRuben("Patatas Ruben"),
	YunnanSpices("Yunnan Spices");
	
	private String supplierName;
	
	Supplier(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}
	
	@Override 
	public String toString()
    {
        return this.supplierName;
    }
}
