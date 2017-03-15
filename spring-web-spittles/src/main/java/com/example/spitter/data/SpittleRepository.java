package com.example.spitter.data;

import com.example.spitter.Spittle;

import java.util.List;

/**
 * Created by anil on 3/12/17.
 */
public interface SpittleRepository {
    public List<Spittle> findSpittles(long max, int count);

    public Spittle findOne(long spittleId);
}
