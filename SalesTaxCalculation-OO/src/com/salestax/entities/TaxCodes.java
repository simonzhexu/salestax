package com.salestax.entities;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TaxCodes.
 */
public class TaxCodes {
	
	/** The tax codes. */
	private List<Tax> taxCodes;
	
	/**
	 * Instantiates a new tax codes.
	 */
	public TaxCodes()
	{
		this.taxCodes = new ArrayList<Tax>();
	}
	
	/**
	 * Adds the.
	 *
	 * @param tax the tax
	 */
	public void Add(Tax tax)
	{
		this.taxCodes.add(tax);
	}
	
	/**
	 * Gets the tax codes.
	 *
	 * @return the tax codes
	 */
	public List<Tax> getTaxCodes() {
		return taxCodes;
	}
	
	
	
}
