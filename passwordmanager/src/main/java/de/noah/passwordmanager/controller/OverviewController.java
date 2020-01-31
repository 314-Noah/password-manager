package de.noah.passwordmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.noah.passwordmanager.collections.Repositories;
import de.noah.passwordmanager.collections.userdata.UserData;

@Controller
public class OverviewController {

	@GetMapping("/")
	public String overview(Model model) {
		
		HashMap<String, List<UserData>> map = new HashMap<>();
		
		List<UserData> list = Repositories.userdata.findAll();
		
		for (int i = 0; i < list.size(); i++) {
			if(!map.containsKey(list.get(i).getTopic())) {
				map.put(list.get(i).getTopic(), new ArrayList<UserData>());
			}
			map.get(list.get(i).getTopic()).add(list.get(i));
		}
		
		model.addAttribute("map", map);
		
		return "overview";
	}
	
	@GetMapping("/search")
	public String searchSite(Model model) {
		
		HashMap<String, List<UserData>> map = new HashMap<>();
		
		List<UserData> list = Repositories.userdata.findAll();
		
		for (int i = 0; i < list.size(); i++) {
			if(!map.containsKey(list.get(i).getTopic())) {
				map.put(list.get(i).getTopic(), new ArrayList<UserData>());
			}
			map.get(list.get(i).getTopic()).add(list.get(i));
		}
		
		model.addAttribute("map", map);
		
		return "overview";
	}
	
	@GetMapping("/operations/delete/{id}")
	public String orderMenu(Model model, @PathVariable String id) {
		
		Repositories.userdata.deleteById(id);
		
		return "redirect:/";
	}
	
}
