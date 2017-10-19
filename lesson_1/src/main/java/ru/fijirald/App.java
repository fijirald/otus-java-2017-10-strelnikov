package ru.fijirald;

import com.google.common.base.Objects;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String... args ) {

        if(args.length > 0) {

            for(String arg: args) {
                System.out.println(getHash(arg));
            }

        } else {
            System.out.println(getHash("Hello World!"));
        }
    }

    static String getHash(String str) {
        String hash = String.valueOf(Objects.hashCode(str));
        return String.format("com.google.common.base.Objects.hashCode(\"%s\") = %s", str, hash);
    }
}
