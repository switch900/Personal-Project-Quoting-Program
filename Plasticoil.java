/**
 * Quoting Software Plasticoil Class. Classes primary function is to produce a price for the cost
 * of a Plasticoil bound book.
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */

package data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Plasticoil {

    public static final String IN_PLASTICOIL_FILENAME = "plasticoil.csv";
    public static final Logger LOG_READER = LogManager.getLogger(Plasticoil.class);

    private double bindingEdge;
    private int quantity;
    private double bindingSize;
    // current price list is hardcoded as a 2d array. Future iterations will import a CSV file and eventually will import from a SQL database
    private final double[][] priceList = { { 0.85, 0.85, 0.85, 0.85, 0.85, 0.85, 0.95, 0.95, 0.95, 1.10, 1.20, 1.30, 1.45, 1.55, 2.00, 2.00, 2.00, 2.30, 2.40 }, { 0.76, 0.77, 0.78, 0.79, 0.82, 0.83, 0.89, 0.92, 0.95, 1.06, 1.15, 1.25, 1.27, 1.29, 1.72, 1.93, 2.06, 2.28, 2.34 }, { 0.59, 0.62, 0.64, 0.65, 0.69, 0.71, 0.75, 0.79, 0.86, 0.90, 1.09, 1.12, 1.17, 1.20, 1.24, 1.65, 1.92, 2.25, 2.31 },
            { 0.43, 0.44, 0.46, 0.49, 0.51, 0.53, 0.55, 0.60, 0.67, 0.70, 0.80, 0.84, 0.87, 0.91, 0.95, 1.25, 1.34, 1.71, 1.76 }, { 0.41, 0.43, 0.45, 0.47, 0.49, 0.50, 0.51, 0.57, 0.62, 0.66, 0.75, 0.79, 0.81, 0.85, 0.90, 1.16, 1.30, 1.56, 1.61 }, { 0.40, 0.41, 0.42, 0.45, 0.48, 0.48, 0.49, 0.56, 0.60, 0.64, 0.73, 0.77, 0.79, 0.84, 0.88, 1.14, 1.28, 1.54, 1.60 } };

    // default constructor
    public Plasticoil() {
    }

    /**
     * @param bindingEdge
     * @param quantity
     * @param bindingSize
     * @param priceList
     */
    public Plasticoil(double bindingEdge, int quantity, double bindingSize) {
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
    public double getBindingSize() {
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
    public double getPlasticoilBindingPrice(double bindingSize, int quantity) {
        double price = 0.0;
        int priceLevel = 0;
        double minimumPrice = 0.0;

        if (bindingSize <= 20 && bindingSize >= 6) {
            priceLevel = (int) bindingSize - 6;
        } else if (bindingSize > 20 && bindingSize <= 23) {
            priceLevel = 15;
        } else if (bindingSize > 23 && bindingSize <= 25) {
            priceLevel = 16;
        } else if (bindingSize > 25 && bindingSize <= 30) {
            priceLevel = 17;
        } else if (bindingSize > 30 && bindingSize <= 32) {
            priceLevel = 18;
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
        return "Plasticoil [bindingEdge=" + bindingEdge + ", quantity=" + quantity + ", bindingSize=" + bindingSize + "]";
    }

}
