package MobilePhone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyMobilePhoneController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private MobilePhoneService mobilePhoneService = null;
    
    private String[] listColumn={"Hệ điều hành","Mã điện thoại","Tên điện thoại","Đơn giá","Số lượng","Loại"};
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyMobilePhoneController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.mobilePhoneService = new MobilePhoneServiceIpm();
    }
    
    public void setDataToModel(){
        List<MobilePhone> listItem = mobilePhoneService.getList();
        DefaultTableModel model = new ClassTableModel().setTableSanPham(listItem, listColumn);
        
        JTable table = new JTable(model);
        rowSorter=new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text =jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text =jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               
            }
        });
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.getRowHeight(50);
        
        table.validate();
        table.repaint();
        
        table.addMouseListener (new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                
                MobilePhone mobilePhone = new MobilePhone();
                mobilePhone.setHeDieuHanh(model.getValueAt(selectedRowIndex, 0).toString());
                mobilePhone.setMaDT(model.getValueAt(selectedRowIndex, 1).toString());
                mobilePhone.setTenDT(model.getValueAt(selectedRowIndex, 2).toString());
                mobilePhone.setDonGia(model.getValueAt(selectedRowIndex, 3).toString());
                mobilePhone.setSoLuong(model.getValueAt(selectedRowIndex, 4).toString());
                mobilePhone.setNutBam(model.getValueAt(selectedRowIndex, 5).toString());
                
                MobilePhoneUpdateJFrame frame =new MobilePhoneUpdateJFrame(mobilePhone);
                frame.setTitle("Thong tin MobliePhone");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        }
    });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();     
    }
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               MobilePhoneJFrame jframe = new MobilePhoneJFrame(new MobilePhone());
               jframe.setTitle("Thêm Thông Tin MobliePhone");
               jframe.setLocationRelativeTo(null);
               jframe.setResizable(false);
               jframe.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0,200,83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100,221,23));
            }
            
        });
    }
}