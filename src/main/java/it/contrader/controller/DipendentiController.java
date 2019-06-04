package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.DipendentiService;

import java.util.List;

@Controller
@RequestMapping("/Dipendenti")
public class DipendentiController {

	private final DipendentiService dipendentiService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public DipendentiController(DipendentiService dipendentiService) {
		this.dipendentiService = dipendentiService;
	}

	private void visualDipendenti(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");
		List<DipendentiDTO> allDipendenti = this.dipendentiService.findDipendentiDTOByUser(userDTO);
		request.setAttribute("allDipendentiDTO", allDipendenti);
	}

	@RequestMapping(value = "/dipendentiManagement", method = RequestMethod.GET)
	public String dipendentiManagement(HttpServletRequest request) {
		visualDipendenti(request);
		return "dipendenti/manageDipendenti";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.dipendentiService.deleteDipendentiById(id);
		visualDipendenti(request);
		return "dipendenti/manageDipendenti";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "dipendenti/insertDipendenti";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String dipendentiName = request.getParameter("name").toString();
		String dipendentiSurname = request.getParameter("surname").toString();
		

		DipendentiDTO dipendentiObj = new DipendentiDTO();
		dipendentiObj.setName(dipendentiName);
		dipendentiObj.setSurname(dipendentiSurname);
		dipendentiObj.setUserDTO(userLogged);
		dipendentiService.insertDipendenti(dipendentiObj);
		visualDipendenti(request);
		 

		return "dipendenti/manageDipendenti";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		DipendentiDTO dipendentiUpdate = new DipendentiDTO();

		dipendentiUpdate = this.dipendentiService.getDipendentiDTOById(id);
		request.setAttribute("dipendentiUpdate", dipendentiUpdate);
		return "dipendenti/updateDipendenti";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("idDipendente"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String dipendentiName = request.getParameter("name");
		String dipendentiSurname = request.getParameter("surname");
		
		DipendentiDTO dipendentiUpdateDTO = new DipendentiDTO();
		dipendentiUpdateDTO.setName(dipendentiName);
		dipendentiUpdateDTO.setSurname(dipendentiSurname);
		dipendentiUpdateDTO.setUserDTO(userLogged);
		dipendentiUpdateDTO.setIdDipendenti(idUpdate);
		
		dipendentiService.updateDipendenti(dipendentiUpdateDTO);
		visualDipendenti(request);
		
		return "dipendenti/manageDipendenti";
	}
	
}
