import java.util.*;

public class Coach {
    private static int count = 1;
    private Integer coachId;
    private CoachType type;
    private Integer totalSeats;
    private Map<Integer, Boolean> seatAvailability;
    private Integer availableSeatsCount;

    public enum CoachType {
        AC,
        SLEEPER,
        GENERAL
    }

    public Coach(CoachType type, Integer totalSeats) {
        this.coachId = count++;
        this.type = type;
        this.totalSeats = totalSeats;
        this.seatAvailability = new HashMap<>();
        this.availableSeatsCount = totalSeats;

        for (int i = 1; i <= totalSeats; i++) {
            seatAvailability.put(i, true); // true = available
        }
    }

    public Integer getCoachId() {
        return coachId;
    }

    public CoachType getType() {
        return type;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public Integer getAvailableSeatsCount() {
        return availableSeatsCount;
    }

    public List<Integer> bookSeat() {
        List<Integer> bookedSeats = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : seatAvailability.entrySet()) {
            if (entry.getValue()) {
                bookedSeats.add(entry.getKey());
                seatAvailability.put(entry.getKey(), false);
                availableSeatsCount--;
            }
            
        }
        return bookedSeats;
    }

    public void cancelSeat(int seatNumber) {
        if (seatAvailability.containsKey(seatNumber) && !seatAvailability.get(seatNumber)) {
            seatAvailability.put(seatNumber, true);
            availableSeatsCount++;
        }
    }

    public List<Integer> getAvailableSeatNumbers() {
        List<Integer> available = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : seatAvailability.entrySet()) {
            if (entry.getValue()) {
                available.add(entry.getKey());
            }
        }
        return available;
    }
}
