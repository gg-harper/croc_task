package production;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int counter = 9;


        Scanner scanner = new Scanner(System.in);
        try {
            switch (args[0]) {
                case "-f":
                    if (args.length < 2) {
                        System.out.println("Wrong format. Use -h option.");
                        return;
                    }
                    System.out.println("How many producers?");
                    int producerCount = Integer.parseInt(scanner.nextLine());
                    System.out.println("How many consumers?");
                    int consumerCount = Integer.parseInt(scanner.nextLine());

                    Product product = new Product();                    // create product object to create and temporary storage data
                    Storage storage = new Storage(args[1]);             //create storage object to write data to file
                    Producer producer = new Producer(product, counter);
                    Consumer consumer = new Consumer(product, storage, counter);

                    for (int i = 0; i < producerCount; i++) {
                        new Thread(producer).start();
                    }
                    for (int i = 0; i < consumerCount; i++) {
                        new Thread(consumer).start();
                    }
                    break;
                case "-h":
                    System.out.println("Use -f option to set output file. Example \"-f filename.txt\"");
                    break;
                default:
                    System.out.println("Unknown option. Use -h to get some help");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong format. Use -h option.");
        }

   }
}
