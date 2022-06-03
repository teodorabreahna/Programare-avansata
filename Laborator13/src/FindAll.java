import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FindAll {

    private final static List<Locale> available= Arrays.stream(Locale.getAvailableLocales()).collect(Collectors.toList());
    public FindAll(){
        for (Locale locale : available)
            if(!locale.getLanguage().isEmpty() && !locale.getCountry().isEmpty()){
                System.out.print(locale.getDisplayLanguage()+"-"+locale.getDisplayCountry() + "\n");
            }
        System.out.println();
    }
    public static List<Locale> getAvailableLocales() {
        return available;
    }
}
