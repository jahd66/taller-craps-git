package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    private int gamesWon; // Contador de juegos ganados
    private int gamesLost; // Contador de juegos perdidos
    public Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
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
                win = true;
                lose = false;
                gamesWon++; // Incrementa el contador de juegos ganados
            } else if (shoot == 2 || shoot == 3 || shoot == 12) {
                win = false;
                lose = true;
                gamesLost++; // Incrementa el contador de juegos perdidos
            } else { // Establece el punto
                point = shoot;
            }
        } else { // Tiros después del primer
            if (shoot == point) {
                win = true;
                lose = false;
                gamesWon++; // Incrementa el contador de juegos ganados
            } else if (shoot == 7) {
                win = false;
                lose = true;
                gamesLost++; // Incrementa el contador de juegos perdidos
            }
        }
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
        return this.win;
    }

    public boolean isLose() {
        return this.lose;
    }

    public int getGamesWon() { // Método para obtener juegos ganados
        return this.gamesWon;
    }

    public int getGamesLost() { // Método para obtener juegos perdidos
        return this.gamesLost;
    }
}