package XuatKho;

import javax.swing.JButton;
import javax.swing.JTextField;

public class XuatKhoController {
    private JButton btnAdd;
    private JTextField jtfMaXuatKho;
    private JTextField jtfTenDienThoai;
    private JTextField jtfSoLuong;
    private JTextField jtfNoiNhan;
    private JTextField jtfNgayXuat;

    public XuatKhoController(JButton btnAdd, JTextField jtfMaXuatKho, JTextField jtfTenDienThoai, JTextField jtfSoLuong, JTextField jtfNoiNhan, JTextField jtfNgayXuat) {
        this.btnAdd = btnAdd;
        this.jtfMaXuatKho = jtfMaXuatKho;
        this.jtfTenDienThoai = jtfTenDienThoai;
        this.jtfSoLuong = jtfSoLuong;
        this.jtfNoiNhan = jtfNoiNhan;
        this.jtfNgayXuat = jtfNgayXuat;
    }

 
    public void setView(XuatKho xuatKho){
        jtfMaXuatKho.setText( xuatKho.getMaXuatKho());
        jtfTenDienThoai.setText(xuatKho.getTenDienThoai());
        jtfSoLuong.setText(xuatKho.getSoLuong());
        jtfNoiNhan.setText(xuatKho.getNoiNhan());
        jtfNgayXuat.setText(xuatKho.getNgayXuat());
    }
    
}