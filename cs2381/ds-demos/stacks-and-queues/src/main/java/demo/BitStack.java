package demo;

import java.util.ArrayList;

class BsDemo {

    public static void main(String[] args) {
        var st = new BitStack();
        st.push(true);
        st.push(false);
        st.push(true);
        st.push(true);

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}

public class BitStack implements Stack<Boolean> {
    ArrayList<Byte> data = new ArrayList<Byte>();
    int size = 0;

    @Override
    public void push(Boolean item) {
        // Next bit is going to go at the index
        // equal to the current stack size.
        var ii = size;

        // Which byte does this new bit go in?
        var byte_index = ii / 8;
        var bit_index = ii % 8;

        if (byte_index >= data.size()) {
            data.add((byte) 0);    
        }

        int vv = data.get(byte_index);
        //System.out.println("push, before: " + Integer.toBinaryString(vv));
        if (item) {
            // Set bit to 1
            vv = vv | (1 << bit_index);       
        }
        else {
            // Set bit to 0
            vv = vv & ~(1 << bit_index);       
        }
        //System.out.println("push, after: " + Integer.toBinaryString(vv));
        data.set(byte_index, (byte) vv);

        //int tmp = data.get(byte_index);
        //System.out.println("byte:" + Integer.toBinaryString(tmp & 255));

        this.size += 1;
    }

    @Override
    public Boolean pop() {
        this.size -= 1;

        var ii = size;

        // Which byte does this new bit go in?
        var byte_index = ii / 8;
        var bit_index = ii % 8;

        int vv = data.get(byte_index);
        // System.out.println("pop byte: " + Integer.toBinaryString(vv & 255));
        // System.out.println("size: " + size);
        int mask = 1 << bit_index;
        //System.out.println("mask: " + Integer.toBinaryString(mask & 255));

        int bit = (vv & mask) >> bit_index;
        // System.out.println("bit: " + bit);


        return bit == 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Boolean peek() {
        var tmp = pop();
        push(tmp);
        return tmp;
    }

    @Override
    public int size() {
        return size;
    }

}

