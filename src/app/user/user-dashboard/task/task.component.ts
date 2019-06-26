import { Component, OnInit } from '@angular/core';
import { TaskDTO} from "../../../../dto/taskdto";
import { SubTaskService} from '../../../../service/subtask.service';
import { SubTaskDTO} from "../../../../dto/subtaskdto";
import { ActivatedRoute } from '@angular/router';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit   {

  subtasklist: SubTaskDTO[];
  id: number;
  task: TaskDTO;

  // tslint:disable-next-line:max-line-length
  constructor(public activatedRoute: ActivatedRoute, public subtaskService: SubTaskService) {

  }
  ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
      this.id = p.id;
      console.log(this.id);
      this.subtaskService.getAllBy(this.id).subscribe(data => {
        this.subtasklist = data;
      });
    });
  }
}
