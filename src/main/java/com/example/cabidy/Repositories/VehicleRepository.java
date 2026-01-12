package com.example.cabidy.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cabidy.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {}