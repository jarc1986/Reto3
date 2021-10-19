/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_G31.Alveiro;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class RepositorioCategory {
    @Autowired
    private InterfaceCategory crud;
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    public Optional<Category> getCategory(int id){
        return crud.findById(id);
    }

    public Category save(Category category){
        return crud.save(category);
    }
    public void delete(Category category){
        crud.delete(category);
    }
}
