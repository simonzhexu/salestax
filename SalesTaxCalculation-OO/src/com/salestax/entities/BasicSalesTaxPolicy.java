package com.salestax.entities;

import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/*
 * checks whether a product is taxable
 */
/**
 * The Class BasicSalesTaxPolicy.
 */
public class BasicSalesTaxPolicy implements ITaxPolicy{

	/** The tax exempt categories. */
	public List<Category> taxExemptCategories;
	
	/**
	 * Instantiates a new basic sales tax policy.
	 *
	 * @param taxExemptCategories the tax exempt categories
	 */
	public BasicSalesTaxPolicy (Category[] taxExemptCategories)
	{
		this.taxExemptCategories = Arrays.asList(taxExemptCategories);
	}
	
	/* (non-Javadoc)
	 * @see com.salestax.entities.TaxPolicy#isTaxable(com.salestax.entities.Product)
	 */
	@Override
	public boolean isTaxable(Product product) {
		return !this.taxExemptCategories.contains(product.getCategory());
	}
}
