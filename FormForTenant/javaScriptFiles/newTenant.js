/*------------------------------------------------------
This is the JS library file for newTenant.html page 
-------------------------------------------------------*/
/*
   The purpose of this function is to go thru the newFriendForm for Tenant and check the content of all the
   text boxes for validity.  Created  11/01/2015 by Ranjit Sekhon.
*/

function putCSSToStartingValues() {
     // Resets everything
    document.formNewFriend.lastName.focus();
    document.formNewFriend.firstName.style.backgroundColor = "";
    document.formNewFriend.lastName.style.backgroundColor = "";
    document.formNewFriend.Country.style.backgroundColor = "";
    document.formNewFriend.GenderCode.style.backgroundColor = "";
    document.formNewFriend.pwdTextFld.style.backgroundColor = "";
    document.formNewFriend.pwdConfirmFld.style.backgroundColor = "";
    return false; // leave now --block submit
}


function checkAllInputs()  {

    // Resets everything
     putCSSToStartingValues();
     
    // Declare all variables and assign values, this will make code readable 
    var firstNameFld = document.formNewFriend.firstName.value;
    var lastNameFld = document.formNewFriend.lastName.value;
    var countryFld = document.formNewFriend.Country.value;
    var genderCodeFld = document.formNewFriend.GenderCode.value;
    var pwdTextFld = document.formNewFriend.pwdTextFld;
    var pwdConfirmFld = document.formNewFriend.pwdConfirmFld;
    
    
    // The artist actual first name field must contain at least two characters, 
    // with each of them being a letter of the alphabet.
     if (firstNameFld.length <= 1 || !/^[A-Za-z]+$/.test(firstNameFld)) { 
        alert("First name entry must contain at least two characters with " 
        	+ "each of them being a letter of the alphabet.");
        document.formNewFriend.firstName.select();
        document.formNewFriend.firstName.style.backgroundColor = "yellow";
        return false;    // leave now
    } 
   
    // The artist actual last name field must contain at least two characters, 
    // with each of them being a letter of the alphabet.
    if (lastNameFld.length <= 1 || !/^[A-Za-z]+$/.test(lastNameFld)) { 
        alert("Last name entry must contain at least two characters with " 
        	+ "each of them being a letter of the alphabet.");
        document.formNewFriend.lastName.select();
        document.formNewFriend.lastName.style.backgroundColor = "yellow";
        return false;    // leave now
    } 
   
   
    // The viewer must have selected (i.e. click to select) both a Country 
    // and a Gender Code from the drop down select lists. 
    // [As shown in class, use a default value which is the invalid value for 
    // the first option on the list.]
    
    // The validation of the Country list starts here ------
   
    if (countryFld === "0000") {     
        alert("Must select a Country");
        document.formNewFriend.Country.style.backgroundColor = "yellow";
        return false;    // leave now --block submit
    }
    
   // Validation for Gender Code
   
   if (genderCodeFld === "valNo") {     
        alert("Must select a Gender");
        document.formNewFriend.GenderCode.style.backgroundColor = "yellow";
        return false;    // leave now --block submit
    }
    
   // The first password field must contain at least five characters. 
   // They can be any combination of different kinds of characters.
   
   
   
    // -- Validation of first Password Field starts here -------
   if (pwdTextFld.value.length < 5) { 
        alert("Passwords must be minimum 5 chars long");
        document.formNewFriend.pwdTextFld.select();
        return false;     // leave now --block submit
    }
    
    // -- Validation of second Password Field starts here -------
    // The password confirm repeat field must contain at least five characters.
    if (pwdConfirmFld.value.length < 5) { 
        alert("Passwords must be minimum 5 chars long");
        document.formNewFriend.pwdConfirmFld.select();
        return false;     // leave now --block submit
    }
    
   
    // Now compare the two password fields to one another.
    // After each of the two password fields has individually passed their 
    // individual validation tests, then a final validation test must be done 
    // which is that the content of the two password fields must be equal to 
    // each other. If they are not equal to each other, both of the password 
    // fields must change to a yellow (or other distinctive color) background 
    // color.

    if (pwdTextFld.value !==  pwdConfirmFld.value)  {
        alert("Passwords MUST be the same");
        document.formNewFriend.pwdTextFld.select();
        document.formNewFriend.pwdTextFld.style.backgroundColor = "yellow";
        document.formNewFriend.pwdConfirmFld.style.backgroundColor = "yellow";
        return false;     // leave now --block submit
    }

   
    return true;    // if made it to here, all OK--let submit proceed

}  // FUNCTION ENDS HERE -------------------------------

