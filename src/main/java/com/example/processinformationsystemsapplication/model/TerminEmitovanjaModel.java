package com.example.processinformationsystemsapplication.model;

import java.sql.Date;
import java.sql.Time;

public record TerminEmitovanjaModel(Time vrijemePocetka, Time vrijemeZavrsetka, Date datumEmitovanja, String idEpizode) {
}
