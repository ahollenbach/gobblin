package com.linkedin.uif.publisher;

import java.util.Collection;

import com.linkedin.uif.configuration.State;

/**
 * Defines how to publish data and its corresponding metadata
 * Can be used for either task level or job level publishing
 */
public abstract class DataPublisher
{
    private State state;
    
    public DataPublisher(State state) {
        this.setState(state);
    }
    
    public abstract void initialize() throws Exception;
    
    public abstract void close() throws Exception;
    
    /**
     * Returns true if it successfully publishes the data,
     * false otherwise
     */
    public abstract boolean publishData(State task) throws Exception;
    
    public abstract boolean publishData(Collection<? extends State> tasks) throws Exception;
    
    /**
     * Returns true if it successfully publishes the metadata,
     * false otherwise. Examples are checkpoint files, offsets, etc.
     */
    public abstract boolean publishMetadata(State task) throws Exception;
    
    public abstract boolean publishMetadata(Collection<? extends State> tasks) throws Exception;

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}