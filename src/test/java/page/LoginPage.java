package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement fieldLogin = $("[data-test-id=login] input");
    private SelenideElement fieldPassword = $("[data-test-id=password] input");
    private SelenideElement continueButton =  $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        fieldLogin .setValue(info.getLogin());
        fieldPassword.setValue(info.getPassword());
        continueButton.click();
        return new VerificationPage();
    }
    public VerificationPage success() {
        return new VerificationPage();
    }
}
