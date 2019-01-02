/**
 * Paper Thickness Calculator MainFrame class
 * 
 * File: MainClass.java
 * Date:October 27, 2018
 * 
 * @author Andrew Hewitson
 */

package ui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import data.Paper;
import data.Plasticoil;
import io.PaperReader;
import util.Book_Thickness;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

    private static final Logger LOG = LogManager.getLogger();
    private String[] bindingTypesArray = { "Plasticoil", "Wire-O", "Perfect Binding" };

    static JCheckBoxMenuItem chckbxmntmByJoinDate;
    static JCheckBoxMenuItem chckbxmntmByAuthor;
    static JCheckBoxMenuItem authorsDescending;
    static JCheckBoxMenuItem sortByCompany;
    static JCheckBoxMenuItem lastNameDescending;
    static JCheckBoxMenuItem sortByEstimator;
    static JCheckBoxMenuItem sortByBindingType;
    static JMenuItem sortByQuoteNumber;

    public static Long object;
    private JTextField bindingEdgeTextField;
    private JTextField nonBindingEdgeTextField;
    private JTextField coverQuantityTextBox;
    private JTextField textQuantityTextField;
    private JTextField insertQuantityTextField;
    private JLabel coverStockOutLabel;
    private JLabel textOutLabel;
    private JLabel insertsOutLabel;
    private JLabel bookSizeOutLabel;
    private JLabel bookThicknessOutLabel;

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
    public MainFrame() throws SQLException, Exception {

        thickness = new Book_Thickness();

        getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
        getContentPane().setLayout(new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("182px"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("346px:grow"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("max(41dlu;min)"), FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("87px:grow"), },
                new RowSpec[] { FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(30px;pref)"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(30px;pref)"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(30px;default)"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.RELATED_GAP_ROWSPEC,
                        RowSpec.decode("max(30px;pref)"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("12px"), FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"),
                        FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(20dlu;default)"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

        JLabel headerLabel = new JLabel("Andrew Hewitson's Sample Quoting Software");
        getContentPane().add(headerLabel, "2, 2, 7, 1, center, fill");

        JLabel companyNameLabel = new JLabel("Company Name:");
        getContentPane().add(companyNameLabel, "2, 4, right, default");

        companyNametextField = new JTextField();
        getContentPane().add(companyNametextField, "4, 4, fill, default");
        companyNametextField.setColumns(10);

        JLabel estimatorNameLabel = new JLabel("Estimator's Name:");
        getContentPane().add(estimatorNameLabel, "2, 6, right, default");

        // make this first name and last name as two fields
        estimatorsNameTextField = new JTextField();
        getContentPane().add(estimatorsNameTextField, "4, 6, fill, default");
        estimatorsNameTextField.setColumns(10);

        JLabel dateLabel = new JLabel("Date:");
        getContentPane().add(dateLabel, "2, 8, right, default");

        Date date = new Date();
        dateTextField = new JTextField();
        getContentPane().add(dateTextField, "4, 8, fill, default");
        dateTextField.setColumns(10);
        dateTextField.setText(DateFormat.getDateTimeInstance().format(date).toString());

        referenceNumberLabel = new JLabel("Purchase Order");
        getContentPane().add(referenceNumberLabel, "2, 10, right, fill");

        referenceTextField = new JTextField();
        getContentPane().add(referenceTextField, "4, 10, fill, default");
        referenceTextField.setColumns(10);

        JLabel bindingTypeLabel = new JLabel("Binding Type:");
        getContentPane().add(bindingTypeLabel, "2, 12, right, default");

        Vector<String> bindingTypes = new Vector<String>();
        for (int x = 0; x < bindingTypesArray.length; x++) {
            bindingTypes.add(bindingTypesArray[x]);
        }
        JComboBox<String> bindingTypesComboBox = new JComboBox<String>(bindingTypes);
        getContentPane().add(bindingTypesComboBox, "4, 12, fill, default");

        JLabel lblNewLabel = new JLabel("Quantity of books");
        getContentPane().add(lblNewLabel, "6, 12, center, default");

        bookQuantityTextField = new JTextField();
        getContentPane().add(bookQuantityTextField, "8, 12, fill, default");
        bookQuantityTextField.setColumns(10);

        coverStockLabel = new JLabel("Cover Stock:");
        getContentPane().add(coverStockLabel, "2, 14, right, fill");

        Vector<String> index = new Vector<String>();
        if (PaperReader.readPaper() != null) {
            sorted = new TreeMap<>(PaperReader.paper);
            Set<Integer> paper = sorted.keySet();
            for (Integer temp : paper) {
                index.addElement(sorted.get(temp).getDescription());
            }
        }

        coverStockComboBox = new JComboBox<String>(index);
        getContentPane().add(coverStockComboBox, "4, 14, fill, fill");

        JLabel coverQuantityLabel = new JLabel("Amount of Covers: ");
        getContentPane().add(coverQuantityLabel, "6, 14, center, fill");

        coverQuantityTextBox = new JTextField("0");
        getContentPane().add(coverQuantityTextBox, "8, 14, fill, fill");
        coverQuantityTextBox.setColumns(10);

        JLabel textStockLabel = new JLabel("Text Stock");
        getContentPane().add(textStockLabel, "2, 16, right, fill");

        JComboBox<String> textStockComboBox = new JComboBox<String>(index);
        getContentPane().add(textStockComboBox, "4, 16, fill, fill");

        JLabel textQuantityLabel = new JLabel("Amount of Text Sheets:");
        getContentPane().add(textQuantityLabel, "6, 16, right, fill");

        textQuantityTextField = new JTextField("0");
        getContentPane().add(textQuantityTextField, "8, 16, fill, fill");
        textQuantityTextField.setColumns(10);

        JLabel insertStockLabel = new JLabel("Insert Stock");
        getContentPane().add(insertStockLabel, "2, 18, right, fill");

        JComboBox<String> insertStockComboBox = new JComboBox<String>(index);
        getContentPane().add(insertStockComboBox, "4, 18, fill, fill");

        JLabel insertQuantityLabel = new JLabel("Amount of Inserts:");
        insertQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(insertQuantityLabel, "6, 18, right, fill");

        insertQuantityTextField = new JTextField("0");
        getContentPane().add(insertQuantityTextField, "8, 18, fill, fill");
        insertQuantityTextField.setColumns(10);

        JLabel bindingEdgeLabel = new JLabel("Binding Edge");
        getContentPane().add(bindingEdgeLabel, "2, 22, right, fill");

        bindingEdgeTextField = new JTextField("0");
        getContentPane().add(bindingEdgeTextField, "4, 22, fill, fill");
        bindingEdgeTextField.setColumns(10);

        JLabel nonBindingEdgeLabel = new JLabel("Non-Binding Edge");
        getContentPane().add(nonBindingEdgeLabel, "2, 24, right, fill");

        nonBindingEdgeTextField = new JTextField("0");
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
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TO DO Move all generate quote to separate dialog box

                String quoteNumber = Long.toString(Instant.now().toEpochMilli());
                quoteNumberLabel.setText("Quote Number: " + quoteNumber);

                String companyEntered = companyNametextField.getText();
                companyNameOutLabel.setText("Company Name: " + companyEntered);

                String estimatorNameEntered = estimatorsNameTextField.getText();
                estimatorNameOutLabel.setText("Estimator's Name: " + estimatorNameEntered);

                String dateEntered = dateTextField.getText();
                dateOutLabel.setText("Date: " + dateEntered);

                String referenceEntered = referenceTextField.getText();
                referenceOutLabel.setText("Reference: " + referenceEntered);

                String quantityEntered = bookQuantityTextField.getText();
                bookQuantityOutLabel.setText("Quantity: " + quantityEntered);

                String bindingTypeSelected = bindingTypesComboBox.getItemAt(bindingTypesComboBox.getSelectedIndex());
                bindingTypeOutLabel.setText(bindingTypeSelected);

                String coverSelected = coverStockComboBox.getItemAt(coverStockComboBox.getSelectedIndex());
                double coverThickness = sorted.get(coverStockComboBox.getSelectedIndex() + 1).getPointThickness();
                int cover = Integer.parseInt(coverQuantityTextBox.getText());
                thickness.setCoversCount(cover);
                thickness.setCoverThicknesses(coverThickness);
                coverStockOutLabel.setText("Covers: " + thickness.getCoversCount() + " sheets of " + coverSelected + " (" + thickness.getCoverThicknesses() + " pt.)");
                coverStockOutLabel.setVisible(true);

                String textSelected = textStockComboBox.getItemAt(textStockComboBox.getSelectedIndex());
                double textThickness = sorted.get(textStockComboBox.getSelectedIndex() + 1).getPointThickness();
                int text = Integer.parseInt(textQuantityTextField.getText());
                thickness.setTextCount(text);
                thickness.setTextThicknesses(textThickness);
                textOutLabel.setText("Text: " + thickness.getTextCount() + " sheets of " + textSelected + " (" + thickness.getTextThicknesses() + " pt.)");
                textOutLabel.setVisible(true);

                String insertSelected = insertStockComboBox.getItemAt(insertStockComboBox.getSelectedIndex());
                double insertThickness = sorted.get(insertStockComboBox.getSelectedIndex() + 1).getPointThickness();
                int insert = Integer.parseInt(insertQuantityTextField.getText());
                thickness.setInsertThicknesses(insertThickness);
                thickness.setInsertCount(insert);
                insertsOutLabel.setText("Inserts: " + thickness.getInsertCount() + " sheets of " + insertSelected + " (" + thickness.getInsertThicknesses() + " pt.)");
                insertsOutLabel.setVisible(true);

                double bindingEdgeDouble = 0;
                bindingEdgeDouble = Double.parseDouble(bindingEdgeTextField.getText());
                thickness.setBindingEdgeInInches(bindingEdgeDouble);
                double nonBindingEdgeDouble = 0;
                nonBindingEdgeDouble = Double.parseDouble(nonBindingEdgeTextField.getText());
                thickness.setNonBindingEdgeInInches(nonBindingEdgeDouble);

                bookSizeOutLabel.setText("Book Size: " + nonBindingEdgeDouble + " inches X " + bindingEdgeDouble + " (binding edge)");
                bookThicknessOutLabel.setText("Book Thickness: " + thickness.bookThicknessAsString());
                bookThicknessOutLabel.setVisible(true);

                bindingSizeOutLabel.setText("Wire or Coil Size: " + thickness.bindingSize());
                bindingSizeOutLabel.setVisible(true);

                Plasticoil plasticoilPrice = new Plasticoil();
                double price = plasticoilPrice.getBindingPrice(Double.parseDouble(thickness.bindingSize()), Integer.parseInt(quantityEntered));
                String stringPrice = Double.toString(price);
                priceLabel.setText("Price: $" + stringPrice);
                priceLabel.setVisible(true);
            }
        });
        getContentPane().add(btnOk, "8, 26");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 957, 1015);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setBackground(SystemColor.windowBorder);
        fileMenu.setMnemonic('F');
        menuBar.add(fileMenu);

        JMenuItem printQuote = new JMenuItem("Export As PDF");
        printQuote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to print this quote?", "Print Quote", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                }
            }
        });

        printQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        fileMenu.add(printQuote);

        JMenuItem exportQuote = new JMenuItem("Print");
        exportQuote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to export this quote as a PDF?", "Export Quote", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                }
            }
        });

        exportQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
        fileMenu.add(exportQuote);

        JMenuItem saveQuote = new JMenuItem("Save");
        saveQuote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(getContentPane(), "Do you want to save this quote?", "Save Quote", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                }
            }
        });

        saveQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        fileMenu.add(saveQuote);

        JMenuItem quitQuote = new JMenuItem("Quit");
        quitQuote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
        quitQuote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOG.debug("Program Quit By User");
                System.exit(0);
            }
        });
        fileMenu.add(quitQuote);

        JMenu editMenu = new JMenu("Edit");
        editMenu.setBackground(SystemColor.windowBorder);

        editMenu.setMnemonic('B');
        menuBar.add(editMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Count");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        editMenu.add(mntmNewMenuItem);

        chckbxmntmByAuthor = new JCheckBoxMenuItem("By Author");
        chckbxmntmByAuthor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
        editMenu.add(chckbxmntmByAuthor);

        authorsDescending = new JCheckBoxMenuItem("Descending");
        authorsDescending.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        editMenu.add(authorsDescending);

        JMenuItem mntmList = new JMenuItem("List");
        mntmList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        mntmList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        editMenu.add(mntmList);

        JMenu maintainMenu = new JMenu("Maintain");
        maintainMenu.setMnemonic('C');
        maintainMenu.setBackground(SystemColor.windowBorder);
        menuBar.add(maintainMenu);

        JMenuItem mnNewMenu_2 = new JMenuItem("Count");
        mnNewMenu_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        mnNewMenu_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        maintainMenu.add(mnNewMenu_2);

        JMenuItem mnNewMenu_4 = new JMenuItem("List");
        mnNewMenu_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        mnNewMenu_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        chckbxmntmByJoinDate = new JCheckBoxMenuItem("By Join Date");
        chckbxmntmByJoinDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.ALT_MASK));
        maintainMenu.add(chckbxmntmByJoinDate);
        maintainMenu.add(mnNewMenu_4);

        JMenu Reports = new JMenu("Reports");
        Reports.setFont(new Font("Dialog", Font.PLAIN, 12));
        Reports.setBackground(SystemColor.windowBorder);
        Reports.setMnemonic('P');
        menuBar.add(Reports);

        sortByCompany = new JCheckBoxMenuItem("Company");
        sortByCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(getContentPane(), "Search By Company Name", "Search By Company Name", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        sortByCompany.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        Reports.add(sortByCompany);

        sortByEstimator = new JCheckBoxMenuItem("Estimator");
        sortByEstimator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(getContentPane(), "Search By Estimator's Name", "Search By Estimator's Name", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        sortByEstimator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        Reports.add(sortByEstimator);

        JMenuItem sortByDate = new JMenuItem("Date");
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

        JCheckBoxMenuItem sortByReference = new JCheckBoxMenuItem("Reference");
        sortByReference.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        Reports.add(sortByReference);

        sortByBindingType = new JCheckBoxMenuItem("Binding Type");
        sortByBindingType.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
        Reports.add(sortByBindingType);

        sortByQuoteNumber = new JMenuItem("Quote Number");
        sortByQuoteNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(getContentPane(), "Search By Quote Number", "Search By Quote Number", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        sortByQuoteNumber.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
        Reports.add(sortByQuoteNumber);

        JMenuItem sortByAll = new JMenuItem("View All");
        sortByAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK));
        sortByAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "Would you like to produce a list\nof all quotes in database?", "View All", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        Reports.add(sortByAll);

        JMenu mnHelp = new JMenu("Help");
        mnHelp.setMnemonic('H');
        mnHelp.setBackground(SystemColor.windowBorder);
        menuBar.add(mnHelp);

        JMenuItem mnAbout = new JMenuItem("About");
        mnAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        mnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "Personal Project\nSample Quoting Software\nBy Andrew Hewitson", "Sample Quoting Software", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mnHelp.add(mnAbout);
    }
}
