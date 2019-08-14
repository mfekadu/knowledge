package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SynsetController {
    @GetMapping(value = "/sysnet/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Synset findById(@PathVariable( "id" ) String id) {
        return new Synset(id, id, id);
    }
}
