package com.logikas.samples.errai.client.place.configure;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.logikas.samples.errai.client.place.LoginPlace;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author cristian
 */
public class AppPlaceHistoryMapper implements PlaceHistoryMapper {

    @Deprecated
    String delimiter = "/";
    private final List<TypedPlaceTokenizer<?>> tokenizers = new ArrayList<TypedPlaceTokenizer<?>>();

    @PostConstruct
    public void init() {
        //Add Tokenizer instances
        tokenizers.add(new LoginPlace.Tokenizer());
    }

    @Override
    public Place getPlace(String token) {
        Place result = null;
        //Solo si el delimitador es / en lugar de :
        token = token.replaceFirst("[^/]+://[^/]+/", "");
        //String contextPath = HistoryStateImpl.getContextPath();

        //if (token.startsWith(contextPath)) {
        //    token = token.substring(contextPath.length());
        //}

        for (PlaceTokenizer<?> t : tokenizers) {
            result = t.getPlace(token);
            if (result != null) {
                break;
            }
        }

        if (result == null) {
            throw new RuntimeException("Could not map token [" + token + "] to Place");
        }

        System.out.println("Mapped token [" + token + "] to place [" + result + "]");
        return result;
    }

    @Override
    public String getToken(Place place) {
        String result = null;

        for (TypedPlaceTokenizer t : tokenizers) {
            if (t.getPlaceType().getName().equals(place.getClass().getName())) {
                result = t.getToken(place);
            }
        }

        if (result == null) {
            throw new RuntimeException("Failed to get token from Place [" + place.getClass() + "]");
        }

        return result;
    }
}
