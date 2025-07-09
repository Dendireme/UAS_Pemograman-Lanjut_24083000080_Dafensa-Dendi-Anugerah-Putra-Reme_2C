/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Tiket;
import repository.TiketRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TiketGUI extends JFrame {
    TiketRepository repo = new TiketRepository();
    DefaultTableModel model;
    JTable table;

    JTextField txtId, txtNama, txtRute, txtTanggal, txtKursi;

    public TiketGUI() {
        setTitle("Sistem Pemesanan Tiket Kereta");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 240, 255)); // Warna latar biru muda
        panel.setLayout(null);
        add(panel);

        JLabel lblTitle = new JLabel("Form Tiket Kereta");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(300, 10, 300, 30);
        panel.add(lblTitle);

        JLabel lblId = new JLabel("ID:");
        JLabel lblNama = new JLabel("Nama:");
        JLabel lblRute = new JLabel("Rute:");
        JLabel lblTanggal = new JLabel("Tanggal:");
        JLabel lblKursi = new JLabel("No. Kursi:");

        lblId.setBounds(50, 60, 100, 20);
        lblNama.setBounds(50, 90, 100, 20);
        lblRute.setBounds(50, 120, 100, 20);
        lblTanggal.setBounds(50, 150, 100, 20);
        lblKursi.setBounds(50, 180, 100, 20);

        txtId = new JTextField();
        txtNama = new JTextField();
        txtRute = new JTextField();
        txtTanggal = new JTextField();
        txtKursi = new JTextField();

        txtId.setBounds(150, 60, 200, 20);
        txtNama.setBounds(150, 90, 200, 20);
        txtRute.setBounds(150, 120, 200, 20);
        txtTanggal.setBounds(150, 150, 200, 20);
        txtKursi.setBounds(150, 180, 200, 20);

        JButton btnTambah = new JButton("Tambah");
        JButton btnUpdate = new JButton("Update");
        JButton btnHapus = new JButton("Hapus");

        btnTambah.setBounds(400, 60, 100, 25);
        btnUpdate.setBounds(400, 90, 100, 25);
        btnHapus.setBounds(400, 120, 100, 25);

        panel.add(lblId);
        panel.add(lblNama);
        panel.add(lblRute);
        panel.add(lblTanggal);
        panel.add(lblKursi);

        panel.add(txtId);
        panel.add(txtNama);
        panel.add(txtRute);
        panel.add(txtTanggal);
        panel.add(txtKursi);

        panel.add(btnTambah);
        panel.add(btnUpdate);
        panel.add(btnHapus);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Nama", "Rute", "Tanggal", "Kursi"});
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 230, 680, 200);
        panel.add(sp);

        // Aksi tombol
        btnTambah.addActionListener(e -> {
            Tiket tiket = new Tiket(
                txtId.getText(),
                txtNama.getText(),
                txtRute.getText(),
                txtTanggal.getText(),
                txtKursi.getText()
            );
            repo.tambah(tiket);
            tampilData();
            clearForm();
        });

        btnUpdate.addActionListener(e -> {
            Tiket tiket = new Tiket(
                txtId.getText(),
                txtNama.getText(),
                txtRute.getText(),
                txtTanggal.getText(),
                txtKursi.getText()
            );
            repo.update(txtId.getText(), tiket);
            tampilData();
            clearForm();
        });

        btnHapus.addActionListener(e -> {
            repo.hapus(txtId.getText());
            tampilData();
            clearForm();
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtId.setText(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtRute.setText(model.getValueAt(row, 2).toString());
                txtTanggal.setText(model.getValueAt(row, 3).toString());
                txtKursi.setText(model.getValueAt(row, 4).toString());
            }
        });

        setVisible(true);
    }

    private void tampilData() {
        model.setRowCount(0);
        for (Tiket t : repo.getAll()) {
            model.addRow(new Object[]{
                t.getId(), t.getNama(), t.getRute(), t.getTanggal(), t.getKursi()
            });
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtNama.setText("");
        txtRute.setText("");
        txtTanggal.setText("");
        txtKursi.setText("");
    }
}
