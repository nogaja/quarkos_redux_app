package org.acme;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    private Set<Message> msgs = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Message> list() {
        return msgs;
    }

    @POST
    @Transactional
    public Collection<Message> add(Message msg) {
        msg.persist();
        return Message.listAll();
    }
    // public String postMsg(Message postMsg){
    //     // System.out.println(postMsg.content);
    //     return (postMsg.content);
    // } 
}

