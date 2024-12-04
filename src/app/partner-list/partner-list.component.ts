import { Component, OnInit } from '@angular/core';
import { ApiService, Partner } from '../../services/api.service';

@Component({
  selector: 'app-partner-list',
  templateUrl: './partner-list.component.html',
  styleUrls: ['./partner-list.component.css']
})
export class PartnerListComponent implements OnInit {
  partners: Partner[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.fetchPartners();
  }

  fetchPartners(): void {
    this.apiService.getPartners().subscribe((data) => {
      this.partners = data;
    });
  }
}
