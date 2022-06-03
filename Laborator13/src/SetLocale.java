import java.util.Locale;

public class SetLocale {
    public SetLocale(String localeString){
        boolean localeFound=false;
        for(Locale locale: FindAll.getAvailableLocales())
            if(locale.getDisplayLanguage().concat("-").concat(locale.getDisplayCountry()).equals(localeString)){
                Locale.setDefault(locale);
                localeFound=true;
                break;
            }
        if(!localeFound)
            System.out.println("Invalid locale.");

        //System.out.println("New default locale:" + Locale.getDefault().toString());
    }
}
