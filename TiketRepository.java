/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Tiket;
import java.util.ArrayList;

public class TiketRepository {
    private ArrayList<Tiket> daftarTiket = new ArrayList<>();

    public void tambah(Tiket tiket) {
        daftarTiket.add(tiket);
    }

    public ArrayList<Tiket> getAll() {
        return daftarTiket;
    }

    public void update(String id, Tiket tiketBaru) {
        for (int i = 0; i < daftarTiket.size(); i++) {
            if (daftarTiket.get(i).getId().equals(id)) {
                daftarTiket.set(i, tiketBaru);
                break;
            }
        }
    }

    public void hapus(String id) {
        daftarTiket.removeIf(t -> t.getId().equals(id));
    }
}

