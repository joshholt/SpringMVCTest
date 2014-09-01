package hello.services;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joshholt on 8/30/14.
 */
public class PhraseBuilderService {

    private Map<String,String> templates;

    public String buildPhrase(String id, Object... args) {
        return MessageFormat.format(templates.get(id), args);
    }

    @PostConstruct
    public void init() {
        templates = new HashMap<String, String>();
        templates.put("hello", "Hello, {0}!");
    }
}
