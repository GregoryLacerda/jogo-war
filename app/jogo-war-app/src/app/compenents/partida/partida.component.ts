import { Partida } from './../../models/partida';
import { Jogador } from './../../models/jogador';
import { Component, OnInit } from '@angular/core';

import { JogadorService, PartidaService} from 'src/app/services';
import {FormControl} from '@angular/forms';
@Component({
  selector: 'app-partida',
  templateUrl: './partida.component.html',
  styleUrls: ['./partida.component.css']
})
export class PartidaComponent implements OnInit {

  jogadores = new FormControl();
  listaJogadores: Jogador[] = [];
  rodadas: string[] = [];


  partida: Partida = {
    codigo: 0,
    jogadores: [],
    rodadas: [],
    vencedor: ''
  }

  constructor(
    private jogadorService: JogadorService,
    private partidaService: PartidaService,
  ) { }

  ngOnInit(): void {
    this.buscarJogadores();
  }

  public buscarJogadores(){
    this.jogadorService.findAll()
    .subscribe(
      data => {
        this.listaJogadores = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  public criarPartida(){
    this.partida.jogadores = this.jogadores.value;
    this.partida.rodadas = this.rodadas;
    this.partidaService.criarPartida(this.partida);
  }


}
