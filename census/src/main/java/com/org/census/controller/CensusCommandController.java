package com.org.census.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.org.census.dto.Response;
import com.org.census.dto.StatusEnum;
import com.org.census.exception.AppValidationException;
import com.org.census.service.CensusCommandService;

/**
 * This is the REST controller for handing the input data file
 */
@RestController
@RequestMapping("/upload")
public class CensusCommandController {

	@Autowired
	private CensusCommandService censusService;

	/**
	 * this method does the upload of data file
	 * 
	 * @param file
	 * @return
	 * @throws ValidationException
	 */
	@PostMapping
	public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) throws AppValidationException {
		censusService.saveCensusDetails(file);
		return ResponseEntity.ok(new Response(StatusEnum.SUCCESS));
	}

}