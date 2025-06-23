import java.util.ArrayList;
import java.util.List;

public class Train {
    private static int count=1;
    private Integer trainId;
    private String name;
    private List<String> stations;
    private List<String> timings;
    private List<Coach> coach;
    private List<String> dates;

    Train(String name, List<String> stations, List<String> timings, List<String> dates) {
        this.trainId = count++;
        this.name = name;
        this.stations = new ArrayList<>(stations);
        this.coach=new ArrayList<>(coach);
        this.timings = new ArrayList<>(timings);
        this.dates = new ArrayList<>(dates);
    }

    public Integer getTrainId() {
        return trainId;
    }  

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return stations;
    }

    public int getLocationId(String station) {
        return (stations.indexOf(station));
    }

    public List<Coach> getCoach() {
        return coach;
    }

    public List<String> getDates() {
        return dates;
    }

    public List<String> getTimings() {
        return timings;
    }

    public void setCoach(Coach coach) {
        this.coach.add(coach);
    }

    public void getTrainDetails() {
        System.out.println("Train ID: " + trainId);
        System.out.println("Name: " + name);
        System.out.println("Stations: " + String.join(", ", stations));
        System.out.println("Timings: " + String.join(", ", timings));
        System.out.println("Dates: " + String.join(", ", dates));
        System.out.println("Coaches:");
        for (Coach c : coach) {
            System.out.println("  Coach ID: " + c.getCoachId() + ", Type: " + c.getType() + ", Total Seats: " + c.getTotalSeats() + ", Available Seats: " + c.getAvailableSeatsCount());
        }
    } 
}
