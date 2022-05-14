import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import {MatTableModule} from '@angular/material/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JogadorComponent } from './compenents/jogador/jogador.component';
import { PartidaComponent } from './compenents/partida/partida.component';
import { TelaInicialComponent } from './compenents/tela-inicial/tela-inicial.component';
import { JogadorService } from './services';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    JogadorComponent,
    PartidaComponent,
    TelaInicialComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatTableModule,
    NgbModule
  ],
  providers: [JogadorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
