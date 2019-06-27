import {Component, OnInit} from '@angular/core';
import {ProjectDTO} from '../../../../dto/projectdto';
import {ProjectService} from '../../../../service/project.service';
import {UserDTO} from '../../../../dto/userdto';



@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {

  user: UserDTO;
  project: ProjectDTO[];


  constructor(private service: ProjectService) {
  }

  ngOnInit() {
    this.project = new Array<ProjectDTO>();
    this.getAllBy();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getAllBy() {
    this.service.getAllBy(+JSON.parse(localStorage.getItem('currentUser')).id).subscribe(project => this.project = project);
  }
}
