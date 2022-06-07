package Models;

public class Guest {
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;

    public Guest() {
    }

    public Guest(String id, String password, String name, String phoneNumber, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + "," + password + "," + name + ","+ phoneNumber +
                "," + address;
    }
    public String showGuest(){
        return "Tên tài khoản"+ id + " Mật khẩu: "+password+ "Tên : "+name+ " Số điện thoại: "+phoneNumber+ " Địa chỉ: "+address;
    }
}
