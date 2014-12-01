package org.commons.util;

import java.io.File;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerFacUtil {

    public static void info(String className, String message) {
        Logger LOG = LoggerFactory.getLogger( className );
        LOG.info( message );
    }

    public static void debug(String className, String message) {
        Logger LOG = LoggerFactory.getLogger( className );
        LOG.debug( message );        
    }

    public static void warn(String className, String message) {
        Logger LOG = LoggerFactory.getLogger( className );
        LOG.warn( message );        
    }

    public static void error(String className, Throwable e, String message) {
        if (message != null && message.trim().length() > 0) {
            Logger LOG = LoggerFactory.getLogger( className );
            LOG.error( message, e);             
        } else {
            Logger LOG = LoggerFactory.getLogger( className );
            LOG.error( e.toString(), e);            
        }
    }
    
    public static Boolean isDeployInTomcat() {
        if (System.getProperty("catalina.base") != null) {
            return true;
        }
        return false;
    }
    
    public static File[] tomcatLogFiles() {
        // Directory path here
        String path = System.getProperty("catalina.base"); 
        if (path != null) {
            File folder = new File(System.getProperty("catalina.base"), "logs");
            File[] listOfFiles = folder.listFiles(); 
            return listOfFiles;
        } 
        return null;
    }
    
    public static File getTomcatLogFile(String filename) {
        String path = System.getProperty("catalina.base");
        if (path != null) {
            try {
                String pureFilename = (new File(URLDecoder.decode(filename, "UTF-8"))).getName();
                String logPath =  path + File.separator + "logs";
                File file = new File(logPath, pureFilename);
                if (file.exists() && !file.isDirectory()) {
                    return file;
                }
            } catch (Exception e) {}
        }
        return null;
    }
}
