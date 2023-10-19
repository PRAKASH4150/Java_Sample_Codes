/**
 * UserController.java: This file acts as the controller class
 * and intercepts all the HTTP requests.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10-18-2023
 */
package com.techtrack.techtrack.controller;

import com.techtrack.techtrack.model.UserInfo;
import com.techtrack.techtrack.model.UserInfoWrapper;
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

    /**
     * getAllUserDetails(): This method is used to return the details
     * of all the users stored in the list.
     * @return ResponseEntity<UserInfoWrapper>
     */
    @GetMapping("/getallusers")
    public ResponseEntity<UserInfoWrapper> getAllUserDetails()
    {
        UserInfoWrapper userInfoWrapper=new UserInfoWrapper();
       if(userDetailList.isEmpty())
       {
           userInfoWrapper.setInfoMessage("No records to display.");
       }
       else{
           userInfoWrapper.getUserInfoList().addAll(userDetailList);
       }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userInfoWrapper);

    }

    /**
     * getUserById(): This method is used to fetch the user by the ID
     * and return the record if found.
     * @param id - Unique identifier assigned to each user
     * @return ResponseEntity<UserInfoWrapper>
     */
    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<UserInfoWrapper> getUserById(@PathVariable("id") int id)
    {
        UserInfoWrapper userInfoWrapper=new UserInfoWrapper();
        boolean foundFlag=false;

        if(userDetailList.isEmpty()) {
            userInfoWrapper.setInfoMessage("No records to display.");
        }
        else
        {
            for(UserInfo user:userDetailList)
            {
                if(user.getUserId()==id)
                {
                    userInfoWrapper.getUserInfoList().add(user);
                    foundFlag=true;
                    break;
                }
            }

            if(!foundFlag)
            {
                userInfoWrapper.setInfoMessage("No record with the given ID exists.");
            }
        }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(userInfoWrapper);
    }

    /**
     * createUser(): This method is used to add a new user to the end
     * of the list.
     * @param userDetails- Takes the user record as an argument.
     * @return ResponseEntity<UserInfoWrapper>
     *
     */
    @PostMapping(value = "/createuser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfoWrapper> createUser(@RequestBody UserInfo userDetails )
    {
        UserInfoWrapper userInfoWrapper =new UserInfoWrapper();
        boolean dupUser=false;
        for(UserInfo userRecord:userDetailList)
        {
            if(userRecord.getUserId()==userDetails.getUserId())
            {
                dupUser=true;
                break;
            }
        }
        if(dupUser)
        {
            userInfoWrapper.setErrorMessage("User with the same ID already exists. Please double check");
        }
        else {
            userDetailList.add(userDetails);
            userInfoWrapper.getUserInfoList().add(userDetails);
            userInfoWrapper.setInfoMessage("User record added successfully!!");
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoWrapper);

    }

    /**
     * updateUserById(): This method is used to update an existing user
     * by taking ID as the parameter. If a record is found with the
     * given ID, it will update or else it will throw an error
     * message.
     * @param id - Unique Identifier assigned to the user
     * @param userInfo - Object consisting of updated user info
     * @return ResponseEntity<UserInfoWrapper>
     */

    @PutMapping(value="/updateuser/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfoWrapper> updateUserById(@PathVariable("id") int id,@RequestBody UserInfo userInfo)
    {
        UserInfoWrapper userInfoWrapper=new UserInfoWrapper();
        boolean foundFlag=false;
        if(userDetailList.isEmpty()) {
            userInfoWrapper.setInfoMessage("No records to display.");
        }
        else
        {
            for(UserInfo user:userDetailList)
            {
                if(user.getUserId()==id)
                {
                    user.setFirstName(userInfo.getFirstName());
                    user.setLastName(userInfo.getLastName());
                    user.setAge(userInfo.getAge());
                    foundFlag=true;
                }

            }
            if(!foundFlag)
            {
                userInfoWrapper.setInfoMessage("No record with the given ID exists.");
            }
            else
            {
                userInfoWrapper.getUserInfoList().add(userInfo);
                userInfoWrapper.setInfoMessage("Record updated successfully!!");
            }
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userInfoWrapper);
    }

    /**
     * deleteUserById(): This method is used to delete an existing user
     * by taking ID as the parameter. If a record is found with the
     * given ID, it will delete or else it will throw an error
     * message.
     * @param id - Unique Identifier assigned to the user
     * @return ResponseEntity<UserInfoWrapper>
     */
    @DeleteMapping("deleteuserbyid/{id}")
    public ResponseEntity<UserInfoWrapper> deleteUserById(@PathVariable("id") int id)
    {
        UserInfoWrapper userInfoWrapper=new UserInfoWrapper();
        boolean foundFlag=false;
        for(UserInfo user:userDetailList)
        {
            if(user.getUserId()==id){
                userDetailList.remove(user);
                foundFlag=true;
                userInfoWrapper.setInfoMessage("Record deleted successfully!!");
                break;
            }
        }
        if(!foundFlag)
        {
            userInfoWrapper.setInfoMessage("No record with the given ID exists.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoWrapper);
    }
 }
