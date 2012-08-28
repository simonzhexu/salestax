package com.salestax.entities;

import java.math.BigDecimal;



// TODO: Auto-generated Javadoc
/**
 * purchase information about a product purchase
 * including product to be purchased, price, quantity and applicable tax.
 *
 * @author Zhe Xu
 */
public class ProductPurchase{

	/** The product. */
	private final Product product;
	
	/** The price. */
	private float price;
	
	/** The quantity. */
	private int quantity;
	
	/** The tax codes. */
	private final TaxCodes taxCodes;
	
	/**
	 * Instantiates a new product purchase.
	 *
	 * @param product the product
	 * @param price the price
	 * @param quantity the quantity
	 * @param taxCodes the tax codes
	 */
	public ProductPurchase(Product product, float price, int quantity, TaxCodes taxCodes)
	{
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.taxCodes = taxCodes;
	}
	
	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Gets the subtotal.
	 *
	 * @return the subtotal
	 */
	public float getSubtotal() {
		return price * quantity;
	}

	/**
	 * Gets the tax.
	 *
	 * @return the tax
	 */
	public float getTax() {
		float totalTax = 0;
		for (Tax tax : taxCodes.getTaxCodes())
		{
			if (tax.getTaxable().isTaxable(product))
			{
				totalTax += ( quantity * roundTax( (float)( price * tax.getRate() ) ) );
			}
		}
		return totalTax;
	}
	
	
	
	/**
	 * Round tax.
	 *
	 * @param taxAmount the tax amount
	 * @return the float
	 */
	private float roundTax(float taxAmount)
	{	
		BigDecimal bd = new BigDecimal(taxAmount * 20);
		bd=bd.setScale(0,BigDecimal.ROUND_UP);
		float result = (float) (bd.intValue())/20;
		return result;
	}
	
	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public float getTotal() 
	{
		return getSubtotal() +  getTax() ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(quantity).append(" ")
			.append(product.getName()).append(": ")
			.append(getTotal());
		
		return builder.toString();
	}
}
