package com.techtrack.techtrack.controller;

import com.techtrack.techtrack.model.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/techtrack")
public class UserController {

    private List<UserInfo> userDetailList=new ArrayList<UserInfo>();

    @GetMapping("/getallusers")
    public ResponseEntity<List<UserInfo>> getAllUserDetails()
    {
       if(userDetailList.isEmpty())
       {
           return ResponseEntity.notFound().build();
       }
       else{
           return ResponseEntity.ok(userDetailList);
       }
    }

    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable("id") int id)
    {
        if(userDetailList.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            for(UserInfo user:userDetailList)
            {
                if(user.getUserId()==id)
                {
                    return ResponseEntity.ok(user);
                }
                else
                {
                    return ResponseEntity.notFound().build();
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/createuser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userDetails )
    {
        userDetailList.add(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);

    }


    @PutMapping("/updateuser/{id}")
    public ResponseEntity<UserInfo> updateUserById(@PathVariable int id,@RequestBody UserInfo userInfo)
    {
        for(UserInfo user:userDetailList)
        {
            if(user.getUserId()==id)
            {
                user.setFirstName(userInfo.getFirstName());
                user.setLastName(userInfo.getLastName());
                user.setAge(userInfo.getAge());
                return ResponseEntity.ok(userInfo);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("deleteuserbyid/{id}")
    public ResponseEntity<List<UserInfo>> deleteUserById(@PathVariable int id)
    {
        for(UserInfo user:userDetailList)
        {
            if(user.getUserId()==id){
                userDetailList.remove(user);
                return ResponseEntity.ok(userDetailList);
            }
            else
            {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
 }
