package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Invitation;
import com.zpi.server.repositories.IInvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvitationController 
{
    @Autowired
    IInvitationRepository _repo;

    @GetMapping("/invitations")
    public List<Invitation> getAllInvitations()
    {
        return _repo.findAll();
    }

    @PostMapping("/invitations")
    public Invitation createInvitation(@Valid @RequestBody Invitation invitation)
    {
        return _repo.save(invitation);
    }

    @GetMapping("/invitations/{id}")
    public Invitation getInvitationById(@PathVariable(value = "id") Integer invitationId)
    {
        return _repo.findById(invitationId).get();
    }

    @PutMapping("/invitations/{id}")
    public Invitation updateInvitation(@PathVariable(value="id") Integer invitationId, @Valid @RequestBody Invitation invitationDetails)
    {
        Invitation _invitation = _repo.findById(invitationId).get();

        _invitation.setGroupID(invitationDetails.getGroupID());
        _invitation.setStudentID(invitationDetails.getStudentID());
        _invitation.setIsConfirmed(invitationDetails.getIsConfirmed());
        _invitation.setIsViewed(invitationDetails.getIsViewed());

        Invitation _updatedInvitation = _repo.save(_invitation);
        return _updatedInvitation;
    }

    @DeleteMapping("/invitations/{id}")
    public ResponseEntity<?> deleteInvitation(@PathVariable(value="id") Integer invitationId)
    {
        Invitation _invitation = _repo.findById(invitationId).get();
        _repo.delete(_invitation);
        return ResponseEntity.ok().build();
    }
}
