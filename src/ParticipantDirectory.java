

import java.util.Map;
import java.util.TreeMap;

/**
 * Application to demonstrate a TreeMap storing key:value
 * pairs in sorted order based on the keys.
 */
public class ParticipantDirectory {

    private final Map<String, Participant> usernameToParticipant;
    // stores participants by username
    private final Map<Integer, Participant> userIdNumberToParticipant;
    // stores participants by user id

    /*
    (1) look up participants by ID number and (2) obtain a roster of participants sorted by ID number
     */

    /**
     * ParticipantDirectory constructor creates two TreeMaps to store data with different keys.
     */
    public ParticipantDirectory() {
        this.usernameToParticipant = new TreeMap<>();
        this.userIdNumberToParticipant = new TreeMap<>();
    }

    /**
     * Adds a Participant to this ParticipantDirectory.
     *
     * @param idNumber This Participant's unique ID number.
     * @param username The Participant's username.
     * @param fullname The Participant's full name.
     */
    public void addParticipant(Integer idNumber, String username, String fullname) {
        Participant p = new Participant(idNumber, username, fullname);
        this.usernameToParticipant.put(p.username, p);
        // using the username of the Participant, p, as key.
        this.userIdNumberToParticipant.put(p.idNumber, p);
    }

    /**
     * Looks up a Participant given a username. This operation is
     * O(log n) when a TreeMap is used to store participants.
     *
     * @param username The username to be looked up.
     * @return Participant object mapped to the given username; null if username not in map.
     */
    public Participant getParticipantByUsername(String username) {
        // Lookup the username in the participants tree map.
        return this.usernameToParticipant.get(username);
    }

    /**
     * Looks up a Participant given a username. This operation is
     * O(log n) when a TreeMap is used to store participants.
     *
     * @param idNumber The ID number to be looked up.
     * @return Participant object mapped to the given username; null if username not in map.
     */
    public Participant getParticipantByID(Integer idNumber) {
        return this.userIdNumberToParticipant.get(idNumber);
    }

    /**
     * Builds and returns a String containing the current Participant roster
     * sorted by username.
     *
     * @return String containing the current roster, sorted by username.
     */
    public String getRosterByUsername() {
        // Use a StringBuilder for efficiency when appending strings.
        StringBuilder sb = new StringBuilder();
        for (Participant p : this.usernameToParticipant.values()) {
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Builds and returns a String containing the current Participant roster
     * sorted by ID number.
     *
     * @return String containing the current roster, sorted by ID number.
     */
    public String getRosterByID() {
        StringBuilder sb = new StringBuilder();
        for (Participant p : this.userIdNumberToParticipant.values()) {
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Main method to demonstrate the ParticipantDirectory.
     *
     * @param args Command line arguments; ignored in this application.
     */
    public static void main(String[] args) {
        ParticipantDirectory dir = new ParticipantDirectory();

        // Add a bit of test data.
        dir.addParticipant(1, "fjones", "Fred Jones");
        dir.addParticipant(2, "dblake", "Daphne Blake");
        dir.addParticipant(3, "vdinkley", "Velma Dinkley");
        dir.addParticipant(4, "nroberts", "Norville Rogers");

        System.out.println("Participant 'fjones': " +
            dir.getParticipantByUsername("fjones"));

        System.out.println("Participant Roster By Username:");
        System.out.println(dir.getRosterByUsername());
    }
}
