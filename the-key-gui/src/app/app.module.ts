import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './routing/app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {ThekeyModule} from "./thekey/thekey.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ThekeyModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
