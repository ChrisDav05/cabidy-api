package com.example.cabidy.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cabidy.Entity.Checklist;

public interface ChecklistRepository extends JpaRepository<Checklist, UUID> {}
