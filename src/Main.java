import static ui.UIMenu.*;

public class Main {
     public static void main(String[] args) {
         Doctor myDoctor = new Doctor("Tobias Sandoval", "Pediatra");
         System.out.println(myDoctor.name);
         System.out.println(myDoctor.speciality);

         Patient myPatient = new Patient("Nico", "nico@gmail.com");
         System.out.println(myPatient.name);
         System.out.println(myPatient.email);
//         showMenu();
    }
}
