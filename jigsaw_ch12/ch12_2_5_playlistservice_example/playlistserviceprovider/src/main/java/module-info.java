module playlistserviceprovider 
{
    requires playlistservice;

    provides com.javaprofi.spi.PlaylistService
             with com.javaprofi.services.RockPlaylistService;
}