import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAnalytics {

    public static void main(String[] args) throws FileNotFoundException {
        //Read the file
        File masterList = new File("Ressources/students.csv");
        //System.out.println(masterList.exists());
        Scanner fileReader = new Scanner(masterList);

        //Arraylist to contain the individual entities (Students)
        ArrayList<Student> listOfStudents = new ArrayList<>();

        while (fileReader.hasNext()) {
            //Print all entities
            String currentLine = fileReader.nextLine();
            //System.out.println(currentLine)

            //Make object from every entity
            //Tell the ArrayList to split the data into individual mail and name lists
            String[] lineAsArray = currentLine.split(";"); //Takes a String as an argument, and returns String Array
            String studentMail = lineAsArray[0]; //.trim() before ; would remove whitespace from both ends of a String
            String studentName = lineAsArray[1];

            Student individualStudent = new Student(studentMail, studentName); //Creates an object called individualStudent, with a cluster of information (attributes)

            listOfStudents.add(individualStudent); //Add each individualStudent to Arraylist listOfStudents
            //To print every object
            //System.out.println("Student name: " + studentName);
            //System.out.println("Student mail: " + studentMail);
        }
        //Print how many Students are in the Arraylist listOfStudents
        System.out.println("There is a total of " + listOfStudents.size() + " students attending the course");

        findLongestName(listOfStudents);                        //Returns Frederik Mahipal Høst Vilhelmsen
        howManySimons(listOfStudents);                          //Returns 3 Simons
        averageNameLength(listOfStudents);                      //Returns 18.205882352941178 characters
        System.out.println(maxAmountOfNames(listOfStudents));   //Returns Andrea Jiao Brinkbøl Gråe
    }

    public static String findLongestName(ArrayList<Student> listOfStudents) {
        //Find no. of characters in each name
        //Go through all names and compare no. of char
        //Return result
        String longestName = "";
        for (Student individualStudent : listOfStudents) { //For each loop: Go through every instance of 'Student' on the 'listOfStudents'
            int currentStudentLength = individualStudent.getName().length();
            if (currentStudentLength > longestName.length()) {
                longestName = individualStudent.getName();
            }
        }
        System.out.println("The student with the longest name is: " + longestName);
        return longestName;
    }
    /*howManySimons() - returns how many Simons are in this class*/
    public static int howManySimons(ArrayList<Student> listOfStudents) {
        int totalSimons = 0; //Create the value we need to return
        for (Student individualStudent : listOfStudents) { //Run through list for Simons
            individualStudent.getName();
            if (individualStudent.getName().startsWith("Simon")) {
                //TODO: find better method - difference between .startsWith and .contains, how to use each?
                totalSimons++; //Add each Simon to the value of totalSimons
            }
        }
        System.out.println("There are a total of " + totalSimons + " Simons in this course.");
        return totalSimons;
    }
    /*averageNameLength() - returns the average name length*/
    public static double averageNameLength(ArrayList<Student> listOfStudents) {
        double averageLength;
        //Add all length of names together, divide by total students = average name length
        //int count;
        double sum = 0;
        for (Student individualStudent : listOfStudents) {
            double currentName = individualStudent.getName().replaceAll("[\\s-]+", "").length();
            //Need counter for variable 'name'
            //Store variable 'length of name'
            sum += currentName;
            //Calculate average length by dividing by listOfStudents.size
        }
        averageLength = sum / listOfStudents.size();
        System.out.println("The average name length is: " + averageLength + " characters");
        return averageLength;
    }
    //maxAmountOfNames() - returns the max amount of names e.g Nicklas Frederiksen = 2
    public static String maxAmountOfNames(ArrayList<Student> listOfStudents) {
        int maxAmountOfNames = 0;
        String personWithMostNames = "";
        for (Student individualStudent : listOfStudents) {
            String[] numberOfNamesForIndividualStudent = individualStudent.getName().split(" ");
            //maxAmountOfNames = 0, replace with
            //Number of elements in Array
            System.out.println(individualStudent.getName() + " has a total of " + numberOfNamesForIndividualStudent.length + " names");  //For every student on the list, print "(Name of student)" + maxAmountOfNames

            //number of names
            //list of students
            //Greatest amount of names
            if (numberOfNamesForIndividualStudent.length > maxAmountOfNames) {
                maxAmountOfNames = numberOfNamesForIndividualStudent.length;
                personWithMostNames = individualStudent.getName();
            }
        }
        return "The person with the most names is " + personWithMostNames + " who has " + maxAmountOfNames + " names";
        //TODO: How to add ties?
    }
}