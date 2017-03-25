import edu.stanford.nlp.util.logging.Redwood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.StringReader;

public class TaggerDemo  {

  /** A logger for this class */
  private static Redwood.RedwoodChannels log = Redwood.channels(TaggerDemo.class);

   private TaggerDemo() {}

  public static void main(String[] args) throws Exception {
    /*if (args.length != 2) {
      log.info("usage: java TaggerDemo modelFile fileToTag");
      return;
    }*/
    MaxentTagger tagger = new MaxentTagger("wsj-0-18-bidirectional-distsim.tagger.props");//model fie from their models
    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader("Hello, from the outside I must of called a thousand times to tell you I am sorry for breaking your heart but you call me up and say I will never be part, so hello fom hte outside")));
    for (List<HasWord> sentence : sentences) {
      List<TaggedWord> tSentence = tagger.tagSentence(sentence);
      System.out.println(SentenceUtils.listToString(tSentence, false)); //part of Stanford package
      TaggedWord t = tSentence.get(0);
      /*System.out.println(t.toString());
      System.out.println(t.tag());
      Get the API methods.
      */
    }
  }
}
