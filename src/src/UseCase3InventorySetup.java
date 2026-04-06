import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - RoomInventory
 */
class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

/**
 * CLASS - HotelRoom (renamed to avoid duplicate error)
 */
class HotelRoom {

    private String type;
    private int beds;
    private int size;
    private double price;

    public HotelRoom(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() { return type; }
    public int getBeds() { return beds; }
    public int getSize() { return size; }
    public double getPrice() { return price; }
}

/**
 * MAIN CLASS - UseCase3InventorySetup
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Create room objects
        HotelRoom single = new HotelRoom("Single", 1, 250, 1500.0);
        HotelRoom doubleRoom = new HotelRoom("Double", 2, 400, 2500.0);
        HotelRoom suite = new HotelRoom("Suite", 3, 750, 5000.0);

        // Store rooms in map
        Map<String, HotelRoom> roomMap = new HashMap<>();
        roomMap.put("Single", single);
        roomMap.put("Double", doubleRoom);
        roomMap.put("Suite", suite);

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display output
        System.out.println("Hotel Room Inventory Status\n");

        for (String type : roomMap.keySet()) {

            HotelRoom r = roomMap.get(type);
            int available = inventory.getRoomAvailability().get(type);

            System.out.println(type + " Room:");
            System.out.println("Beds: " + r.getBeds());
            System.out.println("Size: " + r.getSize() + " sqft");
            System.out.println("Price per night: " + r.getPrice());
            System.out.println("Available Rooms: " + available);
            System.out.println();
        }
    }
}

