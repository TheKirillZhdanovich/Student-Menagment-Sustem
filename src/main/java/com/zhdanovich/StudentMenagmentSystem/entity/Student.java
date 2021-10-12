package com.zhdanovich.StudentMenagmentSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(name = "unique_student_email", columnNames = "email")})
public class Student {

    @Id
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_generator"
    )
    @Column(
            name = "id",
            unique = true
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message = "Should not be empty")
    @Size(min = 1, max = 15, message = "Should be between 1 and 15")
    private String firstName;

    @Column(
            name = "second_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message = "Should not be empty")
    @Size(min = 1, max = 15, message = "Should be between 1 and 15")
    private String secondName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty(message = "Should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Student(){

    }

    public Student(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
