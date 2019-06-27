import { Injectable } from '@angular/core';
import { SubTaskDTO } from '../dto/subtaskdto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class SubTaskService extends AbstractService<SubTaskDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'subtask';
    this.port = '8080';
}
}
