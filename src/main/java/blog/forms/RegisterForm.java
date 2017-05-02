package blog.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

/**
 * Created by Windows 7 on 01-May-17.
 */
public class RegisterForm {

    @Column(nullable = false, length = 30, unique = true)
    @NotEmpty
    String username;

    @Column(length = 60)
    @NotEmpty
    String fullName;

    @Column(length = 100)
    @NotEmpty
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

