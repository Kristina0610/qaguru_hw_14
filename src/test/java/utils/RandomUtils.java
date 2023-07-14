package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {

  private final Faker faker = new Faker(new Locale("ru"));

  String[] gender = {"Male", "Female", "Other"},
          month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"},
          subject = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"},
          hobby = {"Music","Reading","Sports"},
          state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
          cityOfNCR = {"Delhi", "Gurgaon", "Noida"},
          cityOfUttarPradesh = {"Agra", "Lucknow", "Merrut"},
          cityOfHaryana = {"Karnal", "Panipat"},
          cityOfRajasthan = {"Jaipur", "Jaiselmer"};


  public String getRandomFirstName() {
    return faker.name().firstName();
  }

  public String getRandomLastName() {
    return faker.name().lastName();
  }

  public String getRandomEmail() {
    return new Faker().internet().emailAddress();
  }

  public String getRandomGender() {
    return faker.options().option(gender);
  }

  public String getRandomPhoneNumber() {
    return faker.number().digits(10);
  }

  public String getRandomDayOfBirthday() {
    return String.valueOf(faker.number().numberBetween(10, 27));
  }

  public String getRandomMonthOfBirthday() {
    return faker.options().option(month);
  }
  public String getRandomYearOfBirthday() {
    return String.valueOf(faker.number().numberBetween(1900,2100));
  }

  public String getRandomSubject() {
    return faker.options().option(subject);
  }

  public String getRandomHobby() {
    return faker.options().option(hobby);
  }

  public String getRandomAddress() {
    return faker.address().fullAddress();
  }

  public String getRandomState() {
    return faker.options().option(state);
  }

  public String getRandomCity(String state) {
    switch (state) {
      case "NCR": {
        return faker.options().option(cityOfNCR);
      }
      case "Uttar Pradesh": {
        return faker.options().option(cityOfUttarPradesh);
      }
      case "Haryana": {
        return faker.options().option(cityOfHaryana);
      }
      case "Rajasthan": {
        return faker.options().option(cityOfRajasthan);
      }
    }
    return null;
  }
}

