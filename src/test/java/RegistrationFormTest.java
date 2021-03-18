import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {

    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void successfulFillRegistrationForm() {
        String firstName = DataHelper.getRandomFirstName();
        String lastName = DataHelper.getRandomLastName();
        String email = DataHelper.getRandomEmail();
        String mobileNumber = DataHelper.getRandomMobileNumber();
        String year = DataHelper.getRandomYear();
        String month = DataHelper.getRandomMonth();
        String currentAddress = DataHelper.getRandomCurrentAddress();

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        String gender = DataHelper.selectRandomGenderAndReturnName();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String day = DataHelper.selectRandomDayAndReturnNumber();
        String subjects = DataHelper.selectRandomSubjectAndReturnList();
        String hobbies = DataHelper.selectRandomHobbiesAndReturnName();
        $("#uploadPicture").uploadFile(new File("./src/test/resources/image.jpg"));
        $("#currentAddress").scrollIntoView(true).setValue(currentAddress);
        String state = DataHelper.selectRandomStateAndReturnName();
        String city = DataHelper.selectRandomCityAndReturnName(state);
        $("#submit").click();

        $(".table").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(mobileNumber),
                text(day),
                text(month),
                text(year),
                text(subjects),
                text(hobbies),
                text("image.jpg"),
                text(currentAddress),
                text(state),
                text(city));
    }

}
