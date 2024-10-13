package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean won;
    private boolean lost;
    private int gamesWon; // Contador de juegos ganados
    private int gamesLost; // Contador de juegos perdidos
    public Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.won = false;
        this.lost = false;
        this.gamesWon = 0; // Inicializa el contador de juegos ganados
        this.gamesLost = 0; // Inicializa el contador de juegos perdidos
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    public void rollDices() {
        dice1.rollDice();
        dice2.rollDice();
        this.shoot = dice1.getValue() + dice2.getValue();
        shootCount++;

        if (shootCount == 1) { // Primera tirada
            if (shoot == 7 || shoot == 11) {
                won = true;
                lost = false;
                gamesWon++; // Incrementa el contador de juegos ganados
            } else if (shoot == 2 || shoot == 3 || shoot == 12) {
                lost = true;
                won = false;
                gamesLost++; // Incrementa el contador de juegos perdidos
            } else { // Establece el punto
                point = shoot;
                won = false;
                lost = false;
            }
        } else { // Tiros después del primer
            if (shoot == point) {
                won = true;
                lost = false;
                gamesWon++; // Incrementa el contador de juegos ganados
            } else if (shoot == 7) {
                lost = true;
                won = false;
                gamesLost++; // Incrementa el contador de juegos perdidos
            }
        }
    }

    //Reinicia el estado del juego
    public void resetGame() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.won = false;
        this.lost = false;
    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean isWin() {
        return this.won;
    }

    public boolean isLose() {
        return this.lost;
    }

    public int getGamesWon() { // Método para obtener juegos ganados
        return this.gamesWon;
    }

    public int getGamesLost() { // Método para obtener juegos perdidos
        return this.gamesLost;
    }
}