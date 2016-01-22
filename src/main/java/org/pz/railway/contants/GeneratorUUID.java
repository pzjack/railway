package org.pz.railway.contants;

import java.util.UUID;

public class GeneratorUUID {

	private final static String UUID_SPLITER = "-";

    public static String getRadomUUID() {
        String idStr = UUID.randomUUID().toString();
        int p1 = 0;
        int p2 = idStr.indexOf(UUID_SPLITER);
        StringBuilder sb = new StringBuilder();
        while (p2 >= 0) {
            if (p2 > 0) {
                sb.append(idStr.substring(p1, p2));
                p1 = p2 + 1;
                p2 = idStr.indexOf(UUID_SPLITER, p1);
            } else {
                sb.append(idStr.substring(p1));
                p2 = -1;
            }
        }
        if (p2 < 0) {
                sb.append(idStr.substring(p1));
        }
        return sb.toString().toUpperCase();
    }
}
