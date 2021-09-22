package com.javaprofi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.javaprofi.spi.PlaylistService;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class RockPlaylistService implements PlaylistService 
{
  private final Map<String, List<String>> songMap = Map.of(
          "Bryan Adams", List.of("Summer of 69"),
          "Bon Jovi", List.of("Livin' On A Prayer"),
          "Metallica", List.of("Nothing Else Matters"),
          "Nickelback", List.of("How You Remind Me"),
          "Toto", List.of("Africa", "Hold The Line"));

  public List<String> getTitles()
  {
      final Stream<List<String>> titlesStream = songMap.values().stream();
      final List<String> allTitles = titlesStream.reduce(new ArrayList<>(), (list1, list2) -> {
          list1.addAll(list2);
          return list1;
      });
      return allTitles;
  }

    @Override
    public List<String> searchByArtist(final String artist) 
    {
        return songMap.getOrDefault(artist, 
                                   List.of("No song found for" + artist));
    }
}