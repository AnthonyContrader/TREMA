import { Injectable } from '@angular/core';
import { TeamDTO } from '../dto/teamdto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class TeamService extends AbstractService<TeamDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'team';
    this.port = '8080';
  }
}
