package codes.june_challenge.day16;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class ValidateIPAddress {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String ipAddress = in.next();
        out.printLine(validIPAddress(ipAddress));
    }

    enum ADDRESS {
        IPV4("IPv4"),
        IPV6("IPv6"),
        NEITHER("Neither");

        private final String address;

        ADDRESS(String address) {
            this.address = address;
        }
        public String getAddress() {
            return address;
        }
    }
    public String validIPAddress(String IP) {
        ADDRESS address = getAddress(IP);
        return address.getAddress();
    }

    private ADDRESS getAddress(String ip) {
        int dot = (int) ip.chars().filter(e -> e == '.').count();
        int colon = (int) ip.chars().filter(e -> e == ':').count();
        if (dot > 0 && colon > 0) {
            return ADDRESS.NEITHER;
        } else if (dot > 0) {
            return checkIPV4(ip, dot);
        } else {
            return checkIPV6(ip, colon);
        }
    }

    private ADDRESS checkIPV6(String ip, int colon) {
        String[] parts = ip.split(":");
        if (colon != 7 || parts.length != 8) {
            return ADDRESS.NEITHER;
        }
        for (String part : parts) {
            part = part.toLowerCase();
            if (part.isEmpty() || part.length() > 4 ||  isGreaterThanffff(part)) {
                return ADDRESS.NEITHER;
            }
        }
        return ADDRESS.IPV6;
    }

    private boolean isGreaterThanffff(String part) {
        for (char c : part.toCharArray()) {
            if (Character.isDigit(c)) continue;
            if (c >= 'a' && c <= 'f') continue;
            return true;
        }
        return "ffff".compareTo(part) < 0;
    }

    private ADDRESS checkIPV4(String ip, int dot) {
        String[] parts = ip.split("\\.");
        if (dot != 3 || parts.length != 4) {
            return ADDRESS.NEITHER;
        }
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 3 || (part.startsWith("0") && part.length() != 1) || isGreaterThan255(part)) {
                return ADDRESS.NEITHER;
            }
        }
        return ADDRESS.IPV4;
    }

    private boolean isGreaterThan255(String part) {
        for (char c : part.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return "255".compareTo(part) < 0;
    }
}
