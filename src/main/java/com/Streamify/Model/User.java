package com.Streamify.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[User]" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FirstName")
    private String FirstName;
    @Column(name = "PassWord")
    private String Password;
    @Column(name = "LastName")
    private String LastName;
    @Column(name = "Email")
    private String Email;
    @Column (name = "IsAdmin")
    private Boolean IsAdmin;


}
