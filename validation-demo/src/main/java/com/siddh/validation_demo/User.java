package com.siddh.validation_demo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "password cannot be blank")
    @Size(min=6,max=20,message = "Password must be greater than equal to 6 and less than equal to 20")
    private String password;

    @Min(value = 18,message = "Age should be greater than equal to 18")
    @Max(value = 30, message = "Age should be less than equal to 30")
    private int age;

    @Positive(message = "Salary must be positive")
    private Double salary;

    @Digits(integer = 6,fraction = 2,message = "Account balance must not be greater than 6 figures")
    private Double accountBalance;

    @Email(message = "It should be in proper format")
    private String email;

    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@bounteous\\.com$" ,
            message = "Email should be in bounteous*Accolite company format")
    private String corporateMail;

    @Past(message = "date of birth must be some past date")
    private LocalDate dob;

    @Future(message = "Expiry must be some future date")
    private LocalDate userExpiry;

    @Size(min=1, message = "There must be at least one hobby for the user")
    @NotNull
    private List<String>hobbies;

    @PhoneNumber
    private String phoneNumber;
}
