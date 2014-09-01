package hello.services;

import hello.interfaces.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joshholt on 8/30/14.
 */
public class GreeterService implements IGreetingService {

    @Autowired
    PhraseBuilderService phraseBuilder;

    @Override
    public String greet(String message) {
        return phraseBuilder.buildPhrase("hello", message);
    }
}
