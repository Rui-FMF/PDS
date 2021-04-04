
[comment]: <> (This fie is more visually appealing if it's viewed in a Markdown compatible platform - GitHub)


# Java Calendar Class Review

This is a review of the [Java Calendar Class](http://www.docjar.com/html/api/java/util/Calendar.java.html).

## Constructors
The Java Calendar Class has 2 constructors:
    1. protected Calendar()
    2. protected Calendar(TimeZone zone, Locale aLocale)

The protected Calendar() contructor creates a Calendar with the default system time zone and locale
The protected Calendar(TimeZone zone, Locale aLocale) constructor creates a Calendar with specified time zone and locale.

Both constructors are 'protected' so they can't be accessed outside the class.

For this we use other methods:
    1. public static Calendar getInstance() 
    2. public static Calendar getInstance(TimeZone zone)
    3. public static Calendar getInstance(Locale aLocale)
    4. public static Calendar getInstance(TimeZone zone, Locale aLocale)

This allows for many different instances of Calendar.

These methods call the createCalendar() method. 

The createCalendar() method creates a new Calendar object.

## Which Design Pattern?
    We concluded that this is the Factory Design Pattern because the use of the createCalendar() method to create the Calendar objects. 