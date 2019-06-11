package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DipendentiDTO;
import it.contrader.services.DipendentiService;

import it.contrader.dto.TaskDTO;
import it.contrader.services.TaskService;

import java.util.List;

@Controller
@RequestMapping("/Dipendenti")
public class DipendentiController {
	private final TaskService taskService;
	private final DipendentiService dipendentiService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public DipendentiController(DipendentiService dipendentiService, TaskService taskservice) {
		this.taskService = taskservice;
		this.dipendentiService = dipendentiService;
	}

	private void visualDipendenti(HttpServletRequest request) {
		//int idtask = Integer.parseInt(request.getParameter("id_task"));
		//TaskDTO taskDTO = new TaskDTO();
		//taskDTO.setIdTask(idtask);
		
		//List<DipendentiDTO> allDipendenti = this.dipendentiService.findDipendentiDTOByTask(taskDTO);
		List<DipendentiDTO> allDipendenti = this.dipendentiService.getListDipendentiDTO();
		request.setAttribute("allDipendentiDTO", allDipendenti);
	}

	@RequestMapping(value = "/dipendentiManagement", method = RequestMethod.GET)
	public String dipendentiManagement(HttpServletRequest request) {
		visualDipendenti(request);
		return "dipendenti/manageDipendenti";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idDipendente = Integer.parseInt(request.getParameter("id_dipendente"));
		request.setAttribute("id_dipendente", idDipendente);
		this.dipendentiService.deleteDipendentiById(idDipendente);
		visualDipendenti(request);
		return "dipendenti/manageDipendenti";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "dipendenti/insertDipendenti";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		TaskDTO taskInsertDTO = new TaskDTO();
		
		String nameInsert = request.getParameter("name").toString();
		String surnameInsert = request.getParameter("surname").toString();
		Integer idtaskInsert = Integer.parseInt(request.getParameter("id_task"));
		taskInsertDTO.setIdTask(idtaskInsert);
		
		DipendentiDTO dipendentiDTO = new DipendentiDTO();
		dipendentiDTO.setName(nameInsert);
		dipendentiDTO.setSurname(surnameInsert);
		dipendentiDTO.setTaskDTO(taskInsertDTO);
		
		dipendentiService.insertDipendenti(dipendentiDTO);
		
		visualDipendenti(request);
		return "dipendenti/manageDipendenti";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		//List<TaskDTO> taskList = taskService.getListaTaskDTO();
		
		DipendentiDTO dipendentiDTOUpdate = new DipendentiDTO();
		int idDipendenti = Integer.parseInt(request.getParameter("id_dipendenti"));
		dipendentiDTOUpdate = this.dipendentiService.getDipendentiDTOById(idDipendenti);
		
		request.setAttribute("dipendentiUpdate", dipendentiDTOUpdate);
		//request.setAttribute("taskList", taskList);
		return "dipendenti/updateDipendenti";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		Integer idDipendentiUpdate = Integer.parseInt(request.getParameter("id_dipendenti"));
		String nameUpdate = request.getParameter("name");
		String surnameUpdate = request.getParameter("surname");
		int idtaskUpdate = Integer.parseInt(request.getParameter("id_task"));
		
		TaskDTO taskDTOUpdate = new TaskDTO();
		taskDTOUpdate.setIdTask(idtaskUpdate);
		
		DipendentiDTO dipendentiUpdateDTO = new DipendentiDTO();
		dipendentiUpdateDTO.setIdDipendente(idDipendentiUpdate);
		dipendentiUpdateDTO.setName(nameUpdate);
		dipendentiUpdateDTO.setSurname(surnameUpdate);
		dipendentiUpdateDTO.setTaskDTO(taskDTOUpdate);
		
		dipendentiService.updateDipendenti(dipendentiUpdateDTO);
		visualDipendenti(request);
		
		return "dipendenti/manageDipendenti";
	}
	
}
