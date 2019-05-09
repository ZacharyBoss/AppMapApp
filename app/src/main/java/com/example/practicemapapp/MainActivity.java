package com.example.practicemapapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;

// MainActivity is responsible for creating the map of app state's campus,
// adding the markers, and navigation. All Map Activity.
public class MainActivity extends Activity {

    static MapView map;
    IMapController mapController;
    LocationManager locationManager;
    Button navigateButton;

    // MARKERS
    static ArrayList<Marker> markers;
    static ArrayList<GeoPoint> geopoints;

    // Activity centers, food, and larger buildings
    Marker currMarker;
    Marker srcMarker;
    Marker walkerMarker;
    Marker broyhillEventMarker;
    Marker broyhillMusicMarker;
    Marker schaeferMarker;
    Marker stadiumMarker;
    Marker trivetteMarker;
    Marker athleticsCenterMarker;
    Marker quinnMarker;
    Marker parkingDeckMarker;
    Marker jetMarker;
    Marker convoMarker;
    Marker chancellorsHouseMarker;
    Marker estesHouseMarker;
    Marker turchinMarker;
    Marker valborgTheaterMarker;
    Marker libraryMarker;
    Marker doughertyMarker;
    Marker sanfordMallMarker;
    Marker roessMarker;
    Marker varsityMarker;
    Marker tennisMarker;
    Marker bbDoughertyMarker;
    Marker igGreerMarker;
    Marker mailMarker;
    Marker healthServicesMarker;
    Marker studentUnionMarker;
    Marker bookstoreMarker;
    Marker foundersMarker;
    Marker alumniMarker;
    Marker legendsMarker;
    Marker softballStadiumMarker;
    Marker sofieldIndoorMarker;
    Marker baseballStadiumMarker;
    // School building halls
    Marker weyMarker;
    Marker garwoodMarker;
    Marker katharpMarker;
    Marker peacockMarker;
    Marker chapelWilsonMarker;
    Marker edwinDuncanMarker;
    Marker rankinWestMarker;
    Marker rankinNorthMarker;
    Marker smithWrightMarker;
    Marker doughertyHallMarker;
    Marker anneBelkMarker;
    Marker educationMarker;
    Marker sanfordMarker;
    // Dorms
    Marker belkMarker;
    Marker frankMarker;
    Marker eggersMarker;
    Marker bowieMarker;
    Marker gardnerMarker;
    Marker coltraneMarker;
    Marker justiceMarker;
    Marker newlandMarker;
    Marker llcMarker;
    Marker appHeightsMarker;
    Marker mountaineerMarker;
    Marker summitMarker;
    Marker coneMarker;
    Marker appalachianMarker;
    Marker lovillMarker;
    Marker whiteMarker;
    Marker eastMarker;
    Marker doughtonMarker;
    Marker hoeyMarker;
    Marker cannonMarker;
    // Parking Lots & Decks
    Marker stadiumLotMarker;
    Marker hillStreetLotMarker;
    Marker holmesLotMarker;
    Marker appHeightsLotMarker;
    Marker greenwoodLotMarker;
    Marker peacockLotMarker;
    Marker collegeStreetDeckMarker;
    Marker admissionsLotMarker;
    Marker southLotMarker;

