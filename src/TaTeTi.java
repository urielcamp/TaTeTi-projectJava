import java.util.Scanner;

public class TaTeTi {
    private char[][] tablero;
    private char jugadorActual;

    public TaTeTi(){
        tablero = new char[3][3];
        jugadorActual = 'X';
        inicializarTablero();
    }

    private void inicializarTablero(){
        for (int i = 0; i < tablero.length; i ++){
            for (int j = 0; j < tablero.length; j++){
                tablero[i][j] = '-';
            }
        }
    }

    public void jugar(){
        boolean bandera = true;
        Scanner input = new Scanner(System.in);

        while (bandera){
            mostrarTablero();
            System.out.println("jugador: " + jugadorActual + " ingrese la fila entre 0 y 2");
            int fila = input.nextInt();
            System.out.println("jugador: " + jugadorActual + " ingrese la columna entre 0 y 2");
            int columna = input.nextInt();

            if (tablero[fila][columna] == '-'){
                tablero[fila][columna] = jugadorActual;

            }if (filasCoinciden() || columnacoinciden() || diagonalCoinciden()) {
                System.out.println("Felicidades, has ganado la partida");
                bandera = false;

            }else if (empate()){
                System.out.println("Empate");
                bandera = false;


            } else if (jugadorActual == 'X'){
                jugadorActual = 'O';

            }else if (jugadorActual == 'O'){
                jugadorActual = 'X';
            }


            else{
                System.out.println("El casillero ua se encuentra ocupado");
            }

        }
    }

    private boolean empate(){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero.length; j++){
                if (tablero[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    private void mostrarTablero(){
        for (int i = 0; i < tablero.length; i++){
            for (int j= 0; j < tablero.length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean filasCoinciden(){
        for (int i = 0; i < tablero.length; i++){
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]){
                return true;

            }
        }

        return false;

    }

    private boolean columnacoinciden(){
        for (int i = 0; i < tablero.length; i++){
            if (tablero[0][i] != '-' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]){
                return true;

            }
        }
        return false;
    }

    private boolean diagonalCoinciden(){
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] || tablero [2][0] != '-' &&  tablero[2][0] == tablero[1][1] && tablero[1][1] == tablero[0][2]){
            return true;

        }
        return false;
    }


}
