/*
Programming a simple Blockchain example.

J-A-Collins
09-09-2021
*/

// Imports
import javax.xml.crypto.Data;
import java.util.Date;

public class Block {
    // Instance variables
    public String hash;
    public String previousHash;
    private String data; /* Data is just a simple text message */
    private long timestamp; // in milliseconds
    private int miner;

    // Constructor
    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // Methods
    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                previousHash +
                Long.toString(timestamp) +
                Integer.toString(miner) + data
        );
        return calculatedHash;
    }

    public void mineBlock(int complexity) {
        String target = new String(new char[complexity]).replace('\0', '0');
        while (!hash.substring(0, complexity).equals(target)) {
            miner ++;
            hash = calculateHash();
        }
        System.out.println("A new block has been mined: " + hash);
    }
}
