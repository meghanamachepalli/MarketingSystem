package controller;

import java.util.List;

import dao.ProductImpl;
import model.Product;

public class ProductController {
	ProductImpl eImpl = new ProductImpl();

	public int addProduct(int id, String name, int quantity, int price) {
		Product product = new Product(id, name, quantity, price);
		return eImpl.addProduct(product);
	}

	public List<Product> viewProduct() {
		return eImpl.viewProduct();
	}

	public int editProduct(int id, String name, int quantity, int price) {
		Product product = new Product(id, name, quantity, price);
		return eImpl.editProduct(product);
	}

	public int removeProduct(int id) {
		Product product = new Product();
		product.setId(id);
		return eImpl.removeProduct(product);
	}

}
