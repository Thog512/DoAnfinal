package SmartPhone;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    public DefaultTableModel setTableSmartPhone(List<SmartPhone> listItem, String[] listColumn){
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
                SmartPhone smartPhone = listItem.get(i);
                obj = new Object[columns];
                obj[0] = smartPhone.getHeDieuHanh();
                obj[1] = smartPhone.getMaDT();
                obj[2] = smartPhone.getTenDT();
                obj[3] = smartPhone.getDonGia();
                obj[4] = smartPhone.getSoLuong();
                obj[5] = smartPhone.getCamUng();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}