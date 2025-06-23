import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Booking {
    private static int count=1;
    private Integer bookingId;
    private User user;
    private Train train;
    private Coach coach;
    private String date;
    private String time;
    private List<Integer> seatNumbers;
    private Map<Integer,User> bookedSeats;

    public Booking(User user, Train train, Coach coach, String date, String time, List<Integer> seatNumbers) {
        this.bookingId = count++;
        this.user = user;
        this.train = train;
        this.coach = coach;
        this.date = date;
        this.time = time;
        this.seatNumbers = new ArrayList<>(seatNumbers);
        this.bookedSeats = new HashMap<>();
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Train getTrain() {
        return train;
    }

    public Coach getCoach() {
        return coach;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public List<Integer> getSeatNumber() {
        return seatNumbers;
    }

    
    public void addBookedSeat(List<Integer> seatNumber, User user) {
        for(Integer seat : seatNumber){
            bookedSeats.put(seat, user);
        }
    }

    public void cancelBooking(Integer seatNumber) {
        if (bookedSeats.containsKey(seatNumber)) {
            bookedSeats.remove(seatNumber);
            coach.cancelSeat(seatNumber);
        } else {
            System.out.println("Seat number " + seatNumber + " is not booked.");
        }
    }
    public void getBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("User: " + user.getName());
        System.out.println("Train: " + train.getName());
        System.out.println("Coach Type: " + coach.getType());
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Seat Number: " + seatNumbers.toString());
    }
}
