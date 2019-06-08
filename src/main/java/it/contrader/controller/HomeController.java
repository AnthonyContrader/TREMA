package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.*;
import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;
import it.contrader.services.ProjectService;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;
	//private ProjectService projectService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired//si crea il server all'avvio e tramite la injection si richiama il service
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public String homeAdmin(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		return "homeAdmin";
	}

	@RequestMapping(value = "/homePM", method = RequestMethod.GET)
	public String homePM(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		List<ProjectDTO> allProject = this.projectService.findProjectDTOByUser(userLogged);
		request.setAttribute("allProjectDTO", allProject);
		return "homePM"; //tramite la view resolver(bean istanziato da spring)

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "home";

	}
}