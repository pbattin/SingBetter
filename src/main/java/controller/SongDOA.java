package controller;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by prestonbattin on 3/23/17.
 */

public interface SongDOA extends CrudRepository<Song ,Long> {


      Song findByid(int id);
      Song findBytitle(String title);
}
