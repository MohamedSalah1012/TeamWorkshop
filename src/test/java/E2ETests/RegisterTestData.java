package E2ETests;

import com.github.javafaker.Faker;

public class RegisterTestData {

    public static Faker faker = new Faker();
    public static String username  = faker.name().username(),

                firstName  = faker.name().firstName(),
                lastName = faker.name().lastName(),

                company = faker.company().name(),

                emailAddress = faker.internet().emailAddress(),
                password = faker.internet().password(),
                country = faker.country().name(),

                zipCode = faker.address().zipCode(),
                creditCardNumber = faker.business().creditCardNumber(),
                mobileNumber = "+2010" +  faker.number().digits(8);
}
