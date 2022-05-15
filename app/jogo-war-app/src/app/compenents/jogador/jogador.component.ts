import { Jogador } from './../../models/jogador';
import { Component, OnInit} from '@angular/core';

import { JogadorService } from 'src/app/services';
import { MatTableDataSource } from '@angular/material/table';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-jogador',
  templateUrl: './jogador.component.html',
  styleUrls: ['./jogador.component.css']
})
export class JogadorComponent implements OnInit {
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

  public create(): void{
    const jogador ={
      nome:this.jogadorNome
    };

    this.service.create(jogador)
    .subscribe(
    data => {
      this.findAll();
      this.jogadorNome = " ";
      this.openSnackBar("Jogador cadastrado com sucesso", 'snack-success'); 
    },
    err => {
      this.openSnackBar(err.error.message, 'snack-danger'); 
      this.jogadorNome = '';
    });  
  }

  public findAll(){
    this.service.findAll()
      .subscribe(data => {
        this.dataSource.data = data;
      });
  }

  public openSnackBar(erro: string, bgColor: string) {
    this._snackBar.open(erro, '', {
      horizontalPosition: 'right',
      verticalPosition: 'top',
      duration: 2000,
      panelClass: [bgColor]
    });
  }

  public buscar(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  


}
