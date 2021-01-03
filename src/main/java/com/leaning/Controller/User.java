package com.leaning.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leaning.Model.UserModel;
import com.leaning.Services.IDAO;

@Controller
public class User {

	@Autowired
	UserModel model;

	@Autowired
	IDAO mydao;

	@RequestMapping("/")
	public String index(ModelMap map) {
		List<UserModel> valueRecieved = mydao.getUserDetails();
		map.addAttribute("UserValue", valueRecieved);
		return "index";

	}

	@RequestMapping(value = "/insertuser", method = RequestMethod.GET)
	public String inserUser() {

		return "insertuser";

	}

	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public String inserUser(HttpServletRequest request, ModelMap map) {

		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		String addre = request.getParameter("uaddress");

		model.setName(name);
		model.setEmail(email);
		model.setPassword(pass);
		model.setAddre(addre);

		mydao.insertUserRecord(model);

		return "redirect:/";

	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public String editUser(ModelMap map, @PathVariable("id") int userid) {

		UserModel model = mydao.getRecordById(userid);

		map.addAttribute("getrecord", model);

		System.out.println("valued recieved" + userid);

		return "editUser";
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
	public String editUser(ModelMap map, HttpServletRequest request) {

		int uid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		String addre = request.getParameter("uaddress");

		model.setId(uid);
		model.setName(name);
		model.setEmail(email);
		model.setPassword(pass);
		model.setAddre(addre);

		mydao.editUser(model);

		return "redirect:/";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(ModelMap map, @PathVariable("id") int userId) {

		mydao.deleteUser(userId);

		return "redirect:/";
	}

}
