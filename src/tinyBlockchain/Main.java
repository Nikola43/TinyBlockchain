package tinyBlockchain;

public class Main {



    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        TinyBlockchain blockchain = new TinyBlockchain();

        blockchain.addBlock("Paulo 1");

        blockchain.addBlock("Paulo 2");

        blockchain.addBlock("Paulo 3");

        blockchain.printBlockList();

        System.out.println("\nBlockchain is Valid: " + blockchain.isChainValid());
    }
}
