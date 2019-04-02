/*
 * GUI for the Belly Dance Layer Generator
 */
package bellydancelayergenerator;


import java.awt.*;              //Using AWT Container and component classes
import java.awt.event.*;        //Using AWT event classes and listeners
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gabriel Vidrine
 */
public class BellyGUI extends Frame implements ActionListener, WindowListener {
    
    private Label hipLabel;                     //GUI label for hip movement
    private Label chestLabel;                   //GUI label for chest movement
    private Label travelLabel;                  //GUI label for travel movement
    private TextField hipText;                  //Text field for hip movement
    private TextField chestText;                //Text field for chest movement
    private TextField travelText;               //Text field for travel movement
    private TextField hipSpeedText;             //Text field for hip speed
    private TextField chestSpeedText;           //Text field for chest speed
    private TextField travelSpeedText;          //Text field for travel speed
    private Button generateButton;              //Generate random moves button
    
    
    /**
     * Constructor
     */
    public BellyGUI() {
        setLayout(new FlowLayout());                //Flow layout of frame
        
        //Contruct and add labels and text fields for GUI
        hipLabel = new Label("Hip Movement");
        add(hipLabel);
        
        hipText = new TextField("            ");
        hipText.setEditable(false);
        add(hipText);
        
        hipSpeedText = new TextField("           ");
        hipSpeedText.setEditable(false);
        add(hipSpeedText);
        
        chestLabel = new Label("Chest Movement");
        add(chestLabel);
        
        chestText = new TextField("            ");
        chestText.setEditable(false);
        add(chestText);
        
        chestSpeedText = new TextField("           ");
        chestSpeedText.setEditable(false);
        add(chestSpeedText);
        
        travelLabel = new Label("Travel Movement");
        add(travelLabel);
        
        travelText = new TextField("           ");
        travelText.setEditable(false);
        add(travelText);
        
        travelSpeedText = new TextField("           ");
        travelSpeedText.setEditable(false);
        add(travelSpeedText);
    
        //Construct button and add to frame
        generateButton = new Button("Generate Layers");
        add(generateButton);
        
        //Action listener for button
        generateButton.addActionListener(this);
        
        //Add a window listener for window closing, activation
        addWindowListener(this);
        
        //Set title, size, and visibility of frame
        setTitle("Belly Dance Layer Generator");
        setSize(400,250);
        
        setVisible(true);
        
    }
    
    //Close window when close button pushed
    @Override
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }
    
    //Overrides for implentation of WindowListener
    @Override public void windowOpened(WindowEvent evt) { }
    @Override public void windowClosed(WindowEvent evt) { }
    
    //For debugging
    @Override public void windowIconified(WindowEvent evt) { System.out.println("Window Iconified"); }
    @Override public void windowDeiconified(WindowEvent evt) { System.out.println("Window Deiconified"); }
    @Override public void windowActivated(WindowEvent evt) { System.out.println("Window Activated"); }
    @Override public void windowDeactivated(WindowEvent evt) { System.out.println("Window Deactivated"); }
    
    //When Generate button is pushed
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        //Array lists of movements from files
        ArrayList<String> hipMoves = new ArrayList<>();
        ArrayList<String> chestMoves = new ArrayList<>();
        ArrayList<String> travelMoves = new ArrayList<>();
        ArrayList<String> speeds = new ArrayList<>();
        
        //Speeds for movements
        speeds.add("half time");
        speeds.add("full time");
        speeds.add("double time");
        
        //String variables to hold results
        String hipResult;
        String chestResult;
        String travelResult;
        String hipSpeed;
        String chestSpeed;
        String travelSpeed;

        //Populate arrays from files
        hipMoves = getArray("hipmovements.txt");
        chestMoves = getArray("uppermovements.txt");
        travelMoves = getArray("travelsteps.txt");
        
        //Generate random numbers to randomize movements
        int hipRandom = getRandom(hipMoves);
        int chestRandom = getRandom(chestMoves);
        int travelRandom = getRandom(travelMoves);
        
        //Generate random speeds
        hipSpeed = getSpeed(speeds);
        chestSpeed = getSpeed(speeds);
        travelSpeed = getSpeed(speeds);
        
        //Generate random results from random numbers and store in Strings
        hipResult = hipMoves.get(hipRandom);
        chestResult = chestMoves.get(chestRandom);
        travelResult = travelMoves.get(travelRandom);
        
        //Set TextFields to results
        hipText.setText(hipResult);
        hipSpeedText.setText(hipSpeed);
        chestText.setText(chestResult);
        chestSpeedText.setText(chestSpeed);
        travelText.setText(travelResult);
        travelSpeedText.setText(travelSpeed);
        
    }
    
    //Read file of moves and populate the array
    public static ArrayList<String> getArray(String filename) 
    {
        ArrayList<String> array = new ArrayList<>();
        Scanner s;
        
        //To open file
        try {
            
        s = new Scanner(new File(filename));
        while (s.hasNext()){
            array.add(s.nextLine());
        }
        
         s.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        }

        return array;
        
    }
    
    //Generate random numbers according to file size
    public static int getRandom(ArrayList<String> array){
        Random rand = new Random();
        int result;
        
        result = rand.nextInt(array.size());
        
        return result;
        
    }
    
    //Generare random numbers according to array size of speeds
    public static String getSpeed(ArrayList<String> array) {
        int speed;
        String result;        
        
        speed = getRandom(array);
        result = array.get(speed);
        
        return result;
        
    }
        
}
