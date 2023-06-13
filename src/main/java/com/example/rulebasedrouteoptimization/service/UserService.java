package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.User;
import com.example.rulebasedrouteoptimization.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

//    public List<User> getUser() {
//
//        return userRepository.findAll();
//
//
//    }


//    public void addNewUser(User user) {
//        Optional<User> studentOptional = userRepository.findUsersByEmail(user.getEmail());
//        if (studentOptional.isPresent()) {
//            throw new IllegalStateException("Email has taken");
//        }
//        userRepository.save(user);
//
//    }
    public  String saveProf(MultipartFile file, Integer id) throws IOException {
            Files.copy(file.getInputStream(),this.root.resolve(file.getOriginalFilename()));
            User use= userRepository.findById(id).orElse(null);
            Path oldDPname= Paths.get(use.getProfImgUrl()).getFileName();
//            System.out.println(oldDPname);
            Path filePath=Paths.get(root+ "/"+ oldDPname);
            FileSystemUtils.deleteRecursively(filePath.toFile());
            use.setProfImgUrl("../../../assets/UserProfile/"+file.getOriginalFilename());
            userRepository.save(use);
            Optional<User> dp = userRepository.findById(id);
            User user1=dp.get();
            return user1.getProfImgUrl();
    }
    public Boolean authUser(User user) {
        Optional<User> userOptional = userRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());

//        if (userOptional.isPresent()) {

            return userOptional.isPresent();


//        } else {
//
//
//            return 0;
//        }
    }

    public Integer getId(User user) {
        Optional<User> userIdOptional= userRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());
        User userId=userIdOptional.get();

        return userId.getId();
    }

   public String getRole(User user) {

        Optional<User> userRoleOptional= userRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());

        User userRole= userRoleOptional.get();
        return userRole.getRole();
   }
   public String getName(User user) {
       Optional<User> userNameOptional= userRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());
       User userName=userNameOptional.get();

       return userName.getName();
   }
   public String getProfImgUrl(User user) {
       Optional<User> userImg=userRepository.findUsersByEmailAndPassword(user.getEmail(),user.getPassword());
       User userImgUrl=userImg.get();

       return userImgUrl.getProfImgUrl();
   }
    public Integer getUid(User user) {
        Optional<User> userID=userRepository.findUsersByEmailAndPassword(user.getEmail(),user.getPassword());
        User userId=userID.get();

        return userId.getId();
    }
   public Optional<User> getUser(Integer uid) {

        return userRepository.findById(uid);
   }

    public User upUser(Integer userId, User user) {
//        if(userRepository.findById(userId).isPresent()){
          User use= userRepository.findById(userId).orElse(null);
//          System.out.println( "user password is: "+user.getPassword());
            use.setEmail(user.getEmail());
            use.setPhone(user.getPhone());
            use.setBranch(user.getBranch());
            if (user.getPassword()!="") {
                use.setPassword(user.getPassword());
            }
            use.setName(user.getName());
           // System.out.println(use.toString());
            final User upUser= userRepository.save(use);
            return use;
//        }else {
//            return null;
//        }
    }

    public String getBranch(User user) {

        Optional<User> userBranchOptional= userRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());

        User userBranch= userBranchOptional.get();
        return userBranch.getBranch();
    }

//    public List<Optional<User>> getUserbyIDs(List<Integer> uids) {
//        List<Optional<User>> users = new ArrayList<>();
//        uids.forEach(uid->{
//                    users.add(userRepository.findById(uid));
//                }
//        );
//        return users;
//    }

    public User getUserByUid(Integer uid) {
        return userRepository.findById(uid).orElse(null);
    }

    public User creatUser(User userIdAndPWCreateByAdmin) {
        User userIdAndPWCreateByAdminEntity = new User();
        BeanUtils.copyProperties(userIdAndPWCreateByAdmin,userIdAndPWCreateByAdminEntity);
        userRepository.save(userIdAndPWCreateByAdminEntity);
        return userIdAndPWCreateByAdmin;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deletUser(Integer uid) {
        userRepository.deleteById(uid);
    }
}