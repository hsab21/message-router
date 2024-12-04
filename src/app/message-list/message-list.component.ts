import { Component, OnInit } from '@angular/core';
import { ApiService, Message } from '../../services/api.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {
  messages: Message[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.fetchMessages();
  }

  fetchMessages(): void {
    this.apiService.getMessages().subscribe((data) => {
      this.messages = data;
    });
  }
}
