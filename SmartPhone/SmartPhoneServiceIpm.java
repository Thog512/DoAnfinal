package SmartPhone;

import java.util.List;

public class SmartPhoneServiceIpm implements SmartPhoneService{
    private SmartPhoneService smartPhone = null;
    
    public SmartPhoneServiceIpm(){
        smartPhone = new SmartPhoneIpm();
    }

    @Override
    public List<SmartPhone> getList() {
        return smartPhone.getList();
    }
    
    
}