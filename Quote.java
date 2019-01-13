/**
 * Quoting Software Quote Class
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */

package data;

public class Quote {

    private String CompanyName;
    private String EstimatorName;
    private String Date;
    private String QuoteNumber;
    private String ReferenceNumber;
    private String BindingType;
    private double NonBindingEdge;
    private double BindingEdge;
    private int CoverQty;
    private String CoverStock;
    private double CoverThickness;
    private int TextQty;
    private String TextStock;
    private double TextThickness;
    private int InsertQty;
    private String InsertStock;
    private double InsertThickness;
    private int BookQty;
    private double UnitPrice;

    // default constructor
    public Quote() {
    }

    /**
     * @param companyName
     * @param estimatorName
     * @param date
     * @param quoteNumber
     * @param referenceNumber
     * @param bindingType
     * @param nonBindingEdge
     * @param bindingEdge
     * @param coverQty
     * @param coverStock
     * @param coverThickness
     * @param textQty
     * @param textStock
     * @param textThickness
     * @param insertQty
     * @param insertStock
     * @param insertThickness
     * @param bookQty
     * @param unitPrice
     */
    public Quote(String companyName, String estimatorName, String date, String quoteNumber, String referenceNumber, String bindingType, double nonBindingEdge, double bindingEdge, int coverQty, String coverStock, double coverThickness, int textQty, String textStock, double textThickness, int insertQty, String insertStock, double insertThickness, int bookQty, double unitPrice) {
        super();
        CompanyName = companyName;
        EstimatorName = estimatorName;
        Date = date;
        QuoteNumber = quoteNumber;
        ReferenceNumber = referenceNumber;
        BindingType = bindingType;
        NonBindingEdge = nonBindingEdge;
        BindingEdge = bindingEdge;
        CoverQty = coverQty;
        CoverStock = coverStock;
        CoverThickness = coverThickness;
        TextQty = textQty;
        TextStock = textStock;
        TextThickness = textThickness;
        InsertQty = insertQty;
        InsertStock = insertStock;
        InsertThickness = insertThickness;
        BookQty = bookQty;
        UnitPrice = unitPrice;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return CompanyName;
    }

    /**
     * @param companyName
     *            the companyName to set
     */
    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    /**
     * @return the estimatorName
     */
    public String getEstimatorName() {
        return EstimatorName;
    }

    /**
     * @param estimatorName
     *            the estimatorName to set
     */
    public void setEstimatorName(String estimatorName) {
        EstimatorName = estimatorName;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(String date) {
        Date = date;
    }

    /**
     * @return the quoteNumber
     */
    public String getQuoteNumber() {
        return QuoteNumber;
    }

    /**
     * @param quoteNumber
     *            the quoteNumber to set
     */
    public void setQuoteNumber(String quoteNumber) {
        QuoteNumber = quoteNumber;
    }

    /**
     * @return the referenceNumber
     */
    public String getReferenceNumber() {
        return ReferenceNumber;
    }

    /**
     * @param referenceNumber
     *            the referenceNumber to set
     */
    public void setReferenceNumber(String referenceNumber) {
        ReferenceNumber = referenceNumber;
    }

    /**
     * @return the bindingType
     */
    public String getBindingType() {
        return BindingType;
    }

    /**
     * @param bindingType
     *            the bindingType to set
     */
    public void setBindingType(String bindingType) {
        BindingType = bindingType;
    }

    /**
     * @return the nonBindingEdge
     */
    public double getNonBindingEdge() {
        return NonBindingEdge;
    }

    /**
     * @param nonBindingEdge
     *            the nonBindingEdge to set
     */
    public void setNonBindingEdge(double nonBindingEdge) {
        NonBindingEdge = nonBindingEdge;
    }

    /**
     * @return the bindingEdge
     */
    public double getBindingEdge() {
        return BindingEdge;
    }

    /**
     * @param bindingEdge
     *            the bindingEdge to set
     */
    public void setBindingEdge(double bindingEdge) {
        BindingEdge = bindingEdge;
    }

    /**
     * @return the coverQty
     */
    public int getCoverQty() {
        return CoverQty;
    }

    /**
     * @param coverQty
     *            the coverQty to set
     */
    public void setCoverQty(int coverQty) {
        CoverQty = coverQty;
    }

    /**
     * @return the coverStock
     */
    public String getCoverStock() {
        return CoverStock;
    }

    /**
     * @param coverStock
     *            the coverStock to set
     */
    public void setCoverStock(String coverStock) {
        CoverStock = coverStock;
    }

    /**
     * @return the coverThickness
     */
    public double getCoverThickness() {
        return CoverThickness;
    }

    /**
     * @param coverThickness
     *            the coverThickness to set
     */
    public void setCoverThickness(double coverThickness) {
        CoverThickness = coverThickness;
    }

    /**
     * @return the textQty
     */
    public int getTextQty() {
        return TextQty;
    }

    /**
     * @param textQty
     *            the textQty to set
     */
    public void setTextQty(int textQty) {
        TextQty = textQty;
    }

    /**
     * @return the textStock
     */
    public String getTextStock() {
        return TextStock;
    }

    /**
     * @param textStock
     *            the textStock to set
     */
    public void setTextStock(String textStock) {
        TextStock = textStock;
    }

    /**
     * @return the textThickness
     */
    public double getTextThickness() {
        return TextThickness;
    }

    /**
     * @param textThickness
     *            the textThickness to set
     */
    public void setTextThickness(double textThickness) {
        TextThickness = textThickness;
    }

    /**
     * @return the insertQty
     */
    public int getInsertQty() {
        return InsertQty;
    }

    /**
     * @param insertQty
     *            the insertQty to set
     */
    public void setInsertQty(int insertQty) {
        InsertQty = insertQty;
    }

    /**
     * @return the insertStock
     */
    public String getInsertStock() {
        return InsertStock;
    }

    /**
     * @param insertStock
     *            the insertStock to set
     */
    public void setInsertStock(String insertStock) {
        InsertStock = insertStock;
    }

    /**
     * @return the insertThickness
     */
    public double getInsertThickness() {
        return InsertThickness;
    }

    /**
     * @param insertThickness
     *            the insertThickness to set
     */
    public void setInsertThickness(double insertThickness) {
        InsertThickness = insertThickness;
    }

    /**
     * @return the bookQty
     */
    public int getBookQty() {
        return BookQty;
    }

    /**
     * @param bookQty
     *            the bookQty to set
     */
    public void setBookQty(int bookQty) {
        BookQty = bookQty;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return UnitPrice;
    }

    /**
     * @param unitPrice
     *            the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice / BookQty;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Quote [CompanyName=" + CompanyName + ", EstimatorName=" + EstimatorName + ", Date=" + Date + ", QuoteNumber=" + QuoteNumber + ", ReferenceNumber=" + ReferenceNumber + ", BindingType=" + BindingType + ", NonBindingEdge=" + NonBindingEdge + ", BindingEdge=" + BindingEdge + ", CoverQty=" + CoverQty + ", CoverStock=" + CoverStock + ", CoverThickness=" + CoverThickness + ", TextQty="
                + TextQty + ", TextStock=" + TextStock + ", TextThickness=" + TextThickness + ", InsertQty=" + InsertQty + ", InsertStock=" + InsertStock + ", InsertThickness=" + InsertThickness + ", BookQty=" + BookQty + ", UnitPrice=" + UnitPrice + "]";
    }

}
