package dienThoai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import SmartPhone.SmartPhoneJpn;
import NhapKho.NhapKhoJpn;
import MobilePhone.MobilePhoneJpn;
import XuatKho.XuatKhoJpn;

public class chuyenController {
    private JPanel root;
    private String kindSelected;
    private List<danhMuc> listItem=null;
    
    public chuyenController(JPanel jpnRoot){
        this.root=jpnRoot;
    }
    
    public void setView(JPanel jpnItem,JLabel jlbItem){
        kindSelected="Welcome";
        jpnItem.setBackground(new Color(70,80,100));
        jlbItem.setBackground(new Color(70,80,100));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new WelcomeJpn());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<danhMuc> listItem){
        this.listItem=listItem;
        
        for (danhMuc item:listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case"SmartPhone":
                    node=new SmartPhoneJpn();
                    break;
                case"MobilePhone":
                    node=new MobilePhoneJpn();
                    break;
                case"NhapKho":
                    node=new NhapKhoJpn();
                    break;
                case"XuatKho":
                    node=new XuatKhoJpn();
                    break;
                default:
                    node=new WelcomeJpn();
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected=kind;
            jpnItem.setBackground(new Color(70,80,100));
            jlbItem.setBackground(new Color(70,80,100));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           jpnItem.setBackground(new Color(70,80,100));
           jlbItem.setBackground(new Color(70,80,100));
        }

        @Override
        public void mouseExited(MouseEvent e) {
           if(!kindSelected.equalsIgnoreCase(kind)){
               jpnItem.setBackground(new Color(51,255,51));
               jlbItem.setBackground(new Color(51,255,51));
           }
        }
        private void setChangeBackground(String kind){
            for (danhMuc item : listItem) {
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setBackground(new Color(70,80,100));
                    item.getJpn().setBackground(new Color(70,80,100));
                }
                else{
                    item.getJlb().setBackground(new Color(51,255,51));
                    item.getJpn().setBackground(new Color(51,255,51));
                }
            }
        }
    }
}
