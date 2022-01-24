import java.util.Date;

import static ui.UIMenu.*;

public class Main {
     public static void main(String[] args) {
         Doctor myDoctor = new Doctor("Tobias Sandoval", "tobi@gmail.com");
         myDoctor.addAvailableAppointment(new Date(), "6AM");
         myDoctor.addAvailableAppointment(new Date(), "8AM");
         myDoctor.addAvailableAppointment(new Date(), "10AM");
         System.out.println(myDoctor.getData());
//         for (Doctor.AvailableAppointment ap: myDoctor.getAvailableAppointment()) {
//             System.out.println(ap.getDate() + " " + ap.getTime());
//         }
         Patient myPatient = new Patient("Nico", "nico@gmail.com");

         System.out.println(myPatient.getData());
        /* myPatient.setHeight(164.5);
         System.out.println(myPatient.getHeight());

         myPatient.setWeight(66.7);
         System.out.println(myPatient.getWeight());

         myPatient.setPhoneNumber("12345689");
         System.out.println(myPatient.getPhoneNumber());
//         showMenu();*/
    }
}
