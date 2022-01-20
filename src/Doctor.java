public class Doctor {
    static int id = 0;
    String name;
    String speciality;

    Doctor(){

    }

    Doctor(String name, String speciality){
        System.out.println("El nombre del doctor asignado es: "+name);
        this.name = name;
        this.speciality = speciality;
    }
    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("Identificador del Doctor " + id);
    }
}
