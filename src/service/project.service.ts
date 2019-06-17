import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProjectDto } from 'src/dto/projectdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService extends AbstractService<ProjectDto>{
  constructor(http: HttpClient) {
    super(http);
    this.getAll();
  }
}
