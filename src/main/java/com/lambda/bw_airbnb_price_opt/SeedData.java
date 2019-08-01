package com.lambda.bw_airbnb_price_opt;

// Vivek Vishwanath

import com.lambda.bw_airbnb_price_opt.model.*;
import com.lambda.bw_airbnb_price_opt.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{

    RoleRepository rolerepos;
    UserRepository userrepos;
    NeighbourHoodRepository neighbourHoodRepository;
    NeighbourHoodGroupRepository neighbourHoodGroupRepository;
    ListingRepository listingRepository;
    RoomTypeRepository roomTypeRepository;
    PropertyTypeRepository propertyTypeRepository;
    CancellationPolicyRepository cancellationPolicyRepository;
    BedTypeRepository bedTypeRepository;

    public SeedData(
            RoleRepository rolerepos,
            UserRepository userrepos,
            NeighbourHoodRepository neighbourHoodRepository,
            NeighbourHoodGroupRepository neighbourHoodGroupRepository,
            ListingRepository listingRepository,
            RoomTypeRepository roomTypeRepository,
            PropertyTypeRepository propertyTypeRepository,
            CancellationPolicyRepository cancellationPolicyRepository,
            BedTypeRepository bedTypeRepository
    )
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.neighbourHoodRepository = neighbourHoodRepository;
        this.neighbourHoodGroupRepository = neighbourHoodGroupRepository;
        this.listingRepository = listingRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.propertyTypeRepository = propertyTypeRepository;
        this.cancellationPolicyRepository = cancellationPolicyRepository;
        this.bedTypeRepository = bedTypeRepository;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        rolerepos.save(r1);
        rolerepos.save(r2);

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u1 = new User("barnbarn", "ILuvM4th!", users, false);
//        u1.getQuotes().add(new Quote("Live long and prosper", u1));
//        u1.getQuotes().add(new Quote("The enemy of my enemy is the enemy I kill last", u1));
//        u1.getQuotes().add(new Quote("Beam me up", u1));
        userrepos.save(u1);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        User u2 = new User("admin", "password", admins, true);
//        u2.getQuotes().add(new Quote("A creative man is motivated by the desire to achieve, not by the desire to beat others", u2));
//        u2.getQuotes().add(new Quote("The question isn't who is going to let me; it's who is going to stop me.", u2));
        userrepos.save(u2);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("Bob", "password", users, true);
        userrepos.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Jane", "password", users, false);
        userrepos.save(u4);

//        NeighbourHood n1 = new NeighbourHood("NeighbourHood 1");
//        n1.getNeighbourHoodGroupList().add(new NeighbourHoodGroup("NeighbourHood Group 1",n1));
//        neighbourHoodRepository.save(n1);

        PropertyType p1 = new PropertyType("Guesthouse");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("Condominium");

        RoomType room1 = new RoomType("Entire home/apt");
        RoomType room2 = new RoomType("Private room");
        RoomType room3 = new RoomType("Shared room");

        CancellationPolicy c1 = new CancellationPolicy("strict_14_with_grace_period");
        CancellationPolicy c2 = new CancellationPolicy("flexible");
        CancellationPolicy c3 = new CancellationPolicy("moderate");

        BedType b1 = new BedType("Real Bed");
        BedType b2 = new BedType("Pull-out Sofa");
        BedType b3 = new BedType("Couch");
        BedType b4 = new BedType("Futon");
        BedType b5 = new BedType("Airbed");

        bedTypeRepository.save(b1);
        bedTypeRepository.save(b2);
        bedTypeRepository.save(b3);
        bedTypeRepository.save(b4);
        bedTypeRepository.save(b5);

        propertyTypeRepository.save(p1);
        propertyTypeRepository.save(p2);
        propertyTypeRepository.save(p3);

        roomTypeRepository.save(room1);
        roomTypeRepository.save(room2);
        roomTypeRepository.save(room3);

        cancellationPolicyRepository.save(c1);
        cancellationPolicyRepository.save(c2);
        cancellationPolicyRepository.save(c3);

        ArrayList<NeighbourHoodGroup> neighbourHoodGroups = new ArrayList<>();
        neighbourHoodGroups.add(new NeighbourHoodGroup("Charlottenburg-Wilm."));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Friedrichshain-Kreuzberg"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Lichtenberg"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Marzahn - Hellersdorf"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Mitte"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("NeukÃ¶lln"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Pankow"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Reinickendorf"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Spandau"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Steglitz - Zehlendorf"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Tempelhof - SchÃ¶neberg"));
        neighbourHoodGroups.add(new NeighbourHoodGroup("Treptow - KÃ¶penick"));

        for(int i = 0; i < neighbourHoodGroups.size(); i++){
            neighbourHoodGroupRepository.save(neighbourHoodGroups.get(i));
        }

        ArrayList<NeighbourHood> neighbourHoods = new ArrayList<>();

        neighbourHoods.add(new NeighbourHood("BarstraÃŸe", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Charlottenburg Nord", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("DÃ¼sseldorfer StraÃŸe", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Forst Grunewald", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Grunewald", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Halensee", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Heerstrasse", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("KantstraÃŸe", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("KurfÃ¼rstendamm", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Mierendorffplatz", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Neue KantstraÃŸe", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Otto-Suhr-Allee", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("SchloÃŸ Charlottenburg", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Schmargendorf", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Volkspark Wilmersdorf", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Westend", neighbourHoodGroups.get(0)));
        neighbourHoods.add(new NeighbourHood("Wiesbadener StraÃŸe", neighbourHoodGroups.get(0)));


        neighbourHoods.add(new NeighbourHood("Frankfurter Allee Nord", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("Frankfurter Allee SÃ¼d FK", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("Karl-Marx-Allee-Nord", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("Karl-Marx-Allee-SÃ¼d", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("nÃ¶rdliche Luisenstadt", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("SÃ¼dliche Friedrichstadt", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("sÃ¼dliche Luisenstadt", neighbourHoodGroups.get(1)));
        neighbourHoods.add(new NeighbourHood("Tempelhofer Vorstadt", neighbourHoodGroups.get(1)));

        neighbourHoods.add(new NeighbourHood("Alt-HohenschÃ¶nhausen Nord", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Alt-HohenschÃ¶nhausen SÃ¼d", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Alt-Lichtenberg", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Fennpfuhl", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Frankfurter Allee SÃ¼d", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Friedrichsfelde Nord", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Friedrichsfelde SÃ¼d", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Karlshorst", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Malchow, Wartenberg und Falkenberg", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Neu-HohenschÃ¶nhausen Nord", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Neu-HohenschÃ¶nhausen SÃ¼d", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Neu Lichtenberg", neighbourHoodGroups.get(2)));
        neighbourHoods.add(new NeighbourHood("Rummelsburger Bucht", neighbourHoodGroups.get(2)));

        neighbourHoods.add(new NeighbourHood("Biesdorf", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Hellersdorf-Nord", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Hellersdorf-Ost", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Hellersdorf-SÃ¼d", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Kaulsdorf", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Mahlsdorf", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Marzahn-Mitte", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Marzahn-Nord", neighbourHoodGroups.get(3)));
        neighbourHoods.add(new NeighbourHood("Marzahn-SÃ¼d", neighbourHoodGroups.get(3)));

        neighbourHoods.add(new NeighbourHood("Alexanderplatz", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Brunnenstr. Nord", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Brunnenstr. SÃ¼d", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Moabit Ost", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Moabit West", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Osloer StraÃŸe", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Parkviertel", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Regierungsviertel", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Tiergarten SÃ¼d", neighbourHoodGroups.get(4)));
        neighbourHoods.add(new NeighbourHood("Wedding Zentrum", neighbourHoodGroups.get(4)));


        neighbourHoods.add(new NeighbourHood("Britz", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("Buckow", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("Buckow Nord", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("Gropiusstadt", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("KÃ¶llnische Heide", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("NeukÃ¶llner Mitte/Zentrum", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("ReuterstraÃŸe", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("Rixdorf", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("Rudow", neighbourHoodGroups.get(5)));
        neighbourHoods.add(new NeighbourHood("Schillerpromenade", neighbourHoodGroups.get(5)));


        neighbourHoods.add(new NeighbourHood("Blankenburg/Heinersdorf/MÃ¤rchenland", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Blankenfelde/NiederschÃ¶nhausen", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Buch", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Buchholz", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Helmholtzplatz", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Karow", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Pankow SÃ¼d", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Pankow Zentrum", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Prenzlauer Berg Nord", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Prenzlauer Berg Nordwest", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Prenzlauer Berg Ost", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Prenzlauer Berg SÃ¼d", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("Prenzlauer Berg SÃ¼dwest", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("SchÃ¶nholz/Wilhelmsruh/Rosenthal", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("WeiÃŸensee", neighbourHoodGroups.get(6)));
        neighbourHoods.add(new NeighbourHood("WeiÃŸensee Ost", neighbourHoodGroups.get(6)));

        neighbourHoods.add(new NeighbourHood("MV 1", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("MV 2", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("Nord 1", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("Nord 2", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("Ost 1", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("Ost 2", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("West 1", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("West 2", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("West 3", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("West 4", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("West 5", neighbourHoodGroups.get(7)));
        neighbourHoods.add(new NeighbourHood("BrunsbÃ¼tteler Damm", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Falkenhagener Feld", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Gatow / Kladow", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Hakenfelde", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Haselhorst", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("HeerstraÃŸe Nord", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Siemensstadt", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Spandau Mitte", neighbourHoodGroups.get(8)));
        neighbourHoods.add(new NeighbourHood("Wilhelmstadt", neighbourHoodGroups.get(8)));

        neighbourHoods.add(new NeighbourHood("Albrechtstr.", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("Drakestr.", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("Lankwitz", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("OstpreuÃŸendamm", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("SchloÃŸstr.", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("Teltower Damm", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("Zehlendorf  Nord", neighbourHoodGroups.get(9)));
        neighbourHoods.add(new NeighbourHood("Zehlendorf  SÃ¼dwest", neighbourHoodGroups.get(9)));


        neighbourHoods.add(new NeighbourHood("Friedenau", neighbourHoodGroups.get(10)));
        neighbourHoods.add(new NeighbourHood("Lichtenrade", neighbourHoodGroups.get(10)));
        neighbourHoods.add(new NeighbourHood("Mariendorf", neighbourHoodGroups.get(10)));
        neighbourHoods.add(new NeighbourHood("Marienfelde", neighbourHoodGroups.get(10)));
        neighbourHoods.add(new NeighbourHood("SchÃ¶neberg-Nord", neighbourHoodGroups.get(10)));
        neighbourHoods.add(new NeighbourHood("SchÃ¶neberg-SÃ¼d", neighbourHoodGroups.get(10)));
        neighbourHoods.add(new NeighbourHood("Tempelhof", neighbourHoodGroups.get(10)));


        neighbourHoods.add(new NeighbourHood("Adlershof", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Allende-Viertel", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Altglienicke", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Altstadt-Kietz", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Alt  Treptow", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Baumschulenweg", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Bohnsdorf", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Dammvorstadt", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Friedrichshagen", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("GrÃ¼nau", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Johannisthal", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("KÃ¶lln. Vorstadt/Spindlersf.", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("KÃ¶penick-Nord", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("KÃ¶penick-SÃ¼d", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("MÃ¼ggelheim", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("NiederschÃ¶neweide", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("OberschÃ¶neweide", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("PlÃ¤nterwald", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("Rahnsdorf/Hessenwinkel", neighbourHoodGroups.get(11)));
        neighbourHoods.add(new NeighbourHood("SchmÃ¶ckwitz/Karolinenhof/Rauchfangswerder", neighbourHoodGroups.get(11)));

        for(int i = 0; i < neighbourHoods.size(); i++){
            if(i == 0)
            {
                neighbourHoods.get(i).getListings().add(new Listing(
                        "First listing",
                        12.02310231,
                        -123.21321,
                        3, 4,
                        3,
                        1,
                        1,200.00,30.00,
                        1,28.00,true,
                        neighbourHoods.get(i),p2,room1,c1, b1, 23));
                neighbourHoodRepository.save(neighbourHoods.get(i));
            } else {
                neighbourHoodRepository.save(neighbourHoods.get(i));
            }
        }

//        Book book1 = new Book("Book Test 1","ASDN213A",2019);
//        Book book2 = new Book("Book Test 2","NSIW1922",2019);
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//
//        List<Wrote> booksWrote = new ArrayList<>();
//        booksWrote = new ArrayList<>();
//        booksWrote.add(new Wrote(new Author(), book1));
//        Author author1 = new Author("Author lastname", "Author firstname");
//        author1.getBooksWrote().add(new Wrote(author1, book1));
//        authorRepository.save(author1);

//        Book book1 = new Book("Book 1", "1231dasdaB", 2019);
//        book1.setAuthor(author1);
//        bookRepository.save(book1);
    }
}