import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {
    private String userID;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPhone;
    private String userPasswordHash;
    private List<String> ownList;
    private List<String> requestList;

    public User(String id, String fName, String lName, String email, String phone, String password) {
        userID = id;
        userFirstName = fName;
        userLastName = lName;
        userEmail = email;
        userPhone = phone;
        userPasswordHash = hashPassword(password);
    }

    private String hashPassword(String password) {
        String passwordHash = null;
        try {
            MessageDigest msg = MessageDigest.getInstance("MD5");
            msg.update(password.getBytes());
            byte[] bytes = msg.digest();
            StringBuilder str = new StringBuilder();
            for (byte aByte : bytes) {
                str.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            passwordHash = str.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordHash;
    }

    public void setUserID(String id) {
        userID = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserFirstName(String fName) {
        userFirstName = fName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserLastName(String lName) {
        userLastName = lName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserEmail(String email) {
        userEmail = email;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPhone(String phone) {
        userPhone = phone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public boolean checkPassword(String password) {
        return userPasswordHash.equals(hashPassword(password));
    }
}
