public class SimpleGame{
    int locationCells [];
    int noOfHits= 0;

    public void setLocationCells(int []locs)
    {
        locationCells=locs;
    }

    public String CheckYourself(String guessString)
    {
        int guess = Intger.ParseInt(guessString);
        String result="miss";
        for(int cell:locationCells){
            if(guess == cell)
            {
                noOfHits++;
                break;
            }
        }

        if(noOfHits==locationCells.length){
            result="kill";
        }
        System.out.println(result);
        return result;
    }
}