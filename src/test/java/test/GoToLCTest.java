package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.getAuthInfo;

public class GoToLCTest {

    @BeforeEach
    public void auth() {
        open("http://localhost:9999/");
        LoginPage login = new LoginPage();
        DataHelper.AuthInfo authInfo = getAuthInfo();
        VerificationPage verificationPage = login.validLogin(authInfo);

        @Test
        public void shouldHappyPath() {
            login.validLogin(authInfo);
            VerificationPage verifyPage = login.success();
            verifyPage.input(DataHelper.getValidVerifyCode(authInfo.getLogin()));
            DashboardPage dashboardPage = verifyPage.success();
        }
    }
}
