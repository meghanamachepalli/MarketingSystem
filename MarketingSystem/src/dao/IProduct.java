package dao;

import java.util.List;
import model.Product;

public interface IProduct {
	public int addProduct(Product product);

	public List<Product> viewProduct();

	public int editProduct(Product product);

	public int removeProduct(Product product);
}