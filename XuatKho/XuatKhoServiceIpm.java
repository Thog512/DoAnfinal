package XuatKho;

import java.util.List;

public class XuatKhoServiceIpm implements XuatKhoService{
    private XuatKhoService xuatKho = null;
    
    public XuatKhoServiceIpm(){
        xuatKho = new XuatKhoIpm();
    }

    @Override
    public List<XuatKho> getList() {
        return xuatKho.getList();
    }
    
}
