package ultilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/*Essa classe serve para formatar um valor numérico do tipo Double como uma representação
de moeda em real brasileiro (R$)*/

public class Utils {
    static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString( Double valor ) {
        return formatandoValores.format(valor);
    }
}
