package org.productService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.productDomain.ProductDetails;

public interface ProductServices {
	public List<ProductDetails> getAllproduct() throws SQLException;

	public List<ProductDetails> addproduct(ProductDetails product) throws SQLException;

	public ProductDetails getProductsByProductId(int productId);

	public List<ProductDetails> deleteProduct(int productId);

	public ProductDetails getByCategory(String category);

	public List<ProductDetails> getTopNproduct(int n);

	public ProductDetails updatePrice(int productID, double newPrice);

	public List<ProductDetails> sortByPrice();

	public Map<Integer, ProductDetails> addInMaps(ProductDetails product);

}
