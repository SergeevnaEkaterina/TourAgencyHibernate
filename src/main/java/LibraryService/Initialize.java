package LibraryService;

import java.util.Arrays;
import java.util.List;

public class Initialize {
    public void init(){
        PersonHelper ph = new PersonHelper();
        List<Person> persons = Arrays.asList(new Person("Igor","Galaktionov",12345)
                ,new Person("Nailya","Zagrutdinova",5624),
                new Person("Sergey","Antsiferov",888888),
                new Person("Mikhail","Shomov",348962));

        for(Person p:persons){
            ph.addPerson(p);
        }



        TripHelper th = new TripHelper();

        List<Way> trips = Arrays.asList(new Way(1,2,"Venice",1500),
                new Way(2,3,"Russia",3000),
                new Way(3,2,"England",2000),
                new Way(4,4,"Greenland",500),
                new Way(5,5,"Krasnoyarsk",500000),
                new Way(6,3,"Germany",4500));
        for(Way w:trips){
            th.addTrip(w);
        }

    }
}
