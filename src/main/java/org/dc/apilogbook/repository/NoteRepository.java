package org.dc.apilogbook.repository;

import org.dc.apilogbook.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Long> {
}
