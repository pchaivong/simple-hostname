package com.oc.poc.simplehostname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pchaivong on 11/3/2017 AD.
 */

@RestController
public class APIController {

    private DelayedConfiguration delayedConfiguration;

    private final String hostname = System.getenv("HOSTNAME");
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public APIController(DelayedConfiguration config){
        this.delayedConfiguration = config;
    }


    @RequestMapping(value = "/hostname", method = RequestMethod.GET)
    public Hostname getHostname(){
        try {
            logger.info("Delay: " + delayedConfiguration.getDelayed() + " ms.");
            Thread.sleep(delayedConfiguration.getDelayed());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return new Hostname(hostname);
    }


    @RequestMapping(value = "/delayed", method = RequestMethod.GET)
    public DelayedResponse getDelayedConfiguration(){
        DelayedResponse resp = new DelayedResponse();
        resp.setDelayed(delayedConfiguration.getDelayed());
        resp.setHostname(hostname);
        return resp;
    }

    @RequestMapping(value = "/delayed", method = RequestMethod.POST)
    public DelayedResponse updateDelayedConfiguration(@RequestBody DelayedRequest request){
        delayedConfiguration.setDelayed(request.getDelayed());
        DelayedResponse resp = new DelayedResponse();
        resp.setHostname(hostname);
        resp.setDelayed(delayedConfiguration.getDelayed());
        return resp;
    }
}
