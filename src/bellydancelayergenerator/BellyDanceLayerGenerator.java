
package bellydancelayergenerator;

/**
 *
 * @author Gabriel Vidrine
 * Random belly dance movement generator with GUI, uses ArrayLists and files 
 * to read movements from and generate random layers and speeds for practice
 */
public class BellyDanceLayerGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //throws FileNotFoundException {
        
        //Create a new GUI
        BellyGUI randomBelly = new BellyGUI();
    }
        /**
        ArrayList<String> hipMoves = new ArrayList<>();
        ArrayList<String> chestMoves = new ArrayList<>();
        ArrayList<String> travelMoves = new ArrayList<>();
        ArrayList<String> speeds = new ArrayList<>();
        
        speeds.add("half time");
        speeds.add("full time");
        speeds.add("double time");
        
        String hipResult;
        String chestResult;
        String travelResult;
        char doAgain;
        String input;
        
        hipMoves = getArray("hipmovements.txt");
        chestMoves = getArray("uppermovements.txt");
        travelMoves = getArray("travelsteps.txt");
        
        
        do {
        int hipRandom = getRandom(hipMoves);
        int chestRandom = getRandom(chestMoves);
        int travelRandom = getRandom(travelMoves);


        hipResult = hipMoves.get(hipRandom);
        chestResult = chestMoves.get(chestRandom);
        travelResult = travelMoves.get(travelRandom);
        
        System.out.println("Hips movement: " + hipResult + " " + getSpeed(speeds));
        System.out.println("Chest movement: " + chestResult + " " + getSpeed(speeds));
        System.out.println("Travel movement: " + travelResult + " " + getSpeed(speeds));
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to go again?");
        input = keyboard.nextLine();
        
        doAgain = input.charAt(0);
        
        
        } while(doAgain == 'Y' || doAgain == 'y');
    }
    
    public static ArrayList<String> getArray(String filename)
    {
        ArrayList<String> array = new ArrayList<>();
        Scanner s;
        
        
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
    
    public static int getRandom(ArrayList<String> array){
        Random rand = new Random();
        int result;
        
        result = rand.nextInt(array.size());
        
        return result;
        
    }
    
    public static String getSpeed(ArrayList<String> array) {
        int speed;
        String result;        
        
        speed = getRandom(array);
        result = array.get(speed);
        
        return result;
        
    }
    
}
**/
    
}
    
    