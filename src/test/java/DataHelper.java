import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DataHelper {

    public static Faker faker = new Faker();

    public static String selectRandomHobbiesAndReturnName() {
        ElementsCollection hobbies = $$("#hobbiesWrapper .custom-checkbox")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        int indexOfHobbies = faker.number().numberBetween(0, hobbies.size() - 1);
        String hobbiesName = hobbies.get(indexOfHobbies).text();
        hobbies.get(indexOfHobbies).click();
        return hobbiesName;
    }

    public static String selectRandomGenderAndReturnName() {
        ElementsCollection genders = $$("#genterWrapper .custom-radio")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        int indexOfGender = faker.number().numberBetween(0, genders.size() - 1);
        String genderName = genders.get(indexOfGender).text();
        genders.get(indexOfGender).click();
        return genderName;
    }

    public static String selectRandomSubjectAndReturnList() {
        List<String> selectedSubjects = new LinkedList();
        List<String> subjectList = new LinkedList(Arrays.asList
                ("Maths", "Arts", "Accounting", "Social Studies", "Biology",
                        "Physics", "Computer Science", "Chemistry", "Economics",
                        "Commerce", "Civics", "Hindi", "English", "History"));
        int countOfSubject = faker.number().numberBetween(1, subjectList.size());
        while (countOfSubject > 0) {
            int index = faker.number().numberBetween(0, subjectList.size() - 1);
            $("#subjectsInput").setValue(subjectList.get(index)).pressEnter();
            selectedSubjects.add(subjectList.get(index));
            subjectList.remove(index);
            countOfSubject--;
        }
        return selectedSubjects.toString()
                .replace("[", "").replace("]", "");
    }

    public static String selectRandomDayAndReturnNumber() {
        ElementsCollection days = $$(".react-datepicker__day")
                .filter(Condition.not(Condition.cssClass("react-datepicker__day--outside-month")))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        int indexOfElement = faker.number().numberBetween(0, days.size() - 1);
        String numberOfDay = days.get(indexOfElement).text();
        days.get(indexOfElement).click();
        return numberOfDay;
    }

    public static String selectRandomCityAndReturnName(String state) {
        String nameOfCity = null;
        int indexOfCity;
        $("#city").click();
        switch (state) {
            case "NCR":
            case "Uttar Pradesh":
                indexOfCity = faker.number().numberBetween(0, 3);
                if (indexOfCity == 0) {
                    nameOfCity = $("#react-select-4-option-0").text();
                    $("#react-select-4-option-0").click();
                }
                if (indexOfCity == 1) {
                    nameOfCity = $("#react-select-4-option-1").text();
                    $("#react-select-4-option-1").click();
                }
                if (indexOfCity == 2) {
                    nameOfCity = $("#react-select-4-option-2").text();
                    $("#react-select-4-option-2").click();
                }
                break;
            case "Haryana":
            case "Rajasthan":
                indexOfCity = faker.number().numberBetween(0, 2);
                if (indexOfCity == 0) {
                    nameOfCity = $("#react-select-4-option-0").text();
                    $("#react-select-4-option-0").click();
                }
                if (indexOfCity == 1) {
                    nameOfCity = $("#react-select-4-option-1").text();
                    $("#react-select-4-option-1").click();
                }
                break;
        }
        return nameOfCity;
    }

    public static String selectRandomStateAndReturnName() {
        String nameOfState = null;
        $("#state").click();
        int indexOfState = faker.number().numberBetween(1, 5);
        switch (indexOfState) {
            case 1:
                nameOfState = $("#react-select-3-option-0").text();
                $("#react-select-3-option-0").click();
                break;
            case 2:
                nameOfState = $("#react-select-3-option-1").text();
                $("#react-select-3-option-1").click();
                break;
            case 3:
                nameOfState = $("#react-select-3-option-2").text();
                $("#react-select-3-option-2").click();
                break;
            case 4:
                nameOfState = $("#react-select-3-option-3").text();
                $("#react-select-3-option-3").click();
                break;
        }
        return nameOfState;
    }

    public static String getRandomMonth() {
        int numberOfMonth = faker.number().numberBetween(1, 13);
        String month = null;
        switch (numberOfMonth) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month;
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomMobileNumber() {
        return faker.number().digits(10);
    }

    public static String getRandomCurrentAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2101));
    }

}
