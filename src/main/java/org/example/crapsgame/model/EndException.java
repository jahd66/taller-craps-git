package org.example.crapsgame.model;
import java.lang.Exception;
public class EndException extends Exception{
    public EndException(){
        super("Perdiste! Te deseamos más suerte la próxima");
    }
}
