/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7;
import java.util.ArrayList;
import javax.swing.table.*;
import java.util.List;
/**
 *
 * @author sharnplmb
 */

class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Nomor HP", "Jenis Kelamin", "Alamat"};
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
//    private Set<Integer> rowToBeDeleted = new HashSet<>();
    
//    public void setRowToBeDeleted(int row) {
//        rowsToBeDeleted.add(row);
//    }
    
//    public void removeMarkedRows() {
//        List<Integer> rowsToRemove = new ArrayList<>(rowsToBeDeleted);
//        rowToRemove.sort(Collections.reverseOrder());
//        for (int row : rowsToRemove) {
//            removeRow(row);
//        }
//        rowsToBeDeleted.clear();
//    }
    
    public int getColumnCount(){
        return columnNames.length;
    }
    
    public int getRowCount(){
        return data.size();
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col){
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }
    
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public void add(ArrayList<String> value)
    {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 2);
    }
}