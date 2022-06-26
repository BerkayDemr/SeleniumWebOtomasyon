import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
    static Logger logger = Logger.getLogger(Log.class);
    public Log(){
        DOMConfigurator.configure("log4j.xml");
    }
    public void info(String LogMessage){
        logger.info(LogMessage);
    }

    public void warn(String LogMessage){
        logger.warn(LogMessage);
    }

    public void error(String LogMessage){
        logger.error(LogMessage);
    }

}