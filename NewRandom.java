import java.util.Random;
public class NewRandom extends Random {

    // Returns a random integer in between inputted the low and high
    public int nextInt(int low, int high) {
        return(nextInt(high - low + 1) + low);
    }

    // Returns a random integer with "digit" digits
    public int nextIntDigit(int digits) {
        Random r = new Random();
        int num = 0;
        for (int i = 0; i < digits; i++) {
            num *= 10;
            num += r.nextInt(10);
        }
        return num;
    }

    // Returns a random letter character
    public char nextChar(){

        return (char)('a' + Math.random() * 26);
    }

    // Returns a random character in between char from and char to
    public char nextChar(char from, char to) {
        if (from < to) {
            int n = nextInt(from, to);
            return (char) n;
        }
        else if (from > to) {
            int n = nextInt('a', 'z');

            while (n < from && n > to) {
                n = nextInt('a', 'z');
            }
            return (char) n;
        }
        else { // from = to
            return from;
        }
    }

    // Returns a random char  based on the user input of character and int
    public char nextChar(char from, int num) {
        int n = 0;
        int res = 0;
        if (num >= 0) {
            if (num + from > 122) {
                res = nextInt(num + 1) + from;
                if (res > 122) {
                    n = (char) res - 26;
                }
                else {
                    n = (char) res;
                }
            }
            else {
                n = (char) nextInt(from, from + num);
            }
        }
        else {
            if (from + num <= 122){
                res = nextInt(-num + 1) + from + num;
                if (res < 97) {
                    n = (char) res + 26;
                }
                else {
                    n = (char) res;
                }
            }
        }
        return (char) n;
    }

    // Returns a special character
    public char nextSpecialChar() {
        int low = 33; // !
        int high = 126; // ~
        char c = ' '; // note: need a space to assign initial value
        boolean special = false;
        while (!special) {
            int n = nextInt(low, high);
            c = (char) n;
            if ((!Character.isDigit(n)) && (!Character.isLetter(n))) {
                special = true;
            }
        }
        return c;
    }
}