    // GEOPOINTS
    // Activity centers, food, and larger buildings
    GeoPoint currGeoPoint;
    GeoPoint srcGeoPoint;
    GeoPoint broyhillEventGeoPoint;
    GeoPoint broyhillMusicGeoPoint;
    GeoPoint schaeferGeoPoint;
    GeoPoint stadiumGeoPoint;
    GeoPoint trivetteGeoPoint;
    GeoPoint athleticsCenterGeoPoint;
    GeoPoint quinnGeoPoint;
    GeoPoint parkingDeckGeoPoint;
    GeoPoint jetGeoPoint;
    GeoPoint convoGeoPoint;
    GeoPoint chancellorsHouseGeoPoint;
    GeoPoint estesHouseGeoPoint;
    GeoPoint turchinGeoPoint;
    GeoPoint valborgTheaterGeoPoint;
    GeoPoint libraryGeoPoint;
    GeoPoint doughertyGeoPoint;
    GeoPoint sanfordMallGeoPoint;
    GeoPoint roessGeoPoint;
    GeoPoint varsityGeoPoint;
    GeoPoint tennisGeoPoint;
    GeoPoint bbDoughertyGeoPoint;
    GeoPoint igGreerGeoPoint;
    GeoPoint mailGeoPoint;
    GeoPoint healthServicesGeoPoint;
    GeoPoint studentUnionGeoPoint;
    GeoPoint bookstoreGeoPoint;
    GeoPoint foundersGeoPoint;
    GeoPoint alumniGeoPoint;
    GeoPoint legendsGeoPoint;
    GeoPoint softballStadiumGeoPoint;
    GeoPoint sofieldIndoorGeoPoint;
    GeoPoint baseballStadiumGeoPoint;
    // School building halls
    GeoPoint weyGeoPoint;
    GeoPoint garwoodGeoPoint;
    GeoPoint katharpGeoPoint;
    GeoPoint peacockGeoPoint;
    GeoPoint chapelWilsonGeoPoint;
    GeoPoint edwinDuncanGeoPoint;
    GeoPoint rankinWestGeoPoint;
    GeoPoint rankinNorthGeoPoint;
    GeoPoint smithWrightGeoPoint;
    GeoPoint doughertyHallGeoPoint;
    GeoPoint anneBelkGeoPoint;
    GeoPoint educationGeoPoint;
    GeoPoint sanfordGeoPoint;
    GeoPoint walkerGeoPoint;
    // Dorms
    GeoPoint belkGeoPoint;
    GeoPoint frankGeoPoint;
    GeoPoint eggersGeoPoint;
    GeoPoint bowieGeoPoint;
    GeoPoint gardnerGeoPoint;
    GeoPoint coltraneGeoPoint;
    GeoPoint justiceGeoPoint;
    GeoPoint newlandGeoPoint;
    GeoPoint llcGeoPoint;
    GeoPoint appHeightsGeoPoint;
    GeoPoint mountaineerGeoPoint;
    GeoPoint summitGeoPoint;
    GeoPoint coneGeoPoint;
    GeoPoint appalachianGeoPoint;
    GeoPoint lovillGeoPoint;
    GeoPoint whiteGeoPoint;
    GeoPoint eastGeoPoint;
    GeoPoint doughtonGeoPoint;
    GeoPoint hoeyGeoPoint;
    GeoPoint cannonGeoPoint;
    // Parking Lots & Decks
    GeoPoint stadiumLotGeoPoint;
    GeoPoint hillStreetLotGeoPoint;
    GeoPoint holmesLotGeoPoint;
    GeoPoint appHeightsLotGeoPoint;
    GeoPoint greenwoodLotGeoPoint;
    GeoPoint peacockLotGeoPoint;
    GeoPoint collegeStreetDeckGeoPoint;
    GeoPoint admissionsLotGeoPoint;
    GeoPoint southLotGeoPoint;

    static boolean isRouting = false;
    private GeoPoint startGP;
    private GeoPoint destGP;
    private Marker startM;
    private Marker destM;
    private static Road road;

