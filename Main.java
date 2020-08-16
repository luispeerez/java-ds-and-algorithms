import java.util.HashMap;
import java.util.Scanner;

// Problem B. Amigos
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //String msg = sc.next();
        HashMap<String, Integer> participants = new HashMap<>();

        int nParticipants = sc.nextInt(); 
        
        for(int i = 0; i < nParticipants; i++){
            participants.put(sc.next(), i);
        }
        
        int[][] friendships = new int[nParticipants][nParticipants];

        for(int i = 0; i < nParticipants; i++ ){
            for(int j = 0; j < nParticipants; j++ ){
                friendships[i][j] = sc.nextInt();
            }
        }

        //Arrays.deepToString(friendships);

        int questions = sc.nextInt();
        int[] answers = new int[questions];

        for(int i = 0; i < questions; i++){
            String p1 = sc.next();
            String p2 = sc.next();
            answers[i] = resolveQuestion(p1, p2, participants, friendships);
        }

        sc.close();

        for(int i = 0 ; i < questions; i++){
            System.out.println(answers[i]);
        }

/*
        participants.put("ALBERTO", 0);
        participants.put("ALEXIS", 1);
        participants.put("CESAR", 2);
        participants.put("ETHAN", 3);
        participants.put("LUIS", 4);
        participants.put("MARCEL", 5);
*/

        /*int answer = resolveQuestion("LUIS", "ALEXIS", participants, friendships);
        System.out.println(answer);
        */
        
    }

    public static int resolveQuestion(String p1, String p2, HashMap<String, Integer> participants, int[][] friendships){
        int p1Id = participants.get(p1);
        int p2Id = participants.get(p2);

        // Participant not found guard clauses

        if(!participants.containsKey(p1) || !participants.containsKey(p2)){
            return -1;
        }

        if(p1Id < 0 || p1Id >= friendships.length || p1Id < 0 || p2Id >= friendships.length){
            return -1;
        }

        return friendships[p1Id][p2Id];
    }
}