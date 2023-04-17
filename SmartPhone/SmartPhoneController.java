 package SmartPhone;

import javax.swing.JButton;
import javax.swing.JTextField;

public class SmartPhoneController {
    private JButton btnAdd;
    private JTextField jtfHeDieuHanh;
    private JTextField jtfMaDT;
    private JTextField jtfTenDienThoai;
    private JTextField jtfDonGia;
    private JTextField jtfSoLuong;

    public SmartPhoneController(JButton btnAdd, JTextField jtfHeDieuHanh, JTextField jtfMaDT, JTextField jtfTenDienThoai, JTextField jtfDonGia, JTextField jtfSoLuong) {
        this.btnAdd = btnAdd;
        this.jtfHeDieuHanh = jtfHeDieuHanh;
        this.jtfMaDT = jtfMaDT;
        this.jtfTenDienThoai = jtfTenDienThoai;
        this.jtfDonGia = jtfDonGia;
        this.jtfSoLuong = jtfSoLuong;
    }

    
    
    public void setView(SmartPhone smartPhone){
        jtfHeDieuHanh.setText(smartPhone.getHeDieuHanh());
        jtfMaDT.setText(smartPhone.getMaDT());
        jtfTenDienThoai.setText(smartPhone.getTenDT());
        jtfDonGia.setText(smartPhone.getDonGia());
        jtfSoLuong.setText(smartPhone.getSoLuong());
    }
    
}