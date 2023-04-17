package MobilePhone;

import java.util.List;

public class MobilePhoneServiceIpm implements MobilePhoneService{
    private MobilePhoneService mobilePhone = null;
    
    public MobilePhoneServiceIpm(){
        mobilePhone = new MobilePhoneIpm();
    }

    @Override
    public List<MobilePhone> getList() {
        return mobilePhone.getList();
    }
    
    
}