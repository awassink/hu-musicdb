package nl.quintor.train.musicdb.dao;

import nl.quintor.train.musicdb.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByName(String name);
}
