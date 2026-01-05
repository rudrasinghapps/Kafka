package com.delivery.boy.payload;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    private int empId;
    private String name;
    private String city;
    private String companyName;
    private String role;
    private int exp;

}
