package MobilePhone;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    public DefaultTableModel setTableSanPham(List<MobilePhone> listItem, String[] listColumn){
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
                MobilePhone mobilePhone = listItem.get(i);
                obj = new Object[columns];
                obj[0] = mobilePhone.getHeDieuHanh();
                obj[1] = mobilePhone.getMaDT();
                obj[2] = mobilePhone.getTenDT();
                obj[3] = mobilePhone.getDonGia();
                obj[4] = mobilePhone.getSoLuong();
                obj[5] = mobilePhone.getNutBam();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}