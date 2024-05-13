package myfirstwebapp.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	///login => myfirstwebapp.login.LoginController => login.jsp
	private AuthenticationService authService;
	
	public LoginController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if (authService.authenticate(name, password)) {
			
			model.put("name", name);
			
			return "welcome";
		}

		model.put("error", "Invalid Credentials!");
		
		return "login";
	}
}