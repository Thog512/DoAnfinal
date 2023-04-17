package XuatKho;

import dienThoai.connectsql;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XuatKhoIpm implements XuatKhoService{
    
    @Override
    public List<XuatKho> getList(){
        try {
            Connection cons = connectsql.getConnection();
            String sql = "Select * from XuatKho";
            List<XuatKho> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall (sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                XuatKho xuatKho = new XuatKho();
                xuatKho.setMaXuatKho(rs.getString("MaXuatKho"));
                xuatKho.setTenDienThoai(rs.getString("TenDienThoai"));
                xuatKho.setSoLuong(rs.getString("SoLuong"));
                xuatKho.setNoiNhan(rs.getString("NoiNhan"));
                xuatKho.setNgayXuat(rs.getString("NgayXuat"));
                list.add(xuatKho);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
}

    public static void main(String[] args){
        XuatKhoService xuatKho = new XuatKhoIpm();
        System.out.println(xuatKho.getList());
    }
}