package com.cydeo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;

}