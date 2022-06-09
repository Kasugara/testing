import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../_services/employee.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Employee } from '../model/employee';
import { EmployeeListComponent } from '../employee-list/employee-list.component';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {



  constructor(private employeService:EmployeeService, private router: Router) { }

  
  ngOnInit(): void {
  }}