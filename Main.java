// code without GUI 
/*
package library;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
     Scanner input = new Scanner(System.in);
     ArrayList<String> Recommendations = new ArrayList<>();
  
    String[] books = {"Java","Math","Probability","Accounting"};
    boolean[] Borrowbooks = {false, false, false, false};// false mean books 
    boolean found = false;
    
    while (true) {  
         System.out.println("Welcome Readers in your world");
         System.out.println("Please choice number of the following list");
         System.out.println("1-show Book");
         System.out.println("2-Borrow Book");
         System.out.println("3-Back book");
         System.out.println("4-recomendations and feedback");
         
  
   
   int choice = input.nextInt();
          
       if (choice == 1 ) { 
        System.out.println("Available Books:");
         for (int i =0; i<books.length;i++) {
                 if (!Borrowbooks[i]) {System.out.println(books[i]);
                 }
                }
      }
      
      else if (choice == 2 ) {  
        System.out.println("Wich Book do you want:");
        String bookname = input.next();
        String booknamelo = bookname.toLowerCase();
        for (int i = 0; i<books.length;i++) {
          if (books[i].toLowerCase().equals(booknamelo)) {
                   found = true;
          if (!Borrowbooks[i]) { 
            Borrowbooks[i]= true ; 
                  System.out.println("You borrowed " + books[i]);
                  }
          else {
            
            System.out.println("Book Are not Avalibale");
          }
          }
            break; 
            }
            
        if (!found) {
                    System.out.println("Book Are not available");
        
        } 
        
      }
       // back book
      else if (choice == 3 ) { 
        System.out.println("Which book do you want to return?"); 
        String bookname2 = input.next();
        String booknamelo2 = bookname2.toLowerCase();// small 
        found = false;
        for (int i = 0; i<books.length;i++) {
          if (books[i].toLowerCase().equals(booknamelo2)) {
            found = true;
            if ( Borrowbooks[i]) {
              Borrowbooks[i] = false;
            System.out.println("The "+ books[i]+ " Are reterned Sucssefuly");
            } 
            
          
           else {
             System.out.println("This book Is not Borrowed");
              }
          break;
          }
        }
          if (!found) {
                System.out.println("Book not found in library.");
            }
        
      }
      else if (choice == 4 ) { 
        System.out.println("1- New recomendations & fedback");
        System.out.println("2- last recomendations & fedback");
          System.out.println("Enter your choice:");
        int number= input.nextInt();
        input.nextLine();
        if (number==1) {
          System.out.println("Enter your Recomendation:");
                   String Recomendation = input.nextLine();
                   Recommendations.add( Recomendation);
                   System.out.println("Your recommendation has been saved!");            
        }
        else if (number == 2) {
          for (String rec: Recommendations ) {
          System.out.println(rec);
        }
          
          
        }
      
      }



    }
    


  }
}*/






// code with GUI



package library;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.util.ArrayList;

public class Main {
  
    public static void main(String[] args) {
    	
    	 String[] books = {"Java","Math","Probability","Accounting"};
         boolean[] Borrowbooks = {false, false, false, false};
    	ArrayList<String> Recommendations = new ArrayList<>();
    	
 // Main frame
        JFrame frame = new JFrame("Library System");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.decode("#9AB17A"));
        
 //images
        ImageIcon icon = new ImageIcon(Main.class.getResource("/images/libaray logo.png")) ;
        frame.setIconImage(icon.getImage());
        
        
//books button
       
        JButton showBooksBtn = new JButton("Show Books");
        showBooksBtn.setBackground(Color.decode("#F3E4C9"));
        frame.add(showBooksBtn);

        
        JButton borrowBtn = new JButton("Borrow Book");
        borrowBtn.setBackground(Color.decode("#F3E4C9"));
        frame.add(borrowBtn);

        
        JButton returnBtn = new JButton("Return Book");
        returnBtn.setBackground(Color.decode("#F3E4C9"));
        frame.add(returnBtn);

        
        JButton recBtn = new JButton("Recommendations & Feedback");
        recBtn.setBackground(Color.decode("#F3E4C9"));
        frame.add(recBtn);
        
        
        frame.setVisible(true);

  // Output Area
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 120, 400, 200);
        outputArea.setLineWrap(true);           
        outputArea.setWrapStyleWord(true);
        outputArea.setBackground(Color.decode("#9AB17A"));
        outputArea.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        frame.add(outputArea);

        // Action for Show Books
        showBooksBtn.addActionListener(e -> {
            outputArea.setText("Available Books:\n");
            for (int i = 0; i < books.length; i++) {
                if (!Borrowbooks[i]) {
                    outputArea.append(books[i] + "\n");
                }
            }
        });

        // Action for Borrow Book
        borrowBtn.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(frame, "Enter the book name to borrow:");
            if (bookName != null) {
                boolean found = false;
                for (int i = 0; i < books.length; i++) {
                    if (books[i].equalsIgnoreCase(bookName)) {
                        found = true;
                        if (!Borrowbooks[i]) {
                            Borrowbooks[i] = true;
                            outputArea.setText("You borrowed " + books[i]);
                        } else {
                            outputArea.setText("Book is not available");
                        }
                        break;
                    }
                }
                if (!found) outputArea.setText("Book not found in library");
            }
        });

       // Action for Return Book
        returnBtn.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(frame, "Enter the book name to return:");
            if (bookName != null) {
                boolean found = false;
                for (int i = 0; i < books.length; i++) {
                    if (books[i].equalsIgnoreCase(bookName)) {
                        found = true;
                        if (Borrowbooks[i]) {
                            Borrowbooks[i] = false;
                            outputArea.setText("The " + books[i] + " has been returned successfully");
                        } else {
                            outputArea.setText("This book is not borrowed");
                        }
                        break;
                    }
                }
                if (!found) outputArea.setText("Book not found in library");
            }
        });

        // Action for Recommendations
        recBtn.addActionListener(e -> {
            String[] options = {"New Recommendation", "View Recommendations"};
            int choice = JOptionPane.showOptionDialog( // how the popup window show ?
            		frame, // the window 
            		"Choose an option",//message appear 
                    "Recommendations", //title
                    JOptionPane.DEFAULT_OPTION, // option type
                    JOptionPane.QUESTION_MESSAGE,// icon type
                    null,//icon
                    options, //buttons
                    options[0] // default button 
                    		
            		);

            if (choice == 0) {
                String rec = JOptionPane.showInputDialog(frame, "Enter your recommendation:");
                if (rec != null && !rec.isEmpty()) {
                    Recommendations.add(rec);
                    outputArea.setText("Your recommendation has been saved!");
                }
            } else if (choice == 1) {
                outputArea.setText("Recommendations:\n");
                for (String rec : Recommendations) {
                    outputArea.append(rec + "\n");
                }
            }
        });

        
    }
}

