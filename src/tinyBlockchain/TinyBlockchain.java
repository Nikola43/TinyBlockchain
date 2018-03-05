package tinyBlockchain;

import java.util.ArrayList;

public class TinyBlockchain {
    private ArrayList<Block> blockchain;
    private int difficulty;

    //Constructor
    public TinyBlockchain()
    {
        blockchain = new ArrayList<>();
        difficulty = 5;
        blockchain.add(new Block("Genesis Block", "0"));
    }

    public void addBlock(String data) {
        Block newBlock = new Block(data, blockchain.get(blockchain.size() - 1).getHash());
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    public void printBlockList()
    {
        String blockchainJson = StringUtil.getJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}
