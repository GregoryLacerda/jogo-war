import { Partida } from './../models/partida';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const partidaEndpoint = 'http://localhost:8080/partidas';

@Injectable({
  providedIn: 'root'
})
export class TelaInicialService {

  constructor(
      private http: HttpClient,
  ) { }

  partida: any;
  public findAll(): Observable<Partida[]>{
   this.partida = this.http.get<Partida[]>(partidaEndpoint);
   console.log(this.partida);
   return this.partida;
  }

}
