import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSelectModule} from '@angular/material/select';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JogadorComponent, 
  PartidaComponent,
   TelaInicialComponent 
  } from './compenents/';
import { JogadorService, TelaInicialService} from './services';

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
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatTableModule,
    MatSnackBarModule,
    FormsModule,
    MatPaginatorModule,
    MatSelectModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [JogadorService, TelaInicialService],
  bootstrap: [AppComponent]
})
export class AppModule { }
