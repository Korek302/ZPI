package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Group;
import com.zpi.server.repositories.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GroupController 
{
    @Autowired
    IGroupRepository _repo;

    @GetMapping("/groups")
    public List<Group> getAllGroups()
    {
        return _repo.findAll();
    }

    @PostMapping("/groups")
    public Group createGroup(@Valid @RequestBody Group group)
    {
        return _repo.save(group);
    }

    @GetMapping("/groups/{id}")
    public Group getGroupById(@PathVariable(value = "id") Integer groupId)
    {
        return _repo.findById(groupId).get();
    }

    @PutMapping("/groups/{id}")
    public Group updateGroup(@PathVariable(value="id") Integer groupId, @Valid @RequestBody Group groupDetails)
    {
        Group _group = _repo.findById(groupId).get();

        _group.setMembersNumber(groupDetails.getMembersNumber());
        _group.setInvitationNumber(groupDetails.getInvitationNumber());
        _group.setLecturerID(groupDetails.getLecturerID());
        _group.setTopic(groupDetails.getTopic());

        Group _updatedGroup = _repo.save(_group);
        return _updatedGroup;
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value="id") Integer groupId)
    {
        Group _group = _repo.findById(groupId).get();
        _repo.delete(_group);
        return ResponseEntity.ok().build();
    }
}
