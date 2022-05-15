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

  public findAll(): Observable<Partida[]>{
    return this.http.get<Partida[]>(partidaEndpoint);
  }

}
