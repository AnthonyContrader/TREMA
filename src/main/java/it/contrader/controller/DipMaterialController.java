package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.DipMaterialDTO;
import it.contrader.services.DipMaterialService;
import it.contrader.model.DipMaterial;
import it.contrader.dto.DipendentiDTO;
import it.contrader.dto.MaterialDTO;

@CrossOrigin
@RestController
@RequestMapping("/DipMaterial")
public class DipMaterialController {

	private final DipMaterialService dipMaterialService;
	// private final ClientService clientService;

	@Autowired
	public DipMaterialController(DipMaterialService dipMaterialService) {
		this.dipMaterialService = dipMaterialService;
		// this.clientService = clientService;
	}

	@RequestMapping(value = "dipMaterialManagement", method = RequestMethod.GET)
	public List<DipMaterialDTO> dipMaterialManagement(@RequestParam(value = "IdDipMaterial") DipMaterialDTO IdDipMaterial) {
		TeamDTO teamDTODipMaterialList = new TeamDTO();
		teamDTODipMaterialList.setDipMaterialDTO(IdDipMaterial);
		// return
		// this.orderService.findOrderDTOByUser(ConverterUser.toEntity(userDTOOrderList));
		return this.dipMaterialService.findDipMaterialDTOByTeam(teamDTODipMaterialList);
		// visualOrder(request);
		// return "order/manageOrder";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "IdDipMaterial") int id) {
		this.dipMaterialService.deleteDipMaterialById(id);
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
	public void insert(@RequestBody DipMaterialDTO dipMaterialDTO) {
		this.dipMaterialService.insertDipMaterial(dipMaterialDTO);
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
	public DipMaterialDTO read(@RequestParam(value = "IdDipMaterial") int id) {
		DipMaterialDTO dipMaterialUpdate = new DipMaterialDTO();
		dipMaterialUpdate = this.dipMaterialService.getDipMaterialDTOById(id);
		return dipMaterialUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<DipMaterialDTO> update(@RequestParam(value = "IdDipMaterial") int idUpdate,
            @RequestParam(value = "Quantita") int Quantita,
			@RequestParam(value = "IdDipendenti") DipendentiDTO IdDipendenti,
			@RequestParam(value = "IdMaterial") MaterialDTO IdMaterial) {

		DipMaterialDTO dipMaterial = new DipMaterialDTO();
        dipMaterial.setIdDipMaterial(idUpdate);
        dipMaterial.setQuantita(Quantita);
		dipMaterial.setDipendentiDTO(IdDipendenti);
		dipMaterial.setMaterialDTO(IdMaterial);
		dipMaterialService.updateDipMaterial(dipMaterial);
//			visualOrder(request);

		return this.dipMaterialService.getListDipMaterialDTO();
	}

}