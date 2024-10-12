package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel, resultLabel, gamesWonLabel, gamesLostLabel;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    private Game game;

    public GameController() {
        this.game = new Game();
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        // Lanza los dados de la clase Game
        game.rollDices();

        // Actualiza las imágenes de los dados
        this.dice1ImageView.setImage(game.dice1.getDiceImage());
        this.dice2ImageView.setImage(game.dice2.getDiceImage());

        // Actualiza las etiquetas con los valores de tiro y punto
        shootLabel.setText(String.valueOf(game.getShoot()));
        pointLabel.setText(String.valueOf(game.getPoint()));

        // Muestra si el jugador ganó o perdió
        if (game.isWin()) {
            resultLabel.setText("¡Ganaste!");
        } else if (game.isLose()) {
            resultLabel.setText("¡Perdiste!");
        } else {
            resultLabel.setText("Continúa jugando...");
        }

        // Actualiza los contadores de juegos ganados y perdidos
        gamesWonLabel.setText(String.valueOf(game.getGamesWon()));
        gamesLostLabel.setText(String.valueOf(game.getGamesLost()));
    }
}
