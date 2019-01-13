/**
 * Quoting Software Paper Class.
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */

package data;

public class Paper {

    private int SKU;
    private String description;
    private double pointThickness;
    private int gsm;

    /**
     * @param description
     * @param pointThickness
     * @param gsm
     */
    public Paper(final int SKU, final String description, final double pointThickness, final int gsm) {
        super();
        this.SKU = SKU;
        this.description = description;
        this.pointThickness = pointThickness;
        this.gsm = gsm;
    }

    // default constructor
    public Paper() {
    }

    /**
     * @return the sKU
     */
    public int getSKU() {
        return SKU;
    }

    /**
     * @param sKU
     *            the sKU to set
     */
    public void setSKU(final int sKU) {
        SKU = sKU;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the pointThickness
     */
    public double getPointThickness() {
        return pointThickness;
    }

    /**
     * @param pointThickness
     *            the pointThickness to set
     */
    public void setPointThickness(final double pointThickness) {
        this.pointThickness = pointThickness;
    }

    /**
     * @return the gsm
     */
    public int getGsm() {
        return gsm;
    }

    /**
     * @param gsm
     *            the gsm to set
     */
    public void setGsm(final int gsm) {
        this.gsm = gsm;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Paper [SKU=" + SKU + ", description=" + description + ", pointThickness=" + pointThickness + ", gsm=" + gsm + "]";
    }

}
