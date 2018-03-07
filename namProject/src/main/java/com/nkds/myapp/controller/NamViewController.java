package com.nkds.myapp.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nkds.myapp.service.ServiceTestVO;
import com.nkds.myapp.util.ServiceInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NamViewController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "*.do", method = RequestMethod.GET)
	public ModelAndView processGet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return doProcess(request, response);
	}

	@RequestMapping(value = "*.do", method = RequestMethod.POST)
	public ModelAndView processPost(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return doProcess(request, response);
	}

	private ModelAndView doProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BeanFactory beanFactory = new BeanFactory();
		ApplicationContext context = RequestContextUtils
				.getWebApplicationContext(request);
		beanFactory.setApplicationContext(context);
		ModelAndView mav = new ModelAndView();
		String viewName = request.getServletPath().replace("/", "")
				.replace(".do", "");

		System.out.println("viewName:" + viewName);
		ServiceInfo serviceInfo = new ServiceInfo(request.getParameterNames(),
				request);
		mav.setViewName(viewName);
		// mav.addObject(returnVO);

		return mav;
	}

}
