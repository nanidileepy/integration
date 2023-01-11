package com.jsonAll;

import java.io.FileNotFoundException;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonAll.pojos.Emp;
import com.jsonAll.pojos.Studnet;

@SpringBootApplication
public class JsonAllApplication {

	public static void main(String[] args) throws BeansException, FileNotFoundException, JsonProcessingException {
		ConfigurableApplicationContext ap = SpringApplication.run(JsonAllApplication.class, args);
		ap.getBean(JsonAllApplication.class).list();
	}

	@RequestMapping(value = "jsno", method = RequestMethod.GET)
	public void list() throws FileNotFoundException, JsonProcessingException {
		Studnet st = new Studnet();
		st.setName("Dileep");
		st.setNo(112);
		st.setSection("a");
		JSONObject js = new JSONObject(st);
		System.out.println(js.toString());

		JSONObject jo = new JSONObject();
		jo.put("name", "jon doe");
		jo.put("age", "22");
		jo.put("city", "chicago");
		System.out.println(jo);

		String string = "name, city, age \n" + "john, chicago, 22 \n" + "gary, florida, 35 \n" + "sal, vegas, 18";

		JSONArray result = CDL.toJSONArray(string);
		
		
		System.out.println(result);
		
		
		
		Emp e=new Emp();
		e.setId(777);
		e.setName("hdf");
		e.setRole("hjgjgg");
		e.setPermanent(false);
		
		ObjectMapper ob=new ObjectMapper();
		
		String s=ob.writeValueAsString(e);
		System.out.println(s);
		
		
	}

}
