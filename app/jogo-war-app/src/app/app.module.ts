import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JogadorComponent } from './compenents/jogador/jogador.component';
import { PartidaComponent } from './compenents/partida/partida.component';
import { TelaInicialComponent } from './compenents/tela-inicial/tela-inicial.component';
import { JogadorService } from './services';

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
    MatListModule
  ],
  providers: [JogadorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
