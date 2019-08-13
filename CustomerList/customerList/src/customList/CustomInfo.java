package customList;

public class CustomInfo {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String accountNum;
    private String address;

    public CustomInfo(int id, String name, String phone, String email, String accountNum, String address){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.accountNum = accountNum;
        this.address = address;
    }

    public int getId(){ return id; }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public String getAccountNum(){
        return accountNum;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public String toString(){
        return "id: " + this.id + ", name: " + this.name + ", phone: " + this.phone + ", email: " + this.email +
                ", account number: " + this.accountNum + ", address: " + this.address ;
    }
}
