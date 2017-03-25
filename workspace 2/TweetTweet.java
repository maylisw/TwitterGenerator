//Imports for the word categorisation.
/*import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.List;
import java.util.HashMap;

import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.StringReader;

import java.util.Collection;

/**
 * Creates a new class called TweetTweet.

public class TweetTweet
{
    private String link; //declares instance variables
    private String paragraph;
    
    public TweetTweet(String l) //Constructor for TweetTweet
    {
        link = l;
    }
    
    public String websiteToText()
    {
        ReadFromURLExample site = new ReadFromURLExample(link);
        paragraph = site.plainText(site.text());
    }
    
    /**
     * Creates a Set with a list of all the words in the article.
     * @param inputs the article to be analysed
     
    public HashMap<String, Integer> wordLocator() {
        Scanner in = new Scanner(System.in);
        paragraph = in.nextLine();        
        HashMap<String, Integer> wordsValues = new HashMap<>();
        //somehow get the link to be converted into the paragraph text
        int length = paragraph.length();
        String word = "";
        int location = 0;
        while(location < length + 1) {
        for(int i = 0; i < length-1; i++){
            char character = paragraph.charAt(i);
            if(Character.isAlphabetic(character)) {
                for(int k = 0; k < paragraph.length() - i; k++){
                    char char2 = paragraph.charAt(k + i);
                    if(Character.isAlphabetic(char2) == false) {
                        word = paragraph.substring(i, k);
                        location = k;
                        i = k;
                    }
                }
            }
            if(wordsValues.containsKey(word) == false) {
             wordsValues.put(word, 1);
            }
            else {
             wordsValues.put(word, wordsValues.get(word) + 1);
            }
        }
        }
        return wordsValues;
    }
    
    /*public HashMap<String, String> pOfS() 
    {
        HashMap<String, String> h = new HashMap<>();
        MaxentTagger tagger = new MaxentTagger("english-left3words-distsim.tagger");//model fie from their models
        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));
        for (List<HasWord> sentence : sentences) {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for(TaggedWord t: tSentence )
            {
                 h.put((String) t, (string) t.tag());
            }
        }
        return h;
    }
    
    /*public Word[] words(HashMap h, HashMap z)
    {
        
    }
    
    public Word[] conversion(HashMap h)
    {
        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.
        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.
        int[] v2 = v.toArray(); //creates an array w/ values from v.
        String[] w2 = w.toArray(); //creates an array from set w.
        //int[] vals = new Array[s.size()]; creates an array w/ sizes 
        //Set<String> partOfSpeechWord = new Set[paragraph.length()];
        HashMap<String, String> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pofS
        Collection<String> pofs = wordSpeech.values(); //Collection of values from PofS
        String[] pofs2 = pofs.toArray(); //Array of values from PofS.
        for(String element : w2) {
            int n = h.get(element); //gets the key from HM h.
            String part = element.pOfS(); //gets the part of speech the element is from the pOfS method
            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM
            
        }
        ArrayList<Word> nouns = new ArrayList<Word>();
        ArrayList<Word> prestenseVerb = new ArrayList<Word>();
        ArrayList<Word> properNoun = new ArrayList<Word>();
        ArrayList<Word> adj = new ArrayList<Word>();
        ArrayList<String> negNews = new ArrayList<String>();
        ArrayList<String> posNews = new ArrayList<String>();
        ArrayList<Word> pasttenVerb = new ArrayList<Word>();
        ArrayList<Word> other = new ArrayList<W>();
        for(int i = 0; i < w2.length; i++){
            String w3 = w2[i]; //gets the keys
            String pofs3 = pofs2[i]; //gets the values from PofS.
            int v3 = v2[i];
            if(pofs3.equals("NN") || pofs3.equals("NNS")){
                Word x = new Word(w3, pofs3, v3);
                nouns.add(x);
            }
            else if(pofs3.equals("VB") || pofs3.equals("VBP") || pofs3.equals("VBZ")){
                Word x = new Word(w3, pofs3, v3);
                prestenseVerb.add(x);
            }
            else if(pofs3.equals("NNP") || pofs3.equals("NNPS")){
                Word x = new Word(w3, pofs3, v3);
                properNoun.add(x);
            }
            else if(pofs3.equals("JJ") || pofs3.equals("JJR")){
                Word x= new Word(w3, pofs3, v3);
                adj.add(x);
            }
            else if(pofs3.equals("VBD") || pofs3.equals("VBN")){
                Word x = new Word(w3, pofs3, v3);
                pasttenVerb.add(x);
            }
        }
        Collection.sort(nouns, prestenseVerb, properNoun, adj, pasttenVerb);
        Word[] finals = {nouns[0], prestenseVerb[0], properNoun[0], adj[0], pasttenVerb[0]};
        return finals;
        //To find the type of article.
        //for(int i = 0; i < paragraph.length(); i++){
        //    if()
        //}
        posNews.add("Fox News");
        posNews.add("Breitbart News");
        negNews.add("CNN");
        negNews.add("Huffington Post");
    }
}
        /*int max = h.get(w[0]);
        int current = h.get(w[0]);
        for(String m : w){
            current = h.get(m);
            if(current > max){
                max = current;
            }
        }*/
