package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SynsetController {
    @GetMapping(value = "/synset/id:{id}")
    @ResponseStatus(HttpStatus.OK)
    public Synset findById(@PathVariable( "id" ) String id) {
        final SynsetService synsetService = new SynsetService();
        Synset s = synsetService.findById("bn:03083790n");
        return s;
    }

//    class SynsetWordResponse {
//        private final String word;
//        private final String message;
//    }

    @GetMapping(value = "/synset/word:{word}")
    @ResponseStatus(HttpStatus.OK)
    public List<Synset> findByWord(@PathVariable( "word" ) String word) {
        final SynsetService synsetService = new SynsetService();
        return synsetService.findByWord(word);
    }
}
