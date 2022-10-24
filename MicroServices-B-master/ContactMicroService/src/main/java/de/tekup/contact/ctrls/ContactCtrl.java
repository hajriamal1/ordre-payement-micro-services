package de.tekup.contact.ctrls;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactCtrl {
	
	private ServletWebServerApplicationContext context;
	
	@GetMapping("/check")
	public String check() {
		return "Hello I'am "+context.getId()+ " on port "+context.getWebServer().getPort();
	}

}
