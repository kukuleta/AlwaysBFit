package com.example.alwaysbfit;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class SignUpActivityTest {

    @Test
    public void isEmailValidTest(){
        SignUpActivity test = new SignUpActivity();
        assertTrue("email is not valid ",test.isValidEmail("oguuzhansahiin@gmail.com"));
    }
    @Test
    public void isEmailInvalidTest(){
        SignUpActivity test = new SignUpActivity();
        assertFalse("email is valid ",test.isValidEmail("oguuzhansahiin@gmail.m"));
    }

    @Test
    public void isEntryEmpty(){
        SignUpActivity test = new SignUpActivity();
        assertFalse("String is not empty ",test.isEntryEmpty("özgürhocam"));
    }
    @Test
    public void isEntryNotEmpty(){
        SignUpActivity test = new SignUpActivity();
        assertTrue("String is empty ",test.isEntryEmpty("sdıfjsd"));
    }

    @Test
    public void isPasswordValid(){
        SignUpActivity test = new SignUpActivity();
        assertTrue("Password is not valid ",test.is_password_valid("sasdas"));
    }
    @Test
    public void isPasswordNotValid(){
        SignUpActivity test = new SignUpActivity();
        assertFalse("Password valid ",test.is_password_valid("A1312fsB"));
    }
}