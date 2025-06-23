import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        User user;
        Profile profile;
        Train train;
        Coach coach;
        Booking booking;

        Map<String,User> userMap = new HashMap<>();
        Map<Integer,Train> TrainIds = new HashMap<>();
        Train currTrainId;
        User loggedInUser = null;

        while (true) {
            System.out.println("Welcome to the User Management System");
            System.out.println("1. Create User");
            System.out.println("2. Login ");
            System.out.println("3. View profile");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Logout");
            System.out.println("7. Admin Options:");
            System.out.println("8. Exit");
            System.out.print("Please select an option: ");
            
            int choice = sc.nextInt();

            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter User Email: "); 
                    String email = sc.nextLine();
                    System.out.print("Enter User Password: ");
                    String password = sc.nextLine();
                    System.out.print("Enter User Phone Number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter User Location: ");
                    String location = sc.nextLine();
                    System.out.print("Enter user type (CUSTOMER/ADMIN): ");
                    String userTypeInput = sc.nextLine().toUpperCase();
                    User.UserType userType = User.UserType.valueOf(userTypeInput);
                    user = new User(name, email, password, phoneNumber,userType,location);
                    userMap.put(email, user);
                    System.out.println("User created successfully!");

                    System.out.println("Do you want to get profile details? (y/n)");
                    char choiceProfile = sc.nextLine().toLowerCase().charAt(0);
                    if(choiceProfile =='y'){
                        System.out.print("Enter Age:");
                        int age = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter address:");
                        String address= sc.nextLine();
                        System.out.print("Enter preferred payment method (Card/Upi/NetBanking):");
                        String paymentMethodInput = sc.next().toUpperCase();
                        profile = new Profile(age, address, Profile.PaymentMethod.valueOf(paymentMethodInput));
                        user.setProfile(profile);
                        System.out.println("Profile created successfully!");
                    }
                    break;
                    
                case 2:
                    System.out.println("Enter the registered Email :");
                    String emailToView = sc.nextLine();
                    System.out.println("Enter the Password:");
                    String passwordToView = sc.nextLine();
                    if(userMap.getOrDefault(emailToView,null)!=null && userMap.get(emailToView).getPassword().equals(passwordToView)){
                        loggedInUser = userMap.get(emailToView);
                        System.out.println("Login successful!");
                        System.out.println("User Details:");
                    } else {
                        System.out.println("Invalid email or password. Please try again.");
                    }
                    break;

                case 3:
                    if(loggedInUser != null){
                        System.out.print("Uer details : ");
                        loggedInUser.getUserDetails();
                    }
                    else {
                        System.out.println("Please login to view profile.");
                    }
                    break;
                
                case 4:
                    if(loggedInUser!=null){
                        System.out.println("All Trains: ");
                        for (Map.Entry<Integer, Train> entry : TrainIds.entrySet()) {
                            Train t = entry.getValue();
                            t.getTrainDetails();
                        }
                        System.out.print("Enter Train ID to book a ticket: ");
                        int trainIdToBook = sc.nextInt();
                        if(TrainIds.getOrDefault(trainIdToBook,null)!=null){
                            currTrainId=TrainIds.get(trainIdToBook);
                            System.out.println("Selecte the coach type (SLEEPER/GENERAL/AC): ");
                            String coachTypeInput = sc.next().toUpperCase();
                            Coach.CoachType coachType = Coach.CoachType.valueOf(coachTypeInput);
                            for(Coach c: currTrainId.getCoach()){
                                if(c.getType().equals(coachType)){
                                    System.out.println("Enter the number of seats to book:");
                                    int seatsToBook = sc.nextInt();
                                    sc.nextLine(); // Consume newline
                                    System.out.println("Enter the date of travel (YYYY-MM-DD):");
                                    String date = sc.nextLine();
                                    int timeNumber =currTrainId.getLocationId(loggedInUser.getLocation());
                                    String time = currTrainId.getTimings().get(timeNumber);
                                    if(c.getAvailableSeatsCount()>seatsToBook){
                                        booking = new Booking(loggedInUser, currTrainId, c, date, time, c.bookSeat());
                                        booking.addBookedSeat(c.bookSeat(), loggedInUser);
                                        System.out.println("Booking successful! Booking ID: " + booking.getBookingId());
                                        System.out.println("Booking Details:");
                                        booking.getBookingDetails();
                                    }
                                    else{
                                        System.out.println("Not enough seats available in the selected coach.");
                                        break;
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("Invalid Train ID. Please try again.");
                            break;
                        }
                    }
                    else{
                        System.out.println("Please login to book a ticket.");
                    }
                    break;
                case 5:
                    System.out.print("under development");
                    break;

                case 6:
                    loggedInUser=null;
                    System.out.print("Successfully logged out!!");
                    break;
                case 7 :
                    System.out.println("Admin Options:");
                    System.out.println("1. View all users");
                    System.out.println("2. View all bookings");
                    System.out.println("3. Add Train");
                    System.out.println("4. Add Coach");
                    System.out.println("5. View all trains");
                    System.out.println("6. Exit Admin Options");
                    System.out.print("Please select an option: ");
                    int adminChoice = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    switch (adminChoice) {
                        case 1:
                            System.out.println("All Users:");
                            for (User u : userMap.values()) {
                                u.getUserDetails();
                            }
                            break;
                        case 2:
                            // Implement view bookings logic
                            // booking.getBookingDetails();
                            break;
                        case 3:
                            System.out.print("Enter Train Name: ");
                            String trainName = sc.nextLine();

                            System.out.println("Enter the stations:");
                            List<String> stations = new ArrayList<>();
                            while(sc.hasNextLine()) {
                                String station = sc.nextLine();
                                if(station.isEmpty()) break; // Exit on empty line
                                stations.add(station);
                            }

                            System.out.println("Enter the timings:");
                            List<String> timings = new ArrayList<>();
                            while(sc.hasNextLine()) {
                                String timing = sc.nextLine();
                                if(timing.isEmpty()) break; // Exit on empty line
                                timings.add(timing);
                            }

                            System.out.println("Enter the dates:");
                            List<String> dates = new ArrayList<>();
                            while(sc.hasNextLine()) {
                                String date = sc.nextLine();
                                if(date.isEmpty()) break; // Exit on empty line
                                dates.add(date);
                            }

                            train = new Train(trainName, stations, timings, dates);
                            TrainIds.put(train.getTrainId(), train);
                            System.out.println("Train added successfully");
                            break;
                        case 4:
                            System.out.println("Enter the coach type (SLEEPER/GENERAL/AC)");
                            String coachTypeInput = sc.nextLine();
                            Coach.CoachType coachType = Coach.CoachType.valueOf(coachTypeInput.toUpperCase());
                            System.out.println("Enter the total number of seats : ");
                            int totSeats  = sc.nextInt();
                            coach = new Coach(coachType,totSeats);
                            System.out.println("Coach added successfully with ID: ");
                            System.out.println("Enter the train ID to add this coach: ");
                            int trainId = sc.nextInt();
                            currTrainId = TrainIds.get(trainId);
                            if(currTrainId == null) {
                                System.out.println("Train ID not found. Please try again.");
                            }
                            else currTrainId.setCoach(coach);
                            break;
                        case 5:
                            System.out.println("All Trains:");
                            Train trains;
                            for( Map.Entry<Integer,Train> entry: TrainIds.entrySet()) {
                                trains = entry.getValue();
                                trains.getTrainDetails();
                            }
                            break;
                        case 6:
                            System.out.println("Exiting admin controlls.");
                            return;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }    
                    break;

                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
