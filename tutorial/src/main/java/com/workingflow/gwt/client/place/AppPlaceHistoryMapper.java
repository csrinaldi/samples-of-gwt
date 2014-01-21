/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Documentación de {@link AppPlaceHistoryMapper}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
@WithTokenizers ( {
    HomePlace.Tokenizer.class} )
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
