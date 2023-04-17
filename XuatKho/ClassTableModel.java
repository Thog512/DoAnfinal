package XuatKho;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    public DefaultTableModel setTableXuatKho(List<XuatKho> listItem, String[] listColumn){
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
                XuatKho xuatKho = listItem.get(i);
                obj = new Object[columns];
                obj[0]=xuatKho.getMaXuatKho();
                obj[1] = xuatKho.getTenDienThoai();
                obj[2] = xuatKho.getSoLuong();
                obj[3] = xuatKho.getNoiNhan();
                obj[4] = xuatKho.getNgayXuat();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
