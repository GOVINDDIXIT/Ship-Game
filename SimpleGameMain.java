import java.io.*;

class GameHelper{
    public String getUserInut(String prompt)
    {
        String inputLine=null;
        System.out.print(prompt+" ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length()==0) return null;
        }
        catch(IOException e)
        {
            System.out.print("IOException: "+e);
        }
        return inputLine;
    }
}

class SimpleGameMain{
    public static void main(String[] args) {
        int noOfGuesses=0;
        GameHelper helper = new GameHelper();
        SimpleGame game = new SimpleGame();
        int random = (int)(Math.random()*9);
        int locations[]={random, random+1, random+2};
        game.setLocation(locations);
        boolean isAlive= true;

        while(isAlive==true){
            String kill ="BOOM! The ship is destroyed, Captain";
            String guess = helper.getUserInut("Enter a Number : ");
            String result = game.CheckYourself(guess);
            noOfGuesses++;
            if(result.equals(kill))
            {
                isAlive=false;
                System.out.println("You took " + noOfGuesses + " Guesses to win");
            }
        }
    }

}

class SimpleGame{
    int locationCells [];
    int noOfHits= 0;

    public void setLocation(int []locs)
    {
        locationCells=locs;
    }

    public String CheckYourself(String guessString)
    {
        int guess = Integer.parseInt(guessString);
        String result="Miss (The Ship is not there )";
        for(int cell:locationCells){
            if(guess == cell)
            {
                result="Hit";
                noOfHits++;
                break;
            }
        }

        if(noOfHits==locationCells.length){
            result="BOOM! The ship is destroyed Captain";
        }
        System.out.println(result);
        return result;
    }
}


