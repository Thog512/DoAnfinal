package SmartPhone;

import dienThoai.connectsql;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SmartPhoneIpm implements SmartPhoneService{
    
    @Override
    public List<SmartPhone> getList(){
        try {
            Connection cons = connectsql.getConnection();
            String sql = "Select * from SmartPhone";
            List<SmartPhone> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall (sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SmartPhone smartPhone = new SmartPhone();
                smartPhone.setHeDieuHanh(rs.getString("HeDieuHanh"));
                smartPhone.setMaDT(rs.getString("MaDT"));
                smartPhone.setTenDT(rs.getString("TenDT"));
                smartPhone.setDonGia(rs.getString("DonGia"));
                smartPhone.setSoLuong(rs.getString("SoLuong"));
                list.add(smartPhone);
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
        SmartPhoneService smartPhone = new SmartPhoneIpm();
        System.out.println(smartPhone.getList());
    }
}