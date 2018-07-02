import java.util.BitSet;

public class testBit {
    public static void main(String[] args) {
        BitSet a = new BitSet(5);
        a.set(1);
        a.set(2);
        System.out.println(a.size());
        System.out.println(a.length());
        a.set(3);
        //a.set(4);
        //a.set(5);
        BitSet b = new BitSet(5);
        System.out.println(a.get(4));
        System.out.println(b);
        System.out.println(checkinterest(a,b));
    }

    public static BitSet byte2bit(byte[] bytes) {
        BitSet bits = new BitSet();
        for (int i=0; i<bytes.length*8; i++) {
            if ((bytes[bytes.length-i/8-1]&(1<<(i%8))) > 0) {
                bits.set(i);
            }
        }
        return bits;
    }

    public static byte[] bit2byte(BitSet bits) {
        byte[] bytes = new byte[bits.length()/8+1];
        for (int i=0; i<bits.length(); i++) {
            if (bits.get(i)) {
                bytes[bytes.length-i/8-1] |= 1<<(i%8);
            }
        }
        return bytes;
    }

    private static boolean checkinterest(BitSet a, BitSet b)/*check bitfield*/ {
        boolean need_flag2 = false;
        //BitSet bitfieldpeer = peer.getBitfield();
        int length=a.length();
        for (int i = 0; i < length; i++) {
            if (a.get(i)&!b.get(i)) {
                need_flag2 = true;
            }
        }
        return need_flag2;
    }
}
