import java.util.List;
import java.util.LinkedList;
public class Olympian {
    String name;
    String sport;
    int numMedals;
    String event;

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

    public static int computeMedals(List<Olympian> olympianList)
    {
        int totalNumMedals=0;
        for(Olympian olympian:olympianList)
        {
            totalNumMedals+=olympian.getNumMedals();
        }
        return totalNumMedals;

    }
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
