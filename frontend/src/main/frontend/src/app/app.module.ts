import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import {AppComponent} from './app.component';
import {LineChartDemoComponent} from "./chart";

@NgModule({
  declarations: [
    LineChartDemoComponent, AppComponent ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ChartsModule
  ],
  providers: [],
  bootstrap: [ AppComponent]
})
export class AppModule {
}
