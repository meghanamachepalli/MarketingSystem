package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminController acController;

	public void init() {
		acController = new AdminController();
	}

	ProductController controller = new ProductController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> list = controller.viewProduct();

		request.setAttribute("ProductList", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int result = acController.authenticate(username, password);

		if (result == 1) {
			List<Product> list = controller.viewProduct();

			request.setAttribute("ProductList", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
			dispatcher.forward(request, response);
		} else {

			String msg = "Invalid Credentials";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		}

	}
}
