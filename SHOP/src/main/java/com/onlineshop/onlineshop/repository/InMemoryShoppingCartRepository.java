package com.onlineshop.onlineshop.repository;

import com.onlineshop.onlineshop.bootstrap.DataHolder;
import com.onlineshop.onlineshop.model.ShoppingCart;
import com.onlineshop.onlineshop.model.enumeration.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Optional;

@Repository
public class InMemoryShoppingCartRepository {

    public Optional<ShoppingCart> findById(Long id){
        return DataHolder.shoppingCarts.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Optional<ShoppingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status){
        return  DataHolder.shoppingCarts.stream()
                .filter(i->i.getUser().getUsername().equals(username)
                && i.getStatus().equals(status)).findFirst();
    }

    public ShoppingCart save(ShoppingCart shoppingCart){
        DataHolder.shoppingCarts.removeIf(i -> i.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }


}


