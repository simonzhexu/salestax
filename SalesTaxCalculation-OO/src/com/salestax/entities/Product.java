/**
 * 
 */
package com.salestax.entities;

// TODO: Auto-generated Javadoc
/**
 * Defines product information for purchase.
 *
 * @author Zhe Xu
 */
public class Product {

	/** The name. */
	private String name;
	
	/** The origin. */
	private ProductOrigin origin;
	
	/** The category. */
	private Category category;
	
	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 * @param origin the origin
	 * @param category the category
	 */
	public Product(String name, ProductOrigin origin, Category category)
	{
		this.name = name;
		this.origin = origin;
		this.category = category;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Sets the origin.
	 *
	 * @param origin the new origin
	 */
	public void setOrigin(ProductOrigin origin) {
		this.origin = origin;
	}

	/**
	 * Gets the origin.
	 *
	 * @return the origin
	 */
	public ProductOrigin getOrigin() {
		return origin;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

}
