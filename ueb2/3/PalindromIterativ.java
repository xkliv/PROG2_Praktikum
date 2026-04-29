class PalindromIterativ implements Palindrom {

    @Override
    public boolean istPalindrom(String wort) {

        if (wort == null || wort.isEmpty()) {
            return false;
        }

        int j = wort.length() - 1;

        for (int i = 0; i < wort.length() / 2; i++) {

            if (wort.charAt(i) != wort.charAt(j)) {
                return false;
            }

            j--;
        }

        return true;
    }
}