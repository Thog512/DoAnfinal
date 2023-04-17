package NhapKho;

import dienThoai.connectsql;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhapKhoIpm implements NhapKhoService{
    
    @Override
    public List<NhapKho> getList(){
        try {
            Connection cons = connectsql.getConnection();
            String sql = "Select * from NhapKho";
            List<NhapKho> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall (sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhapKho nhapKho = new NhapKho();
                nhapKho.setMaNhapKho(rs.getString("MaNhapKho"));
                nhapKho.setTenDienThoai(rs.getString("TenDienThoai"));
                nhapKho.setSoLuong(rs.getString("SoLuong"));
                nhapKho.setNhaCungCap(rs.getString("NhaCungCap"));
                nhapKho.setNgayNhap(rs.getString("NgayNhap"));
                list.add(nhapKho);
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
        NhapKhoService nhapKho = new NhapKhoIpm();
        System.out.println(nhapKho.getList());
    }
}