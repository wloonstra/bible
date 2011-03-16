package nl.wiggertloonstra.bible.hibernate.factory;

import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.HibernateBibleTextRepository;

public class BibleTextRepositoryFactory {
    
    private static BibleTextRepository bibleTextRepository;
    
    public static BibleTextRepository bibleTextRepository() {
        if (bibleTextRepository == null) {
            bibleTextRepository = new HibernateBibleTextRepository();
        }
        return bibleTextRepository;
    }
    
    

}
