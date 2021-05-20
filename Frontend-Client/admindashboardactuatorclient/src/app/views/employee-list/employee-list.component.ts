import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../data/services/employee.service";
import {Employee} from "../../data/schema/employee";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  public employeeList: Employee[]=[];
  // public employee: Employee;
  // public editEmployee: Employee;
  // public deleteEmployee: Employee;

  constructor(private _employeeService: EmployeeService) {}

  ngOnInit() {
    this.getEmployees();
  }

  public getEmployees(): void {
    console.log('Fetching all employees...');
    this._employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        console.log(response);
        this.employeeList = response;
      },
      (error: HttpErrorResponse) => {
        console.error(error);
      }
    );
  }

}
