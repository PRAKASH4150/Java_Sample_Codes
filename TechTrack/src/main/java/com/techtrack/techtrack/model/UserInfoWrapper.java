/**
 * UserInfoWrapper.java: This class acts as the wrapper
 * for UserInfo
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10-18-2023
 */
package com.techtrack.techtrack.model;

import java.util.ArrayList;
import java.util.List;

public class UserInfoWrapper {
    private List<UserInfo> userInfoList;
    private String infoMessage;
    private String errorMessage;

    public List<UserInfo> getUserInfoList()
    {
        if(this.userInfoList==null)
        {
            this.userInfoList=new ArrayList<UserInfo>();
        }
        return this.userInfoList;
    }

    public String getInfoMessage()
    {
        return this.infoMessage;
    }

    public void setInfoMessage(String infoMessage)
    {
        this.infoMessage=infoMessage;
    }

    public String getErrorMessage()
    {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage=errorMessage;
    }
}
