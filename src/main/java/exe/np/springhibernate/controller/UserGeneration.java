package exe.np.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exe.np.springhibernate.model.User;
import exe.np.springhibernate.servise.UserDao;

@RestController
@RequestMapping("/user/gen/")
public class UserGeneration {

	@Autowired
	private UserDao userDAO;
	
	/**
	 * url = http://localhost:8080/user/gen/add
	 * @return
	 */
	@RequestMapping("add")
	public String createBook() {
			
		int count = 10;
		for(int i=0; i<count; i++) {
			User user = new User();
			user.setName("User "+(i+1));
			userDAO.save(user);
		}		
		return "oK";
	}
	
}
