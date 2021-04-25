package yjy;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PPP {
    private static final int F = 0x7E;
    private static final int A_ = 0xFF;
    private static final int C_ = 0x03;
    private static final int IPProtocol = 0x0021;
    private static final CRC crc = new CRC();
    private int start;
    private int A;
    private int C;
    private int protocol;
    private int[] data;
    private int fcs;
    private int end;

    public PPP(int[] data, int fcs) {
        this.start = F;
        A = A_;
        C = C_;
        this.protocol = IPProtocol;
        this.data = data;
        this.fcs = fcs;
        this.end = F;
    }
    //    private final byte F_DELIMITER = 0x7E;
//    private final unsi A =0x7F;

    public static void main(String[] args) throws IOException {
        String path = "F:\\IdeaProjects\\leetcode\\src\\test.txt";
        byte[] bytes = new byte[]{0x04, 0x5A, 0x7E, 0x3C, 0x4B, 0x7D, 0x3A};
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            dataOutputStream.write(bytes);
        }
//
//7D5E 111110101011110
//7E   1111110
        List<Integer> list = new LinkedList<>();
        int fcs = -1;
        int[] data = null;
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
//            byte[] bytes = new byte[1];
            int i;
            while ((i = dataInputStream.read()) != -1) {
                if (i == 0x7E) {
                    list.add(0x7D);
                    list.add(0x5E);
                } else if (i == 0x7D) {
                    list.add(0x7D);
                    list.add(0x5D);
                } else {
                    list.add(i);
                }
            }
            data = new int[list.size()];
            for (int i1 = 0; i1 < list.size(); i1++) {
                data[i1] = list.get(i1);
            }
            fcs = CRC.crc16(data);
        }
        PPP ppp = new PPP(data, fcs);
        System.out.println(ppp);
    }

    private static class CRC {
        private static final int BITS_OF_BYTE = 8;
        private static final int POLYNOMIAL = 0xA001;
        private static final int INITIAL_VALUE = 0xFFFF;

        public static int crc16(int[] bytes) {
            int res = INITIAL_VALUE;
            for (int data : bytes) {
                res = res ^ data;
                for (int i = 0; i < BITS_OF_BYTE; i++) {
                    res = (res & 0x0001) == 1 ? (res >> 1) ^ POLYNOMIAL : res >> 1;
                }
            }
            return revert(res);
        }

        private static int revert(int res) {
            int low = (res & 0xff00) >> 8;
            int high = (res & 0x00ff) << 8;
            return low | high;
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(Integer.toString(start, 16))
                .append(Integer.toString(A, 16))
                .append('0').append(Integer.toString(C, 16))
                .append("00").append(Integer.toString(protocol, 16));
        stringBuilder.append("|||");
        for (int datum : data) {
            String s = Integer.toString(datum, 16);
            if (s.length() == 1) {
                s = "0" + s;
            }
            stringBuilder.append(s);
        }
        stringBuilder.append("|||");
        String fcs = Integer.toString(this.fcs, 16);
        while (fcs.length() < 4) {
            fcs = "0" + fcs;
        }
        stringBuilder.append(fcs);
        stringBuilder.append(Integer.toString(end, 16));
        return stringBuilder.toString();
    }
}
