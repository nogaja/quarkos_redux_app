package org.acme;

import java.util.Collection;


import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/fruits")
public class FruitResource {

    @GET
    public Collection<Fruit> list() {
        return Fruit.listAll();
    }

    @POST
    @Transactional
    public Fruit add(Fruit fruit) {
        fruit.persist();
        return fruit;
    }

// @POST
// @Transactional
// public Collection<Fruit> add(Fruit fruit) {
//     Fruit existingFruit = Fruit.findById(fruit.id);
//     if(existingFruit != null) {
//         System.out.println("here");

//         existingFruit.name = fruit.name;
//         existingFruit.description = fruit.description;
//         existingFruit.persist();
//     } else {
//         System.out.println("there");

//         fruit.persist();
//     }
//     return Fruit.listAll();
// }

    @DELETE
    @Transactional
    public Collection<Fruit> delete(Fruit fruit) {
        System.out.println(fruit);
        fruit.delete();
        return Fruit.listAll();
    }
}