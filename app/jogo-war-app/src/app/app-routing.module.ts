import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { JogadorComponent, PartidaComponent, TelaInicialComponent } from './compenents';

const routes: Routes = [
  {path: '', component: TelaInicialComponent},
  {path: 'partida', component: PartidaComponent},
  {path: 'novoJogador', component: JogadorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
