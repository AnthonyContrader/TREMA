import { Component, OnInit } from '@angular/core';
import { ProjectDTO} from "../../../dto/projectdto";
import { TaskService } from '../../../service/task.service';
import { TaskDTO} from "../../../dto/taskdto";
import { ActivatedRoute } from '@angular/router';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  tasklist: TaskDTO[];
  id: number;
  project: ProjectDTO;

  // tslint:disable-next-line:max-line-length
  constructor(public activatedRoute: ActivatedRoute, public taskService: TaskService) {

  }
  ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
      this.id = p.id;
      console.log(this.id);
      this.taskService.getAllBy(this.id).subscribe(data => {
        this.tasklist = data;
      });
    });
  }
}
