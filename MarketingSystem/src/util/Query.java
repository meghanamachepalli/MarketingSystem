package util;

public class Query {
	public static String adminAuthentication = "select * from admin where userName=? and password=?";
	public static String addProduct = "insert into product values(?,?,?,?)";
	public static String viewProduct = "select * from product";
	public static String editProduct = "update product set name=?,quantity=?,price=? where id=?";
	public static String removeProduct = "delete from product where id=?";
}