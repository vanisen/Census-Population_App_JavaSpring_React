package com.org.census.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.org.census.dao.CensusRepo;
import com.org.census.dto.ProcessingError;
import com.org.census.dto.UploadFileProcessingResponse;
import com.org.census.entity.Census;
import com.org.census.exception.AppValidationException;
import com.org.census.exception.FileStorageException;

/**
 * this class does the saving of data records in database
 */
@Service
public class CensusCommandService {

	@Autowired
	private CensusRepo censusRepo;

	/**
	 * this method does line by line validation of file and saves its data in
	 * database
	 * 
	 * @param fileName
	 */
	public void saveCensusDetails(final String fileName) {
		List<String> duplicateProcessingErrorLines = new ArrayList<>();
		List<String> processingErrorLines = new ArrayList<>();
		Map<String, Census> uniqueRecords = new HashMap<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			boolean isFirstLine = true;
			while (line != null) {
				if (isFirstLine) {
					line = reader.readLine();
					isFirstLine = false;
					continue;
				} else {
					collectValidLine(line, processingErrorLines, duplicateProcessingErrorLines, uniqueRecords);
					line = reader.readLine();
				}
			}
			reader.close();
			censusRepo.saveAll(uniqueRecords.values());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (processingErrorLines.size() != 0 || duplicateProcessingErrorLines.size() != 0) {
			UploadFileProcessingResponse uploadFileProcessingResponse = handleProcessingErrors(processingErrorLines,
					duplicateProcessingErrorLines);
			throw new FileStorageException(uploadFileProcessingResponse);
		}

	}

	private UploadFileProcessingResponse handleProcessingErrors(final List<String> processingErrorLines,
			final List<String> duplicateProcessingErrorLines) {
		UploadFileProcessingResponse uploadFileProcessingResponse = new UploadFileProcessingResponse();
		uploadFileProcessingResponse.setHttpStatus(HttpStatus.OK);
		uploadFileProcessingResponse.setMessage("File processed with few errors");

		ProcessingError[] processingErrors = new ProcessingError[2];

		ProcessingError processingError = new ProcessingError();
		processingError.setReason("Error while parsing line");
		processingError.setErrorLines(processingErrorLines);
		processingErrors[0] = processingError;

		ProcessingError dupProcessingError = new ProcessingError();
		dupProcessingError.setReason("Error for duplicate entries");
		dupProcessingError.setErrorLines(duplicateProcessingErrorLines);
		processingErrors[1] = dupProcessingError;

		uploadFileProcessingResponse.setProcessingErrors(processingErrors);

		return uploadFileProcessingResponse;
	}

	/**
	 * this method saves each line in database
	 * 
	 * @param line
	 * @param errorLines
	 * @param duplicateProcessingErrorLines
	 * @param uniqueRecords
	 */
	@Transactional
	public void collectValidLine(final String line, final List<String> errorLines,
			final List<String> duplicateProcessingErrorLines, Map<String, Census> uniqueRecords) {

		String[] lineContent = line.split(",");
		if (lineContent.length != 7) {
			errorLines.add(line);
			return;
		}
		System.out.println("Persisting: " + line);
		try {
			Census cenus = getPopulation(lineContent);
			if (uniqueRecords.containsKey(cenus.toString())) {
				duplicateProcessingErrorLines.add(line);
			}
			uniqueRecords.put(cenus.toString(), cenus);

		} catch (AppValidationException ave) {
			errorLines.add(line);
		}

	}

	private Census getPopulation(final String[] populationDetails) throws AppValidationException {
		Census population = null;
		try {
			population = new Census(Long.valueOf(populationDetails[0]),
					Long.valueOf(Long.parseLong(populationDetails[1])), Double.valueOf(populationDetails[2]),
					Long.valueOf(Long.parseLong(populationDetails[3])),
					Long.valueOf(Long.parseLong(populationDetails[4])),
					Long.valueOf(Long.parseLong(populationDetails[5])), Double.valueOf(populationDetails[6]));
		} catch (Exception e) {
			throw new AppValidationException("Error while parsing line in " + populationDetails.toString());
		}

		return population;
	}

	public void saveCensusDetails(MultipartFile file) {
		List<String> duplicateProcessingErrorLines = new ArrayList<>();
		List<String> processingErrorLines = new ArrayList<>();
		Map<String, Census> uniqueRecords = new HashMap<>();
		BufferedReader reader;
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(file.getBytes());
			reader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
			String line = reader.readLine();
			boolean isFirstLine = true;
			while (line != null) {
				if (isFirstLine) {
					line = reader.readLine();
					isFirstLine = false;
					continue;
				} else {
					collectValidLine(line, processingErrorLines, duplicateProcessingErrorLines, uniqueRecords);
					line = reader.readLine();
				}
			}
			reader.close();
			censusRepo.saveAll(uniqueRecords.values());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (processingErrorLines.size() != 0 || duplicateProcessingErrorLines.size() != 0) {
			UploadFileProcessingResponse uploadFileProcessingResponse = handleProcessingErrors(processingErrorLines,
					duplicateProcessingErrorLines);
			throw new FileStorageException(uploadFileProcessingResponse);
		}

	}
}
