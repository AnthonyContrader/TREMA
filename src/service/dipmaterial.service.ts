import { Injectable } from '@angular/core';
import { DipMaterialDTO } from '../dto/dipmaterialdto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class DipMaterialService extends AbstractService<DipMaterialDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'DipMaterial';
    this.port = '8080';
  }
}
