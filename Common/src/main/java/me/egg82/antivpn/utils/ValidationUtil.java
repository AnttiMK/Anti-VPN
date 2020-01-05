package me.egg82.antivpn.utils;

import java.util.regex.Pattern;
import org.apache.commons.validator.routines.InetAddressValidator;

public class ValidationUtil {
    /**
     * Apache IP validator, takes both IPv4 and IPv6 and apparently out-performs
     * pretty much everything else (citation needed?) - point is I don't need to
     * maintain this
     */
    private static final InetAddressValidator ipValidator = InetAddressValidator.getInstance();

    /**
     * UUID_PATTERN_6 compiled and benchmarked from
     * https://github.com/tinnet/java-uuid-validation-benchmark
     * Results on my machine, 06/22/18: https://pastebin.com/hWs62pV2
     * Update: modified for less-than-great UUIDs
     */
    private static final Pattern uuidValidator = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$", Pattern.CASE_INSENSITIVE);

    private ValidationUtil() {}

    public static boolean isValidIp(String ip) {
        if (ip == null) {
            return false;
        }
        return ipValidator.isValid(ip);
    }

    public static boolean isValidUuid(String uuid) {
        if (uuid == null) {
            return false;
        }
        return uuidValidator.matcher(uuid).matches();
    }
}
