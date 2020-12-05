package gohryt.sapphire

class Rust {
    init {
        System.loadLibrary("rust")
    }
    external fun hello(to: String): String
}