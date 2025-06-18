package com.example.register.dto;

import com.example.register.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Validator {
    private String Firstname;
    private String Lastname;
    private String Phonenumber;
    private int Age;
    private String Email;

    private static final Pattern PHONE_PATTERN = Pattern.compile("^(0|\\+84|84)[0-9]{9}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getFirstname() == null || user.getFirstname().trim().isEmpty()) {
            errors.rejectValue("Firstname", "Firstname.empty", "Họ không được để trống");
        } else if (user.getFirstname().length() < 5 || user.getFirstname().length() > 45) {
            errors.rejectValue("Firstname", "Firstname.length", "Họ phải từ 5 đến 45 ký tự");
        }
        if (user.getLastname() == null || user.getLastname().trim().isEmpty()) {
            errors.rejectValue("Lastname", "Lastname.empty", "Tên không được để trống");
        } else if (user.getLastname().length() < 5 || user.getLastname().length() > 45) {
            errors.rejectValue("Lastname", "Lastname.length", "Tên phải từ 5 đến 45 ký tự");
        }
        if (user.getPhonenumber() == null || user.getPhonenumber().trim().isEmpty()) {
            errors.rejectValue("Phonenumber", "Phonenumber.empty", "Số điện thoại không được để trống");
        } else if (!PHONE_PATTERN.matcher(user.getPhonenumber()).matches()) {
            errors.rejectValue("Phonenumber", "Phonenumber.invalid", "Số điện thoại không đúng định dạng");
        }

        if (user.getAge() < 18) {
            errors.rejectValue("Age", "Age.invalid", "Tuổi phải từ 18 trở lên");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            errors.rejectValue("Email", "Email.empty", "Email không được để trống");
        } else if (!EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            errors.rejectValue("Email", "Email.invalid", "Email không đúng định dạng");
        }
    }
}
