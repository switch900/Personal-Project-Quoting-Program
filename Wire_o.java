/**
 * Quoting Software Wire_o. Classes primary function is to produce a price for the cost
 * of a Wire-O bound book.
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */

package data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Wire_o {

    public static final String IN_WIRE_O_FILENAME = "wire_o.csv";
    public static final Logger LOG_READER = LogManager.getLogger(Wire_o.class);

    private double bindingEdge;
    private int quantity;
    private int bindingSize;
    // current price list is hardcoded as a 2d array. Future iterations will import a CSV file and eventually will import from a SQL database
    private final double[][] priceList = { { 0.85, 0.85, 0.85, 0.85, 0.95, 0.99, 1.25, 1.95, 2.00, 2.35, 2.55 }, { 0.76, 0.77, 0.80, 0.83, 0.91, 0.96, 1.18, 1.65, 1.84, 2.23 }, { 0.66, 0.68, 0.70, 0.77, 0.83, 0.92, 1.04, 1.25, 1.57, 2.20, 2.41 }, { 0.55, 0.58, 0.59, 0.61, 0.65, 0.76, 0.86, 1.07, 1.34, 1.84, 2.04 }, { 0.50, 0.53, 0.56, 0.57, 0.62, 0.71, 0.81, 1.02, 1.24, 1.68, 1.88 },
            { 0.48, 0.51, 0.54, 0.55, 0.59, 0.69, 0.78, 1.00, 1.22, 1.66, 1.86 } };

    // default constructor
    public Wire_o() {
    }

    /**
     * @param bindingEdge
     * @param quantity
     * @param bindingSize
     */
    public Wire_o(final double bindingEdge, final int quantity, final int bindingSize) {
        super();
        this.bindingEdge = bindingEdge;
        this.quantity = quantity;
        this.bindingSize = bindingSize;
    }

    /**
     * @return the bindingEdge
     */
    public double getBindingEdge() {
        return bindingEdge;
    }

    /**
     * @param bindingEdge
     *            the bindingEdge to set
     */
    public void setBindingEdge(final double bindingEdge) {
        this.bindingEdge = bindingEdge;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the bindingSize
     */
    public int getBindingSize() {
        return bindingSize;
    }

    /**
     * @param bindingSize
     *            the bindingSize to set
     */
    public void setBindingSize(final int bindingSize) {
        this.bindingSize = bindingSize;
    }

    /**
     * @return price
     * @param bindingSize,
     *            quantity
     */
    public double getWireBindingPrice(double bindingSize, final int quantity) {
        double price = 0.0;
        int priceLevel = 0;
        double minimumPrice = 0.0;

        if (bindingSize <= 6.35) {
            priceLevel = 1;
        } else if (bindingSize > 6.35 && bindingSize <= 7.9375) {
            priceLevel = 2;
        } else if (bindingSize > 7.9375 && bindingSize <= 9.525) {
            priceLevel = 3;
        } else if (bindingSize > 9.525 && bindingSize <= 11.1125) {
            priceLevel = 4;
        } else if (bindingSize > 11.1125 && bindingSize <= 12.7) {
            priceLevel = 5;
        } else if (bindingSize > 12.7 && bindingSize <= 14.2875) {
            priceLevel = 6;
        } else if (bindingSize > 14.2875 && bindingSize <= 15.875) {
            priceLevel = 7;
        } else if (bindingSize > 15.875 && bindingSize <= 19.05) {
            priceLevel = 8;
        } else if (bindingSize > 19.05 && bindingSize <= 22.225) {
            priceLevel = 9;
        } else if (bindingSize > 22.225 && bindingSize <= 25.4) {
            priceLevel = 10;
        } else if (bindingSize > 25.4 && bindingSize <= 31.75) {
            priceLevel = 9;
        } else {
            bindingSize = 0;
        }

        minimumPrice = priceList[0][priceLevel] * 100;
        if (quantity <= 100) {
            price = minimumPrice;
        }

        if (quantity > 100 && quantity < 500) {
            price = priceList[1][priceLevel] * quantity;
        } else if (quantity >= 500 && quantity < 1000) {
            price = priceList[2][priceLevel] * quantity;
        } else if (quantity >= 1000 && quantity < 2000) {
            price = priceList[3][priceLevel] * quantity;
        } else if (quantity >= 2000 && quantity < 3000) {
            price = priceList[4][priceLevel] * quantity;
        } else if (quantity >= 3000) {
            price = priceList[5][priceLevel] * quantity;
        }

        if (price < minimumPrice) {
            return minimumPrice;
        } else {
            return price;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Wire_o [bindingEdge=" + bindingEdge + ", quantity=" + quantity + ", bindingSize=" + bindingSize + "]";
    }

}
