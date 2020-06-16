package com.example.hibernatetypesjsonpoly.domain.document.repository;

import com.example.hibernatetypesjsonpoly.domain.document.entity.Folder;

import java.util.Optional;

public interface FolderRepository {

    void save(Folder folder);

    Optional<Folder> findById(Long id);
}
