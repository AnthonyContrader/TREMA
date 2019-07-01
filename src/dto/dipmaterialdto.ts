import {MaterialDTO} from "./materialdto";
import {DipendentiDTO} from './dipendentidto';

export class DipMaterialDTO {

  id: number;
  quantita: number;
  materialDTO: MaterialDTO;
  dipendentiDTO: DipendentiDTO;
}
