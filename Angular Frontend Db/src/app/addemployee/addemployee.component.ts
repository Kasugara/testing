import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../_services/employee.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Employee } from '../model/employee';
import { formatDate } from '@angular/common';
import { HttpClient, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {

  employees: FormGroup;
  url :any;
  msg = "";
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;
  

  constructor(private employeeService:EmployeeService, private router: Router, private httpClient: HttpClient) { 
   }
  ngOnInit(): void {
    this.employees = new FormGroup({
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
      emailemp: new FormControl('', [Validators.required]),
      noHP: new FormControl('', [Validators.required]),
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

      

    });
    
  }
  get f(){
    return this.employees.controls;
  }
 
  addEmployeeformsubmit(){
    console.log(this.employees.value)
    this.employeeService.addEmployee(this.employees.value).subscribe(
      data =>{
        console.log("Employee added successfuly");
        window.location.reload();       
      },
      error =>console.log("error")
 
    )
    } 

    onSelectFile(event:any){
      if(!event.target.files[0] || event.target.files[0].length == 0) {
        this.msg = 'You must select an image';
        return;
      }
    
      var mimeType = event.target.files[0].type;
        
        if (mimeType.match(/image\/*/) == null) {
          this.msg = "Only images are supported";
          return;
        }
        var reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        
        reader.onload = (_event) => {
          this.msg = "";
          this.url = reader.result; 
        }
    }


    // public onFileChanged(event:any) {
    //   //Select File
    //   this.selectedFile = event.target.files[0];
    // }
  
  
    // //Gets called when the user clicks on submit to upload the image
    // onUpload() {
    //   console.log(this.selectedFile);
      
    //   //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    //   const uploadImageData = new FormData();
    //   uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    
    //   //Make a call to the Spring Boot Application to save the image
    //   this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
    //     .subscribe((response) => {
    //       if (response.status === 200) {
    //         this.message = 'Image uploaded successfully';
    //       } else {
    //         this.message = 'Image not uploaded successfully';
    //       }
    //     }
    //     );
  
  
    // }
  
    //   //Gets called when the user clicks on retieve image button to get the image from back end
    //   getImage() {
    //   //Make a call to Sprinf Boot to get the Image Bytes.
    //   this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
    //     .subscribe(
    //       res => {
    //         this.retrieveResonse = res;
    //         this.base64Data = this.retrieveResonse.picByte;
    //         this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
    //       }
    //     );
    // }
  }
    

