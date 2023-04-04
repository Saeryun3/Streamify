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
@Table(name = "User" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(name = "First_Name")
    private String FirstName;
    @Column(name = "Last_Name")
    private String LastName;
    @Column(name = "Email_ID")
    private  String EmailID;


}
