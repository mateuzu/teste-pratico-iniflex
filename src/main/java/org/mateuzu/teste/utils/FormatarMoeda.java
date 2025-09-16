package org.mateuzu.teste.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatarMoeda {

    public static String formatarMoedaBr(BigDecimal valor){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(valor);
    }
}
