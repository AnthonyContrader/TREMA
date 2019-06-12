package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DipMaterialDTO;
import it.contrader.dto.SubTaskDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.services.TeamService;

@CrossOrigin
@RestController
@RequestMapping("/Team")
public class TeamController {

	private static final int IdSubTask = 0;
	private final TeamService teamService;
	// private final ClientService clientService;

	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
		// this.clientService = clientService;
	}

	@RequestMapping(value = "teamManagement", method = RequestMethod.GET)
	public List<TeamDTO> teamManagement(@RequestParam(value = "IdTeam") int IdTeam) {
		SubTaskDTO subTaskDTOTeamList = new SubTaskDTO();
		subTaskDTOTeamList.setIdSubTask(IdSubTask);
		// return
		// this.orderService.findOrderDTOByUser(ConverterUser.toEntity(userDTOOrderList));
		return this.teamService.findTeamDTOBySubTask(subTaskDTOTeamList);
		// visualOrder(request);
		// return "order/manageOrder";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdTeam") int id) {
		this.teamService.deleteTeamById(id);
	}
	
	

	/*
	 * @RequestMapping(value = "/insertRedirect", method = RequestMethod.GET) public
	 * String insertRedirect(){ return " "; }
	 * 
	 * public String insert(HttpServletRequest request, HttpSession session) {
	 * UserDTO userLogged = (UserDTO) session.getAttribute("utente");
	 * List<ClientDTO> clientList = orderService.findClientDTOByUser(userLogged);
	 * request.setAttribute("clientList", clientList); return "order/insertOrder"; }
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TeamDTO teamDTO) {
		this.teamService.insertTeam(teamDTO);
	}
	/*
	 * @RequestMapping(value = "/updateRedirect", method = RequestMethod.GET) public
	 * OrderDTO updateRedirect(@RequestParam(value = "id") int id) { // int id =
	 * Integer.parseInt(request.getParameter("id"));
	 * 
	 * // UserDTO userLogged = (UserDTO) session.getAttribute("utente"); OrderDTO
	 * orderUpdate = new OrderDTO(); // List<ClientDTO> clientList =
	 * orderService.findClientDTOByUser(userLogged); orderUpdate =
	 * this.orderService.getOrderDTOById(id);
	 * 
	 * // request.setAttribute("orderUpdate", orderUpdate); //
	 * request.setAttribute("clientList", clientList); // return
	 * "order/updateOrder"; return orderUpdate; }
	 */

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public TeamDTO read(@RequestParam(value = "IdTeam") int id) {
		TeamDTO teamUpdate = new TeamDTO();
		teamUpdate = this.teamService.getTeamDTOById(id);
		return teamUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<TeamDTO> update(@RequestParam(value = "IdTeam") int idUpdate,
			@RequestParam(value = "IdSubTask") SubTaskDTO IdSubTask,
			@RequestParam(value = "IdDipMaterial") DipMaterialDTO DipMaterial) {

		TeamDTO team = new TeamDTO();
		team.setIdTeam(idUpdate);
		team.setSubTaskDTO(IdSubTask);
		team.setDipMaterialDTO(DipMaterial);
		teamService.updateTeam(team);
//			visualOrder(request);

		return this.teamService.getListTeamDTO();
	}

}