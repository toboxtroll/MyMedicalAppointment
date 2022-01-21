import static ui.UIMenu.*;

public class Main {
     public static void main(String[] args) {
         Doctor myDoctor = new Doctor("Tobias Sandoval", "Pediatra");
         System.out.println(myDoctor.name);
         System.out.println(myDoctor.speciality);

         Patient myPatient = new Patient("Nico", "nico@gmail.com");

         myPatient.setHeight(164.5);
         System.out.println(myPatient.getHeight());

         myPatient.setWeight(66.7);
         System.out.println(myPatient.getWeight());

         myPatient.setPhoneNumber("12345689");
         System.out.println(myPatient.getPhoneNumber());
//         showMenu();
    }
}
