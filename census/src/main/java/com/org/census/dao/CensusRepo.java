package com.org.census.dao;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.census.entity.Census;

/**
 * this the Census entity repository
 */
@Repository
public interface CensusRepo extends CrudRepository<Census, Long>{

  @Query("SELECT c.zipCode FROM Census c WHERE c.totalPopulation BETWEEN ?1 AND ?2")
  List<Long> findZipCodeForPopulationRange(Long start, Long end);

  @Query("SELECT c.zipCode FROM Census c WHERE c.medianAge BETWEEN ?1 AND ?2")
  List<Long> findZipCodeForMedianRange(Double start, Double Double);

  @Query("select c.zipCode FROM Census c order by c.totalPopulation DESC")
  List<Long> getTopMostPopulatedZipCodes(PageRequest page);

  @Query("select c.zipCode, (c.totalFemales - c.totalMales) as females from Census c order by females desc")
  List<Long> getZipCodesWithMoreFemales();
}
