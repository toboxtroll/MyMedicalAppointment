import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;

    Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del doctor asignado es: "+name);
    }
    public void showName(){
        System.out.println(super.getName());
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
