import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class project {
    static ArrayList<String> passwords = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String master = "1234";

        System.out.println("Enter master password:");
        String input = sc.nextLine();
        if (!input.equals(master)) {
            System.out.println("Incorrect password!");
            return;
        }

        load();

        boolean run = true;
        while (run) {
            System.out.println("1 - Add");
            System.out.println("2 - Show");
            System.out.println("3 - Exit");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter site:");
                String site = sc.nextLine();
                System.out.println("Enter login:");
                String login = sc.nextLine();
                System.out.println("Enter password:");
                String pass = sc.nextLine();

                String record = site + ";" + login + ";" + pass;
                passwords.add(record);
                save();
                System.out.println("Saved!");
            } else if (choice.equals("2")) {
                if (passwords.size() == 0) {
                    System.out.println("Empty");
                } else {
                    for (int i = 0; i < passwords.size(); i++) {
                        System.out.println((i+1) + ") " + passwords.get(i));
                    }
                }
            } else if (choice.equals("3")) {
                save();
                System.out.println("Goodbye");
                run = false;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void load() {
        try {
            File file = new File("passwords.txt");
            if (!file.exists()) return;
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                passwords.add(reader.nextLine());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file");
        }
    }

    static void save() {
        try {
            FileWriter writer = new FileWriter("passwords.txt");
            for (String rec : passwords) {
                writer.write(rec + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error while writing file");
        }
    }
}
