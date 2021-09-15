package com.ceiba.movement.servicio;

import com.ceiba.movement.modelo.entidad.Movement;
import com.ceiba.movement.puerto.repositorio.RepositorioMovement;
import com.ceiba.product.modelo.entidad.Product;
import com.ceiba.product.puerto.repositorio.RepositorioProduct;

import java.util.Calendar;
import java.util.Date;


public class CreateMovementService {

    private final RepositorioMovement repositorioMovement;
    private final RepositorioProduct repositorioProduct;

    public CreateMovementService(RepositorioMovement repositorioMovement, RepositorioProduct repositorioProduct) {
        this.repositorioMovement = repositorioMovement;
        this.repositorioProduct = repositorioProduct;
    }

    public Long ejecutar(Movement movement) {

        updateProduct(movement);
        return this.repositorioMovement.crear(movement);
    }

    private void updateProduct(Movement movement){

        Product product = repositorioProduct.findById(movement.getIdProduct());
        product = getProductToUpdate(product, movement.getSaleDate());
        repositorioProduct.actualizar(product);
    }


    private Product getProductToUpdate(Product product, Date saleDate){

        if(product.getStock().equals(0)){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(saleDate);
            calendar.add(Calendar.DAY_OF_WEEK,3);

            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
                calendar.add(Calendar.DAY_OF_WEEK,2);
            }
            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
                calendar.add(Calendar.DAY_OF_WEEK,1);
            }

            product.setSupplyingDate( calendar.getTime());
        }

        return product;
    }

}
