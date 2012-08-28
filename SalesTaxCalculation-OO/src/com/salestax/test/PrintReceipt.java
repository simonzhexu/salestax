package com.salestax.test;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.salestax.entities.BasicSalesTaxPolicy;
import com.salestax.entities.Category;
import com.salestax.entities.ImportTaxPolicy;
import com.salestax.entities.Order;
import com.salestax.entities.Printer;
import com.salestax.entities.Product;
import com.salestax.entities.ProductOrigin;
import com.salestax.entities.ProductPurchase;
import com.salestax.entities.Tax;
import com.salestax.entities.TaxCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class PrintReceipt.
 */
public class PrintReceipt {
	
	/** The import tax. */
	private Tax importTax;
	
	/** The sales tax. */
	private Tax salesTax;
	
	/** The tax codes. */
	private TaxCodes taxCodes;
	
	/** The printer. */
	private Printer printer = new Printer();
	
	/**
 * Sets the up.
 *
 * @throws Exception the exception
 */
@Before
	public void setUp() throws Exception {
		importTax = new Tax(0.05f, "ImportTax", new ImportTaxPolicy());
		Category[] exemptCategories = { Category.BOOK, Category.FOOD,
				Category.MEDICAL_PRODUCT };
		salesTax = new Tax(0.1f, "SalesTax", new BasicSalesTaxPolicy(
				exemptCategories));
		taxCodes = new TaxCodes();
		taxCodes.Add(importTax);
		taxCodes.Add(salesTax);
	}
	
	/**
	 * Output1.
	 */
	@Test
	public void Output1()
	{
		Product product1 = new Product("book", ProductOrigin.LOCAL,
				Category.BOOK);
		Product product2 = new Product("music CD", ProductOrigin.LOCAL,
				Category.OTHER);
		Product product3 = new Product("chocolate bar", ProductOrigin.LOCAL,
				Category.FOOD);
		ProductPurchase purchase1 = new ProductPurchase(
				product1, 12.49f, 1, taxCodes);
		ProductPurchase purchase2 = new ProductPurchase(
				product2, 14.99f, 1, taxCodes);
		ProductPurchase purchase3 = new ProductPurchase(
				product3, 0.85f, 1, taxCodes);
		Order order = new Order();
		order.AddProduct(purchase1);
		order.AddProduct(purchase2);
		order.AddProduct(purchase3);
		
		order.output(printer);
		
		Assert.assertEquals(1.50f, order.getTotalTax());
		Assert.assertEquals(29.83f, order.getTotal());
	}
	
	/**
	 * Output2.
	 */
	@Test
	public void Output2()
	{
		Product product1 = new Product("imported box of chocolates", ProductOrigin.IMPORTED,
				Category.FOOD);
		Product product2 = new Product("imported bottle of perfume", ProductOrigin.IMPORTED,
				Category.OTHER);
		
		ProductPurchase purchase1 = new ProductPurchase(
				product1, 10f, 1, taxCodes);
		ProductPurchase purchase2 = new ProductPurchase(
				product2, 47.5f, 1, taxCodes);
		Order order = new Order();
		order.AddProduct(purchase1);
		order.AddProduct(purchase2);
		
		order.output(printer);
		
		Assert.assertEquals(7.65f, order.getTotalTax());
		Assert.assertEquals(65.15f, order.getTotal());
	}
	
	/**
	 * Output3.
	 */
	@Test
	public void Output3()
	{
		Product product1 = new Product("imported bottle of perfume", ProductOrigin.IMPORTED,
				Category.OTHER);
		Product product2 = new Product("bottle of perfume", ProductOrigin.LOCAL,
				Category.OTHER);
		Product product3 = new Product("packet of headache pills", ProductOrigin.LOCAL,
				Category.MEDICAL_PRODUCT);
		Product product4 = new Product("box of imported chocolates", ProductOrigin.IMPORTED,
				Category.FOOD);
		ProductPurchase purchase1 = new ProductPurchase(
				product1, 27.99f, 1, taxCodes);
		ProductPurchase purchase2 = new ProductPurchase(
				product2, 18.99f, 1, taxCodes);
		ProductPurchase purchase3 = new ProductPurchase(
				product3, 9.75f, 1, taxCodes);
		ProductPurchase purchase4 = new ProductPurchase(
				product4, 11.25f, 1, taxCodes);
		
		Order order = new Order();
		order.AddProduct(purchase1);
		order.AddProduct(purchase2);
		order.AddProduct(purchase3);
		order.AddProduct(purchase4);
		
		order.output(printer);
		
		Assert.assertEquals(6.70f, order.getTotalTax());
		Assert.assertEquals(74.68f, order.getTotal());
	}
	
	
}
