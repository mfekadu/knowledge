package hello;


import java.util.*;

import com.babelscape.util.POS;
import com.babelscape.util.UniversalPOS;
import com.google.common.collect.Multimap;

import it.uniroma1.lcl.babelnet.*;
import it.uniroma1.lcl.babelnet.data.BabelCategory;
import it.uniroma1.lcl.babelnet.data.BabelGloss;
import it.uniroma1.lcl.babelnet.data.BabelImage;
import it.uniroma1.lcl.babelnet.data.BabelSenseSource;
import it.uniroma1.lcl.jlt.util.Language;
import it.uniroma1.lcl.jlt.util.ScoredItem;
import it.uniroma1.lcl.kb.SynsetType;


public class SynsetService {

    static void bankTest() {
        BabelNet bn = BabelNet.getInstance();
        String word = "bank";
        System.out.println("SYNSETS WITH English word: \""+word+"\"");
        List<BabelSynset> synsets = bn.getSynsets(word, Language.EN);
        Collections.sort(synsets, new BabelSynsetComparator(word));
        for (BabelSynset synset : synsets)
        {
            System.out.print("  =>(" + synset.getID() +
                    "; TYPE: " + synset.getType() +
                    "; WN SYNSET: " + synset.getWordNetOffsets() + ";\n" +
                    "  MAIN LEMMA: " + synset.getMainSense(Language.EN) +
                    ";\n  IMAGES: " + synset.getImages() +
                    ";\n  CATEGORIES: " + synset.getCategories() +
                    ";\n  SENSES (Italian): { ");
            for (BabelSense sense : synset.getSenses(Language.IT))
                System.out.print(sense.toString()+" "+sense.getPronunciations()+" ");
            System.out.println("}\n  -----");
        }
    }

    // package-private function because it doesnt say "private"
    // thus accessible via other classes in "package hello"
    public static void simpleTest() {
        BabelNet bn = BabelNet.getInstance();
        System.out.println("=== DEMO ===");
        BabelSynset synset = bn.getSynset(new BabelSynsetID("bn:03083790n"));
        System.out.println("Welcome on "+synset.getMainSense(Language.EN).get().getFullLemma().replace("_", " "));
        System.out.println(synset.getMainGloss(Language.EN).get().getGloss());
    }

    public static void main(String[] args) {
        System.out.println("Hello from SynsetService.java!");
    }

    public List<Synset> findByWord(String word) {
        BabelNet bn = BabelNet.getInstance();
        System.out.println("SYNSETS WITH English word: \""+word+"\"");
        List<BabelSynset> synsets = bn.getSynsets(word, Language.EN);
        Collections.sort(synsets, new BabelSynsetComparator(word));
        ArrayList<Synset> mySynsetList = new ArrayList<Synset>();

        for (BabelSynset synset : synsets) {
            BabelSynsetID synsetID = synset.getID();
            POS pos = synset.getPOS();
            List<BabelSenseSource> senseSources = synset.getSenseSources();
            SynsetType synsetType = synset.getType();
            List<WordNetSynsetID> synsetWordNetOffsets = synset.getWordNetOffsets();
            Optional<BabelSense> synsetMainLemma = synset.getMainSense(Language.EN);
            List<BabelImage> synsetImages = synset.getImages();
            List<BabelCategory> synsetCategories = synset.getCategories();
            mySynsetList.add(new Synset(synsetID.toString(),pos.toString(), senseSources.toString()));
            System.out.print("  =>(" + synsetID +
                    "; TYPE: " + synsetType +
                    "; WN SYNSET: " + synsetWordNetOffsets + ";\n" +
                    "  MAIN LEMMA: " + synsetMainLemma +
                    ";\n  IMAGES: " + synsetImages +
                    ";\n  CATEGORIES: " + synsetCategories);
            System.out.println("}\n  -----");
        }
        return mySynsetList;
    }

    public Synset findById(String s) {
        BabelNet bn = BabelNet.getInstance();
        BabelSynset synset = bn.getSynset(new BabelSynsetID(s));
        return new Synset(synset.getID().toString(),
                synset.getPOS().toString(),
                synset.getSenseSources().toString());
    }
}
