import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProjectDTO } from 'src/dto/projectdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectService extends AbstractService<ProjectDTO> {
  constructor(http: HttpClient) {
    super(http);
    this.getAll();
  }
}
