package data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    private static Faker faker = new Faker();

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya","qwerty123");
    }

    public static String getRandomPassword() {
        String randomPassword = faker.internet().password();
        return randomPassword;
    }

    public static String getValidVerifyCode(String login) {
        String verifyCode = SQLHelper.getValidVerifyCode(login);
        return verifyCode;

    }
}
