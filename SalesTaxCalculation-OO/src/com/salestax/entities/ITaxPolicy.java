/**
 * 
 */
package com.salestax.entities;

// TODO: Auto-generated Javadoc
/**
 * checks whether a product is taxable.
 *
 * @author Zhe Xu
 */
public interface ITaxPolicy {
	
	/**
	 * Checks if is taxable.
	 *
	 * @param product the product
	 * @return true, if is taxable
	 */
	boolean isTaxable(Product product);
}
