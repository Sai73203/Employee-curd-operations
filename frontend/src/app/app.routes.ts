import { Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeAddComponent } from './employee-add/employee-add.component';
import { EmployeeUpdateComponent } from './employee-update/employee-update.component';

export const routes: Routes = [
    {
        path:"employeeList",
        component:EmployeeListComponent
    },
    {
        path:"addEmployee",
        component:EmployeeAddComponent
    },
    {
        path:'updateEmployee/:id',
        component:EmployeeUpdateComponent
    }
];
