import { Component, OnInit } from '@angular/core';
import { TeamDTO} from '../../../../dto/teamdto';
import { TeamService} from '../../../../service/team.service';
import { SubTaskDTO} from '../../../../dto/subtaskdto';
import { ActivatedRoute } from '@angular/router';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit   {

  teamlist: TeamDTO[];
  id: number;
  subtask: SubTaskDTO;

  // tslint:disable-next-line:max-line-length
  constructor(public activatedRoute: ActivatedRoute, public teamService: TeamService) {

  }
  ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
      this.id = p.id;
      console.log(this.id);
      this.teamService.getAllBy(this.id).subscribe(data => {
        this.teamlist = data;
        console.log(this.teamlist);
        for ( let team of this.teamlist) {
          console.log(team.dipMaterialDTO);
        };
      });
    });
  }
  asd(){
    console.log("XXXXXXX");
  }
}
