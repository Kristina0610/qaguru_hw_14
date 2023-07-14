package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class TestStudentRegistrationForm extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();
  RandomUtils randomUtils = new RandomUtils();

  String firstName = randomUtils.getRandomFirstName(),
          lastName = randomUtils.getRandomLastName(),
          userEmail = randomUtils.getRandomEmail(),
          gender = randomUtils.getRandomGender(),
          phoneNumber = randomUtils.getRandomPhoneNumber(),
          dayOfBirthday = randomUtils.getRandomDayOfBirthday(),
          monthOfBirthday = randomUtils.getRandomMonthOfBirthday(),
          yearOfBirthday = randomUtils.getRandomYearOfBirthday(),
          subject = randomUtils.getRandomSubject(),
          hobby = randomUtils.getRandomHobby(),
          currentAddress = randomUtils.getRandomAddress(),
          state = randomUtils.getRandomState(),
          city = randomUtils.getRandomCity(state);

  @Test
  @Tag("remote")
  @Owner("Kristina Gaevskaya")
  @Epic("Учёба")
  @Story("Jenkins")
  @DisplayName("Successful registration")
  @Severity(SeverityLevel.CRITICAL)
  void successfulFillFormTest() {

    registrationPage.openPage()
            .removeHeader()
            .removeFooter()
            .removeBanners()
            .setFirstNameInput(firstName)
            .setLastNameInput(lastName)
            .setUserEmailInput(userEmail)
            .setGender(gender)
            .setNumber(phoneNumber)
            .setBirthDate(dayOfBirthday, monthOfBirthday, yearOfBirthday)
            .setSubjectInput(subject)
            .setHobby(hobby)
            .uploadFile()
            .setCurrentAddress(currentAddress)
            .setState(state)
            .setCity(city)
            .clickButton();

    registrationPage.verifyRegistrationResultsModalAppears()
            .verifyResult("Student Name", firstName + " " + lastName)
            .verifyResult("Student Email", userEmail)
            .verifyResult("Gender", gender)
            .verifyResult("Mobile", phoneNumber)
            .verifyResult("Date of Birth", dayOfBirthday + " " + monthOfBirthday + "," + yearOfBirthday)
            .verifyResult("Subjects", subject)
            .verifyResult("Hobbies", hobby)
            .verifyResult("Picture", "screenshot_1.png")
            .verifyResult("Address", currentAddress)
            .verifyResult("State and City", state + " " + city);

  }
}
