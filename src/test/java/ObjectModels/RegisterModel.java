package ObjectModels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterModel {

    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private String telephone;
    private String password;
    private String confirmPassword;
    private String loginErr;

    // No-argument constructor for Jackson
    public RegisterModel() {
    }

    // Constructor to initialize fields directly (used for SQL results or JSON parsing)
    @JsonCreator
    public RegisterModel(@JsonProperty("firstName") String firstName,
                         @JsonProperty("lastName") String lastName,
                         @JsonProperty("email") String email,
                         @JsonProperty("street") String street,
                         @JsonProperty("city") String city,
                         @JsonProperty("postalCode") String postalCode,
                         @JsonProperty("state") String state,
                         @JsonProperty("country") String country,
                         @JsonProperty("telephone") String telephone,
                         @JsonProperty("password") String password,
                         @JsonProperty("confirmPassword") String confirmPassword,
                         @JsonProperty("loginErr") String loginErr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.telephone = telephone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.loginErr = loginErr;
    }

    @Override
    public String toString() {
        return "RegisterModel {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", loginErr='" + loginErr + '\'' +
                '}';
    }
}
