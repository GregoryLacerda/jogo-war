import { Partida } from './../../models/partida';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit } from '@angular/core';
import { TelaInicialService } from 'src/app/services';

@Component({
  selector: 'app-tela-inicial',
  templateUrl: './tela-inicial.component.html',
  styleUrls: ['./tela-inicial.component.css']
})
export class TelaInicialComponent implements OnInit {

  displayedColumns= ['codigo', 'jogadores', 'numRodadas', 'vencedor'];
  dataSource = new MatTableDataSource<Partida>();

  constructor(
    private service: TelaInicialService,
    ) { }

  ngOnInit(): void {
  }

  public buscar(event: Event ){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  public findAll(){
    this.service.findAll()
      .subscribe(data => {
        console.log(data)
        this.dataSource.data = data;
      },
      err => {
        console.log(err)
      }
      );
  }

}
