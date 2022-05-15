import { Jogador } from './../models/jogador';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const jogadoresEndpoint = 'http://localhost:8080/jogadores';

@Injectable({
  providedIn: 'root'
})
export class JogadorService {

  constructor(
      private http: HttpClient,
    ) { }

    public findAll(): Observable<Jogador[]>{
      return this.http.get<Jogador[]>(jogadoresEndpoint);
    } 

    public create(nome: any): Observable<any>{
      return this.http.post(jogadoresEndpoint, nome);
    }
}
