package org.joguzmandev.demo.test;

import org.joguzmandev.demo.base.BaseTest;
import org.joguzmandev.demo.pages.OrangeHRMLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void do_login_with_username_and_password_empties_test(){
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(this.webDriver);

        String userName = "";
        String password = "";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        loginPage.clickLoginButton();
        String expectedResult = "Username cannot be empty";
        String actualResult = loginPage.messageWithUsernameOrPasswordEmpty();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void do_login_with_username_empty_test(){
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(this.webDriver);

        String userName = "";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        loginPage.clickLoginButton();
        String expectedResult = "Username cannot be empty";
        String actualResult = loginPage.messageWithUsernameOrPasswordEmpty();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void do_login_with_password_empty_test(){
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(this.webDriver);

        String userName = "Admin";
        String password = "";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        loginPage.clickLoginButton();
        String expectedResult = "Password cannot be empty";
        String actualResult = loginPage.messageWithUsernameOrPasswordEmpty();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void do_login_with_username_and_password_incorrect(){
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(this.webDriver);

        String userName = "administrator";
        String password = "administrator";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        loginPage.clickLoginButton();

        String expectedResult = "Invalid credentials";
        String actualResult = loginPage.messageWithUsernameOrPasswordEmpty();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void do_login_with_admin_username_and_password_correct(){
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
        webDriver.manage().window().maximize();

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        loginPage.clickLoginButton();

        String expectedResult = "Admin";
        String actualResult = loginPage.messageWhenLoginIsCorrect();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
