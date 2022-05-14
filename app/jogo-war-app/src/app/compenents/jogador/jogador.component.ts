import { Jogador } from './../../models/jogador';
import { Component, OnInit } from '@angular/core';

import { JogadorService } from 'src/app/services';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-jogador',
  templateUrl: './jogador.component.html',
  styleUrls: ['./jogador.component.css']
})
export class JogadorComponent implements OnInit {
  jogadores: any;
  jogadorNome: any;
  displayedColumns = ['id', 'nome'];
  dataSource = new MatTableDataSource<Jogador>();
  error= false;
  
  constructor(
    private service: JogadorService,

  ) { }
  
  ngOnInit(): void {
     this.findAll();  
  }

  buscar(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  create(): void{
    const jogador ={
      nome:this.jogadorNome
    };

    console.log(jogador);
    this.service.create(jogador)
    .subscribe(data => {
      console.log(data);
      this.findAll();
    },
    error => {
      console.log(error);
    });
  }

  findAll(){
    this.service.findAll()
      .subscribe(data => {
        console.log(data)
        this.dataSource.data = data;
      })
  }


}
