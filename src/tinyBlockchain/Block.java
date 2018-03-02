package tinyBlockchain;

import java.util.Date;

public class Block {

    private String data;
    private long timeStamp;
    private String previousHash;
    private String hash;
    private int nonce;

    //Block Constructor.
    public Block( ) {
        data = "";
        timeStamp = 0;
        previousHash = "";
        hash = "";
    }

    public Block(String data, String previousHash) {
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public int getNonce() {
        return nonce;
    }

    @Override
    public String toString() {
        return (data+","+timeStamp+","+previousHash+","+hash+","+nonce);
    }

    //Calculate new hash based on blocks contents
    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                      Long.toString(timeStamp) +
                      Integer.toString(nonce) +
                      data);
    }

    //Increases nonce value until hash target is reached.
    public void mineBlock(int difficulty) {
        String target = StringUtil.getDificultyString(difficulty); //Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }
}