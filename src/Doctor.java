public class Doctor {
    static int id;
    String name;
    String speciality;

    Doctor(){
        System.out.println("Construyendo el objeto Doctor");
        id ++;
    }

    Doctor(String name){
        System.out.println("El nombre del doctor asignado es: "+name);
    }
    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("Identificador del Doctor " + id);
    }
}
