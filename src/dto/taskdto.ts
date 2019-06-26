import {ProjectDTO} from './projectdto';

export class TaskDTO {

  id: number;
  task: string;
  dataInizio: Date;
  dataFine: Date;
  projectDTO: ProjectDTO;
}
