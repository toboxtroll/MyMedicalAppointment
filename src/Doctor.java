public class Doctor {
    int id;
    String name;
    String speciality;

    Doctor(){
        System.out.println("Construyendo el objeto Doctor");
    }

    Doctor(String name){
        System.out.println("El nombre del doctor asignado es: "+name);
    }
    public void showName(){
        System.out.println(name);
    }
}
