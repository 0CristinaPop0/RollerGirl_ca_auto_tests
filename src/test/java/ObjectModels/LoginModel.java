package ObjectModels;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginModel {

    private String username;
    private String email;
    private String password;
    private String loginErr;

    // Constructor to initialize fields directly (used for SQL results)
    public LoginModel(String username, String email, String password, String loginErr) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.loginErr = loginErr;
    }

    @Override
    public String toString() {
        return "LoginModel {" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loginErr='" + loginErr + '\'' +
                '}';
    }
}
