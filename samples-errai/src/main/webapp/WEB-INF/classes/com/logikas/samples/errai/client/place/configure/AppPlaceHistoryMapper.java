package com.logikas.samples.errai.client.place.configure;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.logikas.samples.errai.client.place.LoginPlace;

/**
 *
 * @author cristian
 */
@WithTokenizers({
    LoginPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
