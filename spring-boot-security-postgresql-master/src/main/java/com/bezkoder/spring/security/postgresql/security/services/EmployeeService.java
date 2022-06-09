package com.bezkoder.spring.security.postgresql.security.services;

import com.bezkoder.spring.security.postgresql.models.Employee;
import com.bezkoder.spring.security.postgresql.repository.EmployeeRepository;
import com.bezkoder.spring.security.postgresql.security.exception.ResourceAlreadyExistException;
import com.bezkoder.spring.security.postgresql.security.exception.ResourceDoseNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
        public class EmployeeService {

        private EmployeeRepository employeeRepository;

        public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
        }

        public Employee findById(Long id) throws ResourceDoseNotExistException {

        Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeId(id);
        if (optionalEmployee.isPresent()) {
        return optionalEmployee.get();
        } else {
        throw new ResourceDoseNotExistException(id + "");
        }
        }


//findAll method
public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
        }


//add method
public Employee addEmployee(Employee employee) throws ResourceAlreadyExistException {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
//        if (optionalEmployee.isPresent()) {
//                throw new ResourceAlreadyExistException(employee.getEmployeeId() + "");
//        } else {
        System.out.println("ini anjne" + employee.getTanggalLahir());
        try {
                return employeeRepository.save(employee);

        } catch (Exception e) {
                e.printStackTrace();
                return null;
        }
}





//update method

public Employee updateEmployee( Long id,Employee employee) throws ResourceDoseNotExistException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {

        Employee employeeUpdate = optionalEmployee.get();
        employeeUpdate.setEmailemp(employee.getEmailemp());
        employeeUpdate.setNoHP(employee.getNoHP());
        employeeUpdate.setNamaLengkap(employee.getNamaLengkap());
        employeeUpdate.setAgama(employee.getAgama());
        employeeUpdate.setAlamat(employee.getAlamat());
        employeeUpdate.setTanggalLahir(employee.getTanggalLahir());
        employeeUpdate.setAkunInstagram(employee.getAkunInstagram());
        employeeUpdate.setAnakKeberapa(employee.getAnakKeberapa());
        employeeUpdate.setBeratBadan(employee.getBeratBadan());
        employeeUpdate.setDivisi(employee.getDivisi());
        employeeUpdate.setNamaPanggilan(employee.getNamaPanggilan());
        employeeUpdate.setKotaKelahiran(employee.getKotaKelahiran());
        employeeUpdate.setNoKtp(employee.getNoKtp());
        employeeUpdate.setUploadKtp(employee.getUploadKtp());
        employeeUpdate.setTinggi(employee.getTinggi());
        employeeUpdate.setBeratBadan(employee.getBeratBadan());
        employeeUpdate.setGolonganDarah(employee.getGolonganDarah());
        employeeUpdate.setKacamata(employeeUpdate.getKacamata());
        employeeUpdate.setStatusKerja(employee.getStatusKerja());
        employeeUpdate.setStatusPernikahan(employee.getStatusPernikahan());
        employeeUpdate.setJumlahAnak(employee.getJumlahAnak());
        employeeUpdate.setJabatan(employee.getJabatan());
        employeeUpdate.setNoNpwp(employee.getNoNpwp());
        employeeUpdate.setUploadNpwp(employee.getUploadNpwp());
        employeeUpdate.setUploadImageSolo(employee.getUploadImageSolo());
        employeeUpdate.setNomorMember(employee.getNomorMember());
        employeeUpdate.setPendidikanTerakhir(employee.getPendidikanTerakhir());
        employeeUpdate.setNamaPendidikan(employee.getNamaPendidikan());
        employeeUpdate.setTahunKelulusan(employee.getTahunKelulusan());
        employeeUpdate.setNamaAyah(employee.getNamaAyah());
        employeeUpdate.setPekerjaanAyah(employee.getPekerjaanAyah());
        employeeUpdate.setNamaIbu(employee.getNamaIbu());
        employeeUpdate.setPekerjaanIbu(employee.getPekerjaanIbu());
        employeeUpdate.setJumlahSaudara(employee.getJumlahSaudara());
        employeeUpdate.setNamaKontakDarurat(employee.getNamaKontakDarurat());
        employeeUpdate.setHubunganKontakDarurat(employee.getHubunganKontakDarurat());
        employeeUpdate.setNoHpKontakDarurat(employee.getNoHpKontakDarurat());
        employeeUpdate.setKantorCabang(employee.getKantorCabang());
        employeeUpdate.setNoRekBca(employee.getNoRekBca());
        employeeUpdate.setHireDate(employeeUpdate.getResignDate());
        employeeUpdate.setResignDate(employee.getResignDate());




        return employeeRepository.save(employeeUpdate);

        } else {
        throw new ResourceDoseNotExistException(id + "");
        }

        }


//        deleteById method
        public void deleteById(Long id)
        {
//         EmployeeRepository.deleteEmployeeById(id);
              employeeRepository.deleteEmployeeByEmployeeId(id);
        }
        }