import { Component, OnInit } from '@angular/core';
import { CurrentTransactions } from '../shared/current-transactions';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { OrderServiceService } from '../order-service.service';


@Component({
  selector: 'app-pending-transactions',
  templateUrl: './pending-transactions.component.html',
  styleUrls: ['./pending-transactions.component.css']
})
export class PendingTransactionsComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public tid: number;
  public cid: number;
  public payment_type: string;
  public status: number;
  public currTransactions: CurrentTransactions[];

  constructor(private createService: OrderServiceService,
    private router: Router) { }

  ngOnInit() {
    this.createService.getTransactions().subscribe((data: CurrentTransactions[]) => {
      this.currTransactions = data;
    });
  }
  backToHome(){
    this.router.navigate(['home']);
  }
}
