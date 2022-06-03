import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{
            Database.createConnection();
            Connection con = Database.getConnection();
            System.out.println(con);
            var continents = new ContinentDAO();
            System.out.println(continents.findByName("Europe"));


            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            /*
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
             */
            System.out.println(countries.findByContinent("Europe"));

            var cities = new CityDAO();
            cities.create(countries.findByName("Romania"),"Onesti",0, (float) 12.653, (float) 21.653);


        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
