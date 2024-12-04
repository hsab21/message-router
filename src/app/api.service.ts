import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Interfaces pour vos données
export interface Message {
  id: number;
  content: string;
  timestamp: string;
}

export interface Partner {
  id: number;
  alias: string;
  type: string;
  direction: string;
  application: string;
  processedFlowType: string;
  description: string;
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiBaseUrl = 'http://localhost:8080'; // URL du back-end

  constructor(private http: HttpClient) {}

  // Récupérer les messages
  getMessages(): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.apiBaseUrl}/api/messages`);
  }

  // Ajouter un message
  addMessage(message: Partial<Message>): Observable<Message> {
    return this.http.post<Message>(`${this.apiBaseUrl}/api/messages`, message);
  }

  // Récupérer les partenaires
  getPartners(): Observable<Partner[]> {
    return this.http.get<Partner[]>(`${this.apiBaseUrl}/api/partners`);
  }

  // Ajouter un partenaire
  addPartner(partner: Partner): Observable<Partner> {
    return this.http.post<Partner>(`${this.apiBaseUrl}/api/partners`, partner);
  }

  // Supprimer un partenaire
  deletePartner(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiBaseUrl}/api/partners/${id}`);
  }
}
