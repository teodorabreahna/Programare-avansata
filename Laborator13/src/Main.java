import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws IOException {
        String language;
        String country;
        Locale locale;
        ResourceBundle messages;

        if (args.length != 2) {
            language = "en";
            country = "US";
        } else {
            language = args[0];
            country = args[1];
        }

        locale = new Locale(language, country);
        messages = ResourceBundle.getBundle("res/Messages", locale);

        while(true){
            System.out.print(messages.getString("prompt")+" ");
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String input= reader.readLine();
            int spaceIndex=input.indexOf(" ");
            String command;
            if(spaceIndex>0)
                command=input.substring(0,spaceIndex);
            else
                command=input;
            switch (command) {
                case "seeLocales" -> {
                    System.out.println(messages.getString("locales"));
                    new FindAll();
                }
                case "setLocale" -> {
                    String localaNoua;
                    if(spaceIndex>0)
                        localaNoua = input.substring(spaceIndex+1);
                    else
                        break;
                    new SetLocale(localaNoua);
                    locale=new Locale(Locale.getDefault().getLanguage(),Locale.getDefault().getCountry());
                    messages = ResourceBundle.getBundle("res/Messages", locale);
                    System.out.println(MessageFormat.format(messages.getString("locale.set"),locale));
                }
                case "info" ->{
                    Info about;
                    if(spaceIndex<=0)
                        about=new Info(messages);
                    else
                        about=new Info(messages,input.substring(spaceIndex+1));
                }
                default -> System.out.println(messages.getString("invalid"));
            }
        }
    }
}
