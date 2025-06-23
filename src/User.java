public class User {
    private static int count=1;

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Profile profile;
    private UserType userType;
    private String location;
    public enum UserType {
        CUSTOMER,
        ADMIN
    }

    public User(String name, String email, String password,  String phoneNumber, UserType userType, String location) {
        this.id = count++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.location = location;
        System.out.println("User created with ID: " + this.id);
    }

    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }
    public String getLocation() {
        return location;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void getUserDetails() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("User Type: " + userType);
        if (profile != null) {
            profile.getProfileDetails();
        }else {
            System.out.println("No profile details available.");
        }
    }
}
