package com.registration.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Reference;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "USER_ID")
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;
	
	private String displayName;

	@Column(nullable = true)
	private String firstName;

	@Column(unique = true, nullable = true)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private String DateOfBirth;

	@Column(unique = true, nullable = false)
	private String govtIssueId;

	@Column(unique = false, nullable = false)
	private String academy;

	@Column(nullable = false)
	private String password;

	private String country;

	private String countryCode;

	private String state;

	private String clubcode;

	private String region;

	@Column(nullable = false)
	private String gender;

	private String yearOfBirth;

	private String otp;

	private String status;
	
	private String proSportsId;

	private boolean locked;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns= {
			@JoinColumn (name = "USER_ID",referencedColumnName = "USER_ID")},inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ROLE_ID")})
	
	private Set<Roles> roles;
	
	public User() {
		super();
		locked = false;
	}

	public User(final String nameToSet, final String passwordToSet,final Set<Roles> rolesToSet) {
		name = nameToSet;
		password = passwordToSet;
		roles = rolesToSet;
	}

	public User(final String nameToSet, final String phoneNumberToSet, final String govtIssueIdToSet,
			final String passwordToSet,final Set<Roles> rolesToSet) {
		name = nameToSet;
		phoneNumber = phoneNumberToSet;
		govtIssueId = govtIssueIdToSet;
		password = passwordToSet;
		roles = rolesToSet;
	}

	// API

	
	
	public Set<Roles> getRoles() {
		return roles;
	}

	public String getProSportsId() {
		return proSportsId;
	}

	public void setProSportsId(String proSportsId) {
		this.proSportsId = proSportsId;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void SetDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getGovtIssueId() {
		return govtIssueId;
	}

	public void setGovtIssueId(String govtIssueId) {
		this.govtIssueId = govtIssueId;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClubcode() {
		return clubcode;
	}

	public void setClubcode(String clubcode) {
		this.clubcode = clubcode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).append("ProsId", name)
				.append("govtId", name).append("email", name).append("dateOfBirth", name).toString();
	}

}
