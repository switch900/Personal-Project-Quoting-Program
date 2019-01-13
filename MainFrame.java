/**
 * Quoting Software MainFrame Class. Generates UI and functionability
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */

package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import data.Paper;
import data.Plasticoil;
import data.Quote;
import data.Wire_o;
import io.PaperReader;
import io.QuoteReport;
import util.ApplicationException;
import util.Book_Thickness;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Printable {

    private static final Logger LOG = LogManager.getLogger();
    private final String[] bindingTypesArray = { "Plasticoil", "Wire-O", "Perfect Binding" };

    static JCheckBoxMenuItem chckbxmntmByJoinDate;
    static JCheckBoxMenuItem chckbxmntmByAuthor;
    static JCheckBoxMenuItem authorsDescending;
    static JCheckBoxMenuItem sortByCompany;
    static JCheckBoxMenuItem lastNameDescending;
    static JCheckBoxMenuItem sortByEstimator;
    static JCheckBoxMenuItem sortByBindingType;
    static JMenuItem sortByQuoteNumber;

    public static Long object;
    private final JTextField bindingEdgeTextField;
    private final JTextField nonBindingEdgeTextField;
    private final JTextField coverQuantityTextBox;
    private final JTextField textQuantityTextField;
    private final JTextField insertQuantityTextField;
    private final JLabel headerLabel;
    private final JLabel coverStockOutLabel;
    private final JLabel textOutLabel;
    private final JLabel insertsOutLabel;
    private final JLabel bookSizeOutLabel;
    private final JLabel bookThicknessOutLabel;

    JLabel referenceNumberLabel;
    JLabel coverStockLabel;
    JComboBox<String> coverStockComboBox;

    public Book_Thickness thickness;

    public static int inserts;
    public static Map<Integer, Paper> sorted;
    private JTextField companyNametextField;
    private JTextField estimatorsNameTextField;
    private JTextField dateTextField;
    private JTextField referenceTextField;
    private JTextField bookQuantityTextField;

    /**
     * Create the frame.
     *
     * @throws Exception
     *             if input invalid
     * @throws SQLException
     *             if SQL data invalid
     */
    @SuppressWarnings("deprecation")
    public MainFrame(Quote quote) throws SQLException, Exception {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\switc\\COMP2613\\PaperThicknessCalculator\\src\\pictures\\Apak.JPEG.jpg"));

        setTitle("Apak Quoting Software");

        thickness = new Book_Thickness();

        getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
        getContentPane().setLayout(new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("182px"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("346px:grow"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("max(41dlu;min)"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("87px:grow"), },
                new RowSpec[] { FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("48px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(30px;pref)"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(30px;pref)"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(30px;default)"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.RELATED_GAP_ROWSPEC,
                        RowSpec.decode("max(30px;pref)"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("12px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"),
                        FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(20dlu;default)"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

        final JLabel titleLabel = new JLabel("Binding Quote:");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        getContentPane().add(titleLabel, "2, 2, center, center");

        headerLabel = new JLabel();
        getContentPane().add(headerLabel, "6, 4, 3, 6, center, bottom");
        BufferedImage img;
        try {
            final File file = new File("C:\\Users\\switc\\COMP2613\\PaperThicknessCalculator\\Apak.jpg");
            img = ImageIO.read(file);
            headerLabel.setIcon(new ImageIcon(img));
        } catch (final Exception e) {
            System.out.println(e.getMessage());
            headerLabel.setText("Cannot read image");
        }

        final JLabel companyNameLabel = new JLabel("Company Name:");
        getContentPane().add(companyNameLabel, "2, 4, right, default");

        companyNametextField = new JTextField();
        getContentPane().add(companyNametextField, "4, 4, fill, default");
        companyNametextField.setColumns(10);

        final JLabel estimatorNameLabel = new JLabel("Estimator's Name:");
        getContentPane().add(estimatorNameLabel, "2, 6, right, default");

        // TODO make this first name and last name as two fields
        estimatorsNameTextField = new JTextField();
        getContentPane().add(estimatorsNameTextField, "4, 6, fill, default");
        estimatorsNameTextField.setColumns(10);

        final JLabel dateLabel = new JLabel("Date:");
        getContentPane().add(dateLabel, "2, 8, right, default");

        final Date date = new Date();
        dateTextField = new JTextField();
        getContentPane().add(dateTextField, "4, 8, fill, default");
        dateTextField.setColumns(10);
        dateTextField.setText(DateFormat.getDateTimeInstance().format(date).toString());

        referenceNumberLabel = new JLabel("Purchase Order");
        getContentPane().add(referenceNumberLabel, "2, 10, right, fill");

        referenceTextField = new JTextField();
        getContentPane().add(referenceTextField, "4, 10, fill, default");
        referenceTextField.setColumns(10);

        final JLabel bindingTypeLabel = new JLabel("Binding Type:");
        getContentPane().add(bindingTypeLabel, "2, 12, right, default");

        final Vector<String> bindingTypes = new Vector<>();
        for (final String element : bindingTypesArray) {
            bindingTypes.add(element);
        }
        final JComboBox<String> bindingTypesComboBox = new JComboBox<>(bindingTypes);
        getContentPane().add(bindingTypesComboBox, "4, 12, fill, default");

        final JLabel quantityLabel = new JLabel("Quantity of books");
        getContentPane().add(quantityLabel, "6, 12, center, default");

        bookQuantityTextField = new JTextField("0");
        getContentPane().add(bookQuantityTextField, "8, 12, fill, default");
        bookQuantityTextField.setColumns(10);

        coverStockLabel = new JLabel("Cover Stock:");
        getContentPane().add(coverStockLabel, "2, 14, right, fill");

        final Vector<String> index = new Vector<>();
        if (PaperReader.readPaper() != null) {
            sorted = new TreeMap<>(PaperReader.paper);
            final Set<Integer> paper = sorted.keySet();
            for (final Integer temp : paper) {
                index.addElement(sorted.get(temp).getDescription());
            }
        }

        coverStockComboBox = new JComboBox<>(index);
        getContentPane().add(coverStockComboBox, "4, 14, fill, fill");

        final JLabel coverQuantityLabel = new JLabel("Amount of Covers: ");
        getContentPane().add(coverQuantityLabel, "6, 14, center, fill");

        coverQuantityTextBox = new JTextField("0");
        coverQuantityTextBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                coverQuantityTextBox.selectAll();
            }
        });
        getContentPane().add(coverQuantityTextBox, "8, 14, fill, fill");
        coverQuantityTextBox.setColumns(10);

        final JLabel textStockLabel = new JLabel("Text Stock");
        getContentPane().add(textStockLabel, "2, 16, right, fill");

        final JComboBox<String> textStockComboBox = new JComboBox<>(index);
        getContentPane().add(textStockComboBox, "4, 16, fill, fill");

        final JLabel textQuantityLabel = new JLabel("Amount of Text Sheets:");
        getContentPane().add(textQuantityLabel, "6, 16, right, fill");

        textQuantityTextField = new JTextField("0");
        textQuantityTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                textQuantityTextField.selectAll();
            }
        });
        getContentPane().add(textQuantityTextField, "8, 16, fill, fill");
        textQuantityTextField.setColumns(10);

        JLabel insertStockLabel = new JLabel("Insert Stock");
        getContentPane().add(insertStockLabel, "2, 18, right, fill");

        JComboBox<String> insertStockComboBox = new JComboBox<>(index);
        getContentPane().add(insertStockComboBox, "4, 18, fill, fill");

        JLabel insertQuantityLabel = new JLabel("Amount of Inserts:");
        insertQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(insertQuantityLabel, "6, 18, right, fill");

        insertQuantityTextField = new JTextField("0");
        insertQuantityTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                insertQuantityTextField.selectAll();
            }
        });
        getContentPane().add(insertQuantityTextField, "8, 18, fill, fill");
        insertQuantityTextField.setColumns(10);

        JLabel bindingEdgeLabel = new JLabel("Binding Edge");
        getContentPane().add(bindingEdgeLabel, "2, 22, right, fill");

        bindingEdgeTextField = new JTextField("0");
        bindingEdgeTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                bindingEdgeTextField.selectAll();
            }
        });
        getContentPane().add(bindingEdgeTextField, "4, 22, fill, fill");
        bindingEdgeTextField.setColumns(10);

        JLabel nonBindingEdgeLabel = new JLabel("Non-Binding Edge");
        getContentPane().add(nonBindingEdgeLabel, "2, 24, right, fill");

        nonBindingEdgeTextField = new JTextField("0");
        nonBindingEdgeTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                nonBindingEdgeTextField.selectAll();
            }
        });
        nonBindingEdgeTextField.setColumns(10);
        getContentPane().add(nonBindingEdgeTextField, "4, 24, fill, fill");

        JLabel quoteNumberLabel = new JLabel("Quote Number: ");
        getContentPane().add(quoteNumberLabel, "2, 28, 3, 1");

        JLabel companyNameOutLabel = new JLabel("Company Name:");
        getContentPane().add(companyNameOutLabel, "2, 30, 3, 1");

        JLabel estimatorNameOutLabel = new JLabel("Estimator's Name:");
        getContentPane().add(estimatorNameOutLabel, "6, 30, 3, 1");

        JLabel referenceOutLabel = new JLabel("Reference: ");
        getContentPane().add(referenceOutLabel, "2, 32, 3, 1");

        JLabel dateOutLabel = new JLabel("Date:");
        getContentPane().add(dateOutLabel, "6, 32, 3, 1");

        JLabel bindingTypeOutLabel = new JLabel("Binding Type: ");
        getContentPane().add(bindingTypeOutLabel, "2, 34, 3, 1");

        bookSizeOutLabel = new JLabel("Book Size: ");
        getContentPane().add(bookSizeOutLabel, "6, 34, 3, 1");

        coverStockOutLabel = new JLabel("Covers: ");
        getContentPane().add(coverStockOutLabel, "2, 36, 3, 1");

        bookThicknessOutLabel = new JLabel("Book Thickness: ");
        getContentPane().add(bookThicknessOutLabel, "6, 36, 3, 1");

        textOutLabel = new JLabel("Text: ");
        getContentPane().add(textOutLabel, "2, 38, 3, 1");

        JLabel bindingSizeOutLabel = new JLabel("Binding Size: ");
        getContentPane().add(bindingSizeOutLabel, "6, 38");

        insertsOutLabel = new JLabel("Inserts: ");
        getContentPane().add(insertsOutLabel, "2, 40, 3, 1");

        JLabel bookQuantityOutLabel = new JLabel("Quantity: ");
        getContentPane().add(bookQuantityOutLabel, "6, 40, 3, 1");

        JLabel priceLabel = new JLabel("Price:");
        getContentPane().add(priceLabel, "6, 42, 3, 1");

        JButton btnOk = new JButton("Generate Quote");
        btnOk.addActionListener(e -> {

            // TO DO Move all generate quote to separate dialog box

            quote.setQuoteNumber(Long.toString(Instant.now().toEpochMilli()));
            quoteNumberLabel.setText("Quote Number: " + quote.getQuoteNumber());

            quote.setCompanyName(companyNametextField.getText());
            companyNameOutLabel.setText("Company Name: " + quote.getCompanyName());

            quote.setEstimatorName(estimatorsNameTextField.getText());
            estimatorNameOutLabel.setText("Estimator's Name: " + quote.getEstimatorName());

            quote.setDate(dateTextField.getText());
            dateOutLabel.setText("Date: " + quote.getDate());

            quote.setReferenceNumber(referenceTextField.getText());
            referenceOutLabel.setText("Reference: " + quote.getReferenceNumber());

            int temp = 0;

            try {
                temp = Integer.parseInt(bookQuantityTextField.getText());
            } catch (final Exception f) {
                JOptionPane.showMessageDialog(getContentPane(), "Quantity is not a number", "View All", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                quote.setBookQty(temp);
                bookQuantityOutLabel.setText("Quantity: " + quote.getBookQty());
            }

            quote.setBindingType(bindingTypesComboBox.getItemAt(bindingTypesComboBox.getSelectedIndex()));
            bindingTypeOutLabel.setText("Binding Type: " + quote.getBindingType());

            quote.setCoverStock(coverStockComboBox.getItemAt(coverStockComboBox.getSelectedIndex()));
            quote.setCoverThickness(sorted.get(coverStockComboBox.getSelectedIndex() + 1).getPointThickness());
            quote.setCoverQty(Integer.parseInt(coverQuantityTextBox.getText()));
            thickness.setCoversCount(quote.getCoverQty());
            thickness.setCoverThicknesses(quote.getCoverThickness());
            coverStockOutLabel.setText("Covers: " + quote.getCoverQty() + " sheets of " + quote.getCoverStock() + " (" + quote.getCoverThickness() + " pt.)");
            coverStockOutLabel.setVisible(true);

            quote.setTextQty(Integer.parseInt(textQuantityTextField.getText()));
            quote.setTextStock(textStockComboBox.getItemAt(textStockComboBox.getSelectedIndex()));
            quote.setTextThickness(sorted.get(textStockComboBox.getSelectedIndex() + 1).getPointThickness());
            thickness.setTextCount(quote.getTextQty());
            thickness.setTextThicknesses(quote.getTextThickness());
            textOutLabel.setText("Text: " + quote.getTextQty() + " sheets of " + quote.getTextStock() + " (" + quote.getTextThickness() + " pt.)");
            textOutLabel.setVisible(true);

            quote.setInsertQty(Integer.parseInt(insertQuantityTextField.getText()));
            quote.setInsertStock(insertStockComboBox.getItemAt(insertStockComboBox.getSelectedIndex()));
            quote.setInsertThickness(sorted.get(insertStockComboBox.getSelectedIndex() + 1).getPointThickness());

            thickness.setInsertThicknesses(quote.getInsertThickness());
            thickness.setInsertCount(quote.getInsertQty());
            insertsOutLabel.setText("Inserts: " + quote.getInsertQty() + " sheets of " + quote.getInsertStock() + " (" + quote.getInsertStock() + " pt.)");
            insertsOutLabel.setVisible(true);

            double bindingEdgeDouble = 0;
            bindingEdgeDouble = Double.parseDouble(bindingEdgeTextField.getText());
            thickness.setBindingEdgeInInches(bindingEdgeDouble);
            double nonBindingEdgeDouble = 0;
            nonBindingEdgeDouble = Double.parseDouble(nonBindingEdgeTextField.getText());
            thickness.setNonBindingEdgeInInches(nonBindingEdgeDouble);

            bookSizeOutLabel.setText("Book Size: " + nonBindingEdgeDouble + " inches X " + bindingEdgeDouble + " (binding edge)");
            bookThicknessOutLabel.setText("Book Thickness: " + thickness.bookThicknessAsString(quote));
            bookThicknessOutLabel.setVisible(true);

            bindingSizeOutLabel.setText("Wire or Coil Size: " + thickness.bindingSize(quote));
            bindingSizeOutLabel.setVisible(true);

            if (quote.getBindingType().equals("Plasticoil")) {
                Plasticoil plasticoilPrice = new Plasticoil(quote.getBindingEdge(), quote.getBookQty(), thickness.bookThickness(quote));
                if (quote.getBookQty() >= 0) {
                    double price1 = plasticoilPrice.getPlasticoilBindingPrice(Double.parseDouble(thickness.bindingSize(quote)), quote.getBookQty());
                    quote.setUnitPrice(price1);
                    String stringPrice1 = String.format("%.2f", quote.getUnitPrice());
                    priceLabel.setText("Price: $" + stringPrice1 + "/per book");
                    priceLabel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Quantity must be greater than 0", "View All", JOptionPane.INFORMATION_MESSAGE);
                    quote.setBookQty(0);
                }
            } else if (quote.getBindingType().equals("Wire-O")) {
                final Wire_o wire_oPrice = new Wire_o();
                if (quote.getBookQty() > 0) {
                    double price2 = wire_oPrice.getWireBindingPrice(Double.parseDouble(thickness.bindingSize(quote)), quote.getBookQty());
                    quote.setUnitPrice(price2);
                    String stringPrice2 = String.format("%.2f", quote.getUnitPrice());
                    priceLabel.setText("Price: $" + stringPrice2 + "/per book");
                    priceLabel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Quantity must be greater than 0", "View All", JOptionPane.INFORMATION_MESSAGE);
                    quote.setBookQty(0);
                }
            } else if (quote.getBindingType().equals("Perfect Binding")) {
                JOptionPane.showMessageDialog(getContentPane(), "Perfect Binding", "View All", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        getContentPane().add(btnOk, "8, 26");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(150, 25, 900, 725);

        final JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        final JMenu fileMenu = new JMenu("File");
        fileMenu.setBackground(SystemColor.windowBorder);
        fileMenu.setMnemonic('F');
        menuBar.add(fileMenu);

        final JMenuItem printQuote = new JMenuItem("Export As PDF");
        printQuote.addActionListener(e -> {
            final int reply = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to export this quote as a PDF?", "Export Quote", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {

            }
        });

        printQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        fileMenu.add(printQuote);

        final JMenuItem exportQuote = new JMenuItem("Print");
        exportQuote.addActionListener(e -> {
            final int reply = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to print this quote?", "Print Quote", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(this);
                boolean ok = job.printDialog();
                if (ok) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                    }
                }
            }
        });

        exportQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
        fileMenu.add(exportQuote);

        final JMenuItem saveQuote = new JMenuItem("Save");
        saveQuote.addActionListener(e -> {
            final int reply = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to save this quote?", "Save Quote", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                try {
                    QuoteReport.writeQuoteToFile(quote);
                } catch (ApplicationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        saveQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        fileMenu.add(saveQuote);

        final JMenuItem quitQuote = new JMenuItem("Quit");
        quitQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
        quitQuote.addActionListener(e -> {
            LOG.debug("Program Quit By User");
            System.exit(0);
        });
        fileMenu.add(quitQuote);

        final JMenu editMenu = new JMenu("Edit");
        editMenu.setBackground(SystemColor.windowBorder);

        editMenu.setMnemonic('B');
        menuBar.add(editMenu);

        final JMenuItem mntmNewMenuItem = new JMenuItem("Count");
        mntmNewMenuItem.addActionListener(e -> {

        });

        mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        editMenu.add(mntmNewMenuItem);

        chckbxmntmByAuthor = new JCheckBoxMenuItem("By Author");
        chckbxmntmByAuthor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
        editMenu.add(chckbxmntmByAuthor);

        authorsDescending = new JCheckBoxMenuItem("Descending");
        authorsDescending.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        editMenu.add(authorsDescending);

        final JMenuItem mntmList = new JMenuItem("List");
        mntmList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        mntmList.addActionListener(e -> {
        });
        editMenu.add(mntmList);

        final JMenu maintainMenu = new JMenu("Maintain");
        maintainMenu.setMnemonic('C');
        maintainMenu.setBackground(SystemColor.windowBorder);
        menuBar.add(maintainMenu);

        final JMenuItem mnNewMenu_2 = new JMenuItem("Count");
        mnNewMenu_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        mnNewMenu_2.addActionListener(e -> {

        });
        maintainMenu.add(mnNewMenu_2);

        final JMenuItem mnNewMenu_4 = new JMenuItem("List");
        mnNewMenu_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        mnNewMenu_4.addActionListener(e -> {
        });
        chckbxmntmByJoinDate = new JCheckBoxMenuItem("By Join Date");
        chckbxmntmByJoinDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.ALT_MASK));
        maintainMenu.add(chckbxmntmByJoinDate);
        maintainMenu.add(mnNewMenu_4);

        final JMenu Reports = new JMenu("Reports");
        Reports.setFont(new Font("Dialog", Font.PLAIN, 12));
        Reports.setBackground(SystemColor.windowBorder);
        Reports.setMnemonic('P');
        menuBar.add(Reports);

        sortByCompany = new JCheckBoxMenuItem("Company");
        sortByCompany.addActionListener(e -> JOptionPane.showInputDialog(getContentPane(), "Search By Company Name", "Search By Company Name", JOptionPane.INFORMATION_MESSAGE));
        sortByCompany.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        Reports.add(sortByCompany);

        sortByEstimator = new JCheckBoxMenuItem("Estimator");
        sortByEstimator.addActionListener(e -> JOptionPane.showInputDialog(getContentPane(), "Search By Estimator's Name", "Search By Estimator's Name", JOptionPane.INFORMATION_MESSAGE));
        sortByEstimator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        Reports.add(sortByEstimator);

        final JMenuItem sortByDate = new JMenuItem("Date");
        // sortByDate.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // Properties p = new Properties();
        // p.put("text.today", "today");
        // p.put("text.month", "month");
        // p.put("text.year", "year");
        // UtilDateModel model = new UtilDateModel();
        // JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        // JOptionPane.showInputDialog(datePicker);
        // }
        // });
        sortByDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        Reports.add(sortByDate);

        final JCheckBoxMenuItem sortByReference = new JCheckBoxMenuItem("Reference");
        sortByReference.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        Reports.add(sortByReference);

        sortByBindingType = new JCheckBoxMenuItem("Binding Type");
        sortByBindingType.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
        Reports.add(sortByBindingType);

        sortByQuoteNumber = new JMenuItem("Quote Number");
        sortByQuoteNumber.addActionListener(e -> JOptionPane.showInputDialog(getContentPane(), "Search By Quote Number", "Search By Quote Number", JOptionPane.INFORMATION_MESSAGE));

        sortByQuoteNumber.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
        Reports.add(sortByQuoteNumber);

        final JMenuItem sortByAll = new JMenuItem("View All");
        sortByAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK));
        sortByAll.addActionListener(e -> JOptionPane.showMessageDialog(getContentPane(), "Would you like to produce a list\nof all quotes in database?", "View All", JOptionPane.INFORMATION_MESSAGE));
        Reports.add(sortByAll);

        final JMenu mnHelp = new JMenu("Help");
        mnHelp.setMnemonic('H');
        mnHelp.setBackground(SystemColor.windowBorder);
        menuBar.add(mnHelp);

        final JMenuItem mnAbout = new JMenuItem("About");
        mnAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        mnAbout.addActionListener(e -> JOptionPane.showMessageDialog(getContentPane(), "Personal Project\nSample Quoting Software\nBy Andrew Hewitson", "Sample Quoting Software", JOptionPane.INFORMATION_MESSAGE));
        mnHelp.add(mnAbout);
    }

    // print method
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        int w = (int) pf.getImageableWidth();
        int h = (int) pf.getImageableHeight();
        getContentPane().setSize(new Dimension(w, getContentPane().getPreferredSize().height));
        getContentPane().setSize(w, h);
        getContentPane().validate();
        getContentPane().printAll(g2d);

        return PAGE_EXISTS;
    }
}
