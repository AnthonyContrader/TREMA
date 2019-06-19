import { Component, OnInit } from '@angular/core';
import { ProjectService} from 'src/service/project.service';
import { ProjectDTO} from 'src/dto/projectdto';
import {UserDTO} from 'src/dto/userdto';
import {Observable} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  projects: ProjectDTO[];
  projecttoinsert: ProjectDTO = new ProjectDTO();

  constructor(private projectservice: ProjectService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getProjects();
  }

  getProjects() {
    return this.projectservice.getAllBy(this.user.id).subscribe(projects => this.projects = projects);
  }
  delete(project: ProjectDTO) {
    this.projectservice.delete(project.id).subscribe(() => this.getProjects());
  }
  update(project: ProjectDTO) {
    this.projectservice.update(project).subscribe(() => this.getProjects());
  }
  insert(project: ProjectDTO) {
    this.projectservice.insert(project).subscribe(() => this.getProjects());
  }
  clear() {
    this.projecttoinsert = new ProjectDTO();
  }
}

