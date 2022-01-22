import java.util.ArrayList;
import java.util.Date;

public class Doctor {
    static int id = 0;
    private String name;
    private String speciality;

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

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment(){
        return availableAppointments;
    }

    public static class AvailableAppointment{
        int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
