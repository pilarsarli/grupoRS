export class Proyecto {
    id : number;
    nombre: string;
    fecha_inicio : string;
    fecha_estimada : string;

}   

export class Usuario {
    id: number;
    username: string;
    nombre : string;
    apellido : string;
    mail : string;

}

export const PROYECTOS: Proyecto[] = [
                                      {id: 1,
                                         nombre : 'Proyecto 1',
                                         fecha_inicio : '01/01/2018',
                                         fecha_estimada : '01/01/2019' 
                                      },
                                      {
                                          id: 2,
                                          nombre : 'Proyecto 2',
                                          fecha_inicio : '01/02/2018',
                                          fecha_estimada : '01/02/2019' 
                                       }]; 