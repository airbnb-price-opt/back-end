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

        NeighbourHoodGroup ng1 = new NeighbourHoodGroup("Group 1");
        NeighbourHood n1 = new NeighbourHood("Neighbourhood 1", ng1);

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

        ng1.getNeighbourHoods().add(n1);
        n1.getListings().add(new Listing(
                "First listing",
                12.02310231,
                -123.21321,
                3, 4,
                3,
                1,1,
                60.00,200.00,30.00,
                1,28.00,true,
                n1,p2,room1,c1, b1));
        neighbourHoodGroupRepository.save(ng1);
        NeighbourHoodGroup ng2 = new NeighbourHoodGroup("Group 2");
        neighbourHoodGroupRepository.save(ng2);



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