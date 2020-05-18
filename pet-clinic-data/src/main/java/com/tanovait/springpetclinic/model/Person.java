package com.tanovait.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    Person(Long id, String firstName, String secondName){
        super(id);
        this.firstName = firstName;
        this.lastName = secondName;
    }
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String lastName;
}
