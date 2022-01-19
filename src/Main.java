public class Main {
     public static void main(String[] args) {
//         System.out.println("Hola mundo");
         Doctor myDoctor = new Doctor("Nicolás Sandoval");
         myDoctor.showName();
         myDoctor.name = "Tobias Sandoval";
         myDoctor.showName();
    }
}
