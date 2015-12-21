package com.sekhon.springmvc.controller;

import com.sekhon.springmvc.model.User;
import com.sekhon.springmvc.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.annotations.Test;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


/**
 * Created by Ranjit on 12/20/2015.
 */
public class AppControllerTest {

    UserService userService;

    MessageSource messageSource;

    @Test
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String testListUsers(ModelMap model) throws Exception {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "userslist";

    }

    @Test
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
    public String testNewUser(ModelMap model) throws Exception {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";

    }

    @Test
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public String testSaveUser(@Valid User user, BindingResult result,
                               ModelMap model) throws Exception {

        if (result.hasErrors()) {
            return "registration";
        }

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation
		 * and applying it on field [sso] of Model class [User].
		 *
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 *
		 */
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
        //return "success";
        return "registrationsuccess";


    }

    @Test
    @RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
    public String testEditUser(@PathVariable String ssoId, ModelMap model) throws Exception {

        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";

    }

    @Test
    @RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
    public String testUpdateUser(@Valid User user, BindingResult result,
                                 ModelMap model, @PathVariable String ssoId) throws Exception {
        if (result.hasErrors()) {
            return "registration";
        }

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
        return "registrationsuccess";

    }

    @Test
    @RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
    public String testDeleteUser(@PathVariable String ssoId) throws Exception {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";

    }



}