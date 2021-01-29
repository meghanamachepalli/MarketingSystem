package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditController")
public class EditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductController controller = new ProductController();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));

		controller.editProduct(id, name, quantity, price);

		response.sendRedirect("Login");

	}

}