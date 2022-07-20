package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

        private SelenideElement codeField = $("[data-test-id=code] input");
        private SelenideElement verifyContinueButton = $("[data-test-id=action-verify]");

        public VerificationPage() {
            codeField.shouldBe(visible);
        }

        public void input(String code) {
            codeField.val(code);
            verifyContinueButton.click();
        }

    public DashboardPage success() {
        return new DashboardPage();
    }

}
