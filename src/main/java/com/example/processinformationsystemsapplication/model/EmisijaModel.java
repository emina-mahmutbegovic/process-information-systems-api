package com.example.processinformationsystemsapplication.model;

import java.util.Set;

public record EmisijaModel(String nazivEmisije, String opisEmisije, int ocjenaEmisije, int trajanjeEmisije,
                           String idVrsteEmisije, String idVoditelja, String idUrednika, Set<String> idGostiju) {
}
