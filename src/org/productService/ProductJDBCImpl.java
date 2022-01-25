package org.productService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.product.utils.ProductUtils;
import org.productDomain.ProductDetails;

public class ProductJDBCImpl implements ProductServices {
ProductUtils link = new ProductUtils();
List<ProductDetails> productList = new ArrayList<>();

	@Override
	public ProductDetails getProductsByProductId(int productID) {
		// TODO Auto-generated method stub
		return link.getproduct(productID);
	}

	@Override
	public List<ProductDetails> addproduct(ProductDetails product) {
		//link.insertProductDetails(product);
		// TODO Auto-generated method stub
		productList.add(link.insertProductDetails(product));
		return productList;
	}

	@Override
	public List<ProductDetails> getAllproduct() {
		// TODO Auto-generated method stub
		return link.getAllDetails();
	}

	@Override
	public List<ProductDetails>deleteProduct(int productId) {
		// TODO Auto-generated method stub
		link.deleteProduct(productId);
		return null;
	}

	@Override
	public ProductDetails getByCategory(String category) {
		// TODO Auto-generated method stub
		return link.getProductByCategory(category);
	}

	@Override
	public List<ProductDetails> getTopNproduct(int n) {
		// TODO Auto-generated method stub
		return link.getTopNProducts(n);
	}

	@Override
	public ProductDetails updatePrice(int productID, double newPrice) {
		// TODO Auto-generated method stub
		link.updateprice(productID, newPrice);
		return null;
	}
	@Override
	public List<ProductDetails> sortByPrice() {
		// TODO Auto-generated method stub
		return link.sortByPrice();
	}

	@Override
	public Map<Integer, ProductDetails> addInMaps(ProductDetails product) {
		// TODO Auto-generated method stub
		return link.addInMaps(product);
	}

}
