package nano;

import java.util.regex.Pattern;

public abstract class Patterns {

    public final static Pattern WORD = Pattern.compile("[a-zA-Z]+-?[a-zA-Z]*");
    public final static Pattern PUNCTUATION_MARK = Pattern.compile("[,.!?():;-]");
    public final static Pattern LOWER_CASE = Pattern.compile("[a-z]");
    public final static Pattern UPPER_CASE = Pattern.compile("[A-Z]");
    public final static Pattern REAL_NUMBER = Pattern.compile("-?\\d+");
    public final static Pattern NUMBER = Pattern.compile("\\d");
    public final static Pattern LETTER_O = Pattern.compile("[oO]");
    public final static Pattern CONSONANT_MORE_ONE =
            Pattern.compile("[b-df-hj-np-tv-xzB-DF-HJ-NP-TV-XZ]{2,}");
    public final static Pattern VOWEL_MORE_ONE = Pattern.compile("[aeiouyAEIOUY]{2,}");
}
