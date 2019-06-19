import {Component, OnInit} from '@angular/core';
import {ProjectService} from 'src/service/project.service';
import {ProjectDTO} from 'src/dto/projectdto';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})

export class ProjectComponent implements OnInit {
    project: ProjectDTO[];
    projecttoinsert: ProjectDTO = new ProjectDTO();

    constructor(private service: ProjectService) {}

  ngOnInit(): void {
    this.getProjects();
  }

  getProjects() {
      this.service.getAll().subscribe(projects => this.project = projects);
  }

  delete(project: ProjectDTO) {
      this.service.delete(project.id).subscribe(() => this.getProjects());
  }

  update(project: ProjectDTO) {
      this.service.update(project).subscribe(() => this.getProjects());
  }

  insert(project: ProjectDTO) {
      this.service.insert(project).subscribe(() => this.getProjects());
  }

  clear() {
      this.projecttoinsert = new ProjectDTO();
  }
}
