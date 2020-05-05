
  package com.registration.Service;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
  
  import com.registration.Model.User; import com.registration.dao.IUserJpaDao;
  
  public interface IUserService {
  
  
  
  List<User>findByPhoneNumber(String phoneNumber); User
  findByProSportsId(String proSportsId); void update(User userModel);
  
  public default void deleteUser(Long id) {
  
  
  }
  
  }
 