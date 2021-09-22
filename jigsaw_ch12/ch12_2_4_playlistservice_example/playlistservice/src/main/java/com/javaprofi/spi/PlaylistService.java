package com.javaprofi.spi;

import java.util.List;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public interface PlaylistService 
{
    public List<String> getTitles();
    public List<String> searchByArtist(final String artist);
}