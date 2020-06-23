package com.myschool.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.entity.AddressEntity;
import com.myschool.entity.UserEntity;
import com.myschool.repository.UserRepository;

@Component
public class UserServiceUtils {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * public static boolean readDataFromCSV(MultipartFile file) { try {
	 * InputStreamReader isr=new InputStreamReader(file.getInputStream()); CSVReader
	 * csv=new CSVReaderBuilder(isr).withSkipLines(1).build(); List<String[]>
	 * rows=csv.readAll(); for(String[] row:rows) { UserEntity user=new
	 * UserEntity(); user.setFirstName(row[0]); user.setLastName(row[1]);
	 * user.setFatherName(row[2]); user.setMotherName(row[3]);
	 * //user.setImage(row[4]); user.setUserName(row[5]); user.setPassword(row[6]);
	 * user.setEmail(row[7]); user.setPhone(row[8]); user.setRoles(row[9]);
	 * user.setPermissions(row[10]); user.setDateOfBirth(row[11]);
	 * user.setJoiningDate(row[12]); user.setEndingDate(row[13]);
	 * user.setSchoolId(row[14]); user.setCategoryId(row[15]);
	 * 
	 * userRepo.save(user); } return true; } catch (Exception e) { return false; } }
	 */
	public boolean readDataFromJson(MultipartFile file) {
		try {
			InputStream is = file.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			List<UserEntity> users = Arrays.asList(mapper.readValue(is, UserEntity[].class));
			if (users != null && users.size() > 0) {
				for (UserEntity user : users) {
					userRepo.save(user);
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean readDataFromExecl(MultipartFile file) {
		Workbook wb = getWorkBook(file);
		Sheet sheet = wb.getSheetAt(0);
		List<UserEntity> users = new ArrayList<>();
		Iterator<Row> rows = sheet.iterator();
		rows.next();
		while (rows.hasNext()) {
			Row row = rows.next();
			UserEntity user = new UserEntity();
			if (row.getCell(0).getCellType() == CellType.STRING) {
				user.setFirstName(row.getCell(0).getStringCellValue());
			}
			if (row.getCell(1).getCellType() == CellType.STRING) {
				user.setLastName(row.getCell(1).getStringCellValue());
			}
			if (row.getCell(2).getCellType() == CellType.STRING) {
				user.setFatherName(row.getCell(2).getStringCellValue());
			}
			if (row.getCell(3).getCellType() == CellType.STRING) {
				user.setMotherName(row.getCell(3).getStringCellValue());
			}
			if (row.getCell(4).getCellType() == CellType.STRING) {
				user.setUserName(row.getCell(4).getStringCellValue());
			}
			if (row.getCell(5).getCellType() == CellType.STRING) {
				// user.setPassword(row.getCell(5).getStringCellValue());
				user.setPassword(passwordEncoder.encode(row.getCell(5).getStringCellValue()));
			}
			if (row.getCell(6).getCellType() == CellType.STRING) {
				user.setEmail(row.getCell(6).getStringCellValue());
			}
			if (row.getCell(7).getCellType() == CellType.NUMERIC) {
				String phone = NumberToTextConverter.toText(row.getCell(7).getNumericCellValue());
				user.setPhone(phone);
			} else if (row.getCell(7).getCellType() == CellType.STRING) {
				user.setPhone(row.getCell(7).getStringCellValue());
			}
			if (row.getCell(8).getCellType() == CellType.STRING) {
				user.setRoles(row.getCell(8).getStringCellValue());
			}
			if (row.getCell(9).getCellType() == CellType.STRING) {
				user.setPermissions(row.getCell(9).getStringCellValue());
			}
			if (row.getCell(10).getCellType() == CellType.NUMERIC) {
				user.setSchoolId((long) row.getCell(10).getNumericCellValue());
			}
			if (row.getCell(11).getCellType() == CellType.NUMERIC) {
				user.setCategoryId((long) row.getCell(11).getNumericCellValue());
			}
			if (row.getCell(12).getCellType() == CellType.NUMERIC) {
				user.setDateOfBirth(row.getCell(12).getDateCellValue());
			}
			if (row.getCell(13).getCellType() == CellType.NUMERIC) {
				user.setJoiningDate(row.getCell(13).getDateCellValue());
			}
			if (row.getCell(14).getCellType() == CellType.NUMERIC) {
				user.setEndingDate(row.getCell(14).getDateCellValue());
			}
			if (row.getCell(23).getCellType() == CellType.NUMERIC) {
				user.setGenderId((long) row.getCell(23).getNumericCellValue());
			}
			if (row.getCell(24).getCellType() == CellType.STRING) {
				user.setCaste( row.getCell(24).getStringCellValue());
			}
			if (row.getCell(25).getCellType() == CellType.STRING) {
				user.setReligion( row.getCell(23).getStringCellValue());
			}
			if (row.getCell(23).getCellType() == CellType.STRING) {
				user.setIdProof( row.getCell(23).getStringCellValue());
			}
			AddressEntity address = new AddressEntity();
			
			if (row.getCell(15).getCellType() == CellType.STRING) {
				address.setHouseNum(row.getCell(15).getStringCellValue());
			}
			if (row.getCell(16).getCellType() == CellType.STRING) {
				address.setStreet(row.getCell(16).getStringCellValue());
			}
			if (row.getCell(17).getCellType() == CellType.STRING) {
				address.setVillage(row.getCell(17).getStringCellValue());
			}
			if (row.getCell(18).getCellType() == CellType.STRING) {
				address.setLandmark(row.getCell(18).getStringCellValue());
			}
			if (row.getCell(19).getCellType() == CellType.STRING) {
				address.setMandal(row.getCell(19).getStringCellValue());
			}
			if (row.getCell(20).getCellType() == CellType.STRING) {
				address.setDistrict(row.getCell(20).getStringCellValue());
			}
			if (row.getCell(21).getCellType() == CellType.STRING) {
				address.setState(row.getCell(21).getStringCellValue());
			}
			if (row.getCell(22).getCellType() == CellType.NUMERIC) {
				String pincode = NumberToTextConverter.toText(row.getCell(22).getNumericCellValue());
				address.setPincode(pincode);
			} else if (row.getCell(22).getCellType() == CellType.STRING) {
				address.setPincode(row.getCell(22).getStringCellValue());
			}
			user.setAddress(address);
			// need to add image from excel file row
			users.add(user);
		}
		userRepo.saveAll(users);
		return true;
	}

	public Workbook getWorkBook(MultipartFile file) {
		Workbook wb = null;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		try {
			if (extension.equalsIgnoreCase("xlsx")) {
				wb = new XSSFWorkbook(file.getInputStream());
			} else if (extension.equalsIgnoreCase("xls")) {
				wb = new HSSFWorkbook(file.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb;
	}
}
