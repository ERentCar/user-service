package com.rentCar.userservice.Entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String names;

    @NotNull
    @Size(max = 100)
    private String lastNames;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 20)
    private String password;

    private Long contactNumber;

    @NotNull
    private Long dni;

    private String image;

    private Double rating;

}
