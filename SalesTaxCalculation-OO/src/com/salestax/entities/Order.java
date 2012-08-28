/**
 * 
 */
package com.salestax.entities;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Order.
 *
 * @author Zhe Xu
 */
public class Order {
	
	/** The product purchases. */
	private final List<ProductPurchase> productPurchases = new ArrayList<ProductPurchase>();
	
	/**
	 * Instantiates a new order.
	 */
	public Order()
	{
	}
	
	/**
	 * Adds the product.
	 *
	 * @param purchase the purchase
	 */
	public void AddProduct(ProductPurchase purchase)
	{
		this.productPurchases.add(purchase);
	}
	
	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public float getSubTotal()
	{
		float tempSubTotal = 0f;
		for (ProductPurchase purchase : productPurchases)
		{
			tempSubTotal += purchase.getSubtotal();
		}
		return tempSubTotal;
	}
	
	/**
	 * Gets the total tax.
	 *
	 * @return the total tax
	 */
	public float getTotalTax()
	{
		float tempTotalTax = 0;
		for (ProductPurchase purchase : productPurchases)
		{
			tempTotalTax += purchase.getTax() ;
		}
		return tempTotalTax;
	}
	
	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public float getTotal()
	{
		float tempTotal = 0f;
		for (ProductPurchase purchase : productPurchases)
		{
			tempTotal += purchase.getTotal();
		}
		return tempTotal;
	}
	
	/**
	 * Output.
	 *
	 * @param printer the printer
	 */
	public void output(Printer printer)
	{
		for (ProductPurchase purchase : productPurchases)
		{
			printer.print(purchase.toString());
			printer.printNewLine();
		}
		printer.print("Sales Taxes: " + getTotalTax());
		printer.printNewLine();
		printer.print("Total: " + getTotal());
		printer.printNewLine();
	}
	
	
}
