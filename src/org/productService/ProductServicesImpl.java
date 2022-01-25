package org.productService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.productDomain.ProductDetails;

public class ProductServicesImpl implements ProductServices {

	List<ProductDetails> productList = new ArrayList<ProductDetails>();

	Map<Integer, ProductDetails> mapProduct = new HashMap();

	public ProductDetails getproduct(int productID) {
		for (ProductDetails product : productList) {
			if (product.getProductId() == productID) {
				return product;
			}
		}
		return null;
	}

	public List<ProductDetails> addproduct(ProductDetails product) {
		productList.add(product);
		return productList;

	}

	public List<ProductDetails> deleteproduct(ProductDetails product) {
		productList.remove(product);
		return productList;
	}

	@Override
	public ProductDetails getByCategory(String category) {
		for (ProductDetails product : productList) {
			if (product.getCategory() == category) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<ProductDetails> getAllproduct() throws SQLException {

		return productList;
	}

	@Override
	public ProductDetails getProductsByProductId(int productId) {
		// TODO Auto-generated method stub
		for (ProductDetails product : productList) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<ProductDetails> deleteProduct(int productId) {
		productList.remove(productId);
		return productList;
	}

	@Override
	public List<ProductDetails> getTopNproduct(int n) {

		return productList.subList(0, n);
	}

	@Override
	public ProductDetails updatePrice(int productID, double newPrice) {
		for (ProductDetails product : productList) {
			if (product.getProductId() == productID) {
				product.setListPrice(newPrice);

				return product;
			}

		}

		return null;
	}

	@Override
	public List<ProductDetails> sortByPrice() {

		Collections.sort(productList, new Comparator<ProductDetails>() {

			@Override
			public int compare(ProductDetails product1, ProductDetails product2) {
				if (product1.getListPrice() < product2.getListPrice())
					return 1;

				return -1;

			}

		});
		return productList;

	}

	public Map<Integer, ProductDetails> addInMaps(ProductDetails product) {
		mapProduct.put(product.getProductId(), product);

		return mapProduct;
	}

	public Map<Integer, ProductDetails> getMapProduct() {

		return mapProduct;

	}

}
