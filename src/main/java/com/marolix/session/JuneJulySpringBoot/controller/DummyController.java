package com.marolix.session.JuneJulySpringBoot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DummyController {

	@RequestMapping(value = "/dummy", method = RequestMethod.GET)
	@ResponseBody
	public List<String> m1() {
		return new ArrayList<String>(Arrays.asList("bharath", "sharath", "prathap"));
//		ModelAndView m = new ModelAndView("index");
//		return m;
	}
}
