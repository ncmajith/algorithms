package dev.snakeandladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String []args){
        DescriptionGenerator.heading ();
        Scanner scanner=new Scanner (System.in);
        int numberOfPlayers=scanner.nextInt ();
        int[] players=new int[numberOfPlayers];
        for(int i=0;i<numberOfPlayers;i++) players[i]=1;
        boolean started=true;
        int player=1;
        while(started){
            DescriptionGenerator.numberOfPlayers ("# Number of players :",numberOfPlayers);
            while(player<=numberOfPlayers) {
                DescriptionGenerator.players ("# Player :",player);
                int dice = (int) (Math.random () * 6 + 1);
                DescriptionGenerator.diceAndCurrentPosition (players, player, dice);
                if (dice == 6) {
                    players[player - 1] += dice;
                    DescriptionGenerator.numberOfPlayers ("# New Position :",players[player - 1]);
                }
                else{
                    players[player - 1] =players[player - 1]!=1? players[player - 1]+dice:1;
                    DescriptionGenerator.numberOfPlayers ("# New Position :",players[player - 1]==1?0:players[player - 1]);
                }
                started=playSnakeAndLadder(player,players);
                if(!started) break;
                else{
                    if(player==numberOfPlayers && dice!=6){
                        player=1;
                    }else if(dice!=6){
                        player=player+1;
                    }
                }
            }
        }
        DescriptionGenerator.winner("# Winner :",+player);
    }
    
    private static boolean playSnakeAndLadder ( int player, int[] players) {
        players[player - 1] = Math.min ((players[player - 1]), 100);
        Map<Integer, Integer> ladders = new HashMap<> ();
        ladders.put (2, 30);
        ladders.put (10, 18);
        ladders.put (20, 60);
        ladders.put (30, 90);
        ladders.put (50, 80);
        ladders.put (3, 88);
        Map<Integer, Integer> snakes = new HashMap<> ();
        snakes.put (5, 1);
        snakes.put (99, 1);
        snakes.put (28, 3);
        snakes.put (50, 20);
        snakes.put (90, 10);
        snakes.put (8, 5);
        if (players[player - 1] == 100) return false;
        else{
            while((null != ladders.get (players[player - 1]))||(null != snakes.get (players[player - 1]))) {
                players = checkForSnake (player, players,snakes);
                players = checkForLadder (player, players,ladders);
            }
            return true;
        }
    }

    private static int[] checkForLadder ( int player, int[] players, Map<Integer, Integer> ladders ) {
        if (null != ladders.get (players[player - 1])) {
            DescriptionGenerator.numberOfPlayers("# Got ladder at :",players[player - 1]);
            players[player - 1] = ladders.get (players[player - 1]);
            DescriptionGenerator.numberOfPlayers("# After ladder :",players[player - 1]);
        };
        return players;
    }

    private static int[] checkForSnake ( int player, int[] players, Map<Integer, Integer> snakes ) {
        if (null != snakes.get (players[player - 1])) {
            DescriptionGenerator.numberOfPlayers("# Snake caught at :",players[player - 1]);
            players[player - 1] = snakes.get (players[player - 1]);
            DescriptionGenerator.numberOfPlayers("# After snake attack :",players[player - 1]);
        };
        return players;
    }
}

class DescriptionGenerator{
    public static final String sep="\t================================\t";
    public static void heading (){
        System.out.print(sep+"Welcome to snake and ladder"+sep+"\n\t# Enter Number of players\n\t");
    }
    public static void numberOfPlayers(String message,int numberOfPlayers){
        System.out.println ("\t"+message+"\t"+numberOfPlayers);
    }
    public static void players(String message,int numberOfPlayers){
        System.out.println (sep+"\t\n\t"+message+"\t"+numberOfPlayers+"\n"+sep);
    }
    public static void diceAndCurrentPosition ( int[] players, int player, int dise ) {
        System.out.println ("\t# Dice "+ dise);
        System.out.print ("\t# Current Position :\t"+(players[player - 1]==1?0: players[player - 1])+"\n");
    }
    public static void winner ( String s, int i ) {
        System.out.println(sep+"\n"+sep+"Winner :"+i+sep+"\n");
    }
}