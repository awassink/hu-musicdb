package nl.quintor.train.musicdb.controller;

import nl.quintor.train.musicdb.model.Album;
import nl.quintor.train.musicdb.nl.quintor.train.musicdb.dao.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {
    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @RequestMapping(value = "/album", method = RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album) {
        album.setId(null);
        return albumRepository.save(album);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public Album getAlbum(@PathVariable Long id) {
        return albumRepository.findOne(id);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.PUT)
    public Album updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        album.setId(id);
        return albumRepository.save(album);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.DELETE)
    public void updateAlbum(@PathVariable Long id) {
        albumRepository.delete(id);
    }

}
