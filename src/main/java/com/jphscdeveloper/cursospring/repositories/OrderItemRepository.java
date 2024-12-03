package com.jphscdeveloper.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jphscdeveloper.cursospring.entities.OrderItem;

//Como esse repositorio já herda de JpaRepository que já está registrado como component do spring, não precisa do @Repository
public abstract interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}