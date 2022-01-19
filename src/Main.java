import static ui.UIMenu.*;

public class Main {
     public static void main(String[] args) {
//         System.out.println("Hola mundo");
         Doctor myDoctor = new Doctor();
         myDoctor.name = "Tobias Sandoval";
         myDoctor.showName();
         myDoctor.showId();

         Doctor myDoctorNico = new Doctor();
         myDoctorNico.name = "Nicolás Sandoval";
         myDoctorNico.showName();
         myDoctorNico.showId();

         showMenu();
    }
}
