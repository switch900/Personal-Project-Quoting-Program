/**
 * Quoting Software Book_Thickness Class. Classes primary function is to calculate the
 * thickness of a book based on the user input parameters.
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */
package util;

import data.Quote;

public class Book_Thickness {

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
    public Book_Thickness(final int bookCount, final double textThicknesses, final double coverThicknesses, final double insertThicknesses, final int textCount, final int insertCount, final int coversCount, final double bindingEdge, final double nonBindingEdge) {
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
    public void setBindingEdgeInInches(final double bindingEdgeInInches) {
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
    public void setNonBindingEdgeInInches(final double nonBindingEdgeInInches) {
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
    public void setTextThicknesses(final double textThicknesses) {
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
    public void setCoverThicknesses(final double coverThicknesses) {
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
    public void setInsertThicknesses(final double insertThicknesses) {
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
    public void setBookCount(final int bookCount) {
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
    public void setTextCount(final int textCount) {
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
    public void setInsertCount(final int insertCount) {
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
    public void setCoversCount(final int coversCount) {
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
    public double bookThickness(Quote quote) {
        double bookThickness = 0.0;
        int tempTextCount = quote.getTextQty();
        int tempCoverCount = quote.getCoverQty();
        int tempInsertCount = quote.getInsertQty();
        double tempTextThickness = quote.getTextThickness();
        double tempCoverThickness = quote.getCoverThickness();
        double tempInsertThickness = quote.getInsertThickness();
        bookThickness = tempTextThickness / 1000 * 25.4 * tempTextCount + tempCoverThickness / 1000 * 25.4 * tempCoverCount + tempInsertThickness / 1000 * 25.4 * tempInsertCount;
        return bookThickness;
    }

    /**
     * Change bookThickness from a double to a String
     *
     * @return bookThicknessString as a String
     */
    public String bookThicknessAsString(Quote quote) {
        String bookThicknessString = null;
        double temp = 0.0;
        if (bookThickness(quote) >= 0.0) {
            temp = bookThickness(quote);
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

    public String bindingSize(Quote quote) {
        String thicknessString = null;
        double bindingSize = 0.0;
        if (bookThickness(quote) >= 0) {
            bindingSize = Math.round(bookThickness(quote) + 2.5);
            thicknessString = Double.toString(bindingSize);
        }
        return thicknessString;
    }
}
