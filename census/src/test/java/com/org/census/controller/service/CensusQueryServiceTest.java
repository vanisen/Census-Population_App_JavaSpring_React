package com.org.census.controller.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import com.org.census.dao.CensusRepo;
import com.org.census.service.CensusQueryService;

@RunWith(MockitoJUnitRunner.class)
public class CensusQueryServiceTest {

	@Mock
	private CensusRepo repo;

	@InjectMocks
	private CensusQueryService service;

	private List<Long> zipcodes;
	
	@Before
	public void init() {
		zipcodes  = new ArrayList<>();
		zipcodes.add(1001l);
		zipcodes.add(1012l);
		zipcodes.add(4012l);
		zipcodes.add(4044l);
	}
	
	@Test
	public void getZipCodesBasedOnRange() {
		when(repo.findZipCodeForPopulationRange(Mockito.any(), Mockito.any())).thenReturn(zipcodes);
		List<Long> result = repo.findZipCodeForPopulationRange(10l,  20l);
		Assert.assertTrue(result.equals(zipcodes));
	}

	@Test
	public void getZipCodesBasedOnMedianAge() {
		when(repo.findZipCodeForMedianRange(Mockito.any(), Mockito.any())).thenReturn(zipcodes);
		List<Long> result = repo.findZipCodeForMedianRange(10.0,  20.0);
		Assert.assertTrue(result.equals(zipcodes));
	}

	@Test
	public void getTopZipCodes() {
		when(repo.getTopMostPopulatedZipCodes(Mockito.any())).thenReturn(zipcodes);
		List<Long> result = repo.getTopMostPopulatedZipCodes(PageRequest.of(0, 10));
		Assert.assertTrue(result.equals(zipcodes));
	}

	@Test
	public void getGenderDiffZipCodes() {
		when(repo.getZipCodesWithMoreFemales()).thenReturn(zipcodes);
		List<Long> result = repo.getZipCodesWithMoreFemales();
		Assert.assertTrue(result.equals(zipcodes));
	}

}
