package com.org.census.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.census.dto.StatusEnum;
import com.org.census.dto.ZipCodeResponse;
import com.org.census.service.CensusQueryService;

/**
 * this REST controller handles all query related operations
 */
@RestController
@RequestMapping("/census/population")
public class CensusQueryController {

	@Autowired
	private CensusQueryService censusQueryService;

	/**
	 * Return all zipcodes which have a total population within range provided by
	 * the client.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	@GetMapping("/range")
	public ResponseEntity<ZipCodeResponse> getZipCodesHavingPopulationInGivenRange(@RequestParam("start") Long start,
			@RequestParam("end") Long end) {
		List<Long> response = censusQueryService.getZipCodesHavingPopulationInGivenRange(start, end);
		return ResponseEntity.ok(new ZipCodeResponse(StatusEnum.SUCCESS, response));
	}

	/**
	 * Return all zipcodes which have a median age within a range provided by the
	 * client.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	@GetMapping("/medianage")
	public ResponseEntity<ZipCodeResponse> getZipCodesHavingMedianInGivenRange(@RequestParam("start") Double start,
			@RequestParam("end") Double end) {
		List<Long> response = censusQueryService.getZipCodesHavingMedianInGivenRange(start, end);
		return ResponseEntity.ok(new ZipCodeResponse(StatusEnum.SUCCESS, response));
	}

	/**
	 * Return top X number of most populated zipcodes.
	 * 
	 * @param top
	 * @return
	 */
	@GetMapping("/populated")
	public ResponseEntity<ZipCodeResponse> getTopMostPopulatedZipCodes(@RequestParam("top") int top) {
		List<Long> response = censusQueryService.getTopMostPopulatedZipCodes(top);
		return ResponseEntity.ok(new ZipCodeResponse(StatusEnum.SUCCESS, response));
	}

	/**
	 * Return all zipcodes with more females than males ordered by the difference
	 * descending.
	 * 
	 * @return
	 */
	@GetMapping("/diff/female")
	public ResponseEntity<ZipCodeResponse> getZipCodesWithMoreFemales() {
		List<Long> response = censusQueryService.getZipCodesWithMoreFemales();
		return ResponseEntity.ok(new ZipCodeResponse(StatusEnum.SUCCESS, response));
	}

}
