
  package com.registration.web.Controller;
  
  import java.util.HashSet; import java.util.List; import java.util.Set;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.ResponseStatus; import
  org.springframework.web.bind.annotation.RestController;
  
  import com.registration.Dto.GenericResponseDto; import
  com.registration.Dto.UserDto; import com.registration.Model.Roles; import
  com.registration.Model.User; import com.registration.Service.IRoleService;
  import com.registration.Service.IUserService; import
  com.registration.um.util.UmMappings; import
  com.registration.web.exception.ValidationErrorDTO;
  
  @RestController
  
  @RequestMapping(UmMappings.USERS) public class UserController {
  
  @Autowired private IUserService service;
  
  @Autowired private IRoleService roleService;
  
  public UserController() { super(); }
  
  @GetMapping("/{id}") public UserDto findOne(@PathVariable("id") Long id) {
  return findOne(id); }
  
  @PostMapping
  
  @ResponseStatus(HttpStatus.CREATED) public GenericResponseDto
  create(@RequestBody UserDto resource) {
  
  ValidationErrorDTO errorDto = new ValidationErrorDTO(); String lastFourDigits
  = new String(); List<User> userByPhoneNumber =
  service.findByPhoneNumber(resource.getPhoneNumber());
  
  if (userByPhoneNumber != null && userByPhoneNumber.size() > 0) {
  errorDto.addFieldError("phone.registered",
  "These phone is already registered for another .Plesase use different Number"
  ); }
  
  User userModel = new User(); if (userModel.getName() != null) {
  userModel.setName(resource.getName());
  userModel.SetDisplayName(resource.getName()); } else {
  errorDto.addFieldError("user.name", "Please enter your name"); }
  
  if (resource.getGender() != null) {
  userModel.setGender(resource.getGender()); } else {
  errorDto.addFieldError("user.gender", "Please select your gender"); }
  
  if (resource.getPhoneNumber() != null) {
  userModel.setPhoneNumber(resource.getPhoneNumber()); } else {
  errorDto.addFieldError("user.phone", "Please enter your phone number"); } if
  (userModel.getDateOfBirth() != null) { String dob =
  resource.getDateOfBirth(); String yearOfBirth = dob.substring(dob.length() -
  4); userModel.setDateOfBirth(resource.getDateOfBirth());
  userModel.setYearOfBirth(resource.getYearOfBirth()); } else {
  errorDto.addFieldError("user.DateOfBirth",
  "please enter your date of birth"); }
  
  if (userModel.getGovtIssueId() != null) { String govtIssueId =
  resource.getGovtIssueId();
  
  if (govtIssueId.length() > 4) { String lastFourDigit =
  govtIssueId.substring(govtIssueId.length() - 4); } else {
  errorDto.addFieldError("user.id", "Please enter valid govt id number"); } }
  else { errorDto.addFieldError("user.govtIssueId",
  "Please enter valid govt id number"); }
  
  if (errorDto.getFieldErrors() != null || errorDto.getFieldErrors().size() >
  0) { return new GenericResponseDto("400", "failed", errorDto.toString());
  
  }
  
  if (resource.getUserRole() != null) {
  
  Set<Roles> userRole = new HashSet<Roles>(); String roleName =
  resource.getUserRole();
  
  Roles role = roleService.findByName(roleName); if (role != null) {
  userRole.add(role); } else { errorDto.addFieldError("user.role",
  "No such role found " + roleName); } userModel.setRoles(userRole);
  
  } else { errorDto.addFieldError("user.Role", "User Role Not Provided"); }
  
  userModel.setAcademy(resource.getAcademy()); userModel.setCountry("India");
  userModel.setCountryCode("+91"); userModel.setRegion("Hyderabad");
  userModel.setState("Telangana"); userModel.setPassword(lastFourDigits);
  userModel.setOtp(lastFourDigits); userModel.setLocked(false);
  userModel.setStatus("active");
  
  userModel.setProSportsId(resource.getDateOfBirth() + lastFourDigits);
  
  return new GenericResponseDto("200", "success",
  "Thank you for registering with Proscircle.  This is a one time registration which can you used for all future events."
  );
  
  }
  
  @PutMapping("/profile/{prosId}")
  
  @ResponseStatus(HttpStatus.OK) public void update(@PathVariable("prosId")
  String prosId, @RequestBody UserDto resource) {
  
  if (resource.getId() != null) { User userModel =
  service.findByProSportsId(prosId);
  
  if (userModel != null) {
  
  if (userModel.getFirstName() != null) {
  userModel.setFirstName(resource.getFirstName()); } if
  (userModel.getLastName() != null) {
  userModel.setLastName(resource.getLastName()); } if (userModel.getGender() !=
  null) { userModel.setGender(resource.getGender()); } if
  (userModel.getAcademy() != null) {
  userModel.setAcademy(resource.getAcademy()); } if (userModel.getPhoneNumber()
  != null) { userModel.setPhoneNumber(resource.getPhoneNumber()); } if
  (userModel.getDateOfBirth() != null) {
  userModel.setDateOfBirth(resource.getDateOfBirth()); } if
  (userModel.getClubcode() != null) {
  userModel.setClubcode(resource.getClubCode()); } if
  (userModel.getDisplayName() != null) {
  userModel.SetDisplayName(resource.getDisplayName()); } if
  (userModel.getCountryCode() != null) {
  userModel.setCountryCode(resource.getCountryCode()); } if
  (userModel.getCountry() != null) {
  userModel.setCountry(resource.getCountry()); }
  
  service.update(userModel); } else {
  System.out.println("My entity not found exception"); }
  
  }
  
  }
  
  @DeleteMapping("/{id}")
  
  @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable("id")
  Long id) { service.deleteUser(id); } //
  
  }
 