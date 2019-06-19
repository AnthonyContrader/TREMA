import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import {ProjectDTO} from '../dto/projectdto';
import {Observable} from 'rxjs';
import {UserDTO} from '../dto/userdto';

@Injectable({
  providedIn: 'root'
})

export class ProjectService extends AbstractService<ProjectDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'project';
  }
}

