/**
 * Olympian.java: This is a base POJO class which is used to initialize
 * the data members and also to compute the total number of medals won
 * by all the players.
 *
 * @author: Sai Surya Prakash Moka
 * @date: 09/20/2023
 */

import java.util.List;
import java.util.LinkedList;
public class Olympian {
    private String name;
    private String sport;
    private int numMedals;
    private String event;

    /**
     * Initializing the fields using the parameterized constructor
     * @param name
     * @param sport
     * @param numMedals
     * @param event
     */
    Olympian(String name,String sport,int numMedals,String event)
    {
        this.name=name;
        this.sport=sport;
        this.numMedals=numMedals;
        this.event=event;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSport()
    {
        return this.sport;
    }

    public int getNumMedals()
    {
        return this.numMedals;
    }
    public String getEvent()
    {
        return  this.event;
    }

    /**
     * Calculates the total number of medals won by all the players.
     * @param olympianList
     * @return totalNumMedals
     */

    public static int computeMedals(List<Olympian> olympianList)
    {
        int totalNumMedals=0;
        for(Olympian olympian:olympianList)
        {
            totalNumMedals+=olympian.getNumMedals();
        }
        return totalNumMedals;

    }

    /**
     *
     * @return details of each player record.
     */
    @Override
    public String toString()
    {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("\nName:").append(this.name).append("\nSport:")
                .append(this.sport).append("\nNumber of Medals:").
                append(this.numMedals).append("\nEvent:").
                append(this.event);
        return  stringBuilder.toString();

    }
}
