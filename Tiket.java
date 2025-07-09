/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Tiket {
    private String id;
    private String nama;
    private String rute;
    private String tanggal;
    private String kursi;

    public Tiket(String id, String nama, String rute, String tanggal, String kursi) {
        this.id = id;
        this.nama = nama;
        this.rute = rute;
        this.tanggal = tanggal;
        this.kursi = kursi;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getRute() { return rute; }
    public String getTanggal() { return tanggal; }
    public String getKursi() { return kursi; }

    public void setNama(String nama) { this.nama = nama; }
    public void setRute(String rute) { this.rute = rute; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public void setKursi(String kursi) { this.kursi = kursi; }
}
