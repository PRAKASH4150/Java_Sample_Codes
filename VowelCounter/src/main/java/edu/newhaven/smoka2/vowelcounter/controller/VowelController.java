/**
 * VowelController.java: This file acts as the controller class
 * to calculate the number of vowels present in a given word.
 * The word is passed as a parameter using the end point
 * For instance to calculate the number of vowels present in
 * the word "Hello" the end point should be
 * http://localhost:8080/count?word=Hello
 *
 * @author Sai Surya Prakash Moka.
 *
 * @date 10-12-2023.
 */
package edu.newhaven.smoka2.vowelcounter.controller;

import edu.newhaven.smoka2.vowelcounter.model.VowelCount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VowelController {
    @RequestMapping(path="count",produces = "application/json")
    public VowelCount getVowelCount(@RequestParam("word") String word)
    {
        char []wordArray;
        int aCount;
        int eCount;
        int iCount;
        int oCount;
        int uCount;
        word=word.toLowerCase();
        wordArray=word.toCharArray();
        aCount=eCount=iCount=oCount=uCount=0;
        for(int i=0;i<wordArray.length;i++)
        {
           switch(wordArray[i])
           {
               case 'a':
                   aCount+=1;
                   break;
               case 'e':
                   eCount+=1;
                   break;
               case 'i':
                   iCount+=1;
                   break;
               case 'o':
                   oCount+=1;
                   break;
               case 'u':
                   uCount+=1;
                   break;
           }
        }
        VowelCount vowelCount=new VowelCount(word,aCount,eCount,iCount,oCount,uCount);
        return vowelCount;
    }
}
