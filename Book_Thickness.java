package util;

// import java.io.Serializable;
// import java.io.ObjectInputStream;
/**
 * Book_Thickness class for determining thickness of book. Part of the master
 * class Apak_Quoting
 * 
 * @author Andrew Hewitson
 * @version 10.07.2017
 *
 */

public class Book_Thickness {

    public static transient InputReader reader;
    private double textThicknesses;
    private double coverThicknesses;
    private double insertThicknesses;

    private int textCount;
    private int insertCount;
    private int coversCount;
    private int bookCount;

    private double bindingEdgeInInches;
    private double nonBindingEdgeInInches;

    /**
     * default constructor
     */
    public Book_Thickness() {
    }

    /**
     * Main Constructor
     * 
     * @param bookCount
     *            as int
     * @param textThicknesses
     *            as double
     * @param coverThicknesses
     *            as double
     * @param insertThicknesses
     *            as double
     * @param textCount
     *            as int
     * @param insertCount
     *            as int
     * @param coversCount
     *            as int
     */
    public Book_Thickness(int bookCount, double textThicknesses, double coverThicknesses, double insertThicknesses, int textCount, int insertCount, int coversCount, double bindingEdge, double nonBindingEdge) {
        setBookCount(bookCount);
        setTextThicknesses(textThicknesses);
        setCoverThicknesses(coverThicknesses);
        setInsertThicknesses(insertThicknesses);
        setTextCount(textCount);
        setCoversCount(coversCount);
        setInsertCount(insertCount);
    }

    /**
     * get the length of the binding edge in inches
     * 
     * @return the bindingEdgeInInches
     */
    public double getBindingEdgeInInches() {
        return bindingEdgeInInches;
    }

    /**
     * set the length of the binding edge in inches
     * 
     * @param bindingEdgeInInches
     *            the bindingEdge to set as a double
     */
    public void setBindingEdgeInInches(double bindingEdgeInInches) {
        if (bindingEdgeInInches >= 0.0) {
            this.bindingEdgeInInches = bindingEdgeInInches;
        }
    }

    /**
     * get the length of the non-binding edge in inches
     * 
     * @return the nonBindingEdgeInInches
     */
    public double getNonBindingEdgeInInches() {
        return nonBindingEdgeInInches;
    }

    /**
     * set the length of the binding edge in inches
     * 
     * @param nonBindingEdgeInInches
     *            the bindingEdge to set as a double
     */
    public void setNonBindingEdgeInInches(double nonBindingEdgeInInches) {
        if (nonBindingEdgeInInches >= 0.0) {
            this.nonBindingEdgeInInches = nonBindingEdgeInInches;
        }
    }

    /**
     * get the thickness of one text sheet
     * 
     * @return the textThicknesses
     */
    public double getTextThicknesses() {
        return textThicknesses;
    }

    /**
     * set the thickness of one text sheet
     * 
     * @param textThicknesses
     *            the textThicknesses to set as a double
     */
    public void setTextThicknesses(double textThicknesses) {
        if (textThicknesses >= 0.0) {
            this.textThicknesses = textThicknesses;
        }
    }

    /**
     * get the thickness of one cover sheet
     * 
     * @return the coverThicknesses
     */
    public double getCoverThicknesses() {
        return coverThicknesses;
    }

    /**
     * set the thickness of one cover sheet
     * 
     * @param coverThicknesses
     *            the coverThicknesses to set as a double
     */
    public void setCoverThicknesses(double coverThicknesses) {
        if (coverThicknesses >= 0.0) {
            this.coverThicknesses = coverThicknesses;
        }
    }

    /**
     * get the thickness of one insert or tab sheet
     * 
     * @return the insertThicknesses
     */
    public double getInsertThicknesses() {
        return insertThicknesses;
    }

    /**
     * set the thickness of one insert or tab sheet
     * 
     * @param insertThicknesses
     *            the insertThicknesses to set as a double
     */
    public void setInsertThicknesses(double insertThicknesses) {
        if (insertThicknesses >= 0.0) {
            this.insertThicknesses = insertThicknesses;
        }
    }

    /**
     * get the total number of books to be quoted
     *
     * @return the bookCount
     */
    public int getBookCount() {
        return bookCount;
    }

    /**
     * set the total number of books to be quoted
     * 
     * @param bookCount
     *            the bookCount to set as an int
     */
    public void setBookCount(int bookCount) {
        if (bookCount >= 0) {
            this.bookCount = bookCount;
        }
    }

    /**
     * get the total number of text sheets in one book
     * 
     * @return the textCount
     */
    public int getTextCount() {
        return textCount;
    }

    /**
     * set the total number of text sheets in one book
     * 
     * @param textCount
     *            the textCount to set as an int
     */
    public void setTextCount(int textCount) {
        if (textCount >= 0) {
            this.textCount = textCount;
        }
    }

    /**
     * get the total number of insert sheets or tabs in one book
     * 
     * @return the insertCount
     */
    public int getInsertCount() {
        return insertCount;
    }

