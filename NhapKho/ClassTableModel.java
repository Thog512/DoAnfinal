package NhapKho;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    public DefaultTableModel setTableNhapKho(List<NhapKho> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows>0){
            for (int i=0; i<rows; i++){
                NhapKho nhapKho = listItem.get(i);
                obj = new Object[columns];
                obj[0]=nhapKho.getMaNhapKho();
                obj[1] = nhapKho.getTenDienThoai();
                obj[2] = nhapKho.getSoLuong();
                obj[3] = nhapKho.getNhaCungCap();
                obj[4] = nhapKho.getNgayNhap();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}