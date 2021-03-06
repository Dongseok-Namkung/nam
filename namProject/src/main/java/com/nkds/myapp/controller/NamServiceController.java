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
public class NamServiceController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "service.ax", method = RequestMethod.GET)
	public void processGet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		doProcess(request, response);
	}

	@RequestMapping(value = "service.ax", method = RequestMethod.POST)
	public void processPost(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		BeanFactory beanFactory = new BeanFactory();
		ApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
		beanFactory.setApplicationContext(context);
		String viewName = request.getServletPath().replace("/", "").replace(".do", "");
		
		System.out.println("viewName:"+viewName);
		ServiceInfo serviceInfo = new ServiceInfo(request.getParameterNames(), request);
		
		ServiceTestVO vo = new ServiceTestVO();
		
		JSONObject json = (JSONObject)processServiceLogic(request.getParameterNames(), serviceInfo, vo);
//		StringBuffer sb = createJson(serviceInfo, returnVO);
		
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("application/json;");
		
		String jsonStr = new String(json.toString().getBytes("UTF-8"),"ISO-8859-1");
		//String jsonStr = new String(json.toString().getBytes("UTF-8"));
		out.print(jsonStr);
		out.flush();
		out.close();
		
	}
	
//	public StringBuffer createJson(ServiceInfo serviceInfo, Object returnVO){
//		return null;
//	}

	private Object processServiceLogic(Enumeration enumeration, ServiceInfo serviceInfo, Object...args) throws Exception {
		System.out.println("serviceInfo.getBeanName():"+serviceInfo.getBeanName());
		Object targetBean = BeanFactory.getBean(serviceInfo.getBeanName());
		Class<?> clazz = Class.forName(serviceInfo.getParameterTypeName());
		
		
		Object obj = makePramsToObject(clazz, serviceInfo);
		Method method = targetBean.getClass().getMethod(serviceInfo.getMethodName(), Class.forName(serviceInfo.getParameterTypeName()));
		System.out.println(method.toString());
		System.out.println("obj:"+obj.toString());
		return method.invoke(targetBean, obj);
	}
	
	private Object makePramsToObject(Class<?> clazz, ServiceInfo serviceInfo){
		Field[] fields = clazz.getDeclaredFields();
		Object obj = null;
		try {
			obj = clazz.newInstance();
			
			Map map = serviceInfo.getPramMap();
			
			Set keySets = map.keySet();
			Iterator iter = keySets.iterator();
			
			while(iter.hasNext()){
				String paramName = iter.next().toString();
				
				for (Field field : fields) {
					if(!field.isAccessible()){
						field.setAccessible(true);
					}
					
					if(paramName.equals( field.getName())){
						field.set(obj,map.get(paramName));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

}
