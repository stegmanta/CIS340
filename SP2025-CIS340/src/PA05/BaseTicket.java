package PA05;

/*Interface for Ticket class*/
public interface BaseTicket {

/*Make the following 2 varibales final*/
double onCampusBaseCharge  = 1.25;
double offCampusBaseCharge = 2.34;

/*Fill in to declare the 2 abstract methods as mentioned in the requirement*/
void calculateTicket();
String toString();

}// end Interface
