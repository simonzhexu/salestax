package com.salestax.entities;

// TODO: Auto-generated Javadoc
/*
 * checks whether a product is taxable based on whether it is imported
 */
/**
 * The Class ImportTaxPolicy.
 */
public class ImportTaxPolicy implements ITaxPolicy{

	/**
	 * Instantiates a new import tax policy.
	 */
	public ImportTaxPolicy() {}
	
	/* (non-Javadoc)
	 * @see com.salestax.entities.TaxPolicy#isTaxable(com.salestax.entities.Product)
	 */
	@Override
	public boolean isTaxable(Product product) {
		return ( ProductOrigin.IMPORTED == product.getOrigin());
	}

}
