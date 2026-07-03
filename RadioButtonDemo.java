import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame implements ActionListener {
    // UI Components
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup group;
    private JLabel imageLabel;

    // FIXED: Pathed exactly to your GitHub setup (Capital letters and .webp extension)
    private final String BIRD_PATH = "images/Bird.webp";
    private final String CAT_PATH = "images/Cat.webp";
    private final String DOG_PATH = "images/Dog.webp";
    private final String RABBIT_PATH = "images/Rabbit.webp";
    private final String PIG_PATH = "images/Pig.webp";

    public RadioButtonDemo() {
        // Set up the frame
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create the radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons so only one can be selected at a time
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add action listeners to handle selections
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Put the radio buttons in a column within a panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        pigButton.setSelected(true); // Default selection
        radioPanel.add(pigButton);

        // Set up the image label
        imageLabel = new JLabel(createImageIcon(PIG_PATH));
        imageLabel.setPreferredSize(new Dimension(200, 200));
        
        JPanel imagePanel = new JPanel(new CenterLayout());
        imagePanel.add(imageLabel);

        // Add panels to the frame
        add(radioPanel, BorderLayout.WEST);
        add(imagePanel, BorderLayout.CENTER);

        // Size and display the window
        setSize(450, 260);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPet = "";
        ImageIcon newIcon = null;

        if (e.getSource() == birdButton) {
            selectedPet = "Bird";
            newIcon = createImageIcon(BIRD_PATH);
        } else if (e.getSource() == catButton) {
            selectedPet = "Cat";
            newIcon = createImageIcon(CAT_PATH);
        } else if (e.getSource() == dogButton) {
            selectedPet = "Dog";
            newIcon = createImageIcon(DOG_PATH);
        } else if (e.getSource() == rabbitButton) {
            selectedPet = "Rabbit";
            newIcon = createImageIcon(RABBIT_PATH);
        } else if (e.getSource() == pigButton) {
            selectedPet = "Pig";
            newIcon = createImageIcon(PIG_PATH);
        }

        // Update the image display
        if (newIcon != null) {
            imageLabel.setIcon(newIcon);
        }

        // Display selection using a message box
        JOptionPane.showMessageDialog(this, "You selected the " + selectedPet + "!", "Pet Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    // Helper method to safely load images
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return new ImageIcon(path);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonDemo());
    }
}

class CenterLayout implements LayoutManager {
    @Override public void addLayoutComponent(String name, Component comp) {}
    @Override public void removeLayoutComponent(Component comp) {}
    @Override public Dimension preferredLayoutSize(Container parent) { return new Dimension(200, 200); }
    @Override public Dimension minimumLayoutSize(Container parent) { return new Dimension(100, 100); }
    @Override public void layoutContainer(Container parent) {
        int ncomponents = parent.getComponentCount();
        if (ncomponents == 0) return;
        Component c = parent.getComponent(0);
        Dimension d = c.getPreferredSize();
        int x = (parent.getWidth() - d.width) / 2;
        int y = (parent.getHeight() - d.height) / 2;
        c.setBounds(x, y, d.width, d.height);
    }
}
