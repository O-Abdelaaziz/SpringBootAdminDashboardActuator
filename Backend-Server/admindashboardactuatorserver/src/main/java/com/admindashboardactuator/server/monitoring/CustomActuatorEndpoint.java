package com.admindashboardactuator.server.monitoring;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id ="custom" ,enableByDefault = true)
@Component
public class CustomActuatorEndpoint {

//    @ReadOperation
//    public Map<String,String> customEndpoint(){
//        Map<String,String> map=new HashMap<>();
//        map.put("Key","Value");
//        return map;
//    }

    @ReadOperation
    public Map<String,String> customEndpointWithParameter(String username){
        Map<String,String> map=new HashMap<>();
        map.put("Key",username);
        return map;
    }
}
