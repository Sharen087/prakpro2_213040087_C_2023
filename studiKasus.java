/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author sharnplmb
 */
public class studiKasus extends JFrame {
    private DefaultTableModel tableModel;
//    private Action remove;
    private JTable table;
    private JButton button;    
    
    public studiKasus() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15,40,350,10);
        
        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);
        
        JLabel labelInput2 = new JLabel("Nomor HP:");
        labelInput2.setBounds(15,90,400,50);
        
        JTextField textField2 = new JTextField();
        textField2.setBounds(15,135,350,30);
        
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15,150,400,70);
        
        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15,200,500,30);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan", true);
        radioButton2.setBounds(15,225,515,30);
        
        JLabel labelInput3 = new JLabel("Alamat:");
        labelInput3.setBounds(15,250,530,30);
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,285,345,100);
        
//        JRadioButton radioButton3 = new JRadioButton("Platinum", true);
//        radioButton3.setBounds(15,175,350,30);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
//        bg.add(radioButton3);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15,400,100,40);
        
        JButton button2 = new JButton("Edit");
        button2.setBounds(120,400,100,40);
        
        JButton button3 = new JButton("Hapus");
        button3.setBounds(225,400,100,40);
        
        JButton button4 = new JButton("Simpan ke File");
        button4.setBounds(330,400,150,40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,460,600,300);
        
        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String nomorHP = "";
//                if(radioButton1.isSelected()){
//                    nomorHP = radioButton1.getText();
//                }
                
                String jenisKelamin = "";
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }
                
//                String alamat = "";
//                if(radioButton1.isSelected()){
//                    alamat = txtOutput.getText();
//                }
//                if(radioButton3.isSelected()){
//                    jenisMember = radioButton3.getText();
//                }
//                
                String nama = textField.getText();
                String nomorHP = textField2.getText();
                String alamat = txtOutput.getText();
                tableModel.add(new ArrayList<>(Arrays.asList(nama, nomorHP, jenisKelamin, alamat)));
            }
        });
        
//        tableModel.addRow(new Object[]{"Data 1", "Data 2", "Data 3"});
        
        // fungsi tombol "edit"
        button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int selectedRow = table.getSelectedRow();
               if (selectedRow != -1) {
                   tableModel.setValueAt("\n", selectedRow, 0);
                   tableModel.setValueAt("\n", selectedRow, 1);
                   tableModel.setValueAt("\n", selectedRow, 2);
                   tableModel.setValueAt("\n", selectedRow, 3);
//                   tableModel.setValueAt("Nomor HP", selectedRow, 0);
//                   tableModel.setValueAt("Jenis Kelamin", selectedRow, 0);
//                   tableModel.setValueAt("Alamat", selectedRow, 0);
//                   tableModel.setRowToDeleted(selectedRow);
               }
           } 
        });
        
        // fungsi tombol "hapus"
        button3.addActionListener(new ActionListener() {
//           @Override
           public void actionPerformed(ActionEvent e) {
               int selectedRow = table.getSelectedRow();
               if (selectedRow != -1) {
                   // Hapus baris yang dipilih dari tabel
                   tableModel.setValueAt("", selectedRow, 0);
                   tableModel.setValueAt("", selectedRow, 1);
                   tableModel.setValueAt("", selectedRow, 2);
                   tableModel.setValueAt("", selectedRow, 3);
                   // Menandai baris yang diubah sebagai baris yang ingin dihapus
//                   tableModel.setRowToDeleted(selectedRow);
//                   tabelModel.removeMarkedRows();
                   
//                   DefaultTableModel model = (DefaultTableModel) table.getModel();
//                   model.removeRow(selectedRow);
               }
           }
        });
        
        // fungsi tombol "simpan ke file"
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanFile();
            }
        });
        
        setTitle("Form Biodata");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(textField);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
//        this.add(radioButton3);
        this.add(labelInput);
        this.add(labelInput2);
        this.add(labelInput3);
        this.add(txtOutput);
        this.add(scrollableTable);
        
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    private void simpanFile() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == fileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave + ".txt")) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        writer.write(tableModel.getValueAt(i, j).toString() + "\t");
                    }
                    writer.write("\n");
                }
                writer.close();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke file.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan dalam menyimpan file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                studiKasus h = new studiKasus();
                h.setVisible(true);
            }
        });
        
        SwingUtilities.invokeLater(() -> {
           new studiKasus(); 
        });
    }
    
}
