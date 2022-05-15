import { Jogador } from './../../models/jogador';
import { Component, OnInit, ViewChild } from '@angular/core';

import { JogadorService } from 'src/app/services';
import { MatTableDataSource } from '@angular/material/table';
import {MatSnackBar} from '@angular/material/snack-bar';
import { EMPTY, empty } from 'rxjs';

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
  erro: any | undefined;
  


  constructor(
    private service: JogadorService,
    private _snackBar: MatSnackBar,
  ) { }
  
  ngOnInit(): void {
     this.findAll(); 
  }

  create(): void{
    const jogador ={
      nome:this.jogadorNome
    };
    console.log(jogador)
    this.service.create(jogador)
    .subscribe(
    data => {
      console.log(data);
      this.findAll();
      this.jogadorNome = " ";
      this.openSnackBar("Jogador cadastrado com sucesso", 'snack-success'); 
    },
    err => {
      console.log(err);
      this.openSnackBar(err.error.message, 'snack-danger'); 
      this.jogadorNome = '';
    });  
  }

  findAll(){
    this.service.findAll()
      .subscribe(data => {
        console.log(data)
        this.dataSource.data = data;
      });
  }

  openSnackBar(erro: string, bgColor: string) {
    this._snackBar.open(erro, '', {
      horizontalPosition: 'right',
      verticalPosition: 'top',
      duration: 2000,
      panelClass: [bgColor]
    });
  }

  buscar(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  


}
