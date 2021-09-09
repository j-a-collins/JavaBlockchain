import java.util.ArrayList;
import com.google.gson.GsonBuilder;

/*
Main class for my first attempt at creating
a blockchain using SHA256 for the fingerprint

J-A-Collins 09-09-2021
*/


import java.util.ArrayList;

public class MyFirstBlockChain {
    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int complexity = 5;
   /*
   Complexity here is a measure of how difficult it is to find a hash below the given target.
   1: is instantly solvable on my laptop
   5: takes around 3 seconds per block
   10: takes longer than I am patient enough to wait for
   Info on bitcoin's current difficulty can be found here: http://bitcoin.sipa.be/
   */

    public static void main(String[] args) {
        blockChain.add(new Block("This is the genesis of the Blockchain.", "0"));
        System.out.println("Currently mining block 1...");
        blockChain.get(0).mineBlock(complexity);
        blockChain.add(new Block("This is the second block in the chain.", blockChain.get(blockChain.size()-1).hash));
        System.out.println("Currently mining block 2...");
        blockChain.get(1).mineBlock(complexity);
        blockChain.add(new Block("This is the third block in the chain.", blockChain.get(blockChain.size()-1).hash));
        System.out.println("Currently mining block 3...");
        blockChain.get(2).mineBlock(complexity);

        System.out.println(StringUtil.lineDivider);
        System.out.println("\nThe Blockchain is valid:" + isChainValid());
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("\nThe Entire Blockchain: ");
        System.out.println(blockchainJson);
    }

    // Methods
    public static boolean isChainValid() {
        /* Compares the registered hash with the calculated hash */
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[complexity]).replace('\0', '0');

        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Hashes are not valid.");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous hashes are not valid.");
                return false;
            }

            if (!currentBlock.hash.substring(0, complexity).equals(hashTarget)) {
                System.out.println("This block has not been mined.");
                return false;
            }
        }
        return true;
    }
}
