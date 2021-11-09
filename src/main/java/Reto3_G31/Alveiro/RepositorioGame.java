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
public class RepositorioGame {
    @Autowired
    private InterfaceGame crud;

    public List<Game> getAll(){
        return (List<Game>) crud.findAll();
    }
	
    public Optional<Game> getGame(int id){
        return crud.findById(id);
    }
	
    public Game save(Game game){
        return crud.save(game);
    }
    
    public void delete(Game game){
        crud.delete(game);
    }

    Optional<Game> getGame(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
