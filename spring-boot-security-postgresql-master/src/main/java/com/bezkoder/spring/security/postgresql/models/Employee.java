package com.bezkoder.spring.security.postgresql.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_employee_id_seq")
    @SequenceGenerator(name = "employee_employee_id_seq", sequenceName = "employee_employee_id_seq", allocationSize = 1)
    private Long employeeId;

    private String namaLengkap;
    private String namaPanggilan;
    private String gender;

    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date tanggalLahir;
    private String kotaKelahiran;
    private String agama;
    private String noKtp;
    private String uploadKtp;
    private String alamat;
    private String  tinggi;
    private String  beratBadan;
    private String golonganDarah;
    private String kacamata;
    private String statusPernikahan;
    private String jumlahAnak;
    private String emailemp;
    private String noHP;
    private String jabatan;
    private String divisi;
    private String akunInstagram;
    private String noNpwp;
    private String uploadNpwp;
    private String uploadImageSolo;
    private String nomorMember;
    private String pendidikanTerakhir;
    private String namaPendidikan;
    private String tahunKelulusan;
    private String namaAyah;
    private String pekerjaanAyah;
    private String namaIbu;
    private String pekerjaanIbu;
    private String anakKeberapa;
    private String jumlahSaudara;
    private String namaKontakDarurat;
    private String hubunganKontakDarurat;
    private String noHpKontakDarurat;
    private String kantorCabang;
    private String statusKerja;
    private String noRekBca;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date hireDate;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date resignDate;

    public  Employee (){}

    public Employee( String namaLengkap, String namaPanggilan,
                    String gender, String tanggalLahir, String kotaKelahiran, String agama,
                    String noKtp, String uploadKtp, String alamat, String tinggi, String beratBadan,
                    String golonganDarah, String kacamata, String statusPernikahan, String jumlahAnak,
                    String emailemp, String noHP, String jabatan, String divisi, String akunInstagram, String noNpwp,
                    String uploadNpwp, String uploadImageSolo,String nomorMember, String pendidikanTerakhir, String namaPendidikan,
                    String tahunKelulusan, String namaAyah, String pekerjaanAyah, String namaIbu,
                    String pekerjaanIbu, String anakKeberapa, String jumlahSaudara, String namaKontakDarurat,
                    String hubunganKontakDarurat, String noHpKontakDarurat, String kantorCabang,
                     String statusKerja, String noRekBca,
                    String hireDate, String resignDate) throws ParseException {

        this.namaLengkap = namaLengkap;
        this.namaPanggilan = namaPanggilan;
        this.gender = gender;
        this.tanggalLahir = convertDateFromString(tanggalLahir);
        this.kotaKelahiran = kotaKelahiran;
        this.agama = agama;
        this.noKtp = noKtp;
        this.uploadKtp = uploadKtp;
        this.alamat = alamat;
        this.tinggi = tinggi;
        this.beratBadan = beratBadan;
        this.golonganDarah = golonganDarah;
        this.kacamata = kacamata;
        this.statusPernikahan = statusPernikahan;
        this.jumlahAnak = jumlahAnak;
        this.emailemp = emailemp;
        this.noHP = noHP;
        this.jabatan = jabatan;
        this.divisi = divisi;
        this.akunInstagram = akunInstagram;
        this.noNpwp = noNpwp;
        this.uploadNpwp = uploadNpwp;
        this.uploadImageSolo = uploadImageSolo;
        this.nomorMember = nomorMember;
        this.pendidikanTerakhir = pendidikanTerakhir;
        this.namaPendidikan = namaPendidikan;
        this.tahunKelulusan = tahunKelulusan;
        this.namaAyah = namaAyah;
        this.pekerjaanAyah = pekerjaanAyah;
        this.namaIbu = namaIbu;
        this.pekerjaanIbu = pekerjaanIbu;
        this.anakKeberapa = anakKeberapa;
        this.jumlahSaudara = jumlahSaudara;
        this.namaKontakDarurat = namaKontakDarurat;
        this.hubunganKontakDarurat = hubunganKontakDarurat;
        this.noHpKontakDarurat = noHpKontakDarurat;
        this.kantorCabang = kantorCabang;
        this.statusKerja = statusKerja;
        this.noRekBca = noRekBca;
        this.hireDate = convertDateFromString(hireDate);
        this.resignDate = convertDateFromString(resignDate);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKotaKelahiran() {
        return kotaKelahiran;
    }

    public void setKotaKelahiran(String kotaKelahiran) {
        this.kotaKelahiran = kotaKelahiran;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getUploadKtp() {
        return uploadKtp;
    }

    public void setUploadKtp(String uploadKtp) {
        this.uploadKtp = uploadKtp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public String getKacamata() {
        return kacamata;
    }

    public void setKacamata(String kacamata) {
        this.kacamata = kacamata;
    }

    public String getStatusPernikahan() {
        return statusPernikahan;
    }

    public void setStatusPernikahan(String statusPernikahan) {
        this.statusPernikahan = statusPernikahan;
    }

    public String getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(String jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public String getEmailemp() {
        return emailemp;
    }

    public void setEmailemp(String emailemp) {
        this.emailemp = emailemp;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getAkunInstagram() {
        return akunInstagram;
    }

    public void setAkunInstagram(String akunInstagram) {
        this.akunInstagram = akunInstagram;
    }

    public String getNoNpwp() {
        return noNpwp;
    }

    public void setNoNpwp(String noNpwp) {
        this.noNpwp = noNpwp;
    }

    public String getUploadNpwp() {
        return uploadNpwp;
    }

    public void setUploadNpwp(String uploadNpwp) {
        this.uploadNpwp = uploadNpwp;
    }

    public String getUploadImageSolo() {
        return uploadImageSolo;
    }

    public void setUploadImageSolo(String uploadImageSolo) {
        this.uploadImageSolo = uploadImageSolo;
    }

    public String getNomorMember() {
        return nomorMember;
    }

    public void setNomorMember(String nomorMember) {
        this.nomorMember = nomorMember;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getNamaPendidikan() {
        return namaPendidikan;
    }

    public void setNamaPendidikan(String namaPendidikan) {
        this.namaPendidikan = namaPendidikan;
    }

    public String getTahunKelulusan() {
        return tahunKelulusan;
    }

    public void setTahunKelulusan(String tahunKelulusan) {
        this.tahunKelulusan = tahunKelulusan;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public String getAnakKeberapa() {
        return anakKeberapa;
    }

    public void setAnakKeberapa(String anakKeberapa) {
        this.anakKeberapa = anakKeberapa;
    }

    public String getJumlahSaudara() {
        return jumlahSaudara;
    }

    public void setJumlahSaudara(String jumlahSaudara) {
        this.jumlahSaudara = jumlahSaudara;
    }

    public String getNamaKontakDarurat() {
        return namaKontakDarurat;
    }

    public void setNamaKontakDarurat(String namaKontakDarurat) {
        this.namaKontakDarurat = namaKontakDarurat;
    }

    public String getHubunganKontakDarurat() {
        return hubunganKontakDarurat;
    }

    public void setHubunganKontakDarurat(String hubunganKontakDarurat) {
        this.hubunganKontakDarurat = hubunganKontakDarurat;
    }

    public String getNoHpKontakDarurat() {
        return noHpKontakDarurat;
    }

    public void setNoHpKontakDarurat(String noHpKontakDarurat) {
        this.noHpKontakDarurat = noHpKontakDarurat;
    }

    public String getKantorCabang() {
        return kantorCabang;
    }

    public void setKantorCabang(String kantorCabang) {
        this.kantorCabang = kantorCabang;
    }

    public String getStatusKerja() {
        return statusKerja;
    }

    public void setStatusKerja(String statusKerja) {
        this.statusKerja = statusKerja;
    }

    public String getNoRekBca() {
        return noRekBca;
    }

    public void setNoRekBca(String noRekBca) {
        this.noRekBca = noRekBca;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getResignDate() {
        return resignDate;
    }

    public void setResignDate(Date resignDate) {
        this.resignDate = resignDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", namaPanggilan='" + namaPanggilan + '\'' +
                ", gender='" + gender + '\'' +
                ", tanggalLahir=" + tanggalLahir +
                ", kotaKelahiran='" + kotaKelahiran + '\'' +
                ", agama='" + agama + '\'' +
                ", noKtp='" + noKtp + '\'' +
                ", uploadKtp='" + uploadKtp + '\'' +
                ", alamat='" + alamat + '\'' +
                ", tinggi='" + tinggi + '\'' +
                ", beratBadan='" + beratBadan + '\'' +
                ", golonganDarah='" + golonganDarah + '\'' +
                ", kacamata='" + kacamata + '\'' +
                ", statusPernikahan='" + statusPernikahan + '\'' +
                ", jumlahAnak='" + jumlahAnak + '\'' +
                ", emailemp='" + emailemp + '\'' +
                ", noHP='" + noHP + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", divisi='" + divisi + '\'' +
                ", akunInstagram='" + akunInstagram + '\'' +
                ", noNpwp='" + noNpwp + '\'' +
                ", uploadNpwp='" + uploadNpwp + '\'' +
                ", uploadImageSolo='" + uploadImageSolo + '\'' +
                ", nomorMember='" + nomorMember + '\'' +
                ", pendidikanTerakhir='" + pendidikanTerakhir + '\'' +
                ", namaPendidikan='" + namaPendidikan + '\'' +
                ", tahunKelulusan='" + tahunKelulusan + '\'' +
                ", namaAyah='" + namaAyah + '\'' +
                ", pekerjaanAyah='" + pekerjaanAyah + '\'' +
                ", namaIbu='" + namaIbu + '\'' +
                ", pekerjaanIbu='" + pekerjaanIbu + '\'' +
                ", anakKeberapa='" + anakKeberapa + '\'' +
                ", jumlahSaudara='" + jumlahSaudara + '\'' +
                ", namaKontakDarurat='" + namaKontakDarurat + '\'' +
                ", hubunganKontakDarurat='" + hubunganKontakDarurat + '\'' +
                ", noHpKontakDarurat='" + noHpKontakDarurat + '\'' +
                ", kantorCabang='" + kantorCabang + '\'' +
                ", statusKerja='" + statusKerja + '\'' +
                ", noRekBca='" + noRekBca + '\'' +
                ", hireDate=" + hireDate +
                ", resignDate=" + resignDate +
                '}';
    }

    public Date convertDateFromString(String datepick) throws ParseException {
        System.out.println("ini anjeng " + datepick);
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(datepick);
        System.out.println(date);
        return date;
    }

}
