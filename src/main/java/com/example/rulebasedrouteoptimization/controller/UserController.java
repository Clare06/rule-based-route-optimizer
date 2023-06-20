package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.jwt.JwtUtil;
import com.example.rulebasedrouteoptimization.model.User;
import com.example.rulebasedrouteoptimization.otp.EmailService;
import com.example.rulebasedrouteoptimization.repository.UserRepository;
import com.example.rulebasedrouteoptimization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class UserController {
    private final UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @PostMapping("/users")
    public ResponseEntity<String> creatUser(@RequestBody User userIdAndPWCreateByAdmin){
        String password=userIdAndPWCreateByAdmin.getPassword();
        Optional<User> usr= Optional.ofNullable(userService.findbyEmail(userIdAndPWCreateByAdmin.getEmail()));
        if (usr.isPresent()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User create=userService.creatUser(userIdAndPWCreateByAdmin);
        emailService.sendUserCredentialEmail(userIdAndPWCreateByAdmin,password);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("getusers")
    public List<User> getuserList (){
        return userService.findAll();
    }
    @DeleteMapping("deleteuser/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable("uid") Integer uid){
        userService.deletUser(uid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
//        Integer i = ;
//        System.out.println(user.getPassword());
        if (userService.authUser(user)){
            String token = jwtUtil.generateToken(user);
            System.out.println(token);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("name",userService.getName(user));
            map.put("profUrl",userService.getProfImgUrl(user));
//            map.put("uID",userService.getUid(user));

            return new ResponseEntity<Object>(map,HttpStatus.OK);

        }else {

            return new ResponseEntity<String>("Login credential wrong",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/{uid}")
    public ResponseEntity<User> getUserByUid(@PathVariable Integer uid) {
        User user = userService.getUserByUid(uid);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }
    @GetMapping("userbyid/{uid}")
    public ResponseEntity<Optional<User>> getByID(@PathVariable Integer uid){
        Optional<User> userById= userService.getUser(uid);

        return new ResponseEntity<>(userById,HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
                                           @RequestBody User userDetails)  {
        User upuser1= userService.upUser(userId,userDetails);
//        System.out.println(userDetails);
        return new ResponseEntity<>(upuser1,HttpStatus.OK);
    }
    @PostMapping("profupload/{id}")
    public ResponseEntity<Object> uploadProf(@RequestParam("file")MultipartFile file,@PathVariable(value = "id") Integer id) throws IOException {
//        System.out.println(file);
        userService.init();
        String saveProf= userService.saveProf(file,id);
        Map<String,Object> map = new HashMap<>();
        map.put("url",saveProf);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @GetMapping("branch_count")
    public Integer getcount(){
        Integer user_count = userRepository.branchCount();
        return user_count;
    }
}

