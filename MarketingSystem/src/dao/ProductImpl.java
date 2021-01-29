package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import util.Db;
import util.Query;

public class ProductImpl {
	PreparedStatement pst = null;
	ResultSet rs = null;
	int result = 0;

	public int addProduct(Product product) {
		try {
			pst = Db.getCon().prepareStatement(Query.addProduct);
			pst.setInt(1, product.getId());
			pst.setString(2, product.getName());
			pst.setInt(3, product.getQuantity());
			pst.setInt(4, product.getPrice());
			result = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			result = 0;
		} finally {
			try {
				Db.getCon().close();
				pst.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Product> viewProduct() {
		List<Product> product = new ArrayList<Product>();
		try {
			pst = Db.getCon().prepareStatement(Query.viewProduct);
			rs = pst.executeQuery();
			while (rs.next()) {
				Product e = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				product.add(e);
			}

		} catch (ClassNotFoundException | SQLException e) {
			try {
				Db.getCon().close();
				pst.close();
				rs.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return product;
	}

	public int editProduct(Product product) {
		try {
			pst = Db.getCon().prepareStatement(Query.editProduct);
			pst.setInt(4, product.getId());
			pst.setString(1, product.getName());
			pst.setInt(2, product.getQuantity());
			pst.setInt(3, product.getPrice());
			result = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			result = 0;
		} finally {
			try {
				Db.getCon().close();
				pst.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int removeProduct(Product product) {
		try {
			pst = Db.getCon().prepareStatement(Query.removeProduct);
			pst.setInt(1, product.getId());
			result = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			result = 0;
		} finally {
			try {
				Db.getCon().close();
				pst.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}