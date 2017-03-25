{"changed":true,"filter":false,"title":"TweetTweet.java","tooltip":"/TweetTweet.java","value":"//Imports for the word categorisation.\nimport java.util.HashMap;\nimport java.util.Map;\nimport java.util.Scanner;\n\nimport java.io.BufferedReader;\n//import java.io.FileReader;\nimport java.util.List;\nimport java.util.HashMap;\n\nimport edu.stanford.nlp.ling.SentenceUtils;\nimport edu.stanford.nlp.ling.TaggedWord;\nimport edu.stanford.nlp.ling.HasWord;\nimport edu.stanford.nlp.tagger.maxent.MaxentTagger;\nimport java.io.StringReader;\n\nimport java.util.Collection;\nimport java.util.Set;\n\n/**\n * Creates a new class called TweetTweet.\n*/\npublic class TweetTweet\n{\n    private String link; //declares instance variables\n    private String paragraph;\n    \n    public TweetTweet(String l) //Constructor for TweetTweet\n    {\n        paragraph = l;\n    }\n    \n    /*public String websiteToText()\n    {\n        ReadFromURLExample site = new ReadFromURLExample(link);\n        paragraph = site.text();\n    }*/\n    /**\n     * Creates a Set with a list of all the words in the article.\n     * @param inputs the article to be analysed\n     */\n    public HashMap<String, Integer> wordLocator() {\n        Scanner in = new Scanner(System.in);\n        paragraph = in.nextLine();        \n        HashMap<String, Integer> wordsValues = new HashMap<>();\n        //somehow get the link to be converted into the paragraph text\n        int length = paragraph.length();\n        String word = \"\";\n        int location = 0;\n        while(location < length + 1) {\n        for(int i = 0; i < length-1; i++){\n            char character = paragraph.charAt(i);\n            if(Character.isAlphabetic(character)) {\n                for(int k = 0; k < paragraph.length() - i; k++){\n                    char char2 = paragraph.charAt(k + i);\n                    if(Character.isAlphabetic(char2) == false) {\n                        word = paragraph.substring(i, k);\n                        location = k;\n                        i = k;\n                    }\n                }\n            }\n            if(wordsValues.containsKey(word) == false) {\n             wordsValues.put(word, 1);\n            }\n            else {\n             wordsValues.put(word, wordsValues.get(word) + 1);\n            }\n        }\n        }\n        return wordsValues;\n    }\n    \n    public HashMap<String, String> pOfS() \n    {\n        HashMap<String, String> h = new HashMap<>();\n        MaxentTagger tagger = new MaxentTagger(\"english-left3words-distsim.tagger\");//model fie from their models\n        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));\n        for (List<HasWord> sentence : sentences) {\n            List<TaggedWord> tSentence = tagger.tagSentence(sentence);\n            for(TaggedWord t: tSentence )\n            {\n                 h.put(t.toString(), t.tag());\n            }\n        }\n        return h;\n    }\n    \n    /*public Word[] words(HashMap h, HashMap z)\n    {\n        \n    }*/\n    \n    public Word[] conversion(HashMap h)\n    {\n        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.\n        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.\n        Integer[] v2 = v.toArray(new Integer[0]); //creates an array w/ values from v.\n        String[] w2 = w.toArray(new String[0]); //creates an array from set w.\n        //int[] vals = new Array[s.size()]; creates an array w/ sizes \n        //Set<String> partOfSpeechWord = new Set[paragraph.length()];\n        HashMap<String, String> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pofS\n        Collection<String> pofs = wordSpeech.values(); //Collection of values from PofS\n        String[] pofs2 = pofs.toArray(new String[0]); //Array of values from PofS.\n        for(String element : w2) {\n            Integer n = h.get(element); //gets the key from HM h.\n            String part = element.pOfS(); //gets the part of speech the element is from the pOfS method\n            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM\n            \n        }\n        ArrayList<Word> nouns = new ArrayList<Word>();\n        ArrayList<Word> prestenseVerb = new ArrayList<Word>();\n        ArrayList<Word> properNoun = new ArrayList<Word>();\n        ArrayList<Word> adj = new ArrayList<Word>();\n        ArrayList<String> negNews = new ArrayList<String>();\n        ArrayList<String> posNews = new ArrayList<String>();\n        ArrayList<Word> pasttenVerb = new ArrayList<Word>();\n        ArrayList<Word> other = new ArrayList<W>();\n        for(int i = 0; i < w2.length; i++){\n            String w3 = w2[i]; //gets the keys\n            String pofs3 = pofs2[i]; //gets the values from PofS.\n            int v3 = v2[i];\n            if(pofs3.equals(\"NN\") || pofs3.equals(\"NNS\")){\n                Word x = new Word(w3, pofs3, v3);\n                nouns.add(x);\n            }\n            else if(pofs3.equals(\"VB\") || pofs3.equals(\"VBP\") || pofs3.equals(\"VBZ\")){\n                Word x = new Word(w3, pofs3, v3);\n                prestenseVerb.add(x);\n            }\n            else if(pofs3.equals(\"NNP\") || pofs3.equals(\"NNPS\")){\n                Word x = new Word(w3, pofs3, v3);\n                properNoun.add(x);\n            }\n            else if(pofs3.equals(\"JJ\") || pofs3.equals(\"JJR\")){\n                Word x= new Word(w3, pofs3, v3);\n                adj.add(x);\n            }\n            else if(pofs3.equals(\"VBD\") || pofs3.equals(\"VBN\")){\n                Word x = new Word(w3, pofs3, v3);\n                pasttenVerb.add(x);\n            }\n        }\n        Collection.sort(nouns, prestenseVerb, properNoun, adj, pasttenVerb);\n        Word[]  finals = {nouns[0], nouns[1], prestenseVerb[0], properNoun[0], adj[0], pasttenVerb[0]};\n        return finals;\n        //To find the type of article.\n        //for(int i = 0; i < paragraph.length(); i++){\n        //    if()\n        //}\n        posNews.add(\"Fox News\");\n        posNews.add(\"Breitbart News\");\n        negNews.add(\"CNN\");\n        negNews.add(\"Huffington Post\");\n        \n        /*int max = h.get(w[0]);\n        int current = h.get(w[0]);\n        for(String m : w){\n            current = h.get(m);\n            if(current > max){\n                max = current;\n            }\n        }*/\n    \n}\n}\n","undoManager":{"mark":-2,"position":54,"stack":[[{"start":{"row":0,"column":0},"end":{"row":115,"column":0},"action":"remove","lines":["//Imports for the word categorisation.","import cue.language-master;","import java.util.HashMap;","import java.util.Map;","import java.util.Scanner;","","public class TweetTweet","{","    private String link;","    private String paragraph;","    ","    public TweetTweet(String l)","    {","        link = l;","    }","    public String websiteToText()","    {","        ReadFromURLExample site = new ReadFromURLExample(l);","        paragraph = site.plainText(site.text());","    }*/","    ","    /**","     * Creates a Set with a list of all the words in the article.","     * @param inputs the article to be analysed","     */","    public HashMap<String, Integer> wordLocator() {","        Scanner in = new Scanner(System.in);","        paragraph = in.nextLine();        ","        HashMap<String, Integer> wordsValues = new HashMap<>();","        //somehow get the link to be converted into the paragraph text","        int length = paragraph.length();","        String word = \"\";","        int location = 0;","        while(location < length + 1) {","        for(int i = 0; i < length-1; i++){","            char character = paragraph.charAt(i);","            if(Character.isAlphabetic(character)) {","                for(int k = 0; k < paragraph.length() - i; k++){","                    char char2 = paragraph.charAt(k + i);","                    if(Character.isAlphabetic(char2) == false) {","                        word = paragraph.substring(i, k);","                        location = k;","                        i = k;","                    }","                }","            }","            if(wordsValues.containsKey(word) == false) {","             wordsValues.put(word, 1);","            }","            else {","             wordsValues.put(word, wordsValues.get(word) + 1);","            }","        }","        }","        return wordsValues;","    }","    ","    ","    public Word[] conversion(HashMap h)","    {","        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.","        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.","        int[] v2 = v.toArray(); //creates an array w/ values from v.","        String[] w2 = w.toArray(); //creates an array from set w.","        //int[] vals = new Array[s.size()]; creates an array w/ sizes ","        //Set<String> partOfSpeechWord = new Set[paragraph.length()];","        HashMap<String, Integer> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pOfS","        for(String element : w2) {","            int n = h.get(element); //gets the key from HM h.","            String part = element.pOfS(); //gets the part of speech the element is from the pOfS method","            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM","            ","        }","        int max = h.get(w[0]);","        int current = h.get(w[0]);","        for(String m : w){ //part 2a.","            current = h.get(m);","            if(current > max){","                max = current;","                v2[i+1] = v2[i];","            }","        }","        /*","        1. Convert both maps --> sets --> Arrays *DONE","                a. Take the values array and find the top 5-6 values.","                b. Figure out which value index matches with which word in the Array.","                c. Match with the word and the pOfS.","        2. Run an enhanced for loop on both (simultaneously) and get the times and pOfS.","        3. Put each triplet into Word Object --> how can we store multiple? We can't create new","           Word objects for every specific word.","        */","    }","    public String pOfS()","    {","        MaxentTagger tagger = new MaxentTagger(\"wsj-0-18-bidirectional-distsim.tagger.props\");//model fie from their models","        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));","        for (List<HasWord> sentence : sentences) {","        List<TaggedWord> tSentence = tagger.tagSentence(sentence);","        System.out.println(SentenceUtils.listToString(tSentence, false)); //part of Stanford package","        TaggedWord t = tSentence.get(0);","        /*System.out.println(t.toString());","        System.out.println(t.tag());","        Get the API methods.","        */","    }","","}","/*","1. URL -> paragraphs 50%","2. paragraphs ->  words and their count 100%","3. key words anad their count -> WORD:xkey words,(their parts of speech, times used) ","4. MadLibs + Word -> TWEET","5. TWEET + Template -> FInal","6. Get rid of articles and extraneous words.","*/",""],"id":3478},{"start":{"row":0,"column":0},"end":{"row":117,"column":0},"action":"insert","lines":["//Imports for the word categorisation.","import java.util.HashMap;","import java.util.Map;","import java.util.Scanner;","","import java.io.BufferedReader;","//import java.io.FileReader;","import java.util.List;","import java.util.HashMap;","","import edu.stanford.nlp.ling.SentenceUtils;","import edu.stanford.nlp.ling.TaggedWord;","import edu.stanford.nlp.ling.HasWord;","import edu.stanford.nlp.tagger.maxent.MaxentTagger;","import java.io.StringReader;","","","public class TweetTweet","{","    private String link;","    private String paragraph;","    ","    public TweetTweet(String l)","    {","        link = l;","    }","    ","    public String websiteToText()","    {","        ReadFromURLExample site = new ReadFromURLExample(link);","        paragraph = site.plainText(site.text());","    }","    ","    /**","     * Creates a Set with a list of all the words in the article.","     * @param inputs the article to be analysed","     */","    public HashMap<String, Integer> wordLocator() {","        Scanner in = new Scanner(System.in);","        paragraph = in.nextLine();        ","        HashMap<String, Integer> wordsValues = new HashMap<>();","        //somehow get the link to be converted into the paragraph text","        int length = paragraph.length();","        String word = \"\";","        int location = 0;","        while(location < length + 1) {","        for(int i = 0; i < length-1; i++){","            char character = paragraph.charAt(i);","            if(Character.isAlphabetic(character)) {","                for(int k = 0; k < paragraph.length() - i; k++){","                    char char2 = paragraph.charAt(k + i);","                    if(Character.isAlphabetic(char2) == false) {","                        word = paragraph.substring(i, k);","                        location = k;","                        i = k;","                    }","                }","            }","            if(wordsValues.containsKey(word) == false) {","             wordsValues.put(word, 1);","            }","            else {","             wordsValues.put(word, wordsValues.get(word) + 1);","            }","        }","        }","        return wordsValues;","    }","    ","    public HashMap<String, String> pOfSp() ","    {","        HashMap<String, String> h = new HashMap<>();","        MaxentTagger tagger = new MaxentTagger(\"english-left3words-distsim.tagger\");//model fie from their models","        List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(paragraph)));","        for (List<HasWord> sentence : sentences) {","            List<TaggedWord> tSentence = tagger.tagSentence(sentence);","            for(TaggedWord t: tSentence )","            {","                 h.put(t, t.tag());","            }","        }","        return h;","    }","    ","    public Word[] words(HashMap h, HashMap z)","    {","        ","    }","    ","    /*public Word[] conversion(HashMap h)","    {","        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.","        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.","        int[] v2 = v.toArray(); //creates an array w/ values from v.","        String[] w2 = w.toArray(); //creates an array from set w.","        //int[] vals = new Array[s.size()]; creates an array w/ sizes ","        //Set<String> partOfSpeechWord = new Set[paragraph.length()];","        HashMap<String, Integer> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pOfS","        for(String element : w2) {","            int n = h.get(element); //gets the key from HM h.","            String part = element.pOfS(); //gets the part of speech the element is from the pOfS method","            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM","            ","        }","        int max = h.get(w[0]);","        int current = h.get(w[0]);","        for(String m : w){ //part 2a.","            current = h.get(m);","            if(current > max){","                max = current;","                v2[i+1] = v2[i];ew","            }","        }*/","    ","}","","}",""]}],[{"start":{"row":116,"column":1},"end":{"row":117,"column":0},"action":"remove","lines":["",""],"id":3479}],[{"start":{"row":116,"column":0},"end":{"row":116,"column":1},"action":"remove","lines":["}"],"id":3480}],[{"start":{"row":115,"column":0},"end":{"row":116,"column":0},"action":"remove","lines":["",""],"id":3481}],[{"start":{"row":89,"column":4},"end":{"row":89,"column":6},"action":"remove","lines":["/*"],"id":3482,"ignore":true}],[{"start":{"row":89,"column":4},"end":{"row":89,"column":5},"action":"insert","lines":["/"],"id":3483,"ignore":true}],[{"start":{"row":89,"column":5},"end":{"row":89,"column":6},"action":"insert","lines":["*"],"id":3484,"ignore":true}],[{"start":{"row":89,"column":4},"end":{"row":89,"column":6},"action":"remove","lines":["/*"],"id":3485,"ignore":true}],[{"start":{"row":97,"column":26},"end":{"row":97,"column":30},"action":"remove","lines":["tege"],"id":3486,"ignore":true}],[{"start":{"row":97,"column":24},"end":{"row":97,"column":26},"action":"remove","lines":["In"],"id":3487,"ignore":true}],[{"start":{"row":97,"column":24},"end":{"row":97,"column":25},"action":"remove","lines":["r"],"id":3488,"ignore":true}],[{"start":{"row":97,"column":24},"end":{"row":97,"column":25},"action":"insert","lines":["S"],"id":3489,"ignore":true}],[{"start":{"row":97,"column":25},"end":{"row":97,"column":26},"action":"insert","lines":["t"],"id":3490,"ignore":true}],[{"start":{"row":97,"column":26},"end":{"row":97,"column":30},"action":"insert","lines":["ring"],"id":3491,"ignore":true}],[{"start":{"row":14,"column":28},"end":{"row":16,"column":0},"action":"insert","lines":["","",""],"id":3492,"ignore":true}],[{"start":{"row":16,"column":0},"end":{"row":16,"column":11},"action":"insert","lines":["import java"],"id":3493,"ignore":true}],[{"start":{"row":16,"column":11},"end":{"row":16,"column":19},"action":"insert","lines":[".util.Co"],"id":3494,"ignore":true}],[{"start":{"row":16,"column":17},"end":{"row":16,"column":19},"action":"remove","lines":["Co"],"id":3495,"ignore":true},{"start":{"row":16,"column":17},"end":{"row":16,"column":28},"action":"insert","lines":["Collection;"]}],[{"start":{"row":71,"column":39},"end":{"row":71,"column":40},"action":"remove","lines":["p"],"id":3496,"ignore":true}],[{"start":{"row":91,"column":4},"end":{"row":116,"column":1},"action":"remove","lines":["public Word[] conversion(HashMap h)","    {","        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.","        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.","        int[] v2 = v.toArray(); //creates an array w/ values from v.","        String[] w2 = w.toArray(); //creates an array from set w.","        //int[] vals = new Array[s.size()]; creates an array w/ sizes ","        //Set<String> partOfSpeechWord = new Set[paragraph.length()];","        HashMap<String, String> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pOfS","        for(String element : w2) {","            int n = h.get(element); //gets the key from HM h.","            String part = element.pOfS(); //gets the part of speech the element is from the pOfS method","            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM","            ","        }","        int max = h.get(w[0]);","        int current = h.get(w[0]);","        for(String m : w){ //part 2a.","            current = h.get(m);","            if(current > max){","                max = current;","                v2[i+1] = v2[i];ew","            }","        }*/","    ","}"],"id":3497,"ignore":true},{"start":{"row":91,"column":4},"end":{"row":163,"column":0},"action":"insert","lines":["public Word[] conversion(HashMap h)","    {","        Set<String> w = h.keySet(); //creates a set from keys in HashMap h.","        Collection<Integer> v = h.values(); //creates a collection from values in HashMap h.","        int[] v2 = v.toArray(); //creates an array w/ values from v.","        String[] w2 = w.toArray(); //creates an array from set w.","        //int[] vals = new Array[s.size()]; creates an array w/ sizes ","        //Set<String> partOfSpeechWord = new Set[paragraph.length()];","        HashMap<String, String> wordSpeech = new HashMap<>(); //creates a HashMap mapping word w/ pofS","        Collection<String> pofs = wordSpeech.values(); //Collection of values from PofS","        String[] pofs2 = pofs.toArray(); //Array of values from PofS.","        for(String element : w2) {","            int n = h.get(element); //gets the key from HM h.","            String part = element.pOfS(); //gets the part of speech the element is from the pOfS method","            wordSpeech.put(n, part); //maps the word w/ its pOfS into wordSpeech HM","            ","        }","        ArrayList<Word> nouns = new ArrayList<String>();","        ArrayList<Word> prestenseVerb = new ArrayList<String>();","        ArrayList<Word> properNoun = new ArrayList<String>();","        ArrayList<Word> adj = new ArrayList<String>();","        ArrayList<String> negNews = new ArrayList<String>();","        ArrayList<String> posNews = new ArrayList<String>();","        ArrayList<Word> pasttenVerb = new ArrayList<String>();","        ArrayList<Word> other = new ArrayList<String>();","        for(int i = 0; i < w2.length; i++){","            String w3 = w2[i]; //gets the keys","            String pofs3 = pofs2[i]; //gets the values from PofS.","            int v3 = v2[i];","            if(pofs3 = \"NN\" || pofs3 = \"NNS\"){","                Word x = new Word(w3, pofs3, v3);","                nouns.add(x);","            }","            else if(pofs3 = \"VB\" || pofs3 = \"VBP\" || pofs3 = \"VBZ\"){","                Word x = new Word(w3, pofs3, v3);","                prestenseVerb.add(x);","            }","            else if(pofs3 = \"NNP\" || pofs3 = \"NNPS\"){","                Word x = new Word(w3, pofs3, v3);","                properNoun.add(x);","            }","            else if(pofs3 = \"JJ\" || pofs3 = \"JJR\"){","                Word x= new Word(w3, pofs3, v3);","                adj.add(x);","            }","            else if(pofs3 = \"VBD\" || pofs3 = \"VBN\"){","                Word x = new Word(w3, pofs3, v3);","                pasttenVerb.add(x);","            }","        }","        Collection.sort(nouns, prestenseVerb, properNoun, adj, pasttenVerb);","        Word[] finals = {nouns[0], prestenseVerb[0], properNoun[0], adj[0], pasttenVerb[0]}","        return finals;","        //To find the type of article.","        for(int i = 0; i < paragraph.length(); i++){","            if()","        }","        posNews.add(\"Fox News\");","        posNews.add(\"Breitbart News\");","        negNews.add(\"CNN\");","        negNews.add(\"Huffington Post\");","        ","        /*int max = h.get(w[0]);","        int current = h.get(w[0]);","        for(String m : w){","            current = h.get(m);","            if(current > max){","                max = current;","            }","        }","    ","}",""]}],[{"start":{"row":142,"column":91},"end":{"row":142,"column":92},"action":"insert","lines":[";"],"id":3498,"ignore":true}],[{"start":{"row":145,"column":8},"end":{"row":145,"column":10},"action":"insert","lines":["//"],"id":3499,"ignore":true},{"start":{"row":146,"column":8},"end":{"row":146,"column":10},"action":"insert","lines":["//"]}],[{"start":{"row":147,"column":8},"end":{"row":147,"column":10},"action":"insert","lines":["//"],"id":3500,"ignore":true}],[{"start":{"row":162,"column":1},"end":{"row":163,"column":1},"action":"insert","lines":["","}"],"id":3501,"ignore":true}],[{"start":{"row":162,"column":1},"end":{"row":163,"column":1},"action":"remove","lines":["","}"],"id":3502,"ignore":true}],[{"start":{"row":160,"column":9},"end":{"row":160,"column":11},"action":"insert","lines":["*/"],"id":3503,"ignore":true}],[{"start":{"row":86,"column":4},"end":{"row":86,"column":6},"action":"insert","lines":["/*"],"id":3504,"ignore":true},{"start":{"row":89,"column":5},"end":{"row":89,"column":7},"action":"insert","lines":["*/"]}],[{"start":{"row":162,"column":1},"end":{"row":163,"column":0},"action":"insert","lines":["",""],"id":3505,"ignore":true}],[{"start":{"row":163,"column":0},"end":{"row":163,"column":1},"action":"insert","lines":["}"],"id":3506,"ignore":true}],[{"start":{"row":162,"column":1},"end":{"row":163,"column":1},"action":"remove","lines":["","}"],"id":3507,"ignore":true}],[{"start":{"row":18,"column":0},"end":{"row":19,"column":12},"action":"insert","lines":["/**"," * Creates a"],"id":3508,"ignore":true}],[{"start":{"row":19,"column":12},"end":{"row":20,"column":4},"action":"insert","lines":[" new class called TweetTweet."," * /"],"id":3509,"ignore":true}],[{"start":{"row":20,"column":0},"end":{"row":20,"column":4},"action":"remove","lines":[" * /"],"id":3510,"ignore":true},{"start":{"row":20,"column":0},"end":{"row":20,"column":2},"action":"insert","lines":["*/"]}],[{"start":{"row":23,"column":24},"end":{"row":23,"column":33},"action":"insert","lines":[" //declar"],"id":3511,"ignore":true}],[{"start":{"row":23,"column":33},"end":{"row":23,"column":54},"action":"insert","lines":["es instance variables"],"id":3512,"ignore":true}],[{"start":{"row":26,"column":31},"end":{"row":26,"column":47},"action":"insert","lines":[" //Constructor f"],"id":3513,"ignore":true}],[{"start":{"row":26,"column":47},"end":{"row":26,"column":60},"action":"insert","lines":["or TweetTweet"],"id":3514,"ignore":true}],[{"start":{"row":165,"column":0},"end":{"row":165,"column":1},"action":"insert","lines":["}"],"id":3515,"ignore":true}],[{"start":{"row":110,"column":46},"end":{"row":110,"column":52},"action":"remove","lines":["String"],"id":3516,"ignore":true},{"start":{"row":110,"column":46},"end":{"row":110,"column":50},"action":"insert","lines":["Word"]},{"start":{"row":111,"column":54},"end":{"row":111,"column":60},"action":"remove","lines":["String"]},{"start":{"row":111,"column":54},"end":{"row":111,"column":58},"action":"insert","lines":["Word"]},{"start":{"row":112,"column":51},"end":{"row":112,"column":57},"action":"remove","lines":["String"]},{"start":{"row":112,"column":51},"end":{"row":112,"column":55},"action":"insert","lines":["Word"]},{"start":{"row":113,"column":44},"end":{"row":113,"column":50},"action":"remove","lines":["String"]},{"start":{"row":113,"column":44},"end":{"row":113,"column":48},"action":"insert","lines":["Word"]}],[{"start":{"row":114,"column":50},"end":{"row":114,"column":56},"action":"remove","lines":["String"],"id":3517,"ignore":true},{"start":{"row":114,"column":50},"end":{"row":114,"column":54},"action":"insert","lines":["Word"]},{"start":{"row":115,"column":50},"end":{"row":115,"column":56},"action":"remove","lines":["String"]},{"start":{"row":115,"column":50},"end":{"row":115,"column":54},"action":"insert","lines":["Word"]},{"start":{"row":116,"column":52},"end":{"row":116,"column":58},"action":"remove","lines":["String"]},{"start":{"row":116,"column":52},"end":{"row":116,"column":53},"action":"insert","lines":["W"]}],[{"start":{"row":114,"column":50},"end":{"row":114,"column":54},"action":"remove","lines":["Word"],"id":3518,"ignore":true},{"start":{"row":114,"column":50},"end":{"row":114,"column":56},"action":"insert","lines":["String"]},{"start":{"row":115,"column":50},"end":{"row":115,"column":54},"action":"remove","lines":["Word"]},{"start":{"row":115,"column":50},"end":{"row":115,"column":51},"action":"insert","lines":["S"]},{"start":{"row":116,"column":52},"end":{"row":116,"column":53},"action":"remove","lines":["W"]},{"start":{"row":116,"column":52},"end":{"row":116,"column":56},"action":"insert","lines":["Word"]},{"start":{"row":117,"column":46},"end":{"row":117,"column":52},"action":"remove","lines":["String"]},{"start":{"row":117,"column":46},"end":{"row":117,"column":47},"action":"insert","lines":["W"]}],[{"start":{"row":115,"column":50},"end":{"row":115,"column":51},"action":"remove","lines":["S"],"id":3519,"ignore":true},{"start":{"row":115,"column":50},"end":{"row":115,"column":56},"action":"insert","lines":["String"]}],[{"start":{"row":122,"column":20},"end":{"row":122,"column":22},"action":"remove","lines":[" ="],"id":3520,"ignore":true},{"start":{"row":122,"column":20},"end":{"row":122,"column":29},"action":"insert","lines":[".equals()"]}],[{"start":{"row":122,"column":28},"end":{"row":122,"column":30},"action":"remove","lines":[") "],"id":3521,"ignore":true},{"start":{"row":122,"column":32},"end":{"row":122,"column":33},"action":"insert","lines":[")"]}],[{"start":{"row":122,"column":42},"end":{"row":122,"column":45},"action":"remove","lines":[" = "],"id":3522,"ignore":true},{"start":{"row":122,"column":42},"end":{"row":122,"column":50},"action":"insert","lines":[".equals("]}],[{"start":{"row":122,"column":55},"end":{"row":122,"column":56},"action":"insert","lines":[")"],"id":3523,"ignore":true}],[{"start":{"row":126,"column":25},"end":{"row":126,"column":28},"action":"remove","lines":[" = "],"id":3524,"ignore":true},{"start":{"row":126,"column":25},"end":{"row":126,"column":33},"action":"insert","lines":[".equals("]}],[{"start":{"row":126,"column":37},"end":{"row":126,"column":38},"action":"insert","lines":[")"],"id":3525,"ignore":true},{"start":{"row":126,"column":47},"end":{"row":126,"column":50},"action":"remove","lines":[" = "]},{"start":{"row":126,"column":47},"end":{"row":126,"column":55},"action":"insert","lines":[".equals("]},{"start":{"row":126,"column":60},"end":{"row":126,"column":61},"action":"insert","lines":[")"]}],[{"start":{"row":126,"column":70},"end":{"row":126,"column":73},"action":"remove","lines":[" = "],"id":3526,"ignore":true},{"start":{"row":126,"column":70},"end":{"row":126,"column":78},"action":"insert","lines":[".equals("]},{"start":{"row":126,"column":83},"end":{"row":126,"column":84},"action":"insert","lines":[")"]}],[{"start":{"row":130,"column":25},"end":{"row":130,"column":28},"action":"remove","lines":[" = "],"id":3527,"ignore":true},{"start":{"row":130,"column":25},"end":{"row":130,"column":33},"action":"insert","lines":[".equals("]},{"start":{"row":130,"column":38},"end":{"row":130,"column":39},"action":"insert","lines":[")"]}],[{"start":{"row":130,"column":48},"end":{"row":130,"column":51},"action":"remove","lines":[" = "],"id":3528,"ignore":true},{"start":{"row":130,"column":48},"end":{"row":130,"column":56},"action":"insert","lines":[".equals("]},{"start":{"row":130,"column":62},"end":{"row":130,"column":63},"action":"insert","lines":[")"]},{"start":{"row":134,"column":25},"end":{"row":134,"column":28},"action":"remove","lines":[" = "]},{"start":{"row":134,"column":25},"end":{"row":134,"column":33},"action":"insert","lines":[".equals("]}],[{"start":{"row":134,"column":37},"end":{"row":134,"column":38},"action":"insert","lines":[")"],"id":3529,"ignore":true},{"start":{"row":134,"column":47},"end":{"row":134,"column":50},"action":"remove","lines":[" = "]},{"start":{"row":134,"column":47},"end":{"row":134,"column":55},"action":"insert","lines":[".equals("]}],[{"start":{"row":134,"column":61},"end":{"row":134,"column":62},"action":"insert","lines":[")"],"id":3530,"ignore":true},{"start":{"row":138,"column":25},"end":{"row":138,"column":28},"action":"remove","lines":[" = "]},{"start":{"row":138,"column":25},"end":{"row":138,"column":33},"action":"insert","lines":[".equals("]},{"start":{"row":138,"column":38},"end":{"row":138,"column":39},"action":"insert","lines":[")"]}],[{"start":{"row":138,"column":48},"end":{"row":138,"column":51},"action":"remove","lines":[" = "],"id":3531,"ignore":true},{"start":{"row":138,"column":48},"end":{"row":138,"column":56},"action":"insert","lines":[".equals("]},{"start":{"row":138,"column":62},"end":{"row":138,"column":63},"action":"insert","lines":[")"]}],[{"start":{"row":144,"column":15},"end":{"row":144,"column":16},"action":"insert","lines":[" "],"id":3532}]]},"ace":{"folds":[],"scrolltop":1297.833445072174,"scrollleft":0,"selection":{"start":{"row":157,"column":26},"end":{"row":157,"column":26},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":{"row":80,"state":"start","mode":"ace/mode/java"}},"timestamp":1487522999174}