import { Jogador } from './../../models/jogador';
import { Component, OnInit } from '@angular/core';

import { JogadorService } from 'src/app/services';

@Component({
  selector: 'app-jogador',
  templateUrl: './jogador.component.html',
  styleUrls: ['./jogador.component.css']
})
export class JogadorComponent implements OnInit {
  jogadores: any;

  constructor(
    private service: JogadorService,

  ) { }
  
  ngOnInit(): void {
     this.findAll();  
  }

  

  findAll(){
    this.service.findAll()
      .subscribe(data => {
        console.log(data)
        this.jogadores = data;
      })
  }

}
