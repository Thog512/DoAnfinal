package MobilePhone;

import dienThoai.connectsql;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobilePhoneIpm implements MobilePhoneService{
    
    @Override
    public List<MobilePhone> getList(){
        try {
            Connection cons = connectsql.getConnection();
            String sql = "Select * from MobilePhone";
            List<MobilePhone> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall (sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MobilePhone mobilePhone = new MobilePhone();
                mobilePhone.setHeDieuHanh(rs.getString("HeDieuHanh"));
                mobilePhone.setMaDT(rs.getString("MaDT"));
                mobilePhone.setTenDT(rs.getString("TenDT"));
                mobilePhone .setDonGia(rs.getString("DonGia"));
                mobilePhone.setSoLuong(rs.getString("SoLuong"));
                list.add(mobilePhone);
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
        MobilePhoneService mobilePhone = new MobilePhoneIpm();
        System.out.println(mobilePhone.getList());
    }
}