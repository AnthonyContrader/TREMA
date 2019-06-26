import { Injectable } from '@angular/core';
import { DipendentiDTO } from '../dto/dipendentidto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class DipendentiService extends AbstractService<DipendentiDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'Dipendenti';
    this.port = '8080';
  }
}
