package de.noah.passwordmanager.collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import de.noah.passwordmanager.collections.userdata.UserData;
import de.noah.passwordmanager.collections.userdata.UserDataReposity;

@RestController
public class Repositories {

	public static UserDataReposity userdata;
	
	@Bean
	CommandLineRunner initUserDataDB(UserDataReposity repo) {
		return args -> {
			userdata = repo;
			
			if(userdata.count() == -1) { //impossible
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 5; j++) {
						UserData data = new UserData();
						data.setTopic(i + ". Topic");
						data.setName("<span>Netflix</span>");
						data.setUsername("username_" + j);
						data.setHostname("http://www.google.de/" + i + "/" + j);
						data.setPassword("ABC");
						userdata.save(data);
					}
				}
			}
		};
	}
	
}
