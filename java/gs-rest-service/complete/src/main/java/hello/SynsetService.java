package hello;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.babelscape.util.UniversalPOS;
import com.google.common.collect.Multimap;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelNetUtils;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSenseComparator;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetComparator;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.babelnet.BabelSynsetRelation;
import it.uniroma1.lcl.babelnet.InvalidSynsetIDException;
import it.uniroma1.lcl.babelnet.data.BabelGloss;
import it.uniroma1.lcl.babelnet.data.BabelImage;
import it.uniroma1.lcl.babelnet.data.BabelSenseSource;
import it.uniroma1.lcl.jlt.util.Language;
import it.uniroma1.lcl.jlt.util.ScoredItem;


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
    static void simpleTest() {
        BabelNet bn = BabelNet.getInstance();
        System.out.println("=== DEMO ===");
        BabelSynset synset = bn.getSynset(new BabelSynsetID("bn:03083790n"));
        System.out.println("Welcome on "+synset.getMainSense(Language.EN).get().getFullLemma().replace("_", " "));
        System.out.println(synset.getMainGloss(Language.EN).get().getGloss());
    }

    public static void main(String[] args) {
        simpleTest();
        bankTest();
    }
}
