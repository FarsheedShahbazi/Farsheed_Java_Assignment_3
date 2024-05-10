import utility.*;
import objects.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Adopt_a_pet {
  private static Scanner input = new Scanner(System.in);
  private static Ink ink = new Ink();
  private static User user;
  private static Shelter shelter = new Shelter();
  private static Pet pet;

  private static int choice;
  private static boolean isDone = false;
  private static boolean goBack = false;

  public static void main(String[] args) {

    createUser(); // create the user
    createPets(); // helper pets

    while (!isDone) {
      choice = ink.validateMainMenu();

      switch (choice) {
        case 1: // print available pets
          ink.printAvailablePets(shelter.getPets());
          while (!goBack) {
            int pick = input.nextInt();
            if (pick != 0) {
              ink.printPetDetails(shelter.getPet(pick - 1));
              String answer = input.next();
              if (answer.equalsIgnoreCase("Y")) {
                shelter.adopt(pick - 1, user.getName());
                goBack = !goBack;
              } else {
                goBack = !goBack;
              }
            } else {
              goBack = !goBack;
            }
          } // while
          break;
        case 2: // print shelter details
          ink.printShelterDetails(shelter);
          while (!goBack) {
            input.nextLine();
            goBack = !goBack;
          } // while
          break;
        case 3: // book an appointment
          bookAppointment();
          while (!goBack) {
          }
          break;
        case 4:
          isDone = !isDone;
          break;
      } // switch
      goBack = !goBack; // seems wrong but it is NOT wrong
    } // while(main)

    ink.printGoodday();
  } // main()

  // validation of the selected day
  public static boolean isValidDay(String day) {
    HashSet<String> validDays = new HashSet<>(
        Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    return validDays.contains(day);
  }

  public static void bookAppointment() { // book a appointment
    System.out.println("Please select a day:");
    System.out.println("day1. Monday");
    System.out.println("day2. Tuesday");
    System.out.println("day3. Wednesday");
    System.out.println("day4. Thursday");
    System.out.println("day5. Friday");
    System.out.println("day6. Saturday");
    System.out.println("day7. Sunday");

    int choiceDay = input.nextInt();
    String selectedDay = "";

    // corresponding day?
    switch (choiceDay) {
      case 1:
        selectedDay = "Monday";
        break;
      case 2:
        selectedDay = "Tuesday";
        break;
      case 3:
        selectedDay = "Wednesday";
        break;
      case 4:
        selectedDay = "Thursday";
        break;
      case 5:
        selectedDay = "Friday";
        break;
      case 6:
        selectedDay = "Saturday";
        break;
      case 7:
        selectedDay = "Sunday";
        break;
      default:
        System.out.println("choice again!");
        return;
    }
    if (isValidDay(selectedDay)) {

      user.setDayOfWeek(selectedDay);
      System.out.println("Appointment for " + selectedDay);
    } else {
      System.out.println("Invalid day selected!");
    }
  }

  // 100% for test data!
  public static void createPets() {
    pet = new Pet("spot", "dog",
        3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("cleveland", "dog",
        7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("monster", "cat",
        1, "calico", "calico");
    shelter.addPet(pet);
  } // createPets()

  public static void createUser() {
    String name, email;
    int phone;
    String dayOfWeek = "";
    System.out.println("What is your name? ");
    name = input.nextLine();
    System.out.println("What is your email? ");
    email = input.nextLine();
    System.out.println("What is your phone? ");
    phone = input.nextInt();
    user = new User(name, email, phone, dayOfWeek);
  } // createUser()

  // printForm method
  public static void printForm() {
    System.out.println("form:");
    System.out.println("Name: " + user.getName());
    System.out.println("Email: " + user.getEmail());
    System.out.println("Phone: " + user.getPhone());
    System.out.println("Selected Day: " + user.getDayOfWeek());
  }

} // class
