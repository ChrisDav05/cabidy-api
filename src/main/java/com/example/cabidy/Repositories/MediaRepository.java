package com.example.cabidy.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cabidy.Entity.Media;

public interface MediaRepository extends JpaRepository<Media, UUID> {}