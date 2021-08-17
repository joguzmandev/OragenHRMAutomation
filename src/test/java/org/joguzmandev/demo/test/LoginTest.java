package org.joguzmandev.demo.test;

import org.joguzmandev.demo.base.BaseTest;
import org.joguzmandev.demo.listener.BaseListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.dashboard.DashboardPage;
import pages.auth.LoginPage;

@Listeners(value = BaseListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void test_login_with_username_and_password_empties(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "";
        String password = "";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        String actualResult = loginPage.clickLoginButtonInvalidCredentials();
        String expectedResult = "Username cannot be empty";

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void test_login_with_username_empty(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        String actualResult = loginPage.clickLoginButtonInvalidCredentials();
        String expectedResult = "Username cannot be empty";

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void test_login_with_password_empty(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        String actualResult = loginPage.clickLoginButtonInvalidCredentials();
        String expectedResult = "Password cannot be empty";

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void test_login_with_username_and_password_incorrect(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "administrator";
        String password = "administrator";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        String actualResult = loginPage.clickLoginButtonInvalidCredentials();
        String expectedResult = "Invalid credentials";

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void test_login_with_admin_username_and_password_correct(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        String actualResult = dashboardPage.isUserLoggedOnDashboard();

        Assert.assertTrue(actualResult.contains("Admin"));
    }
}
