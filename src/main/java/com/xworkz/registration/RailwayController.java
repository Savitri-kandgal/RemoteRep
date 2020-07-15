package com.xworkz.registration;

import java.util.*;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class RailwayController {

	public RailwayController() {
		System.out.println("created :" + this.getClass().getSimpleName());
	}

	Map<String, String> search = new HashMap<String, String>();
	{
		search.put("MYS", "Shatabdhi");
		search.put("BGK", "Rani Chennamma");
		search.put("BGLR", "Hampi express");
		search.put("BLGM", "Golgumbaz");
	}

	@RequestMapping(value = "/click.odc", method = RequestMethod.POST)
	public String onSubmit(@RequestParam String name, @RequestParam String age, @RequestParam String phoneno,
			@RequestParam String source, @RequestParam String destination, Model model) {
		System.out.println("invoked click");
		System.out.println("Name :" + name);
		System.out.println("Age :" + age);
		System.out.println("phone no :" + phoneno);
		System.out.println("source :" + source);
		System.out.println("Destination :" + destination);
		System.out.println("will send response to unwellperson.jsp");
		model.addAttribute("show", "Booked By :" + name);
		return "/Success.jsp";

	}

	@RequestMapping(value = "/search.odc", method = RequestMethod.POST)
	public String onSearch(@RequestParam String destination, Model model) {
		for (String i : search.keySet()) {
			System.out.println(destination);
			if (i.equals(destination)) {
				model.addAttribute("show", "Result Found :" + search.get(i));
				System.out.println("Dest matched :"+destination);
				break;
			} else {
				System.out.println("Dest not matched :"+destination);
				model.addAttribute("show", "Result not found");
			}
			System.out.println(destination);

		}
		return "search.jsp";

	}

}
