package MobilePhone;

import SmartPhone.SmartPhone;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MobilePhoneController {
    private JButton btnAdd;
    private JTextField jtfHeDieuHanh;
    private JTextField jtfMaDT;
    private JTextField jtfTenDienThoai;
    private JTextField jtfDonGia;
    private JTextField jtfSoLuong;

    public MobilePhoneController(JButton btnAdd, JTextField jtfHeDieuHanh, JTextField jtfMaDT, JTextField jtfTenDienThoai, JTextField jtfDonGia, JTextField jtfSoLuong) {
        this.btnAdd = btnAdd;
        this.jtfHeDieuHanh = jtfHeDieuHanh;
        this.jtfMaDT = jtfMaDT;
        this.jtfTenDienThoai = jtfTenDienThoai;
        this.jtfDonGia = jtfDonGia;
        this.jtfSoLuong = jtfSoLuong;
    }

    
    
    public void setView(MobilePhone mobilePhone){
        jtfHeDieuHanh.setText(mobilePhone.getHeDieuHanh());
        jtfMaDT.setText(mobilePhone.getMaDT());
        jtfTenDienThoai.setText(mobilePhone.getTenDT());
        jtfDonGia.setText(mobilePhone.getDonGia());
        jtfSoLuong.setText(mobilePhone.getSoLuong());
    }
    
}