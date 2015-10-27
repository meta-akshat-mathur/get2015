package com.metacube.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import com.metacube.converter.TemperatureConverter;
import com.metacube.converter.TemperatureConverterServiceLocator;

/**
 * Servlet implementation class ConverterUse
 */
@WebServlet("/ConverterUse")
public class ConverterUse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConverterUse() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TemperatureConverterServiceLocator converterServiceLocator = new TemperatureConverterServiceLocator();
		converterServiceLocator.setTemperatureConverterEndpointAddress("http://localhost:8080/TemperatureWebService/services/TemperatureConverter");
		String fahr=request.getParameter("Fahrenheit");
		String celcius=request.getParameter("Celsius");
		if(fahr!=null && !fahr.equals(""))
		{   
			try {float result;
				TemperatureConverter converter= converterServiceLocator.getTemperatureConverter();
				result=converter.convertFahrenheitToCelcius(Float.parseFloat(fahr));
				request.setAttribute("result",""+result);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		if(celcius!=null && !celcius.equals(""))
		{   
			try {
				float result;
				TemperatureConverter converter= converterServiceLocator.getTemperatureConverter();
				result=converter.convertCelciusToFahrenheit(Float.parseFloat(celcius));
				request.setAttribute("result1",""+result);
				} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("TemperatureConvertionForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
