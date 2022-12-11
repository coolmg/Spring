package com.mrcool.data.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Officer {
    private Integer id;
    private Rank rank;
    private String firstName;
    private String lastName;

    public Officer(Rank rank, String firstName, String lastName) {
        this.rank = rank;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
