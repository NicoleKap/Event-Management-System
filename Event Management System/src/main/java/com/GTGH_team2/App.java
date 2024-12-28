package com.GTGH_team2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Functionality try!!!
        Organizer org1 = new Organizer("111654321","Nikki","Ioannou","Computer Scientist");
        Event event = new Event("Sailor Moon R","20 Years of Sailor Moon","The princess of the moon is going to save the world again","Athens",500,"Friday","May","2025",5,30,"5:30",org1,true);
        org1.addEvent(event);

        Organizer org2 = new Organizer("111654321","Maria","Papadopoulou","Computer Scientist");
        Event event2 = new Event("Sailor Moon S","20 Years of Sailor Moon","The princess of the moon is going to save the world again","Athens",500,"Friday","May","2025",5,30,"5:30",org1,true);
        org2.addEvent(event2);

        org1.addEvent(event2);
        System.out.println(org1.getEventsList());
        org1.deleteEvent(event);
        System.out.println(org1.getEventsList());
    }
}
