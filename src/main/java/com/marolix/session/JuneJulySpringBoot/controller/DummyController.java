package com.marolix.session.JuneJulySpringBoot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marolix.session.JuneJulySpringBoot.dto.LoginDTO;

@Controller
public class DummyController {

	@RequestMapping(value = "/dummy", method = RequestMethod.GET)
	@ResponseBody
	public List<String> m1() {
		return new ArrayList<String>(Arrays.asList("bharath", "sharath", "prathap"));
//		ModelAndView m = new ModelAndView("index");
//		return m;
	}

	//@GetMapping(value = "/login")
	@ResponseBody
	public String dummyLogin(@RequestParam(name = "uname") String userName,
			@RequestParam(name = "pwd") String password) {

		return userName.equals("bharath") && password.equals("12345") ? "login successful" : "Invalid credentials";
	}

	@PostMapping(value = "/login")
	@ResponseBody
	public String dummyLoginPost(@PathVariable(name="json") String jsonData) throws JsonMappingException, JsonProcessingException {
		System.out.println(jsonData);
		ObjectMapper om= new ObjectMapper();
	LoginDTO login=	om.readValue(jsonData, LoginDTO.class);
System.out.println(login);
		return login.getUserName().equals("bharath") && login.getPassword().equals("12345") ? "login successful"
				: "Invalid credentials";
	}
}
