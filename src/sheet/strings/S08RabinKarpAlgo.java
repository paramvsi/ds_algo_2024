package sheet.strings;

public class S08RabinKarpAlgo {

    public static final int PRIME = 101; // A prime number for hash calculation

    public static void search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int patHash = 0; // hash value for pattern
        int txtHash = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * 256) % PRIME;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            patHash = (256 * patHash + pat.charAt(i)) % PRIME;
            txtHash = (256 * txtHash + txt.charAt(i)) % PRIME;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern
            if (patHash == txtHash) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // if patHash == txtHash and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove leading digit,
            // add trailing digit
            if (i < N - M) {
                txtHash = (256 * (txtHash - txt.charAt(i) * h) + txt.charAt(i + M)) % PRIME;

                // We might get negative value of t, converting it to positive
                if (txtHash < 0)
                    txtHash = (txtHash + PRIME);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        search(txt, pat);
    }
}

