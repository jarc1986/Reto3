/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_G31.Alveiro;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class ServiciosGame {
    @Autowired
    private RepositorioGame metodosCrud;

    public List<Game> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Game> getGame(int gameId) {
        return metodosCrud.getGame(gameId);
    }

    public Game save(Game game){
        if(game.getId()==null){
            return metodosCrud.save(game);
        }else{
            Optional<Game> e=metodosCrud.getGame(game.getId());
            if(e.isEmpty()){
                return metodosCrud.save(game);
            }else{
                return game;
            }
        }
    }

    public Game update(Game game){
        if(game.getId()!=null){
            Optional<Game> e=metodosCrud.getGame(game.getId());
            if(!e.isEmpty()){
                if(game.getName()!=null){
                    e.get().setName(game.getName());
                }
                if(game.getBrand()!=null){
                    e.get().setBrand(game.getBrand());
                }
                if(game.getYear()!=null){
                    e.get().setYear(game.getYear());
                }
                if(game.getDescription()!=null){
                    e.get().setDescription(game.getDescription());
                }
                if(game.getCategory()!=null){
                    e.get().setCategory(game.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }


    public boolean deleteGame(int gameId) {
        Boolean aBoolean = getGame(gameId).map(game -> {
            metodosCrud.delete(game);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
