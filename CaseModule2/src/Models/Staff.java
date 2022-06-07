package Models;

public class Staff extends Guest{
    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Staff() {

    }

    public Staff(String id, String password, String name, String phoneNumber, String address, String idCard) {
        super(id, password, name, phoneNumber, address);
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return super.toString()+
                "," + idCard;
    }
    public String shownv(){
        return super.showGuest()+ " Số CMT/CCCD: "+idCard;
    }
}
