import static ui.UIMenu.*;

public class Main {
     public static void main(String[] args) {
         Doctor myDoctor = new Doctor("Tobias Sandoval", "Pediatra");
         System.out.println(myDoctor.name);
         System.out.println(myDoctor.speciality);
         showMenu();
    }
}
