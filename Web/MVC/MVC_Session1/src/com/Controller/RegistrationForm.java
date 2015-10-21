package com.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.EmployeeCache;
import com.helper.RegistrationAuthentication;
import com.model.Employee;

public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		boolean flag = true;
		String type = (String) req.getParameter("type");
		RequestDispatcher requestDispatcher;

		if (type.equals("register")) {
			flag = registerEmployee(req);
		} else {
			flag = editEmployeeDetails(req);
		}
		if (flag) {
			requestDispatcher = req.getRequestDispatcher("ListController");
			requestDispatcher.forward(req, res);
		}
		requestDispatcher = req.getRequestDispatcher("registration.jsp?id=0");
		requestDispatcher.forward(req, res);
	}

	private boolean registerEmployee(HttpServletRequest req) {
		boolean flag = true;
		flag = checkForNull(req);
		if (flag) {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			int id = (Integer.parseInt(req.getParameter("Eid")));
			int age = (Integer.parseInt(req.getParameter("age")));
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println("ID ; "+id);
			if (RegistrationAuthentication.check(id)) {
				Employee employee = new Employee(name, email, id, age,
						dateFormat.format(date));
				EmployeeCache employeeCache = EmployeeCache.getInstance();
				employeeCache.addEmployee(employee);

			} else {
				flag = false;
				req.setAttribute("msg", "Id Already Present");
			}
		}
		return flag;
	}

	private boolean editEmployeeDetails(HttpServletRequest req) {
		boolean flag = true;
		flag = checkForNull(req);
		if (flag) {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			int id = (Integer.parseInt(req.getParameter("Eid")));
			int age = (Integer.parseInt(req.getParameter("age")));
			EmployeeCache employeeCache = EmployeeCache.getInstance();
			Employee employee = employeeCache.getEmployeeForId(id);
			String date = employee.getDateOfRegistration();
			employee = new Employee(name, email, id, age, date);
			employeeCache.updateEmployee(employee);
		}
		return flag;
	}

	private boolean checkForNull(HttpServletRequest req) {
		boolean flag = true;
		if (req.getParameter("name").equals("")
				|| req.getParameter("email").equals("")
				|| req.getParameter("Eid").equals("")
				|| req.getParameter("age").equals("")) {
			flag = false;
			req.setAttribute("msg", "Specify all Details");
		}
		return flag;
	}

}
