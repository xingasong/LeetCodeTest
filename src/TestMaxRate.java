import java.util.*;

public class TestMaxRate {
    private static List<Integer> maxRate() {
        HashMap<Integer, Integer> curSendMeMsg = new HashMap<>();
        int[] a = {0,0,0};
        for(int i=0; i<3; i++) {
            curSendMeMsg.put(i, a[i]);
        }
        boolean[] curInterestedMe = {false, true, true};
        List<Integer> maxRate = new LinkedList<>();
        //choose limit number of peer
        for(int i=0; i<2; i++){
            //initial
            int max = 0;
            int index = 0;
            //get index of peers currently send me message
            for(int k : curSendMeMsg.keySet()){
                //compare rate with max
                if(curSendMeMsg.get(k)>max){
                    max = curSendMeMsg.get(k);
                    index = k;
                }
                //for same rate randomly choose one
                else if(curSendMeMsg.get(k)==max){  //changed
                    Random random = new Random();
                    boolean b = random.nextBoolean();
                    if(b){
                        max = curSendMeMsg.get(k);
                        index = k;
                    }
                }
            }
            //if not interested in my message, not count in
            if(!curInterestedMe[index]){
                curSendMeMsg.put(index, 0); //changed
                i--;
            }else {
                //choose as prefered
                maxRate.add(index);
                curSendMeMsg.put(index, 0);
            }
        }
        System.out.println(maxRate);
        return maxRate;
    }

    private static void chock() {
        //unchock Interval
        int count = 40;
        int unchockInterval = 4;
        int optUnchockInterval = 10;
        int numOfPreferedNerghbor = 2;
        boolean[] isChock = {true, true, true};

        int optIndex = 1;
        List<Integer> preferNeighbor = new LinkedList<>();
        if(count%unchockInterval==0){
            //change part 21/11

            //contain the index of neighbor interested in P
            preferNeighbor = maxRate();
            if(preferNeighbor==null||preferNeighbor.size()==0){
                System.out.println("unchock failed");
                return;
            }
            //firstly chock all neighbor


            //make sure optimistically unchock
            isChock[optIndex] = false;
            //make sure other peer chocked
            for(int i=0; i<isChock.length; i++){
                if(!isChock[i]&&!preferNeighbor.contains(i)&&i!=optIndex){
                    isChock[i] = true;
                    //create chock message;
                    //\\Message msg = new Message(1, 0, null);
                    //send chock to peer i;
                    //\\sendMessage(msg, i);
                    System.out.println("[" + count + "]" + "Peer chock peer " + i);
                }
            }

            //choose high speed to unchock
            for(int i=0; i<numOfPreferedNerghbor; i++){
                int index = preferNeighbor.get(i);
                if(isChock[index]) {
                    //create unchock message
                    //\\Message msg = new Message(1, 1,null);
                    //send unchock to peer i;
                    //\\sendMessage(msg, index);
                    //waiting for request message from i;
                    isChock[index] = false;
                    System.out.println("[" + count + "]" + "Peer unchock peer " + index);
                }
            }
        }

        //optimistically unchock interval
        if(count%optUnchockInterval==0){
            //actually not new, waiting for coming
            //boolean[] curInterestedMe = new boolean[numOfNeighbor];
//            if(curInterestedMe.length==0){
//                System.out.println("all other peers have my messages");
//                return;
//            }
            //preferNeighbor = maxRate();

            if(preferNeighbor!=null&&!preferNeighbor.contains(optIndex)) {
                //create chock message;
                //\\Message msg = new Message(1, 0, null);
                //send chock to peer index;
                //\\sendMessage(msg, optIndex);
                System.out.println("[" + count + "]" + "Peer chock peer " + optIndex);
                isChock[optIndex] = true;
            }
            //\\send chock to peer optIndex;
            //List<Integer> preferNeighbor = maxRateNeighbor();
            while (true){
                //randomly unchock among currently chocked peer
                int index = (int)(Math.random()*3);
                if(isChock[index]&&index!=0){
                    optIndex = index;
                    //\\Message msg = new Message(1, 1, null);
                    //\\sendMessage(msg, optIndex);
                    isChock[optIndex] = false;
                    break;
                }
            }
            //\\create unchock message;
            //\\send unchock to peer index;
            //\\waiting for request message from index;
            System.out.println("[" + count + "]" + "Peer optimistically unchock peer" + optIndex);
        }
        System.out.println(Arrays.toString(isChock));
    }

    public static void main(String[] args) {
        chock();
        //System.out.println(Arrays.toString(isChock));
    }
}
