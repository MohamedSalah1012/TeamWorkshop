package Tests.Register;

import com.github.javafaker.Faker;

public class TestData {

    public static Faker faker = new Faker();
    static String username  = faker.name().username(),

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
