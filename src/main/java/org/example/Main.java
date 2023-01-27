package org.example;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class CreditCard implements Cloneable {
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private String CardHolder;
    private long CardNumber;
    private String ExpiaryDate;

    CreditCard(String cd, long cn, String ed) {
        CardHolder = cd;
        CardNumber = cn;
        ExpiaryDate = ed;
    }

    public boolean eql(long cardnumber) {
        boolean check = false;
        if (CardNumber == cardnumber) {
            check = true;
        }
        return check;
    }
    public CreditCard copy() throws CloneNotSupportedException {
        return (CreditCard) this.clone();
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        String dumy = "";
        LOGGER.log(Level.INFO, "Enter the CardHolder Name");
        String name = sc.nextLine();
        LOGGER.log(Level.INFO, "Enter the CardNumber");
        long cdnumber = sc.nextLong();
        LOGGER.log(Level.INFO, "Enter the Expiry Date");
        sc.nextLine();
        String expDate = sc.nextLine();
        CreditCard p = new CreditCard(name, cdnumber, expDate);
        CreditCard p1 = p.copy();
        LOGGER.info("Enter the New Card Number");
        p1.CardNumber = sc.nextLong();
        boolean conf = p.eql(p1.CardNumber);
        if (conf) {
            LOGGER.info("True! They are same as Original Details ");
        } else {
            LOGGER.info("False! Both are Not Same");
            LOGGER.info("Want to see the New DebitCard Details with the Original Details\n1.yes\n2.No");
            int op=sc.nextInt();
            if(op==1){
                dumy = "The New Credit Card with Details is \nName of the holder" + p.CardHolder + "\n CardNumber" + p.CardNumber + "\n Expiary Date" + p.ExpiaryDate;
                LOGGER.info(dumy);
            }
            else if(op==2) {
                LOGGER.info("Okay");
            }
            else{
                LOGGER.info("Something Went Wrong");
            }
        }
    }
}