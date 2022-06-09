import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../_services/employee.service';
import { MessageService } from '../_services/message.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import swal from 'sweetalert';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AddemployeeComponent } from '../addemployee/addemployee.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { ViewChild } from '@angular/core';




@Component({
  selector: 'app-board-moderator',
  templateUrl: './board-moderator.component.html',
  styleUrls: ['./board-moderator.component.css']
})
export class BoardModeratorComponent implements OnInit {

  closeResult: string = '';
  title = 'appBootstrap';


  page = 1;
  count= 0;
  pagesize= 5;
  pageSizes = [5,10,20];
  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['namaLengkap', 'emailemp', 'noHP', 'divisi','menu'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort; 

  
    

  constructor( 
    private router : Router,
    private modalService : NgbModal,
    private employeeService: EmployeeService,
    private messageService:MessageService,
  ) {
    this.editEmployee = new FormGroup({
      namaLengkap: new FormControl('', [Validators.required]),
        namaPanggilan: new FormControl('', Validators.required),
        gender: new FormControl('', [Validators.required]),
        tanggalLahir: new FormControl('', [Validators.required]),
        kotaKelahiran: new FormControl('', [Validators.required]),
        agama: new FormControl('', [Validators.required]),
        noKtp: new FormControl('', [Validators.required]),
        uploadKtp: new FormControl('', [Validators.required]),
        alamat: new FormControl('', [Validators.required]),
        tinggi: new FormControl('', [Validators.required]),
        beratBadan: new FormControl('', [Validators.required]),
        golonganDarah: new FormControl('', [Validators.required]),
        kacamata: new FormControl('', [Validators.required]),
        statusPernikahan: new FormControl('', [Validators.required]),
        jumlahAnak: new FormControl('', [Validators.required]),
        noHP: new FormControl('', [Validators.required]),
        emailemp: new FormControl('', [Validators.required]),
        jabatan: new FormControl('', [Validators.required]),
        akunInstagram: new FormControl('', [Validators.required]),
        noNpwp: new FormControl('', [Validators.required]),
        uploadNpwp: new FormControl('', [Validators.required]),
        uploadImageSolo: new FormControl('', [Validators.required]),
        nomorMember: new FormControl('', [Validators.required]),
        pendidikanTerakhir: new FormControl('', [Validators.required]),
        namaPendidikan: new FormControl('', [Validators.required]),
        tahunKelulusan: new FormControl('', [Validators.required]),
        divisi: new FormControl('', [Validators.required]),
        namaAyah: new FormControl('', [Validators.required]),
        pekerjaanAyah: new FormControl('', [Validators.required]),
        namaIbu: new FormControl('', [Validators.required]),
        pekerjaanIbu: new FormControl('', [Validators.required]),
        anakKeberapa: new FormControl('', [Validators.required]),
        jumlahSaudara: new FormControl('', [Validators.required]),
        namaKontakDarurat: new FormControl('', [Validators.required]),
        hubunganKontakDarurat: new FormControl('', [Validators.required]),
        noHpKontakDarurat: new FormControl('', [Validators.required]),
        kantorCabang: new FormControl('', [Validators.required]),
        statusKerja: new FormControl('', [Validators.required]),
        noRekBca: new FormControl('', [Validators.required]),
        hireDate: new FormControl('', [Validators.required]),
        resignDate: new FormControl('', [Validators.required])
      })
   }

  test: Employee;
  employees: Employee[] = [];
  selectEmployee: Employee;
  editEmployee: FormGroup; 
  editedEmployee : Employee;
  
  
  
  
  ngOnInit(): any {
    this.employeeService.getEmployeesList().subscribe(
      (response)=>{
        console.log("response recieved");
        this.employees=response;
        this.employeeView = response;
        // this.dataSource.data = new MatTableDataSource <Employee> (this.employeeView) = response;
        this.dataSource.data = this.employees;
        // this.dataSource = new MatTableDataSource(this.employeeView);
        // that.dataSource = new MatTableDataSource(that.employeeView);
        console.log(this.employeeView);
        console.log(this.dataSource);
        console.log(this.employees);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        console.log(this.dataSource);
        
      },
    error=>console.log("exception occure")
    )

console.log(this.employeeService.getEmployeesList);
    

      
    
  }

  // ngAfterViewInit() {
  //   this.dataSource.paginator = this.paginator;
  //   this.dataSource.sort = this.sort;
  // }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }



  getRequestParams(searchTitle: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchTitle) {
      params[`title`] = searchTitle;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveTutorials(): void {
    const params = this.getRequestParams(this.title, this.page, this.pagesize);

    this.employeeService.getEmployeesById(params)
      .subscribe({
        next: (data) => {
          const { employees, totalItems } = data;
          this.employees = employees;
          this.count = totalItems;
          console.log(data);
        },
        error: (err) => {
          console.log(err);
        }
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveTutorials();
  }
  handlePageSizeChange(event: any): void {
    this.pagesize = event.target.value;
    this.page = 1;
    this.retrieveTutorials();
  }
  searchTitle(): void {
    this.page = 1;
    this.retrieveTutorials();
  }

  employeeView : Employee[];

  


  viewEmployeeList(dataSource:any): any{
    var that = this;
  
    this.employeeService.getEmployeesList().subscribe(
            (response)=>{
              console.log("response recieved");
              this.employees=response;
              this.employeeView = response;
              that.employeeView = response;
              dataSource = new MatTableDataSource(this.employeeView);
              // this.dataSource = new MatTableDataSource(this.employeeView);
              // that.dataSource = new MatTableDataSource(that.employeeView);
              console.log(this.employeeView);
              console.log(this.dataSource);
              console.log(this.employees);
              dataSource.paginator = this.paginator;
              dataSource.sort = this.sort;
              console.log(dataSource);
              
            },
          error=>console.log("exception occure")
          )

    console.log(this.employeeService.getEmployeesList);
    }

  goToUpdate( employeeid:number ){
    this.router.navigate(['form',employeeid]);
  }
  
  open(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  } 

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }



  editSelectedEmployee(employeeid:number, mymodaledit:any){
    this.open(mymodaledit);
    this.employeeService.getEmployeesById(employeeid).subscribe(
      (response)=>{
        
        this.editEmployee.controls['namaLengkap'].setValue(response.namaLengkap);
        this.editEmployee.controls['namaPanggilan'].setValue(response.namaPanggilan);
        this.editEmployee.controls['gender'].setValue(response.gender);
        this.editEmployee.controls['tanggalLahir'].setValue(response.tanggalLahir);
        this.editEmployee.controls['kotaKelahiran'].setValue(response.kotaKelahiran);
        this.editEmployee.controls['agama'].setValue(response.agama);
        this.editEmployee.controls['noKtp'].setValue(response.noKtp);
        this.editEmployee.controls['uploadKtp'].setValue(response.uploadKtp);
        this.editEmployee.controls['alamat'].setValue(response.alamat);
        this.editEmployee.controls['tinggi'].setValue(response.tinggi);
        this.editEmployee.controls['beratBadan'].setValue(response.beratBadan);
        this.editEmployee.controls['golonganDarah'].setValue(response.golonganDarah);
        this.editEmployee.controls['kacamata'].setValue(response.kacamata);
        this.editEmployee.controls['statusPernikahan'].setValue(response.statusPernikahan);
        this.editEmployee.controls['jumlahAnak'].setValue(response.jumlahAnak);      
        this.editEmployee.controls['noHP'].setValue(response.noHP);
        this.editEmployee.controls['emailemp'].setValue(response.emailemp);
        this.editEmployee.controls['jabatan'].setValue(response.jabatan);
        this.editEmployee.controls['akunInstagram'].setValue(response.akunInstagram);
        this.editEmployee.controls['noNpwp'].setValue(response.noNpwp);
        this.editEmployee.controls['uploadNpwp'].setValue(response.uploadNpwp);
        this.editEmployee.controls['uploadImageSolo'].setValue(response.uploadImageSolo);
        this.editEmployee.controls['nomorMember'].setValue(response.nomorMember);
        this.editEmployee.controls['pendidikanTerakhir'].setValue(response.pendidikanTerakhir);
        this.editEmployee.controls['namaPendidikan'].setValue(response.namaPendidikan);
        this.editEmployee.controls['tahunKelulusan'].setValue(response.tahunKelulusan);
        this.editEmployee.controls['divisi'].setValue(response.divisi);
        this.editEmployee.controls['namaAyah'].setValue(response.namaAyah);
        this.editEmployee.controls['pekerjaanAyah'].setValue(response.pekerjaanAyah);
        this.editEmployee.controls['namaIbu'].setValue(response.namaIbu);
        this.editEmployee.controls['pekerjaanIbu'].setValue(response.pekerjaanIbu);
        this.editEmployee.controls['anakKeberapa'].setValue(response.anakKeberapa);
        this.editEmployee.controls['jumlahSaudara'].setValue(response.jumlahSaudara);
        this.editEmployee.controls['namaKontakDarurat'].setValue(response.namaKontakDarurat);
        this.editEmployee.controls['hubunganKontakDarurat'].setValue(response.hubunganKontakDarurat);
        this.editEmployee.controls['noHpKontakDarurat'].setValue(response.noHpKontakDarurat);
        this.editEmployee.controls['kantorCabang'].setValue(response.kantorCabang);
        this.editEmployee.controls['statusKerja'].setValue(response.statusKerja);
        this.editEmployee.controls['noRekBca'].setValue(response.noRekBca);
        this.editEmployee.controls['hireDate'].setValue(response.hireDate);
        this.editEmployee.controls['resignDate'].setValue(response.resignDate);
        this.editedEmployee = response;
        console.log(this.editEmployee.value);
        
      },
    error=>console.log("exception occure")
    )
  }

  updateEmployeeFormSubmit(employeeId: number){
    console.log(this.editEmployee.value)
    this.employeeService.updateEmployee(employeeId, this.editEmployee.value).subscribe(
      data =>{
        console.log("Employee updated successfuly");
        // this.router.navigate(['employees']);
        window.location.reload();
        
      },
      error =>console.log("error")
 
    )
    } 

    

   
  viewSelectedEmployee(employeeid: number, mymodalview: any){
    this.open(mymodalview);
    this.employeeService.getEmployeesById(employeeid).subscribe(
      (response)=>{
        console.log("response recieved");
        this.selectEmployee=response;
        console.log(this.selectEmployee);
      },
    error=>console.log("exception occure")
    )
  }

  deleteSelectedEmployee(employeeId: number){
    swal({
      title: "Are you sure?",
      text: "Once deleted, you will not be able to recover!",
      icon: "warning",
      buttons: [true, true],
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        this.employeeService.deleteEmployee(employeeId).subscribe(
          (response)=>{
            this.viewEmployeeList(this.dataSource);
        this.messageService.showSuccessMessage("Successfully Deleted","");
        })
      } 
    })
}









}











