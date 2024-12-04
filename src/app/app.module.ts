import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MessageListComponent } from './components/message-list/message-list.component';
import { PartnerListComponent } from './components/partner-list/partner-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MessageListComponent,
    PartnerListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, // Ajout du module HTTP
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
