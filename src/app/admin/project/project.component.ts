import { Component, OnInit } from '@angular/core';
import { ProjectService} from 'src/service/project.service';
import { ProjectDTO} from 'src/dto/projectdto';
import {UserDTO} from 'src/dto/userdto';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  user: UserDTO;
  projects: ProjectDTO[];
  projecttoinsert: ProjectDTO = new ProjectDTO();

  constructor(private projectservice: ProjectService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getProjects();
  }

  getProjects() {
    return this.projectservice.getAll().subscribe(projects => this.projects = projects);
  }
  delete(project: ProjectDTO) {
    this.projectservice.delete(project.id).subscribe(() => this.getProjects());
  }
  update(project: ProjectDTO) {
    this.projectservice.update(project).subscribe(() => this.getProjects());
  }
  insert(project: ProjectDTO) {
    // project.userDTO = this.user;
    this.projectservice.insert(project).subscribe(() => this.getProjects());
  }
  clear() {
    this.projecttoinsert = new ProjectDTO();
  }

}