    //Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // IMPORTANT: handle permissions before map is created.
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_main);


        // OSM Map Initialize
        // important! set your user agent to prevent getting banned from the osm servers
        //Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(17);
        GeoPoint startPoint = new GeoPoint(36.214201, -81.679850);
        mapController.setCenter(startPoint);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        setMarkers();

        if (isRouting)
        {
            setNavigation();
        }

        navigateButton = findViewById(R.id.navigate);
        navigateButton.bringToFront();
        navigateButton.invalidate();
        navigateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent viewNavigation = new Intent(MainActivity.this, Navigation.class);
                startActivity(viewNavigation);
            }
        });

        final Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent back;
                if(isRouting)
                {
                    back = new Intent(MainActivity.this, MainActivity.class);
                    turnDirectionsOff();
                    startActivity(back);
                }
                else
                {
                    back = new Intent(MainActivity.this, Homepage.class);
                    startActivity(back);
                }
            }
        });
    }

    private void setMarkers()
    {
        createMarkerList();
        //SimplePointTheme pt = new SimplePointTheme(points, true);
        for (Marker m: markers) {
            m.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            map.getOverlays().add(m);
        }
    }

    private void setNavigation()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Bundle points = getIntent().getExtras();
        assert points != null;
        int start = points.getInt("start");
        int dest = points.getInt("dest");

        ArrayList<GeoPoint> geoList = getGeoPointsList();
        ArrayList<Marker> mList = getMarkerList();

        int index = 0;
        for(GeoPoint gp : geoList)
        {
            if(index == start)
            {
                Marker startTemp = mList.get(index);
                startGP = new GeoPoint(gp.getLatitude(), gp.getLongitude());
                startM = new Marker(map);
                startM.setTitle(startTemp.getTitle());
                startM.setPosition(startGP);
            }
            if(index == dest)
            {
                Marker destTemp = mList.get(index);
                destGP = new GeoPoint(gp.getLatitude(), gp.getLongitude());
                destM = new Marker(map);
                destM.setTitle(destTemp.getTitle());
                destM.setPosition(destGP);
            }
            index++;
        }
        startM.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startM);
        destM.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(destM);
        removeMarkers();

        RoadManager roadManager = new OSRMRoadManager(this);
        roadManager.addRequestOption("routeType=pedestrian");
        ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();
        waypoints.add(startGP);
        waypoints.add(destGP);

        road = roadManager.getRoad(waypoints);

        mapController.setCenter(startGP);
        new UpdateRoadTask().execute(waypoints);
    }

    /*
     * Private class needed for syncing up the overlays if in
     * navigation mode.
     */
    private static class UpdateRoadTask extends AsyncTask<Object, Void, Road>
    {

        protected Road doInBackground(Object... params) {
            @SuppressWarnings("unchecked")
            ArrayList<GeoPoint> waypoints = (ArrayList<GeoPoint>)params[0];
            RoadManager roadManager = new OSRMRoadManager(map.getContext());

            return roadManager.getRoad(waypoints);
        }
        @Override
        protected void onPostExecute(Road result) {
            road = result;

            Polyline roadOverlay = RoadManager.buildRoadOverlay(road);

            map.getOverlays().add(roadOverlay);
            map.invalidate();
        }
    }

    private void createMarkerList()
    {
        markers = new ArrayList<Marker>();
        geopoints = new ArrayList<GeoPoint>();

        //currMarker = createMarker(currMarker, currGeoPoint, lastLocation.getLatitude(), lastLocation.getLongitude(), "Current Location");
        srcMarker = createMarker(srcMarker, srcGeoPoint, 36.216649, -81.686158,
                "Student Recreation Center (SRC):\nFeatures include: \n" +
                        "    50 ft. climbing wall\n" +
                        "    Cardio theater\n" +
                        "    Weight room area\n" +
                        "    Indoor walking/running track\n" +
                        "    50 meter swimming pool\n" +
                        "    Freshens® Smoothie bar\n" +
                        "    UREC Central Offices\n" +
                        "    Outdoor Programs' Outing Center\n");
        broyhillMusicMarker = createMarker(broyhillMusicMarker, broyhillMusicGeoPoint, 36.215849,
                -81.684908,
                "Broyhill Music Center: \n" +
                        "The Broyhill Music Center includes two performance halls, a state of the art recording studio, an opera studio, a computer lab, a piano lab, a 5,000 square foot music library, an instrumental rehearsal hall, a choral rehearsal hall, small ensemble rehearsal rooms, more than 30 offices and over 50 practice rooms with pianos.");
        broyhillEventMarker = createMarker(broyhillEventMarker, broyhillEventGeoPoint, 36.21443,
                -81.69318,
                "Broyhill Event Center:");
        schaeferMarker = createMarker(schaeferMarker, schaeferGeoPoint, 36.215308, -81.683975,
                "Schaefer Center: The Schaefer Center for the Performing Arts is a 1,673-seat multi-use auditorium. The Center features orchestra and balcony level seating and a proscenium stage. The Schaefer Center is also home to the Smith Gallery." +
                        "The Schaefer Center for the Performing Arts is dedicated to enhancing the artistic and cultural landscape of Appalachian State University and the surrounding region by providing a venue devoted to the year-round presentation of campus and community events that enrich, educate, inspire, and promote quality of life.");
        stadiumMarker = createMarker(stadiumMarker, stadiumGeoPoint, 36.212222, -81.685648,
                "Kidd Brewer Stadium: Seats 35,000 people, is home to the App State football team, and is one of the most picturesque settings for college football with Appalachian State's beautiful, modern campus and the natural beauty of the High Country serving as a backdrop.");
        trivetteMarker = createMarker(trivetteMarker, trivetteGeoPoint, 36.213432, -81.683686,
                "Trivette Hall: Trivette Hall overlooks Appalachian's scenic duck pond and is home to Park Place at the Pond and McAlister's Select. The Market at Trivette is also located here. ");
        athleticsCenterMarker = createMarker(athleticsCenterMarker, athleticsCenterGeoPoint,
                36.211506, -81.686524,
                "Appalachian Athletics Center: The Appalachian Athletics Center opened in September 2009. The 120,000-square-foot building, located adjacent to Kidd Brewer Stadium, serves as the hub for Mountaineer athletics and its 20 varsity programs and provides ASU student-athletes and coaches the opportunity to excel on and off the field for decades to come. The Appalachian Athletics Center was the centerpiece of a $50 million athletics facilities enhancement that began in 2006. ");
        quinnMarker = createMarker(quinnMarker, quinnGeoPoint, 36.211736, -81.683685,
                "Dwight W. Quinn Recreation Center: The Dwight W. Quinn Recreation Center is located on Stadium Drive, across from Kidd Brewer Stadium. It was built in 1987 and is a 48,000 square-foot facility equipped with state-of-the-art fitness equipment.");
        parkingDeckMarker = createMarker(parkingDeckMarker, parkingDeckGeoPoint, 36.212142, -81.680524,
                "Rivers Street Parking Deck/University Police/Traffic & Parking Dept.: A place where visitor parking is offered, and is also the headquarters of the University Police and parking department.");
        jetMarker = createMarker(jetMarker, jetGeoPoint, 36.210996, -81.677734,
                "John E. Thomas Hall (JET): Contains the following \n" +
                        "Admissions\n" +
                        "Career Development Center\n" +
                        "Cashiers and Student Accounts\n" +
                        "Financial Aid\n" +
                        "Graduate School\n" +
                        "Office of the Registrar\n" +
                        "Office of Research\n" +
                        "Office of Testing Services\n" +
                        "Office of Transfer Services\n" +
                        "Office of University Scholarships\n" +
                        "Student Employment\n");
        convoMarker = createMarker(convoMarker, convoGeoPoint, 36.210743, -81.675851,
                "Holmes Convocation Center: The Holmes Center is the host for Concerts, University Events, Athletics, and Family Entertainment Shows. There are also various health classes held here.");
        chancellorsHouseMarker = createMarker(chancellorsHouseMarker, chancellorsHouseGeoPoint,
                36.213911, -81.688345,
                "Appalachian House and Chancellor's Residence");
        estesHouseMarker = createMarker(estesHouseMarker, estesHouseGeoPoint, 36.216885, -81.682889,
                "Estes House - Environmental Services");
        turchinMarker = createMarker(turchinMarker, turchinGeoPoint, 36.217015, -81.680703,
                "Turchin Center for the Visual Arts: The Turchin Center's ideal location on King Street—in the heart of downtown Boone, yet within the physical boundaries of the Appalachian State campus—places it at the crossroads between campus and community. The building was designed to visually and physically make the arts more accessible to the Appalachian community, and to serve as a gateway to the greater campus beyond the center.");
        valborgTheaterMarker = createMarker(valborgTheaterMarker, valborgTheaterGeoPoint, 36.216227,
                -81.681161,
                "Valborg Theater");
        libraryMarker = createMarker(libraryMarker, libraryGeoPoint, 36.21544, -81.68043,
                "Belk Library: Centrally located on campus in a beautifully-designed facility, Belk Library and Information Commons is a hub of activity, opening its doors to over a million visitors per year. The library shares its holdings with Western Carolina University and UNC Asheville and features a rich and unique collection, from rare artifacts of Appalachian history to state-of-the-art technology.");
        doughertyMarker = createMarker(doughertyMarker, doughertyGeoPoint, 36.21433, -81.67865,
                "Dougherty Building: Contains the following\n" +
                        "Academic Advising Center\n" +
                        "Archives and Records\n" +
                        "College Awareness Programs\n" +
                        "Department of Military Science and Leadership\n" +
                        "Learning Assistance Program\n" +
                        "Orientation\n");
        sanfordMallMarker = createMarker(sanfordMallMarker, sanfordMallGeoPoint, 36.21408, -81.67908,
                "Sanford Mall: a place in the middle of campus where students like to partake in various activities before, after, or in between classes. ");
        roessMarker = createMarker(roessMarker, roessGeoPoint, 36.21305, -81.67996,
                "Roess(Central) Dining Hall: The Central Dining Hall opened in January 2009. It was renamed the Roess Dining Hall in March 2014. This is the dining hall with chik-fil-a.");
        varsityMarker = createMarker(varsityMarker, varsityGeoPoint, 36.21341, -81.68081,
                "Varsity Gymnasium: Varsity Gymnasium, a cornerstone for generations of Appalachian students, for academics, athletics, and former host to graduations and commencements, is the current home to the Mountaineer wrestling program, and an alternate home for App Volleyball when the Holmes Center is in use. It is also often used by volleyball, men's and women's basketball and track and field as an alternate practice facility.");
        tennisMarker = createMarker(tennisMarker, tennisGeoPoint, 36.21216, -81.67811,
                "Bob Light Tennis Courts");
        bbDoughertyMarker = createMarker(bbDoughertyMarker, bbDoughertyGeoPoint, 36.21255, -81.67747,
                "BB Dougherty Administration Building: Contains the following\n " +
                        "Academic Affairs\n" +
                        "Business Affairs\n" +
                        "Design and Construction\n" +
                        "Institutional Research\n" +
                        "Office of the Chancellor\n" +
                        "Office of the Controller\n" +
                        "Student Development\n" +
                        "University Advancement");
        igGreerMarker = createMarker(igGreerMarker, igGreerGeoPoint, 36.21322, -81.67845,
                "IG Greer Hall: Contains the following,\n" +
                        " College of Arts and Sciences\n" +
                        "Department of Philosophy and Religion\n" +
                        "Equity Office\n" +
                        "IG Greer Theater\n" +
                        "Office of Student Success\n" +
                        "Research Institute for Environment, Energy and Economics (RIEEE)\n" +
                        "University Ombuds Office");
        mailMarker = createMarker(mailMarker, mailGeoPoint, 36.21532, -81.67897,
                "University Post Office");
        healthServicesMarker = createMarker(healthServicesMarker, healthServicesGeoPoint, 36.21549,
                -81.67891,
                "Student Health Services: The Mary S. Shook Student Health Service is a primary care ambulatory campus health clinic helping meet the needs of Appalachian State University students. Serving the student drives everything the Clinic does.\n" +
                        "\n" +
                        "    We are dedicated and experienced health care professionals\n" +
                        "    We provide accredited primary health care\n" +
                        "    We are a centrally located, accessible facility\n" +
                        "    We provide high-quality health care at low cost\n" +
                        "    We engage in ongoing collaboration with Academics and other Student Support Services throughout the university\n");
        studentUnionMarker = createMarker(studentUnionMarker, studentUnionGeoPoint, 36.21473,
                -81.67915,
                "Plemmons Student Union and Solarium: As the centerpiece of the Appalachian campus, the Plemmons Student Union facilitates the mission of the University by providing opportunities for students, faculty, and staff to participate in a variety of programs that enhance learning and foster an appreciation for college life and campus diversity. ");
        bookstoreMarker = createMarker(bookstoreMarker, bookstoreGeoPoint, 36.21500, -81.67960,
                "University Bookstore: The primary mission of the University Bookstore is to provide students and their families, faculty, staff, and alumni, with goods and services to support the educational goals of the institution. Additionally, the bookstore's purpose is to generate funds to support student scholarships. This is accomplished by offering a variety of products from socially and environmentally responsible sources. ");
        foundersMarker = createMarker(foundersMarker, foundersGeoPoint, 36.21289, -81.67682,
                "Founders Hall: Originally the Watauga County Hospital, Founders Hall today serves as an administrative support building on the Appalachian State University campus.");
        alumniMarker = createMarker(alumniMarker, alumniGeoPoint, 36.21053, -81.67420,
                "McKinney Alumni Center: The McKinney Alumni Center is the only building on campus funded entirely by private donations. Located across from the Holmes Convocation Center at 553 Blowing Rock Road, the 7,200-square-foot center serves the needs of more than 126,629 alumni. The Center is comprised of a large reception area, great room, and a multipurpose conference room. The offices of Alumni Affairs and the Appalachian Foundation are housed in the Center.");
        legendsMarker = createMarker(legendsMarker, legendsGeoPoint, 36.21538, -81.67541,
                "Legends: Legends is App State’s entertainment and social scene.  From bands to solo-artists to comedians, Legends is the place to experience great performances. ");
        softballStadiumMarker = createMarker(softballStadiumMarker, softballStadiumGeoPoint, 36.21278,
                -81.68758,
                "Softball @ Sywassink/Lloyd Family Stadium");
        sofieldIndoorMarker = createMarker(sofieldIndoorMarker, sofieldIndoorGeoPoint, 36.21222,
                -81.68726,
                "Sofield Family Indoor Practice Facility");
        baseballStadiumMarker = createMarker(baseballStadiumMarker, baseballStadiumGeoPoint, 36.21142,
                -81.69289,
                "Baseball Stadium (Jim and Bettie Smith Baseball Stadium)");
        weyMarker = createMarker(weyMarker, weyGeoPoint, 36.21461, -81.68412,
                "Wey Hall: Building for the Department of Art.");
        garwoodMarker = createMarker(garwoodMarker, garwoodGeoPoint, 36.21270, -81.68177,
                "Garwood Hall: Building for the Department of Chemistry and Physics.");
        katharpMarker = createMarker(katharpMarker, katharpGeoPoint, 36.21163, -81.67943,
                "Katherine Harper Hall - W. Kerr Scott Hall: Contains the following,\n" +
                        "Department of Sustainable Technology & the Built Environment\n" +
                        "Department of Art's: Commercial Photography, Graphic Arts Imaging Technology\n" +
                        "Department of Applied Design: Interior Design, Industrial Design\n");
        peacockMarker = createMarker(peacockMarker, peacockGeoPoint, 36.21634, -81.68232,
                "Peacock Hall: Building for the Department of Business.");
        chapelWilsonMarker = createMarker(chapelWilsonMarker, chapelWilsonGeoPoint, 36.21592,
                -81.68143,
                "Chapel Wilson Hall: Contains the following,\n " +
                        " Department of Sociology\n" +
                        "Department of Theatre and Dance");
        edwinDuncanMarker = createMarker(edwinDuncanMarker, edwinDuncanGeoPoint, 36.21482,
                -81.68208,
                "Edwin Duncan Hall: Contains the following, \n" +
                        " Department of Communication Sciences and Disorders\n" +
                        "College of Fine and Applied Arts\n" +
                        "Department of Nursing\n" +
                        "Department of Social Work");
        rankinWestMarker = createMarker(rankinWestMarker, rankinWestGeoPoint, 36.21398, -81.68162,
                "Rankin Science West: Subsection of Rankin Science, Contains the following,\n" +
                        "\n" +
                        "Department of Biology\n" +
                        "Department of Geography and Planning\n" +
                        "Department of Geology");
        rankinNorthMarker = createMarker(rankinNorthMarker, rankinNorthGeoPoint, 36.21413,
                -81.68124,
                "Rankin Science North: Subsection of Rankin Science, Contains the following,\n" +
                        "\n" +
                        "Department of Biology\n" +
                        "Department of Geography and Planning\n" +
                        "Department of Geology");
        smithWrightMarker = createMarker(smithWrightMarker, smithWrightGeoPoint, 36.21485,
                -81.68085,
                "Smith Wright Hall: Building for the Department of Psychology.");
        doughertyHallMarker = createMarker(doughertyHallMarker, doughertyHallGeoPoint, 36.21479,
                -81.68015,
                "DD Dougherty Hall: Contains the following, \n" +
                        " Academic Advising Center\n" +
                        "Archives and Records\n" +
                        "College Awareness Programs\n" +
                        "Department of Military Science and Leadership\n" +
                        "Learning Assistance Program\n" +
                        "Orientation");
        anneBelkMarker = createMarker(anneBelkMarker, anneBelkGeoPoint, 36.21423, -81.68045,
                "Anne Belk Hall: Contains the following, \n" +
                        "Department of Anthropology\n" +
                        "Department of Computer Sciences\n" +
                        "Department of Government and Justice Studies\n" +
                        "Department of History\n" +
                        "Educational Media Services\n" +
                        "Faculty and Academic Development\n" +
                        "General Education Program\n" +
                        "Office of Disability Services\n" +
                        "Technology Support Services\n" +
                        "University Communications\n" +
                        "Writing Across the Curriculum Program");
        educationMarker = createMarker(educationMarker, educationGeoPoint, 36.21605, -81.67915,
                "Reich College of Education: Contains the following, \n" +
                        " College of Education\n" +
                        "Department of Curriculum and Instruction\n" +
                        "Department of Family and Child Studies\n" +
                        "Department of Human Development and Psychological Counseling\n" +
                        "Department of Leadership and Educational Studies\n" +
                        "Department of Reading Education and Special Education");
        sanfordMarker = createMarker(sanfordMarker, sanfordGeoPoint, 36.21375, -81.67786,
                "Sanford Hall: Contains the following, \n" +
                        " Department of English\n" +
                        "Department of Foreign Languages and Literatures");

        belkMarker = createMarker(belkMarker, belkGeoPoint, 36.21457, -81.68519,
                "Belk Residence Hall");
        frankMarker = createMarker(frankMarker, frankGeoPoint, 36.21472, -81.68573,
                "Frank Residence Hall");
        eggersMarker = createMarker(eggersMarker, eggersGeoPoint, 36.21391, -81.68612,
                "Eggers Residence Hall");
        bowieMarker = createMarker(bowieMarker, bowieGeoPoint, 36.21349, -81.68620,
                "Bowie Residence Hall");
        gardnerMarker = createMarker(gardnerMarker, gardnerGeoPoint, 36.21254, -81.68399,
                "Gardner Residence Hall");
        coltraneMarker = createMarker(coltraneMarker, coltraneGeoPoint, 36.21247, -81.68347,
                "Coltrane Residence Hall");
        justiceMarker = createMarker(justiceMarker, justiceGeoPoint, 36.21285, -81.68288,
                "Justice Residence Hall");
        newlandMarker = createMarker(newlandMarker, newlandGeoPoint, 36.21404, -81.68387,
                "Newland Residence Hall");
        llcMarker = createMarker(llcMarker, llcGeoPoint, 36.21552, -81.68618, "Living Learning Center");
        appHeightsMarker = createMarker(appHeightsMarker, appHeightsGeoPoint, 36.21502, -81.68936,
                "Appalachian Heights Residence Hall");
        mountaineerMarker = createMarker(mountaineerMarker, mountaineerGeoPoint, 36.21649, -81.68918,
                "Mountaineer Residence Hall");
        summitMarker = createMarker(summitMarker, summitGeoPoint, 36.21441, -81.67782,
                "Summit Residence Hall");
        coneMarker = createMarker(coneMarker, coneGeoPoint, 36.21463, -81.67725,
                "Cone Residence Hall");
        appalachianMarker = createMarker(appalachianMarker, appalachianGeoPoint, 36.21419, -81.67734,
                "Appalachian Residence Hall");
        lovillMarker = createMarker(lovillMarker, lovillGeoPoint, 36.21399, -81.67657,
                "Lovill Residence Hall");
        whiteMarker = createMarker(whiteMarker, whiteGeoPoint, 36.21464, -81.67667,
                "White Residence Hall");
        eastMarker = createMarker(eastMarker, eastGeoPoint, 36.21375, -81.67705,
                "East Residence Hall");
        doughtonMarker = createMarker(doughtonMarker, doughtonGeoPoint, 36.21454, -81.67610,
                "Doughton Residence Hall");
        hoeyMarker = createMarker(hoeyMarker, hoeyGeoPoint, 36.21437, -81.67550, "Hoey Residence Hall");
        cannonMarker = createMarker(cannonMarker, cannonGeoPoint, 36.21387, -81.67594,
                "Cannon Residence Hall");
        stadiumLotMarker = createMarker(stadiumLotMarker, stadiumLotGeoPoint, 36.21350, -81.68509,
                "Kidd Brewer Stadium Parking");
        hillStreetLotMarker = createMarker(hillStreetLotMarker, hillStreetLotGeoPoint, 36.20912,
                -81.67879,
                "Hill Street Parking");
        holmesLotMarker = createMarker(holmesLotMarker, holmesLotGeoPoint, 36.21021, -81.67690,
                "Holmes Convocation Center Parking (George M. Holmes)");
        appHeightsLotMarker = createMarker(appHeightsLotMarker, appHeightsLotGeoPoint, 36.21506,
                -81.68980,
                "Appalachian Heights Parking");
        greenwoodLotMarker = createMarker(greenwoodLotMarker, greenwoodLotGeoPoint, 36.21377,
                -81.68919,
                "Greenwood Parking Lot");
        peacockLotMarker = createMarker(peacockLotMarker, peacockLotGeoPoint, 36.21589, -81.68279,
                "Peacock Parking");
        collegeStreetDeckMarker = createMarker(collegeStreetDeckMarker, collegeStreetDeckGeoPoint,
                36.21595,-81.68003,
                "College Street Parking Deck");
        admissionsLotMarker = createMarker(admissionsLotMarker, admissionsLotGeoPoint, 36.21064,
                -81.67723,
                "Admissions Parking");
        southLotMarker = createMarker(southLotMarker, southLotGeoPoint, 36.21274, -81.69365,
                "South Parking Lot");
        walkerMarker = createMarker(walkerMarker, walkerGeoPoint, 36.21682, -81.68495, "Walker Hall");
    }

    private Marker createMarker(Marker m, GeoPoint p, double lat, double lon, String title)
    {
        m = new Marker(map);
        p = new GeoPoint(lat, lon);
        markers.add(m);
        geopoints.add(p);
        m.setTitle(title);
        m.setPosition(p);
        return m;
    }

    /*
     *   Remove all the markers from the map (not including start and dest)
     */
    private void removeMarkers()
    {
        ArrayList<Marker> mList = getMarkerList();
        for (Marker m : mList)
        {
            map.getOverlays().remove(m);
        }
    }

    public static ArrayList<Marker> getMarkerList()
    {
        return markers;
    }

    public static ArrayList<GeoPoint> getGeoPointsList()
    {
        return geopoints;
    }

    public static void turnDirectionsOn()
    {
        isRouting = true;
    }

    public static void turnDirectionsOff() { isRouting = false; }
}