package tinyBlockchain;

public class Main {



    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        TinyBlockchain blockchain = new TinyBlockchain();

        blockchain.addBlock("0.7");

        blockchain.addBlock("3.4");

        blockchain.addBlock("5.5");

        blockchain.printBlockList();

        System.out.println("\nBlockchain is Valid: " + blockchain.isChainValid());
    }
}
