package com.salestax.test;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.salestax.entities.BasicSalesTaxPolicy;
import com.salestax.entities.Category;
import com.salestax.entities.ImportTaxPolicy;
import com.salestax.entities.Product;
import com.salestax.entities.ProductOrigin;
import com.salestax.entities.ProductPurchase;
import com.salestax.entities.Tax;
import com.salestax.entities.TaxCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class TestProductPurchase.
 */

/**
 * @author Zhe Xu
 * 
 */
public class TestProductPurchase {

	/** The imported book. */
	private Product importedBook;
	
	/** The local book. */
	private Product localBook;
	
	/** The import other. */
	private Product importOther;
	
	/** The local other. */
	private Product localOther;
	
	/** The import tax. */
	private Tax importTax;
	
	/** The sales tax. */
	private Tax salesTax;
	
	/** The tax codes. */
	private TaxCodes taxCodes;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		importedBook = new Product("HarryPotter", ProductOrigin.IMPORTED,
				Category.BOOK);
		localBook = new Product("KnowAboutChina", ProductOrigin.LOCAL,
				Category.BOOK);
		importOther = new Product("ImportOther", ProductOrigin.IMPORTED,
				Category.OTHER);
		localOther = new Product("LocalOther", ProductOrigin.LOCAL,
				Category.OTHER);

		importTax = new Tax(0.05f, "ImportTax",
				new ImportTaxPolicy());
		Category[] exemptCategories = { Category.BOOK, Category.FOOD,
				Category.MEDICAL_PRODUCT };
		salesTax = new Tax(0.1f, "SalesTax",
				new BasicSalesTaxPolicy(exemptCategories));
		taxCodes = new TaxCodes();
		taxCodes.Add(importTax);
		taxCodes.Add(salesTax);
	}

	/**
	 * Local exempt purchase.
	 */
	@Test
	public void LocalExemptPurchase() {
		ProductPurchase purchase = new ProductPurchase
							(localBook, 12f, 1, taxCodes);
		Assert.assertEquals(12f, purchase.getPrice());
		Assert.assertEquals(0f, purchase.getTax());
		Assert.assertEquals(12f, purchase.getTotal());
	}
	
	/**
	 * Import exempt purchase.
	 */
	@Test
	public void ImportExemptPurchase() {
		ProductPurchase purchase = new ProductPurchase
							(this.importedBook, 12f, 1, taxCodes);
		Assert.assertEquals(12f, purchase.getPrice());
		Assert.assertEquals(0.60f, purchase.getTax());
		Assert.assertEquals(12.6f, purchase.getTotal());
	}
	
	/**
	 * Local sales tax purchase.
	 */
	@Test
	public void LocalSalesTaxPurchase() {
		ProductPurchase purchase = new ProductPurchase
							(this.localOther, 12f, 1, taxCodes);
		Assert.assertEquals(12f, purchase.getPrice());
		Assert.assertEquals(1.2f, purchase.getTax());
		Assert.assertEquals(13.2f, purchase.getTotal());
	}
	
	/**
	 * Import sales tax purchase.
	 */
	@Test
	public void ImportSalesTaxPurchase() {
		ProductPurchase purchase = new ProductPurchase
							(this.importOther, 12f, 1, taxCodes);
		Assert.assertEquals(12f, purchase.getPrice());
		Assert.assertEquals(13.8f, purchase.getTotal());
	}
	
	/**
	 * Import sales tax two purchase.
	 */
	@Test
	public void ImportSalesTaxTwoPurchase() {
		ProductPurchase purchase = new ProductPurchase
							(this.importOther, 12f, 2, taxCodes);
		Assert.assertEquals(12f, purchase.getPrice());
		Assert.assertEquals(27.6f, purchase.getTotal());
		
	}
	
}
