package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.User;
import com.example.rulebasedrouteoptimization.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private  final Path root = Paths.get("src/main/webapp/Public/src/assets/UserProfile");

    public void init() throws IOException {
        Files.createDirectories(root);
    }
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public  String saveProf(MultipartFile file, Integer id) throws IOException {
            Files.copy(file.getInputStream(),this.root.resolve(file.getOriginalFilename()));
            User use= userRepository.findById(id).orElse(null);
            Path oldDPname= Paths.get(use.getProfImgUrl()).getFileName();
            Path filePath=Paths.get(root+ "/"+ oldDPname);
            FileSystemUtils.deleteRecursively(filePath.toFile());
            use.setProfImgUrl("../../../assets/UserProfile/"+file.getOriginalFilename());
            userRepository.save(use);
            Optional<User> dp = userRepository.findById(id);
            User user1=dp.get();
            return user1.getProfImgUrl();
    }
    public Boolean authUser(User user) {
            User usrDb=userRepository.findUsersByEmail(user.getEmail());
            return this.bcryptMatch(user.getPassword(),usrDb.getPassword());
    }
    public Integer getId(User user) {
        User userId=userRepository.findUsersByEmail(user.getEmail());
        return userId.getId();
    }
    public String getRole(User user) {
        User userRole=userRepository.findUsersByEmail(user.getEmail());
        return userRole.getRole();
   }
   public String getName(User user) {
       User userName=userRepository.findUsersByEmail(user.getEmail());
       return userName.getName();
   }
   public String getProfImgUrl(User user) {
       User userImgUrl=userRepository.findUsersByEmail(user.getEmail());
       return userImgUrl.getProfImgUrl();
   }
   public Integer getUid(User user) {
        User userId=userRepository.findUsersByEmail(user.getEmail());
        return userId.getId();
    }
   public Optional<User> getUser(Integer uid) {
        return userRepository.findById(uid);
   }

   public User upUser(Integer userId, User user) {
          User use= userRepository.findById(userId).orElse(null);
            use.setEmail(user.getEmail());
            use.setPhone(user.getPhone());
            use.setBranch(user.getBranch());
            if (user.getPassword()!="") {
                String encodedPassword= this.bcryptPassword(user.getPassword());
                use.setPassword(encodedPassword);
            }
            use.setName(user.getName());
            final User upUser= userRepository.save(use);
            return use;
    }
    public String getBranch(User user) {
        User userBranch=userRepository.findUsersByEmail(user.getEmail());
        return userBranch.getBranch();
    }

    public User getUserByUid(Integer uid) {
        return userRepository.findById(uid).orElse(null);
    }
    public User creatUser(User userIdAndPWCreateByAdmin) {
        String encodedPassword=this.bcryptPassword(userIdAndPWCreateByAdmin.getPassword());
        userIdAndPWCreateByAdmin.setPassword(encodedPassword);
        User userIdAndPWCreateByAdminEntity = new User();
        BeanUtils.copyProperties(userIdAndPWCreateByAdmin,userIdAndPWCreateByAdminEntity);
        userRepository.save(userIdAndPWCreateByAdminEntity);
        return userIdAndPWCreateByAdmin;
    }
    public String bcryptPassword(String password){
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        return encodedPassword;
    }
   public boolean bcryptMatch(String usrEntered, String dbPass) {
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       return  encoder.matches(usrEntered,dbPass);
   }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deletUser(Integer uid) {
        userRepository.deleteById(uid);
    }

    public User findbyEmail(String email) {
      return   userRepository.findUsersByEmail(email);
    }
}