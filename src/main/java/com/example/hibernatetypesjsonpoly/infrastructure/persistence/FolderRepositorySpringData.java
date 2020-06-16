package com.example.hibernatetypesjsonpoly.infrastructure.persistence;

import com.example.hibernatetypesjsonpoly.domain.document.entity.Folder;
import com.example.hibernatetypesjsonpoly.domain.document.repository.FolderRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FolderRepositorySpringData implements FolderRepository {

    private final FolderJpaRepository folderJpaRepository;

    @Override
    public void save(Folder folder) {
        folderJpaRepository.save(folder);
    }

    @Override
    public Optional<Folder> findById(Long id) {
        return folderJpaRepository.findById(id);
    }
}

interface FolderJpaRepository extends JpaRepository<Folder, Long> {
}
