import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MessageListComponent } from './message-list/message-list.component';
import { PartnerListComponent } from './partner-list/partner-list.component';
import { MessageDetailComponent } from './message-detail/message-detail.component';
import { PartnerFormComponent } from './partner-form/partner-form.component';
import { AppComponent } from './app.component';
const routes: Routes = [
  { path: '', component: AppComponent },  // Route par défaut
  { path: '/api/messages', component: MessageListComponent },
  { path: '/api/partners', component: PartnerListComponent },
  { path: 'messages/:id', component: MessageDetailComponent },
  { path: 'add-partner', component: PartnerFormComponent },
  { path: '**', redirectTo: '/api/messages' },
  { path: '', redirectTo: '/api/messages', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
