package com.example.hibernatetypesjsonpoly.infrastructure.http;

import com.example.hibernatetypesjsonpoly.domain.Attachment;
import com.example.hibernatetypesjsonpoly.domain.Name;
import com.example.hibernatetypesjsonpoly.domain.document.entity.BankData;
import com.example.hibernatetypesjsonpoly.domain.document.entity.Folder;
import com.example.hibernatetypesjsonpoly.domain.document.entity.PersonalData;
import com.example.hibernatetypesjsonpoly.domain.document.repository.FolderRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class FolderController {

    private final FolderRepository folderRepository;

    @PostMapping("/folders")
    @Transactional
    public void create() {
        Folder folder = new Folder();

        folder.addDocument(PersonalData.create(Name.create("Jose").getValue(), null, null, null, null, null, null, null).getValue());
        folder.addDocument(new BankData("123", Arrays.asList(new Attachment("file1"), new Attachment("file2"))));

        folderRepository.save(folder);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity<Folder> getById(@PathVariable Long id) {
        return ResponseEntity.of(folderRepository.findById(id));
    }
}
