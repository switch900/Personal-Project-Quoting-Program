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
    public Paper(int SKU, String description, double pointThickness, int gsm) {
        super();
        this.SKU = SKU;
        this.description = description;
        this.pointThickness = pointThickness;
        this.gsm = gsm;
    }

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
    public void setSKU(int sKU) {
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
    public void setDescription(String description) {
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
    public void setPointThickness(double pointThickness) {
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
    public void setGsm(int gsm) {
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
