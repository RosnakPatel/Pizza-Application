import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Scanner;

public class PizzaApp {

    // Frame declaration
    private JFrame frame;

    // Container declaration and settings
    Container contentPane;

    // radio buttons and button group
    private JRadioButton regularCrustButton;
    private JRadioButton thinCrustButton;
    private JRadioButton handCrustButton;
    private JRadioButton deepCrustButton;
    private ButtonGroup crustButtonGroup;

    // check boxes
    private JCheckBox pepperoniBox;
    private JCheckBox sausageBox;
    private JCheckBox cheeseBox;
    private JCheckBox pepperBox;
    private JCheckBox onionBox;
    private JCheckBox mushroomBox;
    private JCheckBox oliveBox;
    private JCheckBox anchovyBox;

    // text fields
    private JTextField breadSticksText;
    private JTextField buffaloWingsText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField cityText;

    public static void main(String[] args) {
        // gui declaration
        PizzaApp gui = new PizzaApp();
        gui.start();
    }

    /**
     * Starts gui application
     */
    public void start() {
        // New JFrame that exits program on close
        frame = new JFrame("GUI Pizza");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 300);

        // Make gui menus
        makeMenus();

        // Make gui layout
        makeContent();

        // Frame visible and packed
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Make content pane and layout
     */
    public void makeContent() {
        contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));


        // Make regions
        makeNorth();
        makeWest();
        makeCenter();
        makeEast();
        makeSouth();
    }

    /**
     * Make South region
     */
    public void makeSouth() {
        // Create panel and set border and layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Deliver to:"));

        // Create a panel for name, address, and city
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));

        smallPanel.add(new JLabel("Name:"));
        smallPanel.add(new JLabel("Address:"));
        smallPanel.add(new JLabel("City, St, Zip:"));

        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        panel.add(smallPanel);

        // Create panel for text fields
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));

        // Create text fields
        nameText = new JTextField();
        addressText = new JTextField();
        cityText = new JTextField();

        // Add text fields to panel
        smallPanel.add(nameText);
        smallPanel.add(addressText);
        smallPanel.add(cityText);

        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        panel.add(smallPanel);

        contentPane.add(panel, BorderLayout.SOUTH);

    }

    /**
     * Make North region
     */
    public void makeNorth() {
        JLabel img = new JLabel(new ImageIcon("Resources_njv-1_L08-06.jpg"), JLabel.CENTER);
        contentPane.add(img, BorderLayout.NORTH);
    }

    /**
     * Make Western region
     */
    public void makeWest() {
        // Create panel for the crust buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Set border
        panel.setBorder(BorderFactory.createTitledBorder("Choose a crust"));

        // Create button group
        crustButtonGroup = new ButtonGroup();

        // Add buttons and add to button group
        regularCrustButton = new JRadioButton("Regular crust", true);
        crustButtonGroup.add(regularCrustButton);
        panel.add(regularCrustButton);

        thinCrustButton = new JRadioButton("Thin Crust", false);
        crustButtonGroup.add(thinCrustButton);
        panel.add(thinCrustButton);

        handCrustButton = new JRadioButton("Hand Crust", false);
        crustButtonGroup.add(handCrustButton);
        panel.add(handCrustButton);

        deepCrustButton = new JRadioButton("Deep Crust", false);
        crustButtonGroup.add(deepCrustButton);
        panel.add(deepCrustButton);

        // Add panel to west region of contentPane
        contentPane.add(panel, BorderLayout.WEST);
    }

    /**
     * Make toppings selection region
     */
    public void makeCenter() {
        // Create panel and border
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Select toppings"));

        // Create and add toppings buttons to panel
        pepperoniBox = new JCheckBox("Pepperoni");
        panel.add(pepperoniBox);

        sausageBox = new JCheckBox("Sausage");
        panel.add(sausageBox);

        cheeseBox = new JCheckBox("Extra Cheese");
        panel.add(cheeseBox);

        pepperBox = new JCheckBox("Bell Peppers");
        panel.add(pepperBox);

        onionBox = new JCheckBox("Onions");
        panel.add(onionBox);

        mushroomBox = new JCheckBox("Mushrooms");
        panel.add(mushroomBox);

        oliveBox = new JCheckBox("Olives");
        panel.add(oliveBox);

        anchovyBox = new JCheckBox("Anchovies");
        panel.add(anchovyBox);

        // Add panel to content pane
        contentPane.add(panel, BorderLayout.CENTER);
    }

    /**
     * Make east region
     */
    public void makeEast() {
        // Panel and border setup
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Sides (Enter Quantity)"));
        panel.setPreferredSize(new Dimension(150, 0));

        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));

        // Add text fields
        breadSticksText = new JTextField("", 2);
        breadSticksText.setMaximumSize(new Dimension(20, 24));
        smallPanel.add(breadSticksText);
        smallPanel.add(new JLabel(" Bread Sticks"));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        panel.add(smallPanel);

        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
        buffaloWingsText = new JTextField("", 2);
        buffaloWingsText.setMaximumSize(new Dimension(20, 24));
        smallPanel.add(buffaloWingsText);
        smallPanel.add(new JLabel(" Buffalo Wings"));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        // Add small panel to panel to content pane
        panel.add(smallPanel);
        contentPane.add(panel, BorderLayout.EAST);
    }

    /**
     * Creates file menu
     * @return file menu
     */
    public JMenu fileMenu() {
        // File menu declaration
        JMenu file = new JMenu("File");

        // New order menu item declaration and settings
        JMenuItem newOrd = new JMenuItem("New Order");
        newOrd.setMnemonic(KeyEvent.VK_N);
        newOrd.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        newOrd.addActionListener(new newOrdListener());

        // Save order menu item declaration and settings
        JMenuItem savOrd = new JMenuItem("Save Order");
        savOrd.setMnemonic(KeyEvent.VK_S);
        savOrd.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        savOrd.addActionListener(new savOrdListener());

        // Import order menu item declaration and settings
        JMenuItem impOrd = new JMenuItem("Import Order");
        impOrd.setMnemonic(KeyEvent.VK_I);
        impOrd.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
        impOrd.addActionListener(new impOrdListener());

        // Exit menu item declaration and settings
        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
        exit.addActionListener(new exitListener());

        // Add menu items to file menu
        file.add(newOrd);
        file.add(savOrd);
        file.add(impOrd);
        file.addSeparator();
        file.add(exit);

        // Return file menu
        return file;
    }

    /**
     * Create help menu
     * @return help menu
     */
    public JMenu helpMenu() {
        // Help menu declaration
        JMenu help = new JMenu("Help");

        // AboutGUIPizza menu item declaration and settings
        JMenuItem aboutGUIPizza = new JMenuItem("About GUI Pizza");
        aboutGUIPizza.setMnemonic(KeyEvent.VK_A);
        aboutGUIPizza.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        aboutGUIPizza.addActionListener(new aboutListener());

        // Add menu item to help menu
        help.add(aboutGUIPizza);

        // Return help menu
        return help;
    }

    /**
     * Make menu and menu bar
     */
    public void makeMenus() {
        // menuBar declaration
        JMenuBar menuBar = new JMenuBar();

        // File menu declaration and settings
        JMenu file = fileMenu();
        file.setMnemonic(KeyEvent.VK_F);

        // Help menu declaration and settings
        JMenu help = helpMenu();
        help.setMnemonic(KeyEvent.VK_H);

        // Set menuBar to frame
        frame.setJMenuBar(menuBar);

        // Add menus to menuBar
        menuBar.add(file);
        menuBar.add(help);

    }

    private class aboutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Show GUI Pizza information when clicked
            JOptionPane.showMessageDialog(frame, "GUI Pizza\n\n" +
                            "Version 1.0\n\n" +
                            "Build 12485283\n\n" +
                            "Built By Ronak Patel",
                    "About GUI Pizzas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class exitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Make sure user wants to exit program
            int exit = JOptionPane.showOptionDialog(frame, "Are you sure you want to exit?",
                    null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if (exit == 0) {
                System.exit(0);
            }
        }
    }

    /**
     * Save order by writing to a file
     */
    public class savOrdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String order = "Pizza Order ";
            int breadSticks;
            int buffaloWings;

            // User information
            if (nameText.getText().isEmpty() || addressText.getText().isEmpty()
                    || cityText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter your name, address, and city, state, and zip code");
            }
            else{
                order +=  nameText.getText() + "\n" +
                        "===========\n" +
                        "Deliver to:\n" +
                        "\t" + nameText.getText() + "\n" +
                        "\t" + addressText.getText() + "\n" +
                        "\t" + cityText.getText() + "\n" +
                        "Crust:\n";
            }


            // Add Crust
            if (regularCrustButton.isSelected()) {
                order += "\tRegular\n";
            }
            else if (thinCrustButton.isSelected()) {
                order += "\tThin\n";
            }
            else if (handCrustButton.isSelected()) {
                order += "\tHand-Tossed\n";
            }
            else if (deepCrustButton.isSelected()) {
                order += "\tDeep-Dish\n";
            }

            // Add Toppings
            order += "Toppings:\n";
            if (pepperoniBox.isSelected()) {
                order += "\tPepperoni\n";
            }
            if (sausageBox.isSelected()) {
                order += "\tSausage\n";
            }
            if (cheeseBox.isSelected()) {
                order += "\tExtra Cheese\n";
            }
            if (pepperBox.isSelected()) {
                order += "\tBell Peppers\n";
            }
            if (onionBox.isSelected()) {
                order += "\tOnions\n";
            }
            if (mushroomBox.isSelected()) {
                order += "\tMushrooms\n";
            }
            if (oliveBox.isSelected()) {
                order += "\tOlives\n";
            }
            if (anchovyBox.isSelected()) {
                order += "\tAnchovies\n";
            }

            // Check sides if integer then add to order
            String sides = "Sides:\n";
            try {
                if (!breadSticksText.getText().isEmpty()) {
                    breadSticks = Integer.parseInt(breadSticksText.getText());
                    if (breadSticks > 0) {
                        order += String.format("%s\t%d Bread Sticks\n", sides, breadSticks);
                        sides = "";
                    }
                }
                if (!buffaloWingsText.getText().isEmpty()) {
                    buffaloWings = Integer.parseInt(buffaloWingsText.getText());
                    if (buffaloWings > 0)
                        order += String.format("%s\t%d Buffalo Wings\n", sides, buffaloWings);
                }

            } catch (Exception x) {
                JOptionPane.showMessageDialog(frame,
                        "Side order entries must be numeric and whole numbers");
            }

            order += "\n***END OF ORDER***\n";

            try {
                PrintStream ordersFile = new PrintStream("Orders.txt");
                ordersFile.print(order);
                ordersFile.close();
                JOptionPane.showMessageDialog(frame, "Your order has been saved.");
            } catch (Exception a) {
                System.err.print(a);
            }

        }
    }

    /**
     * Reset order
     */
    public class newOrdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            regularCrustButton.setSelected(true);
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            cheeseBox.setSelected(false);
            pepperBox.setSelected(false);
            onionBox.setSelected(false);
            mushroomBox.setSelected(false);
            oliveBox.setSelected(false);
            anchovyBox.setSelected(false);
            breadSticksText.setText("");
            buffaloWingsText.setText("");
            nameText.setText("");
            addressText.setText("");
            cityText.setText("");
        }
    }

    public class impOrdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String order;
            String name;

            name = JOptionPane.showInputDialog(frame, "Enter your name: ");

            try {
                Scanner scan = new Scanner(new File("Orders.txt"));
                if (scan.hasNextLine()) {
                    if (scan.nextLine().contains(name)) {
                        scan.nextLine();
                        scan.nextLine();
                        nameText.setText(scan.nextLine().split("\t")[1]);
                        addressText.setText(scan.nextLine().split("\t")[1]);
                        cityText.setText(scan.nextLine().split("\t")[1]);
                        scan.nextLine();
                        switch(scan.nextLine().split("\t")[1]) {
                            case "Regular":
                                regularCrustButton.setSelected(true);
                                break;
                            case "Thin":
                                thinCrustButton.setSelected(true);
                                break;
                            case "Hand-Tossed":
                                handCrustButton.setSelected(true);
                                break;
                            case "Deep-Dish":
                                deepCrustButton.setSelected(true);
                                break;
                        }
                        if (scan.nextLine().equalsIgnoreCase("Toppings:")) {

                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Pepperoni")) {
                                pepperoniBox.setSelected(true);
                            } else pepperoniBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Sausage")) {
                                sausageBox.setSelected(true);
                            } else sausageBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Extra Cheese")) {
                                cheeseBox.setSelected(true);
                            } else cheeseBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Bell Peppers")) {
                                pepperBox.setSelected(true);
                            } else pepperBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Onions")) {
                                onionBox.setSelected(true);
                            } else onionBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Mushrooms")) {
                                mushroomBox.setSelected(true);
                            } else mushroomBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Olives")) {
                                oliveBox.setSelected(true);
                            } else oliveBox.setSelected(false);
                            if (scan.nextLine().split("\t")[1].equalsIgnoreCase("Anchovies")) {
                                anchovyBox.setSelected(true);
                            } else anchovyBox.setSelected(false);
                        }

                    }
                    else {
                        scan.nextLine();
                    }
                    if (scan.nextLine().equalsIgnoreCase("Sides:")) {
                        String a = scan.nextLine();
                        if (a.contains("Bread")) {
                            breadSticksText.setText(a.split("\t")[1].split(" ")[0]);
                        }
                        a = scan.nextLine();
                        if (a.contains("Buffalo")) {
                            buffaloWingsText.setText(a.split("\t")[1].split(" ")[0]);
                        }
                    }

                }

            } catch (Exception x) {
                System.err.println(x);
            }

        }
    }
}
