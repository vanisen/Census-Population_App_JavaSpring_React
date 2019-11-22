package com.org.census.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.org.census.dao.CensusRepo;

/**
 * this is the service class for getting data from database
 */
@Service
public class CensusQueryService {

  @Autowired
  private CensusRepo populationRepository;

  /**
   * Return all zipcodes which have a total population within range provided by the client from database
   * @param start
   * @param end
   * @return
   */
  public List<Long> getZipCodesHavingPopulationInGivenRange(final Long start, final Long end) {
    return populationRepository.findZipCodeForPopulationRange(start, end);
  }

  /**
   * Return all zipcodes which have a median age within a range provided by the client from database
   * @param start
   * @param end
   * @return
   */
  public List<Long> getZipCodesHavingMedianInGivenRange(final Double start, final Double end) {
    return populationRepository.findZipCodeForMedianRange(start, end);
  }

  /**
   * Return top X number of most populated zipcodes from database
   * @param top
   * @return
   */
  public List<Long> getTopMostPopulatedZipCodes(final int top) {
     return populationRepository.getTopMostPopulatedZipCodes(PageRequest.of(0, top));
  }

  /**
   * Return all zipcodes with more females than males ordered by the difference descending  from database
   * @return
   */
  public List<Long> getZipCodesWithMoreFemales() {
    return populationRepository.getZipCodesWithMoreFemales();
  }
}
