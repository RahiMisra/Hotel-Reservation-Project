
/**
 * Write a description of class availableRooms here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class availableRooms
{
    
        private int numberOfKingRooms = 20;
        private int numberOfQueenRooms = 20;
        private int numberOfSuiteRooms = 10;
        
        private int availableKingRooms = numberOfKingRooms;//numberOfKingRooms;
        private int availableQueenRooms = numberOfQueenRooms;//numberOfQueenRooms;
        private int availableSuiteRooms = numberOfSuiteRooms;//numberOfSuiteRooms;
        
        availableRooms()
        {
            if(availableKingRooms >0 || availableQueenRooms>0 || availableSuiteRooms>0)
        {
            if(availableKingRooms >0)
            {
                System.out.println("king room available");
            }
            if(availableQueenRooms>0)
            {
                System.out.println("queen room available");
            }
            if(availableSuiteRooms>0) 
            System.out.println("suit room available");
        }
        else
        {
            System.out.println("all out of rooms");
        }
        
        System.out.println("kingroom inventory:" + availableKingRooms );
        System.out.println("queenroom inventory:" + availableQueenRooms );
        System.out.println("suiteroom inventory:" + availableSuiteRooms );

    }
    
            }