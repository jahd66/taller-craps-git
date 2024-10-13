package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Game;

public class GameController {
    @FXML
    private Button rollDiceButton;

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
        if(game.getPoint() != 0) {
            pointLabel.setText(String.valueOf(game.getPoint()));
        }

        // Muestra si el jugador ganó o perdió
        if (game.isWin()) {
            resultLabel.setText("¡Ganaste!");

            //Permitir seguir jugando tras ganar
        } else if (game.isLose()) {
            resultLabel.setText("¡Perdiste!");
            rollDiceButton.setDisable(true); //Deshabilita el boton si se pierde
        } else {
            resultLabel.setText("Continúa jugando...");
        }

        gamesWonLabel.setText(String.valueOf(game.getGamesWon()));
        gamesLostLabel.setText(String.valueOf(game.getGamesLost()));

    }

    //Resetea el juego sin reiniciar los contadores
    @FXML
    public void resetGame() {
        game.resetGame();
        dice1ImageView.setImage(null); //Limpia las imagenes de los dados
        dice2ImageView.setImage(null);
        shootLabel.setText("-");
        pointLabel.setText("-");
        resultLabel.setText("Nuevo juego, lanza los dados");
        rollDiceButton.setDisable(false); //Habilita el boton para jugar de nuevo
    }

    @FXML
    public void onHelpButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game instructions");
        alert.setHeaderText(null);
        alert.setContentText("The game begins when the player takes his shot or tee shot." +
                             " If you roll a 7 or 11, you automatically win." +
                             " If you roll a 2, 3 or 12, it's a 'Craps' and you lose. " +
                             " Any other number (4, 5, 6, 8, 9, 10) establishes the 'point'." +
                             " If the player establishes a 'point', they can continue rolling with the goal of trying to roll that same number again." +
                             " If you manage to get the 'point' before rolling a 7, you win. If you roll a 7 before the point, you lose.");
        alert.showAndWait();
    }
}