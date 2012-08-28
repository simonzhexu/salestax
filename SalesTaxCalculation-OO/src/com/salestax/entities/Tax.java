/**
 * 
 */
package com.salestax.entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Tax.
 *
 * @author Zhe Xu
 */
public class Tax{
	
	/** The rate. */
	private float rate;
	
	/** The name. */
	private String name;
	
	/** The tax policy. */
	private ITaxPolicy iTaxPolicy;
	
	/**
	 * Instantiates a new tax.
	 *
	 * @param rate the rate
	 * @param name the name
	 * @param iTaxPolicy the tax policy
	 */
	public Tax(float rate, String name, ITaxPolicy iTaxPolicy)
	{
		this.rate = rate;
		this.name = name;
		this.iTaxPolicy = iTaxPolicy;
	}
	
	/**
	 * Gets the rate.
	 *
	 * @return the rate
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the taxable.
	 *
	 * @return the taxable
	 */
	public ITaxPolicy getTaxable() {
		return iTaxPolicy;
	}
	
	
}
