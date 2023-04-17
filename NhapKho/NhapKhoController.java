package NhapKho;

import javax.swing.JButton;
import javax.swing.JTextField;

public class NhapKhoController {
    private JButton btnAdd;
    private JTextField jtfMaNhapKho;
    private JTextField jtfTenDienThoai;
    private JTextField jtfSoLuong;
    private JTextField jtfNhaCungCap;
    private JTextField jtfNgayNhap;

    public NhapKhoController(JButton btnAdd, JTextField jtfMaNhapKho, JTextField jtfTenDienThoai, JTextField jtfSoLuong, JTextField jtfNhaCungCap, JTextField jtfNgayNhap) {
        this.btnAdd = btnAdd;
        this.jtfMaNhapKho = jtfMaNhapKho;
        this.jtfTenDienThoai = jtfTenDienThoai;
        this.jtfSoLuong = jtfSoLuong;
        this.jtfNhaCungCap = jtfNhaCungCap;
        this.jtfNgayNhap = jtfNgayNhap;
    }

    
    public void setView(NhapKho nhapKho){
        jtfMaNhapKho.setText( nhapKho.getMaNhapKho());
        jtfTenDienThoai.setText(nhapKho.getTenDienThoai());
        jtfSoLuong.setText(nhapKho.getSoLuong());
        jtfNhaCungCap.setText(nhapKho.getNhaCungCap());
        jtfNgayNhap.setText(nhapKho.getNgayNhap());
    }
    
}