package de.noah.passwordmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.noah.passwordmanager.collections.Repositories;
import de.noah.passwordmanager.collections.userdata.UserData;

@Controller
public class EditController {
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable String id) {
		
		UserData data = Repositories.userdata.findById(id).get();

		model.addAttribute("predefined_name", data.getName());
		model.addAttribute("predefined_user", data.getUsername());
		model.addAttribute("predefined_host", data.getHostname());
		model.addAttribute("predefined_color", data.getHexColor());
		model.addAttribute("predefined_pass", data.getPassword());
		model.addAttribute("predefined_topic", data.getTopic());
		model.addAttribute("predefined_id", data.getId());

		model.addAttribute("btn", "Überschreiben");
		model.addAttribute("path", "edit");
		
		return "create";
	}
	
	@GetMapping("/operations/edit/{name}/{host}/{user}/{pass}/{topic}/{id}/{color}")
	public String opEdit(Model model, @PathVariable String name, @PathVariable String host, @PathVariable String user,
			@PathVariable String pass, @PathVariable String topic, @PathVariable String id, @PathVariable String color) {
		
		UserData data = new UserData();
		data.setHexColor(decrypt(color));
		data.setHostname(decrypt(host));
		data.setUsername(decrypt(user));
		data.setPassword(decrypt(pass));
		data.setTopic(decrypt(topic));
		data.setName(decrypt(name));
		data.setId(decrypt(id));
		
		Repositories.userdata.save(data);
		
		return "redirect:/";
	}
	
	public static String decrypt(String s) {
		return s.replaceAll("@@@", "/");
	}
	
}