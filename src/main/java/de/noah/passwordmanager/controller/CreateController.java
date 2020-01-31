package de.noah.passwordmanager.controller;

import org.springframework.stereotype.Controller;

import static de.noah.passwordmanager.controller.EditController.*;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.noah.passwordmanager.collections.Repositories;
import de.noah.passwordmanager.collections.userdata.UserData;

@Controller
public class CreateController {

	@GetMapping("/create/{topic}")
	public String create(Model model, @PathVariable String topic) {
		
		model.addAttribute("predefined_name", "");
		model.addAttribute("predefined_user", "");
		model.addAttribute("predefined_host", "");
		model.addAttribute("predefined_color", "#22AADD");
		model.addAttribute("predefined_pass", "");
		model.addAttribute("predefined_topic", topic);
		model.addAttribute("predefined_id", "ID");

		model.addAttribute("btn", "Hinzufügen");
		model.addAttribute("path", "create");
		
		return "create";
	}
	
	@GetMapping("/operations/create/{name}/{host}/{user}/{pass}/{topic}/{id}/{color}")
	public String op(Model model, @PathVariable String name, @PathVariable String host, @PathVariable String user,
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
	
}
