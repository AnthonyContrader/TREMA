import {TaskDTO} from './taskdto';

export class SubTaskDTO {

  id: number;
  subTask: string;
  dataInizio: Date;
  dataFine: Date;
  task: TaskDTO;
}
