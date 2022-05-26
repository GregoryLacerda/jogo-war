import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partida } from '../models';

const endpointPartida = 'http://localhost:8080/partidas';
@Injectable({
  providedIn: 'root'
})
export class PartidaService {

  constructor(
    private http: HttpClient
  ) { }

  public criarPartida(partida: Partida){    
    this.http.post(endpointPartida, partida);    
  }

}
