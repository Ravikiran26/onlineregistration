package com.registration.Dto;

import java.util.Iterator;
import java.util.Set;

import com.registration.Model.Roles;
import com.registration.Model.User;
import java.lang.Iterable;;

public class UserDto {

	/**
	 * 
	 */
	private static final Long serialVerionalId = 1l;

	private Long id;
	private String name;
	private String displayName;

	private String firstName;
	private String lastName;

	private String phoneNumber;
	private String dateOfBirth;
	private String yearOfBirth;
	private String gender;
	private String country;
	private String countryCode;
	private String status;
	private String academy;
	private String clubCode;
	private String otp;
	private String responseStatus;
	private String responseCode;
	private String prosId;
	private String govtIssueId;
	private String UserRole;

	public UserDto() {
		super();
	}

	public UserDto(User modelEntity) {
		super();
		this.id = modelEntity.getId();
		this.name = modelEntity.getName();
		this.displayName = modelEntity.getDisplayName();
		this.firstName = modelEntity.getFirstName();
		this.lastName = modelEntity.getLastName();
		this.phoneNumber = modelEntity.getPhoneNumber();
		this.gender = modelEntity.getGender();
		this.country = modelEntity.getCountry();
		this.countryCode = modelEntity.getCountryCode();
		this.status = modelEntity.getStatus();
		this.academy = modelEntity.getAcademy();
		this.clubCode = modelEntity.getClubcode();
		this.otp = modelEntity.getOtp();
		this.govtIssueId = modelEntity.getGovtIssueId();
		this.prosId = modelEntity.getProSportsId();
		Set<Roles> roles = modelEntity.getRoles();
		String roleName = " ";
		
		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Roles roles2 = (Roles) iterator.next();
			roleName = roles2.getName();
		}
		this.UserRole = roleName;
		
		

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getClubCode() {
		return clubCode;
	}

	public void setClubCode(String clubCode) {
		this.clubCode = clubCode;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getProsId() {
		return prosId;
	}

	public void setProsId(String prosId) {
		this.prosId = prosId;
	}

	public String getGovtIssueId() {
		return govtIssueId;
	}

	public void setGovtIssueId(String govtIssueId) {
		this.govtIssueId = govtIssueId;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

}
