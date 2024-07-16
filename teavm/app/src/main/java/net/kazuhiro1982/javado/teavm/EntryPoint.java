package net.kazuhiro1982.javado.teavm;

import org.teavm.interop.Export;

public class EntryPoint {

    @Export(name = "mul")
    public static int mul(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
