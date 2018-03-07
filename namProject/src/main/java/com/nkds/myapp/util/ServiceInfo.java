package com.nkds.myapp.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ServiceInfo {
	
	private String beanName = null;
	private String methodName = null;
	private String parameterTypeName = null;
	private Map pramMap = new HashMap();
	private String returnType = null;
	
	public ServiceInfo(Enumeration param, HttpServletRequest request){
		while (param.hasMoreElements()) { // ������ �Ѿ�� �Ķ����Ͱ��� �� �ִµ���
			String name = (String) param.nextElement(); // �Ķ���� ���� ���ʴ�� ������ name
			
			if("beanName".equals(name)){
				this.beanName = request.getParameter(name);
			}else if("methodName".equals(name)){
				this.methodName = request.getParameter(name);
			}else if("parameterTypeName".equals(name)){
				this.parameterTypeName = request.getParameter(name);
			}else if("returnType".equals(name)){
				this.returnType = request.getParameter(name);
			}else{
				this.pramMap.put(name, request.getParameter(name));
			}
		}
	}


	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}


	public String getParameterTypeName() {
		return parameterTypeName;
	}


	public void setParameterTypeName(String parameterTypeName) {
		this.parameterTypeName = parameterTypeName;
	}


	public Map getPramMap() {
		return pramMap;
	}


	public void setPramMap(Map pramMap) {
		this.pramMap = pramMap;
	}


	public String getReturnType() {
		return returnType;
	}


	public void setReturnType(String returnType) {
		this.returnType = returnType;
	} 
	
	
	
}
