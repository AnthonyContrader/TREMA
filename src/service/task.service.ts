import { Injectable } from '@angular/core';
import { TaskDTO } from '../dto/taskdto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class TaskService extends AbstractService<TaskDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'task';
    this.port = '8080';
  }
}
