package com.mrcool.data.entities;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "officers")
public class Officer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Rank rank;

	private String firstName;

	private String lastName;

	public Officer(Rank rank, String firstName, String lastName) {
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
