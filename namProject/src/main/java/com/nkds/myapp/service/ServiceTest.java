package com.nkds.myapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service("com.nkds.myapp.service.ServiceTest")
public class ServiceTest {
	public JSONObject processService(ServiceTestVO vo){
		System.out.println("processService()");
		
		System.out.println("vo.getId():"+vo.getId());
		System.out.println("vo.getPw():"+vo.getPw());
		
		
		
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < 5; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", vo.getId()+i);
			map.put("name", vo.getPw()+i);
			list.add(map);
		}
		
		//JSONArray jsonArray = new JSONArray();
		//jsonArray.add(list);
		
		JSONObject json = new JSONObject();
		json.put("list", list);
		
		System.out.println(json);
		
		return json;
	}
}
