import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { DataService } from './services/data/data.service';

import { routing } from './app.routes';

import { AppComponent } from './app.component';
import { ProblemListComponent } from './components/problem-list/problem-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NewProblemComponent } from './components/new-problem/new-problem.component';
import { ProblemDetailComponent } from './components/problem-detail/problem-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    ProblemListComponent,
    NavbarComponent,
    NewProblemComponent,
    ProblemDetailComponent
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule,
  ],
  providers: [
    DataService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