    /**
     * set the total number of insert sheets or tabs in one book
     * 
     * @param insertCount
     *            the insertCount to set as int
     */
    public void setInsertCount(int insertCount) {
        if (insertCount >= 0) {
            this.insertCount = insertCount;
        }
    }

    /**
     * get the total number of covers on one book
     * 
     * @return the coversCount
     */
    public int getCoversCount() {
        return coversCount;
    }

    /**
     * set the total number of covers on one book
     * 
     * @param coversCount
     *            the coversCount to set as an int
     */
    public void setCoversCount(int coversCount) {
        if (coversCount >= 0) {
            this.coversCount = coversCount;
        }
    }

    /**
     * calculate the thickness of a book by multiplying the amount of text sheets by
     * their thickness, the amount of covers by their thickness and the amount of
     * insert by their thickness.
     * 
     * @return bookThickness as a double
     */
    public double bookThickness() {
        double bookThickness = 0.0;
        int tempTextCount = getTextCount();
        int tempCoverCount = getCoversCount();
        int tempInsertCount = getInsertCount();
        double tempTextThickness = getTextThicknesses();
        double tempCoverThickness = getCoverThicknesses();
        double tempInsertThickness = getInsertThicknesses();
        bookThickness = (((tempTextThickness / 1000) * 25.4) * tempTextCount) + (((tempCoverThickness / 1000) * 25.4) * tempCoverCount) + (((tempInsertThickness / 1000) * 25.4) * tempInsertCount);
        return bookThickness;
    }

    /**
     * Change bookThickness from a double to a String
     * 
     * @return bookThicknessString as a String
     */
    public String bookThicknessAsString() {
        String bookThicknessString = null;
        double temp = 0.0;
        if (bookThickness() >= 0.0) {
            temp = bookThickness();
            bookThicknessString = Double.toString(temp);
        }
        return bookThicknessString;
    }

    /**
     * Calculate the optimum size of binding material by taking the results from the
     * bookThickness() method and adding 2.5mm. Then rounding the results to the
     * nearest even number and converting to a String
     * 
     * @return bindingSize as a String
     */

    public String bindingSize() {
        String thicknessString = null;
        double bindingSize = 0.0;
        if (bookThickness() >= 0) {
            bindingSize = Math.round(bookThickness() + 2.5);
            thicknessString = Double.toString(bindingSize);
        }
        return thicknessString;
    }

    // Not used Code below. For future consideration as a user input method for
    // quoting.
    // /**
    // * formula to figure out how thickness of a set of sheets of text
    // */
    //
    // public double totalTextThickness() {
    //
    // System.out.println("Enter total amount of text sheets:");
    // int tempText = DropDownMenu.text;
    // // int tempText = reader.getIntInput();
    // if (tempText >= 0) {
    // setTextCount(tempText);
    // }
    // double text = DropDownMenu.textThickness;
    // System.out.println(text);
    // double totalTextThickness = text * getTextCount();
    // return totalTextThickness;
    // }
    //
    // public void printBookThickness() {
    // System.out.println(totalTextThickness());
    //
    // }
    //
    // public void newBookQuote() {
    // reader = new InputReader();
    // System.out.println("How many Books");
    // int tempBookCount = reader.getIntInput();
    // bookCount = tempBookCount;

    // System.out.println("Choose stock from drop down menu and enter quantity of
    // sheets.");
    // int tempTextCount = reader.getIntInput();
    // int tempTextCount = getTextCount();
    // int tempCoverCount = getCoversCount();
    // int tempInsertCount = getInsertCount();
    // double tempTextThickness = getTextThicknesses();
    // double tempCoverThickness = getCoverThicknesses();
    // double tempInsertThickness = getInsertThicknesses();

    // int tempTextCount = DropDownMenu.text;
    // System.out.println("Text Thickness");
    // double tempTextThicknesses = DropDownMenu.textThickness;
    // double tempTextThicknesses = reader.getDoubleInput();
    // textThicknesses = tempTextThicknesses;
    // textCount = tempTextCount;

    // System.out.println("Choose stock from drop down menu and enter quantity of
    // covers.");
    // int tempCoverCount = reader.getIntInput();
    // int tempCoverCount = DropDownMenu.covers;
    // System.out.println("Cover Thickness");
    // double tempCoverThicknesses = DropDownMenu.coverThickness;
    // double tempCoverThicknesses = reader.getDoubleInput();
    // coversCount = tempCoverCount;
    // coverThicknesses = tempCoverThicknesses;

    // System.out.println("Choose stock from drop down menu and enter quantity of
    // inserts or tabs.");
    // int tempInsertCount = reader.getIntInput();
    // int tempInsertCount = DropDownMenu.inserts;
    // System.out.println("Insert Thickness");
    // double tempInserttThicknesses = DropDownMenu.insertThickness;
    // double tempInsertThicknesses = reader.getDoubleInput();
    // insertCount = tempInsertCount;
    // insertThicknesses = tempInserttThicknesses;
    // }
}
