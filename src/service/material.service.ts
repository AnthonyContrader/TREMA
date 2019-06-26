import { Injectable } from '@angular/core';
import { MaterialDTO } from '../dto/materialdto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class MaterialService extends AbstractService<MaterialDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'Material';
    this.port = '8080';
  }
}
