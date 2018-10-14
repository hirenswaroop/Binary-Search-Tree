import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Handles all File I/O for the program
 * @author uscart
 *
 */
public class Main {
   public static void main (String args[]) {
       File file;
       Scanner fInput = null;
       Scanner fRemove = null;
       BSTree<Integer> t = new BSTree<Integer>();

       try {
           // Input file finding
           System.out.println ("Input a valid input text file in the format yourfilename.txt");
           Scanner input = new Scanner (System.in);
           String inputS = input.nextLine().trim();
           file = new File(inputS);
           if (inputS.equalsIgnoreCase("cancel")) {
               System.exit(0);
           }

           while (!file.exists()) {
               System.out.println ("Input a valid input text file in the format yourfilename.txt");
               input = new Scanner (System.in);
               String inputS2 = input.nextLine().trim();
               if (inputS2.equalsIgnoreCase("cancel")) {
                   System.exit(0);
               }
               file = new File(inputS2);
           }
           fInput = new Scanner(file);

           while (fInput.hasNextInt()) {
               int i = fInput.nextInt();
               t.add (i);
           }

           // Remove file finding
           System.out.println ("Input a valid text file with numbers you want to remove in the format yourfilename.txt");
           Scanner remove = new Scanner (System.in);
           String removeS = remove.nextLine().trim();
           if (removeS.equalsIgnoreCase("cancel")) {
               System.exit(0);
           }
           File rFile = new File (removeS);

           while (!rFile.exists()) {
               System.out.println ("Input a valid text file with numbers you want to remove in the format yourfilename.txt");
               remove = new Scanner (System.in);
               String removeS2 = remove.nextLine().trim();
               if (removeS2.equalsIgnoreCase("cancel")) {
                   System.exit(0);
               }
               rFile = new File (removeS2);
           }
           fRemove = new Scanner(rFile);

           while (fRemove.hasNextInt()) {
               t.removeAll(fRemove.nextInt());
           }

           input.close();
           fInput.close();
           remove.close();

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

       // Output File Creation
       try {
           File oFile = new File("output.txt");
           BufferedWriter writer = new BufferedWriter (new FileWriter(oFile));

           // In order
           LList<Integer> list = t.inOrder();
           writer.write("In order traversal\n");
           for (int i = 0; i < list.size(); i++) {
               writer.write(list.get(i) + " ");
           }
           writer.write("\n\n");

           // Post Order
           LList<Integer> list1 = t.postOrder();
           writer.write("Post order traversal\n");
           for (int i = 0; i < list1.size(); i++) {
               writer.write(list1.get(i) + " ");
           }
           writer.write("\n\n");

           // Pre order
           LList<Integer> list2 = t.preOrder();
           writer.write("Pre order traversal\n");
           for (int i = 0; i < list2.size(); i++) {
               writer.write(list2.get(i) + " ");
           }

           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
