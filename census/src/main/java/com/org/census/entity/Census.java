package com.org.census.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * this is the entry to save all records of data file
 */
@Entity
@Table(name = "CENSUS")
@Getter
@Setter
@EqualsAndHashCode(exclude = { "id" })
@ToString(exclude = { "id" })
@NoArgsConstructor
public class Census {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(unique = true)
	private Long zipCode;
	private Long totalPopulation;
	private Double medianAge;
	private Long totalMales;
	private Long totalFemales;
	private Long totalHouseholds;
	private Double averageHouseholdSize;

	public Census(final Long zipCode, final Long totalPopulation, final Double medianAge, final Long totalMales,
			final Long totalFemales, final Long totalHouseholds, final Double averageHouseholdSize) {
		this.zipCode = zipCode;
		this.totalPopulation = totalPopulation;
		this.medianAge = medianAge;
		this.totalMales = totalMales;
		this.totalFemales = totalFemales;
		this.totalHouseholds = totalHouseholds;
		this.averageHouseholdSize = averageHouseholdSize;
	}
}
