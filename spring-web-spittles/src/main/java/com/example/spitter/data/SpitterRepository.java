package com.example.spitter.data;

import com.example.spitter.Spitter;

/**
 * Created by anil on 3/13/17.
 */
public interface SpitterRepository {
    public Spitter save(Spitter spitter);

    public Spitter findUser(String userName);
}
