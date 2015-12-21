package com.sekhon.springmvc.converter;

import com.sekhon.springmvc.model.UserProfile;
import com.sekhon.springmvc.service.UserProfileService;
import org.testng.annotations.Test;

/**
 * Created by Ranjit on 12/21/2015.
 */
public class RoleToUserProfileConverterTest {

    UserProfileService userProfileService;
    @Test
    public UserProfile testConvert(Object element) throws Exception {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findById(id);
        System.out.println("Profile : "+profile);
        return profile;
    }
}