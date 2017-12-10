/**
 * 
 */
package com.potatoBag.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.potatoBag.domain.Bag;

/**
 * This is the utility class.
 * 
 * @author Arvind
 */
public class Utililty {
	
	/**This static variable list acts as persistence variable in the absence of db */
	public static List<Bag> bagDetails = new CopyOnWriteArrayList<Bag>();

	/**These are pre-exists bagTypes in the applications*/
	static {
		bagDetails.add(new Bag("a7ceea32-6bf5-4717-87cb-c901f5401758",20, "de coster",1512913194729L,20));
		bagDetails.add(new Bag("a7deea32-7bf5-4717-87cb-c901f5401757",30, "Owel",1512913183441L,40));
		bagDetails.add(new Bag("a7eeea32-9bf5-4717-87cb-c901f5401756",40, "Patatas Ruben",1512913220058L,50));
		bagDetails.add(new Bag("a7feea32-4bf5-4717-87cb-c901f5401755",70, "Yunnan Spices",1512913387721L,10));
	}
}
