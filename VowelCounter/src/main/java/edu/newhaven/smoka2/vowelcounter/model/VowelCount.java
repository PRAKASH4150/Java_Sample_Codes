/**
 * VowelCount.java: This class acts as a POJO class for VowelCount
 * It contains variables to store the actual word and a,e,i,o,u
 * count respectively.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10-12-2023.
 */
package edu.newhaven.smoka2.vowelcounter.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VowelCount {

    @JsonProperty
    String word;
    @JsonProperty
    int aCount;
    @JsonProperty
    int eCount;
    @JsonProperty
    int iCount;
    @JsonProperty
    int oCount;
    @JsonProperty
    int uCount;

    public VowelCount(String word,int aCount,int eCount,int iCount,int oCount,int uCount)
    {
        this.word=word;
        this.aCount=aCount;
        this.eCount=eCount;
        this.iCount=iCount;
        this.oCount=oCount;
        this.uCount=uCount;
    }
    public String toString()
    {
        return "Word:"+this.word+"A Count:"+this.aCount+" E Count:"+this.eCount+" I Count:"+
                this.iCount+" O Count:"+this.oCount+" U Count:"+this.uCount;
    }
}
