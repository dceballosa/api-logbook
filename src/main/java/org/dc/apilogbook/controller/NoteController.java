package org.dc.apilogbook.controller;

import org.dc.apilogbook.model.Note;
import org.dc.apilogbook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    // displays all notes
    @RequestMapping(value={"/", "notes"})
    public List<Note> noteList(@RequestParam(required = false, name = "filter") String filter) {
        // filter feature not yet implemented
        List<Note> notes = noteService.findAll();
        return notes;
    }

    // display one note with details
    @RequestMapping(value={"notes/{id}"}, method = RequestMethod.GET)
    public Note getNote(@PathVariable(name = "id") Long id) {
        return noteService.findOne(id).get();
    }

    // creates a new note
    @RequestMapping(value="/notes", method = RequestMethod.POST)
    public void saveNote(@RequestBody Note note) {
        noteService.saveNote(note);
    }

    // clones a note. creating a new one
    @RequestMapping(value="/noteClone/{id}", method = RequestMethod.GET)
    public void noteClone(@PathVariable(name = "id") Long id) {
        noteService.cloneNote(id);
    }

    // deletes a note
    @RequestMapping(value="/noteDelete/{id}", method = RequestMethod.GET)
    public void noteDelete(@PathVariable(required = true, name = "id") Long id) {
        noteService.deleteNote(id);
    }

}