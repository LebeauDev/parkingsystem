package com.parkit.parkingsystem;

import com.parkit.parkingsystem.service.InteractiveShell;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger("App");
    public static void main(String args[]){
        logger.info("Initializing Parking System");
        //System.out.println(new Date());
        InteractiveShell.loadInterface();
    }
}
