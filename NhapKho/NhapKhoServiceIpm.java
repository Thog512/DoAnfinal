package NhapKho;

import java.util.List;

public class NhapKhoServiceIpm implements NhapKhoService{
    private NhapKhoService nhapKho = null;
    
    public NhapKhoServiceIpm(){
        nhapKho = new NhapKhoIpm();
    }

    @Override
    public List<NhapKho> getList() {
        return nhapKho.getList();
    }
    
    
}